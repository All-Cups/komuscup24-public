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

// TODO - Document
class Constants {
public:
    // TODO - Document
    int maxTickCount;
    // TODO - Document
    double maxGameTimeSeconds;
    // TODO - Document
    double ticksPerSecond;
    // TODO - Document
    int microticks;
    // TODO - Document
    double cellSize;
    // TODO - Document
    double collisionBounciness;
    // TODO - Document
    model::CityType cityType;
    // TODO - Document
    std::vector<model::VehicleType> vehicleTypes;
    // TODO - Document
    double refillSpeed;
    // TODO - Document
    int questCount;
    // TODO - Document
    model::MinMaxRangeLong questScore;
    // TODO - Document
    model::Traffic traffic;
    // TODO - Document
    std::vector<std::vector<model::CityCell>> city;

    Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, model::CityType cityType, std::vector<model::VehicleType> vehicleTypes, double refillSpeed, int questCount, model::MinMaxRangeLong questScore, model::Traffic traffic, std::vector<std::vector<model::CityCell>> city);

    // Read Constants from input stream
    static Constants readFrom(InputStream& stream);

    // Write Constants to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Constants
    std::string toString() const;
};

}

#endif