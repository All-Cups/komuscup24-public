#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// A vehicle
type Vehicle = {
    /// Current position (center)
    Position: Model.Vec2Double;
    /// Velocity vector
    Velocity: Model.Vec2Double;
    /// Speed of wheels
    Speed: double;
    /// Rotation speed (radians/second)
    RotationSpeed: double;
    /// Current rotation
    Rotation: double;
    /// Vehicle type index
    TypeIndex: int;
    /// Current quest, if any
    Quest: option<Model.Quest>;
    /// Remaining fuel
    Fuel: double;
} with

    /// Write Vehicle to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        this.Position.writeTo writer
        this.Velocity.writeTo writer
        writer.Write this.Speed
        writer.Write this.RotationSpeed
        writer.Write this.Rotation
        writer.Write this.TypeIndex
        match this.Quest with
            | Some value ->
                writer.Write true
                value.writeTo writer
            | None -> writer.Write false
        writer.Write this.Fuel
        ()

    /// Read Vehicle from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Position = Model.Vec2Double.readFrom reader;
        Velocity = Model.Vec2Double.readFrom reader;
        Speed = reader.ReadDouble()
        RotationSpeed = reader.ReadDouble()
        Rotation = reader.ReadDouble()
        TypeIndex = reader.ReadInt32()
        Quest = match reader.ReadBoolean() with
                    | true -> Some(Model.Quest.readFrom reader;)
                    | false -> None
        Fuel = reader.ReadDouble()
    }