#nowarn "0058"

namespace Komus24
namespace Komus24.Debugging

open Komus24

/// Circle
type DebugDataCircle = {
    /// Center
    Pos: Model.Vec2Double;
    /// Radius
    Radius: double;
    /// Color
    Color: Debugging.Color;
} with

    /// Write Circle to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 0
        this.Pos.writeTo writer
        writer.Write this.Radius
        this.Color.writeTo writer
        ()

    /// Read Circle from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Pos = Model.Vec2Double.readFrom reader;
        Radius = reader.ReadDouble()
        Color = Debugging.Color.readFrom reader;
    }

/// Line (segment)
type DebugDataLine = {
    /// First end
    Point1: Model.Vec2Double;
    /// Other end
    Point2: Model.Vec2Double;
    /// Thickness
    Width: double;
    /// Color
    Color: Debugging.Color;
} with

    /// Write Line to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 1
        this.Point1.writeTo writer
        this.Point2.writeTo writer
        writer.Write this.Width
        this.Color.writeTo writer
        ()

    /// Read Line from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Point1 = Model.Vec2Double.readFrom reader;
        Point2 = Model.Vec2Double.readFrom reader;
        Width = reader.ReadDouble()
        Color = Debugging.Color.readFrom reader;
    }

/// Rectangle
type DebugDataRect = {
    /// One of the corners
    Corner1: Model.Vec2Double;
    /// Opposite corner
    Corner2: Model.Vec2Double;
    /// Color
    Color: Debugging.Color;
} with

    /// Write Rect to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 2
        this.Corner1.writeTo writer
        this.Corner2.writeTo writer
        this.Color.writeTo writer
        ()

    /// Read Rect from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Corner1 = Model.Vec2Double.readFrom reader;
        Corner2 = Model.Vec2Double.readFrom reader;
        Color = Debugging.Color.readFrom reader;
    }

/// Text
type DebugDataText = {
    /// Text to draw
    Text: string;
    /// Position
    Pos: Model.Vec2Double;
    /// Font size
    Size: double;
    /// Alignment (0 - left, 0.5 - center, 1 - right)
    Align: double;
    /// Color
    Color: Debugging.Color;
} with

    /// Write Text to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 3
        let textData : byte[] = System.Text.Encoding.UTF8.GetBytes this.Text
        writer.Write textData.Length
        writer.Write textData
        this.Pos.writeTo writer
        writer.Write this.Size
        writer.Write this.Align
        this.Color.writeTo writer
        ()

    /// Read Text from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Text = reader.ReadInt32() |> reader.ReadBytes |> System.Text.Encoding.UTF8.GetString
        Pos = Model.Vec2Double.readFrom reader;
        Size = reader.ReadDouble()
        Align = reader.ReadDouble()
        Color = Debugging.Color.readFrom reader;
    }

/// Data for debug rendering
type DebugData =
    /// Circle
    | Circle of DebugDataCircle
    /// Line (segment)
    | Line of DebugDataLine
    /// Rectangle
    | Rect of DebugDataRect
    /// Text
    | Text of DebugDataText
    with

    /// Write DebugData to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        match this with
            | Circle value -> value.writeTo writer
            | Line value -> value.writeTo writer
            | Rect value -> value.writeTo writer
            | Text value -> value.writeTo writer

    /// Read DebugData from reader
    static member readFrom(reader: System.IO.BinaryReader) =
        match reader.ReadInt32() with
            | 0 -> Circle (DebugDataCircle.readFrom reader)
            | 1 -> Line (DebugDataLine.readFrom reader)
            | 2 -> Rect (DebugDataRect.readFrom reader)
            | 3 -> Text (DebugDataText.readFrom reader)
            | x -> failwith (sprintf "Unexpected tag %d" x)