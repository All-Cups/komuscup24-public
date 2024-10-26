package model

import "fmt"
import "io"
import . "komus24/stream"

// Order for controlling a single vehicle
type VehicleOrder struct {
    // Acceleration (-1 - fully backwards, +1 - fully forward)
    Accelerate float64
    // Hand brakes
    Brakes bool
    // Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
    Rotate float64
}

func NewVehicleOrder(accelerate float64, brakes bool, rotate float64) VehicleOrder {
    return VehicleOrder {
        Accelerate: accelerate,
        Brakes: brakes,
        Rotate: rotate,
    }
}

// Read VehicleOrder from reader
func ReadVehicleOrder(reader io.Reader) VehicleOrder {
    var accelerate float64
    accelerate = ReadFloat64(reader)
    var brakes bool
    brakes = ReadBool(reader)
    var rotate float64
    rotate = ReadFloat64(reader)
    return VehicleOrder {
        Accelerate: accelerate,
        Brakes: brakes,
        Rotate: rotate,
    }
}

// Write VehicleOrder to writer
func (vehicleOrder VehicleOrder) Write(writer io.Writer) {
    accelerate := vehicleOrder.Accelerate
    WriteFloat64(writer, accelerate)
    brakes := vehicleOrder.Brakes
    WriteBool(writer, brakes)
    rotate := vehicleOrder.Rotate
    WriteFloat64(writer, rotate)
}

// Get string representation of VehicleOrder
func (vehicleOrder VehicleOrder) String() string {
    stringResult := "{ "
    stringResult += "Accelerate: "
    accelerate := vehicleOrder.Accelerate
    stringResult += fmt.Sprint(accelerate)
    stringResult += ", "
    stringResult += "Brakes: "
    brakes := vehicleOrder.Brakes
    stringResult += fmt.Sprint(brakes)
    stringResult += ", "
    stringResult += "Rotate: "
    rotate := vehicleOrder.Rotate
    stringResult += fmt.Sprint(rotate)
    stringResult += " }"
    return stringResult
}