#ifndef __MODEL_VEHICLE_ORDER_HPP__
#define __MODEL_VEHICLE_ORDER_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// Order for controlling a single vehicle
class VehicleOrder {
public:
    // Acceleration (-1 - fully backwards, +1 - fully forward)
    double accelerate;
    // Hand brakes
    bool brakes;
    // Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
    double rotate;

    VehicleOrder(double accelerate, bool brakes, double rotate);

    // Read VehicleOrder from input stream
    static VehicleOrder readFrom(InputStream& stream);

    // Write VehicleOrder to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of VehicleOrder
    std::string toString() const;
};

}

#endif