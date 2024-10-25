package debugging

import "fmt"
import "io"
import . "komus24/model"
import . "komus24/stream"

// Data for debug rendering
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
    case 1:
        return ReadDebugDataLine(reader)
    case 2:
        return ReadDebugDataRect(reader)
    case 3:
        return ReadDebugDataText(reader)
    }
    panic("Unexpected tag value")
}

// Circle
type DebugDataCircle struct {
    // Center
    Pos Vec2Float64
    // Radius
    Radius float64
    // Color
    Color Color
}

func NewDebugDataCircle(pos Vec2Float64, radius float64, color Color) DebugDataCircle {
    return DebugDataCircle {
        Pos: pos,
        Radius: radius,
        Color: color,
    }
}

// Read Circle from reader
func ReadDebugDataCircle(reader io.Reader) DebugDataCircle {
    var pos Vec2Float64
    pos = ReadVec2Float64(reader)
    var radius float64
    radius = ReadFloat64(reader)
    var color Color
    color = ReadColor(reader)
    return DebugDataCircle {
        Pos: pos,
        Radius: radius,
        Color: color,
    }
}

// Write Circle to writer
func (debugDataCircle DebugDataCircle) Write(writer io.Writer) {
    WriteInt32(writer, 0)
    pos := debugDataCircle.Pos
    pos.Write(writer)
    radius := debugDataCircle.Radius
    WriteFloat64(writer, radius)
    color := debugDataCircle.Color
    color.Write(writer)
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
    stringResult += ", "
    stringResult += "Color: "
    color := debugDataCircle.Color
    stringResult += color.String()
    stringResult += " }"
    return stringResult
}

// Line (segment)
type DebugDataLine struct {
    // First end
    Point1 Vec2Float64
    // Other end
    Point2 Vec2Float64
    // Thickness
    Width float64
    // Color
    Color Color
}

func NewDebugDataLine(point1 Vec2Float64, point2 Vec2Float64, width float64, color Color) DebugDataLine {
    return DebugDataLine {
        Point1: point1,
        Point2: point2,
        Width: width,
        Color: color,
    }
}

// Read Line from reader
func ReadDebugDataLine(reader io.Reader) DebugDataLine {
    var point1 Vec2Float64
    point1 = ReadVec2Float64(reader)
    var point2 Vec2Float64
    point2 = ReadVec2Float64(reader)
    var width float64
    width = ReadFloat64(reader)
    var color Color
    color = ReadColor(reader)
    return DebugDataLine {
        Point1: point1,
        Point2: point2,
        Width: width,
        Color: color,
    }
}

// Write Line to writer
func (debugDataLine DebugDataLine) Write(writer io.Writer) {
    WriteInt32(writer, 1)
    point1 := debugDataLine.Point1
    point1.Write(writer)
    point2 := debugDataLine.Point2
    point2.Write(writer)
    width := debugDataLine.Width
    WriteFloat64(writer, width)
    color := debugDataLine.Color
    color.Write(writer)
}

// Get string representation of Line
func (debugDataLine DebugDataLine) String() string {
    stringResult := "{ "
    stringResult += "Point1: "
    point1 := debugDataLine.Point1
    stringResult += point1.String()
    stringResult += ", "
    stringResult += "Point2: "
    point2 := debugDataLine.Point2
    stringResult += point2.String()
    stringResult += ", "
    stringResult += "Width: "
    width := debugDataLine.Width
    stringResult += fmt.Sprint(width)
    stringResult += ", "
    stringResult += "Color: "
    color := debugDataLine.Color
    stringResult += color.String()
    stringResult += " }"
    return stringResult
}

// Rectangle
type DebugDataRect struct {
    // One of the corners
    Corner1 Vec2Float64
    // Opposite corner
    Corner2 Vec2Float64
    // Color
    Color Color
}

func NewDebugDataRect(corner1 Vec2Float64, corner2 Vec2Float64, color Color) DebugDataRect {
    return DebugDataRect {
        Corner1: corner1,
        Corner2: corner2,
        Color: color,
    }
}

// Read Rect from reader
func ReadDebugDataRect(reader io.Reader) DebugDataRect {
    var corner1 Vec2Float64
    corner1 = ReadVec2Float64(reader)
    var corner2 Vec2Float64
    corner2 = ReadVec2Float64(reader)
    var color Color
    color = ReadColor(reader)
    return DebugDataRect {
        Corner1: corner1,
        Corner2: corner2,
        Color: color,
    }
}

// Write Rect to writer
func (debugDataRect DebugDataRect) Write(writer io.Writer) {
    WriteInt32(writer, 2)
    corner1 := debugDataRect.Corner1
    corner1.Write(writer)
    corner2 := debugDataRect.Corner2
    corner2.Write(writer)
    color := debugDataRect.Color
    color.Write(writer)
}

// Get string representation of Rect
func (debugDataRect DebugDataRect) String() string {
    stringResult := "{ "
    stringResult += "Corner1: "
    corner1 := debugDataRect.Corner1
    stringResult += corner1.String()
    stringResult += ", "
    stringResult += "Corner2: "
    corner2 := debugDataRect.Corner2
    stringResult += corner2.String()
    stringResult += ", "
    stringResult += "Color: "
    color := debugDataRect.Color
    stringResult += color.String()
    stringResult += " }"
    return stringResult
}

// Text
type DebugDataText struct {
    // Text to draw
    Text string
    // Position
    Pos Vec2Float64
    // Font size
    Size float64
    // Alignment (0 - left, 0.5 - center, 1 - right)
    Align float64
    // Color
    Color Color
}

func NewDebugDataText(text string, pos Vec2Float64, size float64, align float64, color Color) DebugDataText {
    return DebugDataText {
        Text: text,
        Pos: pos,
        Size: size,
        Align: align,
        Color: color,
    }
}

// Read Text from reader
func ReadDebugDataText(reader io.Reader) DebugDataText {
    var text string
    text = ReadString(reader)
    var pos Vec2Float64
    pos = ReadVec2Float64(reader)
    var size float64
    size = ReadFloat64(reader)
    var align float64
    align = ReadFloat64(reader)
    var color Color
    color = ReadColor(reader)
    return DebugDataText {
        Text: text,
        Pos: pos,
        Size: size,
        Align: align,
        Color: color,
    }
}

// Write Text to writer
func (debugDataText DebugDataText) Write(writer io.Writer) {
    WriteInt32(writer, 3)
    text := debugDataText.Text
    WriteString(writer, text)
    pos := debugDataText.Pos
    pos.Write(writer)
    size := debugDataText.Size
    WriteFloat64(writer, size)
    align := debugDataText.Align
    WriteFloat64(writer, align)
    color := debugDataText.Color
    color.Write(writer)
}

// Get string representation of Text
func (debugDataText DebugDataText) String() string {
    stringResult := "{ "
    stringResult += "Text: "
    text := debugDataText.Text
    stringResult += "\"" + text + "\""
    stringResult += ", "
    stringResult += "Pos: "
    pos := debugDataText.Pos
    stringResult += pos.String()
    stringResult += ", "
    stringResult += "Size: "
    size := debugDataText.Size
    stringResult += fmt.Sprint(size)
    stringResult += ", "
    stringResult += "Align: "
    align := debugDataText.Align
    stringResult += fmt.Sprint(align)
    stringResult += ", "
    stringResult += "Color: "
    color := debugDataText.Color
    stringResult += color.String()
    stringResult += " }"
    return stringResult
}