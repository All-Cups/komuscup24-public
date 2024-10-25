#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// A delivery quest
type Quest = {
    /// Cell where to pick delivery from
    PickupCell: Model.Vec2Int;
    /// Cell to drop the delivery at
    DropCell: Model.Vec2Int;
    /// Score for completing the quest
    Score: int64;
} with

    /// Write Quest to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        this.PickupCell.writeTo writer
        this.DropCell.writeTo writer
        writer.Write this.Score
        ()

    /// Read Quest from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        PickupCell = Model.Vec2Int.readFrom reader;
        DropCell = Model.Vec2Int.readFrom reader;
        Score = reader.ReadInt64()
    }