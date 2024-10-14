#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type Traffic = {
    /// TODO - Document
    Amount: int;
    /// TODO - Document
    MoveTime: double;
    /// TODO - Document
    Radius: double;
    /// TODO - Document
    Weight: double;
    /// TODO - Document
    CrashDeceleration: double;
    /// TODO - Document
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