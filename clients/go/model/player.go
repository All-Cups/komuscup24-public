package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type Player struct {
    // TODO - Document
    Index int32
    // TODO - Document
    Score int64
    // TODO - Document
    Vehicles []Vehicle
}

func NewPlayer(index int32, score int64, vehicles []Vehicle) Player {
    return Player {
        Index: index,
        Score: score,
        Vehicles: vehicles,
    }
}

// Read Player from reader
func ReadPlayer(reader io.Reader) Player {
    var index int32
    index = ReadInt32(reader)
    var score int64
    score = ReadInt64(reader)
    var vehicles []Vehicle
    vehicles = make([]Vehicle, ReadInt32(reader))
    for vehiclesIndex := range vehicles {
        var vehiclesElement Vehicle
        vehiclesElement = ReadVehicle(reader)
        vehicles[vehiclesIndex] = vehiclesElement
    }
    return Player {
        Index: index,
        Score: score,
        Vehicles: vehicles,
    }
}

// Write Player to writer
func (player Player) Write(writer io.Writer) {
    index := player.Index
    WriteInt32(writer, index)
    score := player.Score
    WriteInt64(writer, score)
    vehicles := player.Vehicles
    WriteInt32(writer, int32(len(vehicles)))
    for _, vehiclesElement := range vehicles {
        vehiclesElement.Write(writer)
    }
}

// Get string representation of Player
func (player Player) String() string {
    stringResult := "{ "
    stringResult += "Index: "
    index := player.Index
    stringResult += fmt.Sprint(index)
    stringResult += ", "
    stringResult += "Score: "
    score := player.Score
    stringResult += fmt.Sprint(score)
    stringResult += ", "
    stringResult += "Vehicles: "
    vehicles := player.Vehicles
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