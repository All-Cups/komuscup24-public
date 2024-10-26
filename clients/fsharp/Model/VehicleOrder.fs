#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Order for controlling a single vehicle
type VehicleOrder = {
    /// Acceleration (-1 - fully backwards, +1 - fully forward)
    Accelerate: double;
    /// Hand brakes
    Brakes: bool;
    /// Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
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