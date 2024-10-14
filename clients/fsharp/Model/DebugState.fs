#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type DebugState = {
    /// TODO - Document
    PressedKeys: string[];
} with

    /// Write DebugState to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.PressedKeys.Length
        this.PressedKeys |> Array.iter (fun value ->
            let valueData : byte[] = System.Text.Encoding.UTF8.GetBytes value
            writer.Write valueData.Length
            writer.Write valueData )
        ()

    /// Read DebugState from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        PressedKeys = [|for _ in 1 .. reader.ReadInt32() do
                          yield reader.ReadInt32() |> reader.ReadBytes |> System.Text.Encoding.UTF8.GetString |]
    }