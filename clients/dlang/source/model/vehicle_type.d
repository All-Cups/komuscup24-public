module model.vehicle_type;

import stream;
import std.conv;
import std.typecons : Nullable;


/// Vehicle type options
struct VehicleType {
    /// Name
    string name;
    /// Radius
    double radius;
    /// Weight
    double weight;
    /// Maximal backwads movement speed
    double maxBackwardsSpeed;
    /// Maximal forward movement speed
    double maxSpeed;
    /// Acceleration
    double acceleration;
    /// Friction coefficient
    double friction;
    /// Maximal rotation speed
    double maxRotateSpeed;
    /// Rotational acceleration
    double rotateAcceleration;
    /// Maximal amount of fuel
    double maxFuel;
    /// Fuel usage speed
    double fuelUseSpeed;

    this(string name, double radius, double weight, double maxBackwardsSpeed, double maxSpeed, double acceleration, double friction, double maxRotateSpeed, double rotateAcceleration, double maxFuel, double fuelUseSpeed) {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.friction = friction;
        this.maxRotateSpeed = maxRotateSpeed;
        this.rotateAcceleration = rotateAcceleration;
        this.maxFuel = maxFuel;
        this.fuelUseSpeed = fuelUseSpeed;
    }

    /// Read VehicleType from reader
    static VehicleType readFrom(Stream reader) {
        string name;
        name = reader.readString();
        double radius;
        radius = reader.readDouble();
        double weight;
        weight = reader.readDouble();
        double maxBackwardsSpeed;
        maxBackwardsSpeed = reader.readDouble();
        double maxSpeed;
        maxSpeed = reader.readDouble();
        double acceleration;
        acceleration = reader.readDouble();
        double friction;
        friction = reader.readDouble();
        double maxRotateSpeed;
        maxRotateSpeed = reader.readDouble();
        double rotateAcceleration;
        rotateAcceleration = reader.readDouble();
        double maxFuel;
        maxFuel = reader.readDouble();
        double fuelUseSpeed;
        fuelUseSpeed = reader.readDouble();
        return VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed);
    }

    /// Write VehicleType to writer
    void writeTo(Stream writer) const {
        writer.write(name);
        writer.write(radius);
        writer.write(weight);
        writer.write(maxBackwardsSpeed);
        writer.write(maxSpeed);
        writer.write(acceleration);
        writer.write(friction);
        writer.write(maxRotateSpeed);
        writer.write(rotateAcceleration);
        writer.write(maxFuel);
        writer.write(fuelUseSpeed);
    }
}