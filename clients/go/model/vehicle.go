package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type Vehicle struct {
    // TODO - Document
    Position Vec2Float64
    // TODO - Document
    Velocity Vec2Float64
    // TODO - Document
    Speed float64
    // TODO - Document
    RotationSpeed float64
    // TODO - Document
    Rotation float64
    // TODO - Document
    TypeIndex int32
    // TODO maybe multiple quests at the same time?
    Quest *Quest
    // TODO - Document
    Fuel float64
}

func NewVehicle(position Vec2Float64, velocity Vec2Float64, speed float64, rotationSpeed float64, rotation float64, typeIndex int32, quest *Quest, fuel float64) Vehicle {
    return Vehicle {
        Position: position,
        Velocity: velocity,
        Speed: speed,
        RotationSpeed: rotationSpeed,
        Rotation: rotation,
        TypeIndex: typeIndex,
        Quest: quest,
        Fuel: fuel,
    }
}

// Read Vehicle from reader
func ReadVehicle(reader io.Reader) Vehicle {
    var position Vec2Float64
    position = ReadVec2Float64(reader)
    var velocity Vec2Float64
    velocity = ReadVec2Float64(reader)
    var speed float64
    speed = ReadFloat64(reader)
    var rotationSpeed float64
    rotationSpeed = ReadFloat64(reader)
    var rotation float64
    rotation = ReadFloat64(reader)
    var typeIndex int32
    typeIndex = ReadInt32(reader)
    var quest *Quest
    if ReadBool(reader) {
        var questValue Quest
        questValue = ReadQuest(reader)
        quest = &questValue
    } else {
        quest = nil
    }
    var fuel float64
    fuel = ReadFloat64(reader)
    return Vehicle {
        Position: position,
        Velocity: velocity,
        Speed: speed,
        RotationSpeed: rotationSpeed,
        Rotation: rotation,
        TypeIndex: typeIndex,
        Quest: quest,
        Fuel: fuel,
    }
}

// Write Vehicle to writer
func (vehicle Vehicle) Write(writer io.Writer) {
    position := vehicle.Position
    position.Write(writer)
    velocity := vehicle.Velocity
    velocity.Write(writer)
    speed := vehicle.Speed
    WriteFloat64(writer, speed)
    rotationSpeed := vehicle.RotationSpeed
    WriteFloat64(writer, rotationSpeed)
    rotation := vehicle.Rotation
    WriteFloat64(writer, rotation)
    typeIndex := vehicle.TypeIndex
    WriteInt32(writer, typeIndex)
    quest := vehicle.Quest
    if quest == nil {
        WriteBool(writer, false)
    } else {
        WriteBool(writer, true)
        questValue := *quest
        questValue.Write(writer)
    }
    fuel := vehicle.Fuel
    WriteFloat64(writer, fuel)
}

// Get string representation of Vehicle
func (vehicle Vehicle) String() string {
    stringResult := "{ "
    stringResult += "Position: "
    position := vehicle.Position
    stringResult += position.String()
    stringResult += ", "
    stringResult += "Velocity: "
    velocity := vehicle.Velocity
    stringResult += velocity.String()
    stringResult += ", "
    stringResult += "Speed: "
    speed := vehicle.Speed
    stringResult += fmt.Sprint(speed)
    stringResult += ", "
    stringResult += "RotationSpeed: "
    rotationSpeed := vehicle.RotationSpeed
    stringResult += fmt.Sprint(rotationSpeed)
    stringResult += ", "
    stringResult += "Rotation: "
    rotation := vehicle.Rotation
    stringResult += fmt.Sprint(rotation)
    stringResult += ", "
    stringResult += "TypeIndex: "
    typeIndex := vehicle.TypeIndex
    stringResult += fmt.Sprint(typeIndex)
    stringResult += ", "
    stringResult += "Quest: "
    quest := vehicle.Quest
    if quest == nil {
        stringResult += "nil"
    } else {
        questValue := *quest
        stringResult += questValue.String()
    }
    stringResult += ", "
    stringResult += "Fuel: "
    fuel := vehicle.Fuel
    stringResult += fmt.Sprint(fuel)
    stringResult += " }"
    return stringResult
}