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

// TODO - Document
class Vehicle {
public:
    // TODO - Document
    model::Vec2Double position;
    // TODO - Document
    model::Vec2Double velocity;
    // TODO - Document
    double speed;
    // TODO - Document
    double rotationSpeed;
    // TODO - Document
    double rotation;
    // TODO - Document
    int typeIndex;
    // TODO maybe multiple quests at the same time?
    std::optional<model::Quest> quest;
    // TODO - Document
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