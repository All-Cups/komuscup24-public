#ifndef __MODEL_DEBUG_DATA_HPP__
#define __MODEL_DEBUG_DATA_HPP__

#include "Stream.hpp"
#include "model/Vec2Double.hpp"
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>
#include <variant>

namespace model {


// TODO - Document
class Circle {
public:
    // TODO - Document
    model::Vec2Double pos;
    // TODO - Document
    double radius;

    Circle(model::Vec2Double pos, double radius);

    // Read Circle from input stream
    static Circle readFrom(InputStream& stream);

    // Write Circle to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Circle
    std::string toString() const;
};

// TODO - Document
typedef std::variant<Circle> DebugData;

// Read DebugData from input stream
DebugData readDebugData(InputStream& stream);

// Write DebugData to output stream
void writeDebugData(const DebugData& value, OutputStream& stream);

// Get string representation of DebugData
std::string debugDataToString(const DebugData& value);

}

#endif