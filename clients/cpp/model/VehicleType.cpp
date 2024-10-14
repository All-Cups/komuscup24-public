#include "VehicleType.hpp"

namespace model {

VehicleType::VehicleType(std::string name, double radius, double weight, double maxBackwardsSpeed, double maxSpeed, double acceleration, double friction, double maxRotateSpeed, double rotateAcceleration, double maxFuel, double fuelUseSpeed) : name(name), radius(radius), weight(weight), maxBackwardsSpeed(maxBackwardsSpeed), maxSpeed(maxSpeed), acceleration(acceleration), friction(friction), maxRotateSpeed(maxRotateSpeed), rotateAcceleration(rotateAcceleration), maxFuel(maxFuel), fuelUseSpeed(fuelUseSpeed) { }

// Read VehicleType from input stream
VehicleType VehicleType::readFrom(InputStream& stream) {
    std::string name = stream.readString();
    double radius = stream.readDouble();
    double weight = stream.readDouble();
    double maxBackwardsSpeed = stream.readDouble();
    double maxSpeed = stream.readDouble();
    double acceleration = stream.readDouble();
    double friction = stream.readDouble();
    double maxRotateSpeed = stream.readDouble();
    double rotateAcceleration = stream.readDouble();
    double maxFuel = stream.readDouble();
    double fuelUseSpeed = stream.readDouble();
    return VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed);
}

// Write VehicleType to output stream
void VehicleType::writeTo(OutputStream& stream) const {
    stream.write(name);
    stream.write(radius);
    stream.write(weight);
    stream.write(maxBackwardsSpeed);
    stream.write(maxSpeed);
    stream.write(acceleration);
    stream.write(friction);
    stream.write(maxRotateSpeed);
    stream.write(rotateAcceleration);
    stream.write(maxFuel);
    stream.write(fuelUseSpeed);
}

// Get string representation of VehicleType
std::string VehicleType::toString() const {
    std::stringstream ss;
    ss << "VehicleType { ";
    ss << "name: ";
    ss << '"' << name << '"';
    ss << ", ";
    ss << "radius: ";
    ss << radius;
    ss << ", ";
    ss << "weight: ";
    ss << weight;
    ss << ", ";
    ss << "maxBackwardsSpeed: ";
    ss << maxBackwardsSpeed;
    ss << ", ";
    ss << "maxSpeed: ";
    ss << maxSpeed;
    ss << ", ";
    ss << "acceleration: ";
    ss << acceleration;
    ss << ", ";
    ss << "friction: ";
    ss << friction;
    ss << ", ";
    ss << "maxRotateSpeed: ";
    ss << maxRotateSpeed;
    ss << ", ";
    ss << "rotateAcceleration: ";
    ss << rotateAcceleration;
    ss << ", ";
    ss << "maxFuel: ";
    ss << maxFuel;
    ss << ", ";
    ss << "fuelUseSpeed: ";
    ss << fuelUseSpeed;
    ss << " }";
    return ss.str();
}

}