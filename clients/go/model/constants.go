package model

import "fmt"
import "io"
import . "komus24/stream"

// Game constants
type Constants struct {
    // Max duration of the game in ticks
    MaxTickCount int32
    // Max game time in seconds
    MaxGameTimeSeconds float64
    // Ticks per second
    TicksPerSecond float64
    // Subticks for physics simulation
    Microticks int32
    // Size of a single city cell
    CellSize float64
    // Collision bounciness
    CollisionBounciness float64
    // City type
    CityType CityType
    // List of vehicle types
    VehicleTypes []VehicleType
    // Speed of refueling at a station
    RefillSpeed float64
    // Number of available quests
    QuestCount int32
    // Score range for quests
    QuestScore MinMaxRangeInt64
    // Traffic options
    Traffic Traffic
    // Collision penalty modifier
    CollisionPenaltyModifier float64
    // Map of the city
    City [][]CityCell
}

func NewConstants(maxTickCount int32, maxGameTimeSeconds float64, ticksPerSecond float64, microticks int32, cellSize float64, collisionBounciness float64, cityType CityType, vehicleTypes []VehicleType, refillSpeed float64, questCount int32, questScore MinMaxRangeInt64, traffic Traffic, collisionPenaltyModifier float64, city [][]CityCell) Constants {
    return Constants {
        MaxTickCount: maxTickCount,
        MaxGameTimeSeconds: maxGameTimeSeconds,
        TicksPerSecond: ticksPerSecond,
        Microticks: microticks,
        CellSize: cellSize,
        CollisionBounciness: collisionBounciness,
        CityType: cityType,
        VehicleTypes: vehicleTypes,
        RefillSpeed: refillSpeed,
        QuestCount: questCount,
        QuestScore: questScore,
        Traffic: traffic,
        CollisionPenaltyModifier: collisionPenaltyModifier,
        City: city,
    }
}

// Read Constants from reader
func ReadConstants(reader io.Reader) Constants {
    var maxTickCount int32
    maxTickCount = ReadInt32(reader)
    var maxGameTimeSeconds float64
    maxGameTimeSeconds = ReadFloat64(reader)
    var ticksPerSecond float64
    ticksPerSecond = ReadFloat64(reader)
    var microticks int32
    microticks = ReadInt32(reader)
    var cellSize float64
    cellSize = ReadFloat64(reader)
    var collisionBounciness float64
    collisionBounciness = ReadFloat64(reader)
    var cityType CityType
    cityType = ReadCityType(reader)
    var vehicleTypes []VehicleType
    vehicleTypes = make([]VehicleType, ReadInt32(reader))
    for vehicleTypesIndex := range vehicleTypes {
        var vehicleTypesElement VehicleType
        vehicleTypesElement = ReadVehicleType(reader)
        vehicleTypes[vehicleTypesIndex] = vehicleTypesElement
    }
    var refillSpeed float64
    refillSpeed = ReadFloat64(reader)
    var questCount int32
    questCount = ReadInt32(reader)
    var questScore MinMaxRangeInt64
    questScore = ReadMinMaxRangeInt64(reader)
    var traffic Traffic
    traffic = ReadTraffic(reader)
    var collisionPenaltyModifier float64
    collisionPenaltyModifier = ReadFloat64(reader)
    var city [][]CityCell
    city = make([][]CityCell, ReadInt32(reader))
    for cityIndex := range city {
        var cityElement []CityCell
        cityElement = make([]CityCell, ReadInt32(reader))
        for cityElementIndex := range cityElement {
            var cityElementElement CityCell
            cityElementElement = ReadCityCell(reader)
            cityElement[cityElementIndex] = cityElementElement
        }
        city[cityIndex] = cityElement
    }
    return Constants {
        MaxTickCount: maxTickCount,
        MaxGameTimeSeconds: maxGameTimeSeconds,
        TicksPerSecond: ticksPerSecond,
        Microticks: microticks,
        CellSize: cellSize,
        CollisionBounciness: collisionBounciness,
        CityType: cityType,
        VehicleTypes: vehicleTypes,
        RefillSpeed: refillSpeed,
        QuestCount: questCount,
        QuestScore: questScore,
        Traffic: traffic,
        CollisionPenaltyModifier: collisionPenaltyModifier,
        City: city,
    }
}

// Write Constants to writer
func (constants Constants) Write(writer io.Writer) {
    maxTickCount := constants.MaxTickCount
    WriteInt32(writer, maxTickCount)
    maxGameTimeSeconds := constants.MaxGameTimeSeconds
    WriteFloat64(writer, maxGameTimeSeconds)
    ticksPerSecond := constants.TicksPerSecond
    WriteFloat64(writer, ticksPerSecond)
    microticks := constants.Microticks
    WriteInt32(writer, microticks)
    cellSize := constants.CellSize
    WriteFloat64(writer, cellSize)
    collisionBounciness := constants.CollisionBounciness
    WriteFloat64(writer, collisionBounciness)
    cityType := constants.CityType
    cityType.Write(writer)
    vehicleTypes := constants.VehicleTypes
    WriteInt32(writer, int32(len(vehicleTypes)))
    for _, vehicleTypesElement := range vehicleTypes {
        vehicleTypesElement.Write(writer)
    }
    refillSpeed := constants.RefillSpeed
    WriteFloat64(writer, refillSpeed)
    questCount := constants.QuestCount
    WriteInt32(writer, questCount)
    questScore := constants.QuestScore
    questScore.Write(writer)
    traffic := constants.Traffic
    traffic.Write(writer)
    collisionPenaltyModifier := constants.CollisionPenaltyModifier
    WriteFloat64(writer, collisionPenaltyModifier)
    city := constants.City
    WriteInt32(writer, int32(len(city)))
    for _, cityElement := range city {
        WriteInt32(writer, int32(len(cityElement)))
        for _, cityElementElement := range cityElement {
            WriteInt32(writer, int32(cityElementElement))
        }
    }
}

// Get string representation of Constants
func (constants Constants) String() string {
    stringResult := "{ "
    stringResult += "MaxTickCount: "
    maxTickCount := constants.MaxTickCount
    stringResult += fmt.Sprint(maxTickCount)
    stringResult += ", "
    stringResult += "MaxGameTimeSeconds: "
    maxGameTimeSeconds := constants.MaxGameTimeSeconds
    stringResult += fmt.Sprint(maxGameTimeSeconds)
    stringResult += ", "
    stringResult += "TicksPerSecond: "
    ticksPerSecond := constants.TicksPerSecond
    stringResult += fmt.Sprint(ticksPerSecond)
    stringResult += ", "
    stringResult += "Microticks: "
    microticks := constants.Microticks
    stringResult += fmt.Sprint(microticks)
    stringResult += ", "
    stringResult += "CellSize: "
    cellSize := constants.CellSize
    stringResult += fmt.Sprint(cellSize)
    stringResult += ", "
    stringResult += "CollisionBounciness: "
    collisionBounciness := constants.CollisionBounciness
    stringResult += fmt.Sprint(collisionBounciness)
    stringResult += ", "
    stringResult += "CityType: "
    cityType := constants.CityType
    stringResult += cityType.String()
    stringResult += ", "
    stringResult += "VehicleTypes: "
    vehicleTypes := constants.VehicleTypes
    stringResult += "[ "
    for vehicleTypesIndex, vehicleTypesElement := range vehicleTypes {
        if vehicleTypesIndex != 0 {
            stringResult += ", "
        }
        stringResult += vehicleTypesElement.String()
    }
    stringResult += " ]"
    stringResult += ", "
    stringResult += "RefillSpeed: "
    refillSpeed := constants.RefillSpeed
    stringResult += fmt.Sprint(refillSpeed)
    stringResult += ", "
    stringResult += "QuestCount: "
    questCount := constants.QuestCount
    stringResult += fmt.Sprint(questCount)
    stringResult += ", "
    stringResult += "QuestScore: "
    questScore := constants.QuestScore
    stringResult += questScore.String()
    stringResult += ", "
    stringResult += "Traffic: "
    traffic := constants.Traffic
    stringResult += traffic.String()
    stringResult += ", "
    stringResult += "CollisionPenaltyModifier: "
    collisionPenaltyModifier := constants.CollisionPenaltyModifier
    stringResult += fmt.Sprint(collisionPenaltyModifier)
    stringResult += ", "
    stringResult += "City: "
    city := constants.City
    stringResult += "[ "
    for cityIndex, cityElement := range city {
        if cityIndex != 0 {
            stringResult += ", "
        }
        stringResult += "[ "
        for cityElementIndex, cityElementElement := range cityElement {
            if cityElementIndex != 0 {
                stringResult += ", "
            }
            stringResult += CityCellToString(cityElementElement)
        }
        stringResult += " ]"
    }
    stringResult += " ]"
    stringResult += " }"
    return stringResult
}