#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Player's orders
type Order = {
    /// Orders for each of the vehicles
    Vehicles: Model.VehicleOrder[];
} with

    /// Write Order to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.Vehicles.Length
        this.Vehicles |> Array.iter (fun value ->
            value.writeTo writer )
        ()

    /// Read Order from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Vehicles = [|for _ in 1 .. reader.ReadInt32() do
                       yield Model.VehicleOrder.readFrom reader; |]
    }