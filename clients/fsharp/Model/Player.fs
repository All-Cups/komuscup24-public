#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type Player = {
    /// TODO - Document
    Index: int;
    /// TODO - Document
    Score: int64;
    /// TODO - Document
    Vehicles: Model.Vehicle[];
} with

    /// Write Player to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.Index
        writer.Write this.Score
        writer.Write this.Vehicles.Length
        this.Vehicles |> Array.iter (fun value ->
            value.writeTo writer )
        ()

    /// Read Player from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Index = reader.ReadInt32()
        Score = reader.ReadInt64()
        Vehicles = [|for _ in 1 .. reader.ReadInt32() do
                       yield Model.Vehicle.readFrom reader; |]
    }