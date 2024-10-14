package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type Traffic struct {
    // TODO - Document
    Amount int32
    // TODO - Document
    MoveTime float64
    // TODO - Document
    Radius float64
    // TODO - Document
    Weight float64
    // TODO - Document
    CrashDeceleration float64
    // TODO - Document
    CrashLifetime float64
}

func NewTraffic(amount int32, moveTime float64, radius float64, weight float64, crashDeceleration float64, crashLifetime float64) Traffic {
    return Traffic {
        Amount: amount,
        MoveTime: moveTime,
        Radius: radius,
        Weight: weight,
        CrashDeceleration: crashDeceleration,
        CrashLifetime: crashLifetime,
    }
}

// Read Traffic from reader
func ReadTraffic(reader io.Reader) Traffic {
    var amount int32
    amount = ReadInt32(reader)
    var moveTime float64
    moveTime = ReadFloat64(reader)
    var radius float64
    radius = ReadFloat64(reader)
    var weight float64
    weight = ReadFloat64(reader)
    var crashDeceleration float64
    crashDeceleration = ReadFloat64(reader)
    var crashLifetime float64
    crashLifetime = ReadFloat64(reader)
    return Traffic {
        Amount: amount,
        MoveTime: moveTime,
        Radius: radius,
        Weight: weight,
        CrashDeceleration: crashDeceleration,
        CrashLifetime: crashLifetime,
    }
}

// Write Traffic to writer
func (traffic Traffic) Write(writer io.Writer) {
    amount := traffic.Amount
    WriteInt32(writer, amount)
    moveTime := traffic.MoveTime
    WriteFloat64(writer, moveTime)
    radius := traffic.Radius
    WriteFloat64(writer, radius)
    weight := traffic.Weight
    WriteFloat64(writer, weight)
    crashDeceleration := traffic.CrashDeceleration
    WriteFloat64(writer, crashDeceleration)
    crashLifetime := traffic.CrashLifetime
    WriteFloat64(writer, crashLifetime)
}

// Get string representation of Traffic
func (traffic Traffic) String() string {
    stringResult := "{ "
    stringResult += "Amount: "
    amount := traffic.Amount
    stringResult += fmt.Sprint(amount)
    stringResult += ", "
    stringResult += "MoveTime: "
    moveTime := traffic.MoveTime
    stringResult += fmt.Sprint(moveTime)
    stringResult += ", "
    stringResult += "Radius: "
    radius := traffic.Radius
    stringResult += fmt.Sprint(radius)
    stringResult += ", "
    stringResult += "Weight: "
    weight := traffic.Weight
    stringResult += fmt.Sprint(weight)
    stringResult += ", "
    stringResult += "CrashDeceleration: "
    crashDeceleration := traffic.CrashDeceleration
    stringResult += fmt.Sprint(crashDeceleration)
    stringResult += ", "
    stringResult += "CrashLifetime: "
    crashLifetime := traffic.CrashLifetime
    stringResult += fmt.Sprint(crashLifetime)
    stringResult += " }"
    return stringResult
}