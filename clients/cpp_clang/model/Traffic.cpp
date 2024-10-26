#include "Traffic.hpp"

namespace model {

Traffic::Traffic(int amount, double moveTime, double radius, double weight, double crashDeceleration, double crashLifetime) : amount(amount), moveTime(moveTime), radius(radius), weight(weight), crashDeceleration(crashDeceleration), crashLifetime(crashLifetime) { }

// Read Traffic from input stream
Traffic Traffic::readFrom(InputStream& stream) {
    int amount = stream.readInt();
    double moveTime = stream.readDouble();
    double radius = stream.readDouble();
    double weight = stream.readDouble();
    double crashDeceleration = stream.readDouble();
    double crashLifetime = stream.readDouble();
    return Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime);
}

// Write Traffic to output stream
void Traffic::writeTo(OutputStream& stream) const {
    stream.write(amount);
    stream.write(moveTime);
    stream.write(radius);
    stream.write(weight);
    stream.write(crashDeceleration);
    stream.write(crashLifetime);
}

// Get string representation of Traffic
std::string Traffic::toString() const {
    std::stringstream ss;
    ss << "Traffic { ";
    ss << "amount: ";
    ss << amount;
    ss << ", ";
    ss << "moveTime: ";
    ss << moveTime;
    ss << ", ";
    ss << "radius: ";
    ss << radius;
    ss << ", ";
    ss << "weight: ";
    ss << weight;
    ss << ", ";
    ss << "crashDeceleration: ";
    ss << crashDeceleration;
    ss << ", ";
    ss << "crashLifetime: ";
    ss << crashLifetime;
    ss << " }";
    return ss.str();
}

}