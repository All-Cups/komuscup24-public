#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Game constants
type Constants = {
    /// Max duration of the game in ticks
    MaxTickCount: int;
    /// Max game time in seconds
    MaxGameTimeSeconds: double;
    /// Ticks per second
    TicksPerSecond: double;
    /// Subticks for physics simulation
    Microticks: int;
    /// Size of a single city cell
    CellSize: double;
    /// Collision bounciness
    CollisionBounciness: double;
    /// City type
    CityType: Model.CityType;
    /// List of vehicle types
    VehicleTypes: Model.VehicleType[];
    /// Speed of refueling at a station
    RefillSpeed: double;
    /// Number of available quests
    QuestCount: int;
    /// Score range for quests
    QuestScore: Model.MinMaxRangeInt64;
    /// Traffic options
    Traffic: Model.Traffic;
    /// Collision penalty modifier
    CollisionPenaltyModifier: double;
    /// Map of the city
    City: Model.CityCell[][];
} with

    /// Write Constants to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.MaxTickCount
        writer.Write this.MaxGameTimeSeconds
        writer.Write this.TicksPerSecond
        writer.Write this.Microticks
        writer.Write this.CellSize
        writer.Write this.CollisionBounciness
        this.CityType.writeTo writer
        writer.Write this.VehicleTypes.Length
        this.VehicleTypes |> Array.iter (fun value ->
            value.writeTo writer )
        writer.Write this.RefillSpeed
        writer.Write this.QuestCount
        this.QuestScore.writeTo writer
        this.Traffic.writeTo writer
        writer.Write this.CollisionPenaltyModifier
        writer.Write this.City.Length
        this.City |> Array.iter (fun value ->
            writer.Write value.Length
            value |> Array.iter (fun value ->
                writer.Write (int value) ) )
        ()

    /// Read Constants from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        MaxTickCount = reader.ReadInt32()
        MaxGameTimeSeconds = reader.ReadDouble()
        TicksPerSecond = reader.ReadDouble()
        Microticks = reader.ReadInt32()
        CellSize = reader.ReadDouble()
        CollisionBounciness = reader.ReadDouble()
        CityType = Model.CityType.readFrom reader;
        VehicleTypes = [|for _ in 1 .. reader.ReadInt32() do
                           yield Model.VehicleType.readFrom reader; |]
        RefillSpeed = reader.ReadDouble()
        QuestCount = reader.ReadInt32()
        QuestScore = Model.MinMaxRangeInt64.readFrom reader;
        Traffic = Model.Traffic.readFrom reader;
        CollisionPenaltyModifier = reader.ReadDouble()
        City = [|for _ in 1 .. reader.ReadInt32() do
                   yield [|for _ in 1 .. reader.ReadInt32() do
                             yield reader.ReadInt32() |> enum |] |]
    }