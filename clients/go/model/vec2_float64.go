package model

import "fmt"
import "io"
import . "komus24/stream"

// 2 dimensional vector.
type Vec2Float64 struct {
    // `x` coordinate of the vector
    X float64
    // `y` coordinate of the vector
    Y float64
}

func NewVec2Float64(x float64, y float64) Vec2Float64 {
    return Vec2Float64 {
        X: x,
        Y: y,
    }
}

// Read Vec2Float64 from reader
func ReadVec2Float64(reader io.Reader) Vec2Float64 {
    var x float64
    x = ReadFloat64(reader)
    var y float64
    y = ReadFloat64(reader)
    return Vec2Float64 {
        X: x,
        Y: y,
    }
}

// Write Vec2Float64 to writer
func (vec2Float64 Vec2Float64) Write(writer io.Writer) {
    x := vec2Float64.X
    WriteFloat64(writer, x)
    y := vec2Float64.Y
    WriteFloat64(writer, y)
}

// Get string representation of Vec2Float64
func (vec2Float64 Vec2Float64) String() string {
    stringResult := "{ "
    stringResult += "X: "
    x := vec2Float64.X
    stringResult += fmt.Sprint(x)
    stringResult += ", "
    stringResult += "Y: "
    y := vec2Float64.Y
    stringResult += fmt.Sprint(y)
    stringResult += " }"
    return stringResult
}