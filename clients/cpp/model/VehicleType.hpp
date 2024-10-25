#ifndef __MODEL_VEHICLE_TYPE_HPP__
#define __MODEL_VEHICLE_TYPE_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// Vehicle type options
class VehicleType {
public:
    // Name
    std::string name;
    // Radius
    double radius;
    // Weight
    double weight;
    // Maximal backwads movement speed
    double maxBackwardsSpeed;
    // Maximal forward movement speed
    double maxSpeed;
    // Acceleration
    double acceleration;
    // Friction coefficient
    double friction;
    // Maximal rotation speed
    double maxRotateSpeed;
    // Rotational acceleration
    double rotateAcceleration;
    // Maximal amount of fuel
    double maxFuel;
    // Fuel usage speed
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