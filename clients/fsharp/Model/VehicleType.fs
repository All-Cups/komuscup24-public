#nowarn "0058"

namespace Komus24
namespace Komus24.Model

open Komus24

/// Vehicle type options
type VehicleType = {
    /// Name
    Name: string;
    /// Radius
    Radius: double;
    /// Weight
    Weight: double;
    /// Maximal backwads movement speed
    MaxBackwardsSpeed: double;
    /// Maximal forward movement speed
    MaxSpeed: double;
    /// Acceleration
    Acceleration: double;
    /// Friction coefficient
    Friction: double;
    /// Maximal rotation speed
    MaxRotateSpeed: double;
    /// Rotational acceleration
    RotateAcceleration: double;
    /// Maximal amount of fuel
    MaxFuel: double;
    /// Fuel usage speed
    FuelUseSpeed: double;
} with

    /// Write VehicleType to writer
    member this.writeTo(writer: System.IO.BinaryWriter) =
        let nameData : byte[] = System.Text.Encoding.UTF8.GetBytes this.Name
        writer.Write nameData.Length
        writer.Write nameData
        writer.Write this.Radius
        writer.Write this.Weight
        writer.Write this.MaxBackwardsSpeed
        writer.Write this.MaxSpeed
        writer.Write this.Acceleration
        writer.Write this.Friction
        writer.Write this.MaxRotateSpeed
        writer.Write this.RotateAcceleration
        writer.Write this.MaxFuel
        writer.Write this.FuelUseSpeed
        ()

    /// Read VehicleType from reader
    static member readFrom(reader: System.IO.BinaryReader) = {
        Name = reader.ReadInt32() |> reader.ReadBytes |> System.Text.Encoding.UTF8.GetString
        Radius = reader.ReadDouble()
        Weight = reader.ReadDouble()
        MaxBackwardsSpeed = reader.ReadDouble()
        MaxSpeed = reader.ReadDouble()
        Acceleration = reader.ReadDouble()
        Friction = reader.ReadDouble()
        MaxRotateSpeed = reader.ReadDouble()
        RotateAcceleration = reader.ReadDouble()
        MaxFuel = reader.ReadDouble()
        FuelUseSpeed = reader.ReadDouble()
    }