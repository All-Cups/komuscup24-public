#include "VehicleOrder.hpp"

namespace model {

VehicleOrder::VehicleOrder(double accelerate, bool brakes, double rotate) : accelerate(accelerate), brakes(brakes), rotate(rotate) { }

// Read VehicleOrder from input stream
VehicleOrder VehicleOrder::readFrom(InputStream& stream) {
    double accelerate = stream.readDouble();
    bool brakes = stream.readBool();
    double rotate = stream.readDouble();
    return VehicleOrder(accelerate, brakes, rotate);
}

// Write VehicleOrder to output stream
void VehicleOrder::writeTo(OutputStream& stream) const {
    stream.write(accelerate);
    stream.write(brakes);
    stream.write(rotate);
}

// Get string representation of VehicleOrder
std::string VehicleOrder::toString() const {
    std::stringstream ss;
    ss << "VehicleOrder { ";
    ss << "accelerate: ";
    ss << accelerate;
    ss << ", ";
    ss << "brakes: ";
    ss << brakes;
    ss << ", ";
    ss << "rotate: ";
    ss << rotate;
    ss << " }";
    return ss.str();
}

}