#ifndef __MODEL_VEC2_DOUBLE_HPP__
#define __MODEL_VEC2_DOUBLE_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// 2 dimensional vector.
class Vec2Double {
public:
    // `x` coordinate of the vector
    double x;
    // `y` coordinate of the vector
    double y;

    Vec2Double(double x, double y);

    // Read Vec2Double from input stream
    static Vec2Double readFrom(InputStream& stream);

    // Write Vec2Double to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Vec2Double
    std::string toString() const;
};

}

#endif