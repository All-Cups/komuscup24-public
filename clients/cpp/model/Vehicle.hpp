#ifndef __MODEL_VEHICLE_HPP__
#define __MODEL_VEHICLE_HPP__

#include "Stream.hpp"
#include "model/Quest.hpp"
#include "model/Vec2Double.hpp"
#include "model/Vec2Int.hpp"
#include <optional>
#include <sstream>
#include <stdexcept>
#include <string>

namespace model {

// A vehicle
class Vehicle {
public:
    // Current position (center)
    model::Vec2Double position;
    // Velocity vector
    model::Vec2Double velocity;
    // Speed of wheels
    double speed;
    // Rotation speed (radians/second)
    double rotationSpeed;
    // Current rotation
    double rotation;
    // Vehicle type index
    int typeIndex;
    // Current quest, if any
    std::optional<model::Quest> quest;
    // Remaining fuel
    double fuel;

    Vehicle(model::Vec2Double position, model::Vec2Double velocity, double speed, double rotationSpeed, double rotation, int typeIndex, std::optional<model::Quest> quest, double fuel);

    // Read Vehicle from input stream
    static Vehicle readFrom(InputStream& stream);

    // Write Vehicle to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Vehicle
    std::string toString() const;
};

}

#endif