#include "Vehicle.hpp"

namespace model {

Vehicle::Vehicle(model::Vec2Double position, model::Vec2Double velocity, double speed, double rotationSpeed, double rotation, int typeIndex, std::optional<model::Quest> quest, double fuel) : position(position), velocity(velocity), speed(speed), rotationSpeed(rotationSpeed), rotation(rotation), typeIndex(typeIndex), quest(quest), fuel(fuel) { }

// Read Vehicle from input stream
Vehicle Vehicle::readFrom(InputStream& stream) {
    model::Vec2Double position = model::Vec2Double::readFrom(stream);
    model::Vec2Double velocity = model::Vec2Double::readFrom(stream);
    double speed = stream.readDouble();
    double rotationSpeed = stream.readDouble();
    double rotation = stream.readDouble();
    int typeIndex = stream.readInt();
    std::optional<model::Quest> quest = std::optional<model::Quest>();
    if (stream.readBool()) {
        model::Quest questValue = model::Quest::readFrom(stream);
        quest.emplace(questValue);
    }
    double fuel = stream.readDouble();
    return Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel);
}

// Write Vehicle to output stream
void Vehicle::writeTo(OutputStream& stream) const {
    position.writeTo(stream);
    velocity.writeTo(stream);
    stream.write(speed);
    stream.write(rotationSpeed);
    stream.write(rotation);
    stream.write(typeIndex);
    if (quest) {
        stream.write(true);
        const model::Quest& questValue = *quest;
        questValue.writeTo(stream);
    } else {
        stream.write(false);
    }
    stream.write(fuel);
}

// Get string representation of Vehicle
std::string Vehicle::toString() const {
    std::stringstream ss;
    ss << "Vehicle { ";
    ss << "position: ";
    ss << position.toString();
    ss << ", ";
    ss << "velocity: ";
    ss << velocity.toString();
    ss << ", ";
    ss << "speed: ";
    ss << speed;
    ss << ", ";
    ss << "rotationSpeed: ";
    ss << rotationSpeed;
    ss << ", ";
    ss << "rotation: ";
    ss << rotation;
    ss << ", ";
    ss << "typeIndex: ";
    ss << typeIndex;
    ss << ", ";
    ss << "quest: ";
    if (quest) {
        const model::Quest& questValue = *quest;
        ss << questValue.toString();
    } else {
        ss << "none";
    }
    ss << ", ";
    ss << "fuel: ";
    ss << fuel;
    ss << " }";
    return ss.str();
}

}