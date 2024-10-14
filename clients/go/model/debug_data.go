package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type DebugData interface {
    // Write DebugData to writer
    Write(writer io.Writer)

    // Get string representation of DebugData
    String() string
}

// Read DebugData from reader
func ReadDebugData(reader io.Reader) DebugData {
    switch ReadInt32(reader) {
    case 0:
        return ReadDebugDataCircle(reader)
    }
    panic("Unexpected tag value")
}

// TODO - Document
type DebugDataCircle struct {
    // TODO - Document
    Pos Vec2Float64
    // TODO - Document
    Radius float64
}

func NewDebugDataCircle(pos Vec2Float64, radius float64) DebugDataCircle {
    return DebugDataCircle {
        Pos: pos,
        Radius: radius,
    }
}

// Read Circle from reader
func ReadDebugDataCircle(reader io.Reader) DebugDataCircle {
    var pos Vec2Float64
    pos = ReadVec2Float64(reader)
    var radius float64
    radius = ReadFloat64(reader)
    return DebugDataCircle {
        Pos: pos,
        Radius: radius,
    }
}

// Write Circle to writer
func (debugDataCircle DebugDataCircle) Write(writer io.Writer) {
    WriteInt32(writer, 0)
    pos := debugDataCircle.Pos
    pos.Write(writer)
    radius := debugDataCircle.Radius
    WriteFloat64(writer, radius)
}

// Get string representation of Circle
func (debugDataCircle DebugDataCircle) String() string {
    stringResult := "{ "
    stringResult += "Pos: "
    pos := debugDataCircle.Pos
    stringResult += pos.String()
    stringResult += ", "
    stringResult += "Radius: "
    radius := debugDataCircle.Radius
    stringResult += fmt.Sprint(radius)
    stringResult += " }"
    return stringResult
}