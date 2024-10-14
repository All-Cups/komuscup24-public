#include "DebugData.hpp"
#include <stdexcept>

namespace model {

Circle::Circle(model::Vec2Double pos, double radius) : pos(pos), radius(radius) { }

// Read Circle from input stream
Circle Circle::readFrom(InputStream& stream) {
    model::Vec2Double pos = model::Vec2Double::readFrom(stream);
    double radius = stream.readDouble();
    return Circle(pos, radius);
}

// Write Circle to output stream
void Circle::writeTo(OutputStream& stream) const {
    pos.writeTo(stream);
    stream.write(radius);
}

// Get string representation of Circle
std::string Circle::toString() const {
    std::stringstream ss;
    ss << "Circle { ";
    ss << "pos: ";
    ss << pos.toString();
    ss << ", ";
    ss << "radius: ";
    ss << radius;
    ss << " }";
    return ss.str();
}

    
// Read DebugData from input stream
DebugData readDebugData(InputStream& stream) {
    switch (stream.readInt()) {
    case 0:
        return Circle::readFrom(stream);
    default:
        throw std::runtime_error("Unexpected tag value");
    }
}

// Write DebugData to output stream
void writeDebugData(const DebugData& value, OutputStream& stream) {
    std::visit([&](auto& arg) {
        using T = std::decay_t<decltype(arg)>;
        if constexpr (std::is_same_v<T, Circle>) {
            stream.write((int) 0);
        }
        arg.writeTo(stream);
    }, value);
}

// Get string representation of DebugData
std::string debugDataToString(const DebugData& value) {
    return std::visit([](auto& arg) {
        return arg.toString();
    }, value);
}


}