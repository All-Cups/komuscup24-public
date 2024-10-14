#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type DebugDataCircle = {
    /// TODO - Document
    Pos: Model.Vec2Double;
    /// TODO - Document
    Radius: double;
} with

    /// Write Circle to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 0
        this.Pos.writeTo writer
        writer.Write this.Radius
        ()

    /// Read Circle from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Pos = Model.Vec2Double.readFrom reader;
        Radius = reader.ReadDouble()
    }

/// TODO - Document
type DebugData =
    /// TODO - Document
    | Circle of DebugDataCircle
    with

    /// Write DebugData to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        match this with
            | Circle value -> value.writeTo writer

    /// Read DebugData from reader
    static member readFrom(reader: System.IO.BinaryReader) =
        match reader.ReadInt32() with
            | 0 -> Circle (DebugDataCircle.readFrom reader)
            | x -> failwith (sprintf "Unexpected tag %d" x)