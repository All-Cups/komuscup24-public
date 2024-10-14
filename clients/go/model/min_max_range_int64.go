package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type MinMaxRangeInt64 struct {
    // TODO - Document
    Min int64
    // TODO - Document
    Max int64
}

func NewMinMaxRangeInt64(min int64, max int64) MinMaxRangeInt64 {
    return MinMaxRangeInt64 {
        Min: min,
        Max: max,
    }
}

// Read MinMaxRangeInt64 from reader
func ReadMinMaxRangeInt64(reader io.Reader) MinMaxRangeInt64 {
    var min int64
    min = ReadInt64(reader)
    var max int64
    max = ReadInt64(reader)
    return MinMaxRangeInt64 {
        Min: min,
        Max: max,
    }
}

// Write MinMaxRangeInt64 to writer
func (minMaxRangeInt64 MinMaxRangeInt64) Write(writer io.Writer) {
    min := minMaxRangeInt64.Min
    WriteInt64(writer, min)
    max := minMaxRangeInt64.Max
    WriteInt64(writer, max)
}

// Get string representation of MinMaxRangeInt64
func (minMaxRangeInt64 MinMaxRangeInt64) String() string {
    stringResult := "{ "
    stringResult += "Min: "
    min := minMaxRangeInt64.Min
    stringResult += fmt.Sprint(min)
    stringResult += ", "
    stringResult += "Max: "
    max := minMaxRangeInt64.Max
    stringResult += fmt.Sprint(max)
    stringResult += " }"
    return stringResult
}