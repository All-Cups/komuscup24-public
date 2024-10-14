#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// TODO - Document
type Vehicle = {
    /// TODO - Document
    Position: Model.Vec2Double;
    /// TODO - Document
    Velocity: Model.Vec2Double;
    /// TODO - Document
    Speed: double;
    /// TODO - Document
    RotationSpeed: double;
    /// TODO - Document
    Rotation: double;
    /// TODO - Document
    TypeIndex: int;
    /// TODO maybe multiple quests at the same time?
    Quest: option<Model.Quest>;
    /// TODO - Document
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