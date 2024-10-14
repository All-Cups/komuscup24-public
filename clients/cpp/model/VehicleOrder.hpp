#ifndef __MODEL_VEHICLE_ORDER_HPP__
#define __MODEL_VEHICLE_ORDER_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// TODO - Document
class VehicleOrder {
public:
    // -1..+1
    double accelerate;
    // TODO - Document
    bool brakes;
    // -1..+1
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