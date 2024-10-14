#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type VehicleOrder = {
    /// -1..+1
    Accelerate: double;
    /// TODO - Document
    Brakes: bool;
    /// -1..+1
    Rotate: double;
} with

    /// Write VehicleOrder to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.Accelerate
        writer.Write this.Brakes
        writer.Write this.Rotate
        ()

    /// Read VehicleOrder from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Accelerate = reader.ReadDouble()
        Brakes = reader.ReadBoolean()
        Rotate = reader.ReadDouble()
    }