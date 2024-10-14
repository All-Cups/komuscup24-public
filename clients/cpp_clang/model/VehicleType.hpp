#ifndef __MODEL_VEHICLE_TYPE_HPP__
#define __MODEL_VEHICLE_TYPE_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// TODO - Document
class VehicleType {
public:
    // TODO - Document
    std::string name;
    // TODO - Document
    double radius;
    // TODO - Document
    double weight;
    // TODO - Document
    double maxBackwardsSpeed;
    // TODO - Document
    double maxSpeed;
    // TODO - Document
    double acceleration;
    // TODO - Document
    double friction;
    // TODO - Document
    double maxRotateSpeed;
    // TODO - Document
    double rotateAcceleration;
    // TODO - Document
    double maxFuel;
    // TODO - Document
    double fuelUseSpeed;

    VehicleType(std::string name, double radius, double weight, double maxBackwardsSpeed, double maxSpeed, double acceleration, double friction, double maxRotateSpeed, double rotateAcceleration, double maxFuel, double fuelUseSpeed);

    // Read VehicleType from input stream
    static VehicleType readFrom(InputStream& stream);

    // Write VehicleType to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of VehicleType
    std::string toString() const;
};

}

#endif