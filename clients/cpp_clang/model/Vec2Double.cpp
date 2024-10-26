#include "Vec2Double.hpp"

namespace model {

Vec2Double::Vec2Double(double x, double y) : x(x), y(y) { }

// Read Vec2Double from input stream
Vec2Double Vec2Double::readFrom(InputStream& stream) {
    double x = stream.readDouble();
    double y = stream.readDouble();
    return Vec2Double(x, y);
}

// Write Vec2Double to output stream
void Vec2Double::writeTo(OutputStream& stream) const {
    stream.write(x);
    stream.write(y);
}

// Get string representation of Vec2Double
std::string Vec2Double::toString() const {
    std::stringstream ss;
    ss << "Vec2Double { ";
    ss << "x: ";
    ss << x;
    ss << ", ";
    ss << "y: ";
    ss << y;
    ss << " }";
    return ss.str();
}

}