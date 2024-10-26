#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Auto generated manhattan map
type CityTypeManhattan = {
    /// Map size
    Size: Model.Vec2Int;
    /// Size of a single block
    BlockSize: Model.Vec2Int;
    /// Number of refill stations
    Refills: int;
} with

    /// Write Manhattan to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 0
        this.Size.writeTo writer
        this.BlockSize.writeTo writer
        writer.Write this.Refills
        ()

    /// Read Manhattan from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Size = Model.Vec2Int.readFrom reader;
        BlockSize = Model.Vec2Int.readFrom reader;
        Refills = reader.ReadInt32()
    }

/// Fixed map
type CityTypeInline = {
    /// Each string represents a row in the city
    Cells: string[];
} with

    /// Write Inline to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write 1
        writer.Write this.Cells.Length
        this.Cells |> Array.iter (fun value ->
            let valueData : byte[] = System.Text.Encoding.UTF8.GetBytes value
            writer.Write valueData.Length
            writer.Write valueData )
        ()

    /// Read Inline from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Cells = [|for _ in 1 .. reader.ReadInt32() do
                    yield reader.ReadInt32() |> reader.ReadBytes |> System.Text.Encoding.UTF8.GetString |]
    }

/// City type
type CityType =
    /// Auto generated manhattan map
    | Manhattan of CityTypeManhattan
    /// Fixed map
    | Inline of CityTypeInline
    with

    /// Write CityType to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        match this with
            | Manhattan value -> value.writeTo writer
            | Inline value -> value.writeTo writer

    /// Read CityType from reader
    static member readFrom(reader: System.IO.BinaryReader) =
        match reader.ReadInt32() with
            | 0 -> Manhattan (CityTypeManhattan.readFrom reader)
            | 1 -> Inline (CityTypeInline.readFrom reader)
            | x -> failwith (sprintf "Unexpected tag %d" x)