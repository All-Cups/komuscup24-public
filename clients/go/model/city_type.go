package model

import "fmt"
import "io"
import . "komus24/stream"

// TODO - Document
type CityType interface {
    // Write CityType to writer
    Write(writer io.Writer)

    // Get string representation of CityType
    String() string
}

// Read CityType from reader
func ReadCityType(reader io.Reader) CityType {
    switch ReadInt32(reader) {
    case 0:
        return ReadCityTypeManhattan(reader)
    case 1:
        return ReadCityTypeInline(reader)
    }
    panic("Unexpected tag value")
}

// TODO - Document
type CityTypeManhattan struct {
    // TODO - Document
    Size Vec2Int32
    // TODO - Document
    BlockSize Vec2Int32
    // TODO - Document
    Refills int32
}

func NewCityTypeManhattan(size Vec2Int32, blockSize Vec2Int32, refills int32) CityTypeManhattan {
    return CityTypeManhattan {
        Size: size,
        BlockSize: blockSize,
        Refills: refills,
    }
}

// Read Manhattan from reader
func ReadCityTypeManhattan(reader io.Reader) CityTypeManhattan {
    var size Vec2Int32
    size = ReadVec2Int32(reader)
    var blockSize Vec2Int32
    blockSize = ReadVec2Int32(reader)
    var refills int32
    refills = ReadInt32(reader)
    return CityTypeManhattan {
        Size: size,
        BlockSize: blockSize,
        Refills: refills,
    }
}

// Write Manhattan to writer
func (cityTypeManhattan CityTypeManhattan) Write(writer io.Writer) {
    WriteInt32(writer, 0)
    size := cityTypeManhattan.Size
    size.Write(writer)
    blockSize := cityTypeManhattan.BlockSize
    blockSize.Write(writer)
    refills := cityTypeManhattan.Refills
    WriteInt32(writer, refills)
}

// Get string representation of Manhattan
func (cityTypeManhattan CityTypeManhattan) String() string {
    stringResult := "{ "
    stringResult += "Size: "
    size := cityTypeManhattan.Size
    stringResult += size.String()
    stringResult += ", "
    stringResult += "BlockSize: "
    blockSize := cityTypeManhattan.BlockSize
    stringResult += blockSize.String()
    stringResult += ", "
    stringResult += "Refills: "
    refills := cityTypeManhattan.Refills
    stringResult += fmt.Sprint(refills)
    stringResult += " }"
    return stringResult
}

// TODO - Document
type CityTypeInline struct {
    // TODO - Document
    Cells []string
}

func NewCityTypeInline(cells []string) CityTypeInline {
    return CityTypeInline {
        Cells: cells,
    }
}

// Read Inline from reader
func ReadCityTypeInline(reader io.Reader) CityTypeInline {
    var cells []string
    cells = make([]string, ReadInt32(reader))
    for cellsIndex := range cells {
        var cellsElement string
        cellsElement = ReadString(reader)
        cells[cellsIndex] = cellsElement
    }
    return CityTypeInline {
        Cells: cells,
    }
}

// Write Inline to writer
func (cityTypeInline CityTypeInline) Write(writer io.Writer) {
    WriteInt32(writer, 1)
    cells := cityTypeInline.Cells
    WriteInt32(writer, int32(len(cells)))
    for _, cellsElement := range cells {
        WriteString(writer, cellsElement)
    }
}

// Get string representation of Inline
func (cityTypeInline CityTypeInline) String() string {
    stringResult := "{ "
    stringResult += "Cells: "
    cells := cityTypeInline.Cells
    stringResult += "[ "
    for cellsIndex, cellsElement := range cells {
        if cellsIndex != 0 {
            stringResult += ", "
        }
        stringResult += "\"" + cellsElement + "\""
    }
    stringResult += " ]"
    stringResult += " }"
    return stringResult
}