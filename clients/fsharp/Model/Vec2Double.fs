#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// 2 dimensional vector.
type Vec2Double = {
    /// `x` coordinate of the vector
    X: double;
    /// `y` coordinate of the vector
    Y: double;
} with

    /// Write Vec2Double to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.X
        writer.Write this.Y
        ()

    /// Read Vec2Double from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        X = reader.ReadDouble()
        Y = reader.ReadDouble()
    }