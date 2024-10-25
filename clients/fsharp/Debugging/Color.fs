#nowarn "0058"

namespace Komus24
namespace Komus24.Debugging

open Komus24

/// RGBA Color
type Color = {
    /// Red component
    R: double;
    /// Green component
    G: double;
    /// Blue component
    B: double;
    /// Alpha (opacity) component
    A: double;
} with

    /// Write Color to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.R
        writer.Write this.G
        writer.Write this.B
        writer.Write this.A
        ()

    /// Read Color from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        R = reader.ReadDouble()
        G = reader.ReadDouble()
        B = reader.ReadDouble()
        A = reader.ReadDouble()
    }