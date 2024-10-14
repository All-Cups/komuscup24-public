#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type MinMaxRangeInt64 = {
    /// TODO - Document
    Min: int64;
    /// TODO - Document
    Max: int64;
} with

    /// Write MinMaxRangeInt64 to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.Min
        writer.Write this.Max
        ()

    /// Read MinMaxRangeInt64 from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Min = reader.ReadInt64()
        Max = reader.ReadInt64()
    }