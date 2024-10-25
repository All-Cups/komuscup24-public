#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Options for traffic
type Traffic = {
    /// Number of traffic cars
    Amount: int;
    /// Time to move between adjacent keypoints
    MoveTime: double;
    /// Radius of each traffic car
    Radius: double;
    /// Weight of each traffic car
    Weight: double;
    /// Deceleration after crash
    CrashDeceleration: double;
    /// Lifetime after crash
    CrashLifetime: double;
} with

    /// Write Traffic to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        writer.Write this.Amount
        writer.Write this.MoveTime
        writer.Write this.Radius
        writer.Write this.Weight
        writer.Write this.CrashDeceleration
        writer.Write this.CrashLifetime
        ()

    /// Read Traffic from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Amount = reader.ReadInt32()
        MoveTime = reader.ReadDouble()
        Radius = reader.ReadDouble()
        Weight = reader.ReadDouble()
        CrashDeceleration = reader.ReadDouble()
        CrashLifetime = reader.ReadDouble()
    }