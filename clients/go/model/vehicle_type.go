package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type VehicleType struct {
    // TODO - Document
    Name string
    // TODO - Document
    Radius float64
    // TODO - Document
    Weight float64
    // TODO - Document
    MaxBackwardsSpeed float64
    // TODO - Document
    MaxSpeed float64
    // TODO - Document
    Acceleration float64
    // TODO - Document
    Friction float64
    // TODO - Document
    MaxRotateSpeed float64
    // TODO - Document
    RotateAcceleration float64
    // TODO - Document
    MaxFuel float64
    // TODO - Document
    FuelUseSpeed float64
}

func NewVehicleType(name string, radius float64, weight float64, maxBackwardsSpeed float64, maxSpeed float64, acceleration float64, friction float64, maxRotateSpeed float64, rotateAcceleration float64, maxFuel float64, fuelUseSpeed float64) VehicleType {
    return VehicleType {
        Name: name,
        Radius: radius,
        Weight: weight,
        MaxBackwardsSpeed: maxBackwardsSpeed,
        MaxSpeed: maxSpeed,
        Acceleration: acceleration,
        Friction: friction,
        MaxRotateSpeed: maxRotateSpeed,
        RotateAcceleration: rotateAcceleration,
        MaxFuel: maxFuel,
        FuelUseSpeed: fuelUseSpeed,
    }
}

// Read VehicleType from reader
func ReadVehicleType(reader io.Reader) VehicleType {
    var name string
    name = ReadString(reader)
    var radius float64
    radius = ReadFloat64(reader)
    var weight float64
    weight = ReadFloat64(reader)
    var maxBackwardsSpeed float64
    maxBackwardsSpeed = ReadFloat64(reader)
    var maxSpeed float64
    maxSpeed = ReadFloat64(reader)
    var acceleration float64
    acceleration = ReadFloat64(reader)
    var friction float64
    friction = ReadFloat64(reader)
    var maxRotateSpeed float64
    maxRotateSpeed = ReadFloat64(reader)
    var rotateAcceleration float64
    rotateAcceleration = ReadFloat64(reader)
    var maxFuel float64
    maxFuel = ReadFloat64(reader)
    var fuelUseSpeed float64
    fuelUseSpeed = ReadFloat64(reader)
    return VehicleType {
        Name: name,
        Radius: radius,
        Weight: weight,
        MaxBackwardsSpeed: maxBackwardsSpeed,
        MaxSpeed: maxSpeed,
        Acceleration: acceleration,
        Friction: friction,
        MaxRotateSpeed: maxRotateSpeed,
        RotateAcceleration: rotateAcceleration,
        MaxFuel: maxFuel,
        FuelUseSpeed: fuelUseSpeed,
    }
}

// Write VehicleType to writer
func (vehicleType VehicleType) Write(writer io.Writer) {
    name := vehicleType.Name
    WriteString(writer, name)
    radius := vehicleType.Radius
    WriteFloat64(writer, radius)
    weight := vehicleType.Weight
    WriteFloat64(writer, weight)
    maxBackwardsSpeed := vehicleType.MaxBackwardsSpeed
    WriteFloat64(writer, maxBackwardsSpeed)
    maxSpeed := vehicleType.MaxSpeed
    WriteFloat64(writer, maxSpeed)
    acceleration := vehicleType.Acceleration
    WriteFloat64(writer, acceleration)
    friction := vehicleType.Friction
    WriteFloat64(writer, friction)
    maxRotateSpeed := vehicleType.MaxRotateSpeed
    WriteFloat64(writer, maxRotateSpeed)
    rotateAcceleration := vehicleType.RotateAcceleration
    WriteFloat64(writer, rotateAcceleration)
    maxFuel := vehicleType.MaxFuel
    WriteFloat64(writer, maxFuel)
    fuelUseSpeed := vehicleType.FuelUseSpeed
    WriteFloat64(writer, fuelUseSpeed)
}

// Get string representation of VehicleType
func (vehicleType VehicleType) String() string {
    stringResult := "{ "
    stringResult += "Name: "
    name := vehicleType.Name
    stringResult += "\"" + name + "\""
    stringResult += ", "
    stringResult += "Radius: "
    radius := vehicleType.Radius
    stringResult += fmt.Sprint(radius)
    stringResult += ", "
    stringResult += "Weight: "
    weight := vehicleType.Weight
    stringResult += fmt.Sprint(weight)
    stringResult += ", "
    stringResult += "MaxBackwardsSpeed: "
    maxBackwardsSpeed := vehicleType.MaxBackwardsSpeed
    stringResult += fmt.Sprint(maxBackwardsSpeed)
    stringResult += ", "
    stringResult += "MaxSpeed: "
    maxSpeed := vehicleType.MaxSpeed
    stringResult += fmt.Sprint(maxSpeed)
    stringResult += ", "
    stringResult += "Acceleration: "
    acceleration := vehicleType.Acceleration
    stringResult += fmt.Sprint(acceleration)
    stringResult += ", "
    stringResult += "Friction: "
    friction := vehicleType.Friction
    stringResult += fmt.Sprint(friction)
    stringResult += ", "
    stringResult += "MaxRotateSpeed: "
    maxRotateSpeed := vehicleType.MaxRotateSpeed
    stringResult += fmt.Sprint(maxRotateSpeed)
    stringResult += ", "
    stringResult += "RotateAcceleration: "
    rotateAcceleration := vehicleType.RotateAcceleration
    stringResult += fmt.Sprint(rotateAcceleration)
    stringResult += ", "
    stringResult += "MaxFuel: "
    maxFuel := vehicleType.MaxFuel
    stringResult += fmt.Sprint(maxFuel)
    stringResult += ", "
    stringResult += "FuelUseSpeed: "
    fuelUseSpeed := vehicleType.FuelUseSpeed
    stringResult += fmt.Sprint(fuelUseSpeed)
    stringResult += " }"
    return stringResult
}