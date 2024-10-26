#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Current game's state
type PlayerView = {
    /// Current tick number
    CurrentTick: int;
    /// Your player
    You: Model.Player;
    /// Other players
    Other: Model.Player[];
    /// Available quests
    Quests: Model.Quest[];
} with

    /// Write PlayerView to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.CurrentTick
        this.You.writeTo writer
        writer.Write this.Other.Length
        this.Other |> Array.iter (fun value ->
            value.writeTo writer )
        writer.Write this.Quests.Length
        this.Quests |> Array.iter (fun value ->
            value.writeTo writer )
        ()

    /// Read PlayerView from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        CurrentTick = reader.ReadInt32()
        You = Model.Player.readFrom reader;
        Other = [|for _ in 1 .. reader.ReadInt32() do
                    yield Model.Player.readFrom reader; |]
        Quests = [|for _ in 1 .. reader.ReadInt32() do
                     yield Model.Quest.readFrom reader; |]
    }