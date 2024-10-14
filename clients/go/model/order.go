package model

import "io"
import . "komus24/stream"

// Player's orders
type Order struct {
    // TODO - Document
    Vehicles []VehicleOrder
}

func NewOrder(vehicles []VehicleOrder) Order {
    return Order {
        Vehicles: vehicles,
    }
}

// Read Order from reader
func ReadOrder(reader io.Reader) Order {
    var vehicles []VehicleOrder
    vehicles = make([]VehicleOrder, ReadInt32(reader))
    for vehiclesIndex := range vehicles {
        var vehiclesElement VehicleOrder
        vehiclesElement = ReadVehicleOrder(reader)
        vehicles[vehiclesIndex] = vehiclesElement
    }
    return Order {
        Vehicles: vehicles,
    }
}

// Write Order to writer
func (order Order) Write(writer io.Writer) {
    vehicles := order.Vehicles
    WriteInt32(writer, int32(len(vehicles)))
    for _, vehiclesElement := range vehicles {
        vehiclesElement.Write(writer)
    }
}

// Get string representation of Order
func (order Order) String() string {
    stringResult := "{ "
    stringResult += "Vehicles: "
    vehicles := order.Vehicles
    stringResult += "[ "
    for vehiclesIndex, vehiclesElement := range vehicles {
        if vehiclesIndex != 0 {
            stringResult += ", "
        }
        stringResult += vehiclesElement.String()
    }
    stringResult += " ]"
    stringResult += " }"
    return stringResult
}