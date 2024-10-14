module model.vehicle;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.quest;
import model.vec2_double;

/// TODO - Document
struct Vehicle {
    /// TODO - Document
    model.Vec2Double position;
    /// TODO - Document
    model.Vec2Double velocity;
    /// TODO - Document
    double speed;
    /// TODO - Document
    double rotationSpeed;
    /// TODO - Document
    double rotation;
    /// TODO - Document
    int typeIndex;
    /// TODO maybe multiple quests at the same time?
    Nullable!(model.Quest) quest;
    /// TODO - Document
    double fuel;

    this(model.Vec2Double position, model.Vec2Double velocity, double speed, double rotationSpeed, double rotation, int typeIndex, Nullable!(model.Quest) quest, double fuel) {
        this.position = position;
        this.velocity = velocity;
        this.speed = speed;
        this.rotationSpeed = rotationSpeed;
        this.rotation = rotation;
        this.typeIndex = typeIndex;
        this.quest = quest;
        this.fuel = fuel;
    }

    /// Read Vehicle from reader
    static Vehicle readFrom(Stream reader) {
        model.Vec2Double position;
        position = model.Vec2Double.readFrom(reader);
        model.Vec2Double velocity;
        velocity = model.Vec2Double.readFrom(reader);
        double speed;
        speed = reader.readDouble();
        double rotationSpeed;
        rotationSpeed = reader.readDouble();
        double rotation;
        rotation = reader.readDouble();
        int typeIndex;
        typeIndex = reader.readInt();
        Nullable!(model.Quest) quest;
        if (reader.readBool()) {
            quest = model.Quest.readFrom(reader);
        } else {
            quest.nullify();
        }
        double fuel;
        fuel = reader.readDouble();
        return Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel);
    }

    /// Write Vehicle to writer
    void writeTo(Stream writer) const {
        position.writeTo(writer);
        velocity.writeTo(writer);
        writer.write(speed);
        writer.write(rotationSpeed);
        writer.write(rotation);
        writer.write(typeIndex);
        if (quest.isNull()) {
            writer.write(false);
        } else {
            writer.write(true);
            auto questValue = quest.get;
            questValue.writeTo(writer);
        }
        writer.write(fuel);
    }
}