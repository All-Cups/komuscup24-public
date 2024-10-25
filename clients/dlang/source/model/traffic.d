module model.traffic;

import stream;
import std.conv;
import std.typecons : Nullable;


/// Options for traffic
struct Traffic {
    /// Number of traffic cars
    int amount;
    /// Time to move between adjacent keypoints
    double moveTime;
    /// Radius of each traffic car
    double radius;
    /// Weight of each traffic car
    double weight;
    /// Deceleration after crash
    double crashDeceleration;
    /// Lifetime after crash
    double crashLifetime;

    this(int amount, double moveTime, double radius, double weight, double crashDeceleration, double crashLifetime) {
        this.amount = amount;
        this.moveTime = moveTime;
        this.radius = radius;
        this.weight = weight;
        this.crashDeceleration = crashDeceleration;
        this.crashLifetime = crashLifetime;
    }

    /// Read Traffic from reader
    static Traffic readFrom(Stream reader) {
        int amount;
        amount = reader.readInt();
        double moveTime;
        moveTime = reader.readDouble();
        double radius;
        radius = reader.readDouble();
        double weight;
        weight = reader.readDouble();
        double crashDeceleration;
        crashDeceleration = reader.readDouble();
        double crashLifetime;
        crashLifetime = reader.readDouble();
        return Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime);
    }

    /// Write Traffic to writer
    void writeTo(Stream writer) const {
        writer.write(amount);
        writer.write(moveTime);
        writer.write(radius);
        writer.write(weight);
        writer.write(crashDeceleration);
        writer.write(crashLifetime);
    }
}