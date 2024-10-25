#ifndef __MODEL_CONSTANTS_HPP__
#define __MODEL_CONSTANTS_HPP__

#include "Stream.hpp"
#include "model/CityCell.hpp"
#include "model/CityType.hpp"
#include "model/MinMaxRangeLong.hpp"
#include "model/Traffic.hpp"
#include "model/Vec2Int.hpp"
#include "model/VehicleType.hpp"
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>
#include <variant>
#include <vector>

namespace model {

// Game constants
class Constants {
public:
    // Max duration of the game in ticks
    int maxTickCount;
    // Max game time in seconds
    double maxGameTimeSeconds;
    // Ticks per second
    double ticksPerSecond;
    // Subticks for physics simulation
    int microticks;
    // Size of a single city cell
    double cellSize;
    // Collision bounciness
    double collisionBounciness;
    // City type
    model::CityType cityType;
    // List of vehicle types
    std::vector<model::VehicleType> vehicleTypes;
    // Speed of refueling at a station
    double refillSpeed;
    // Number of available quests
    int questCount;
    // Score range for quests
    model::MinMaxRangeLong questScore;
    // Traffic options
    model::Traffic traffic;
    // Collision penalty modifier
    double collisionPenaltyModifier;
    // Map of the city
    std::vector<std::vector<model::CityCell>> city;

    Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, model::CityType cityType, std::vector<model::VehicleType> vehicleTypes, double refillSpeed, int questCount, model::MinMaxRangeLong questScore, model::Traffic traffic, double collisionPenaltyModifier, std::vector<std::vector<model::CityCell>> city);

    // Read Constants from input stream
    static Constants readFrom(InputStream& stream);

    // Write Constants to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Constants
    std::string toString() const;
};

}

#endif