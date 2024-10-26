#ifndef __MODEL_DEBUG_DATA_HPP__
#define __MODEL_DEBUG_DATA_HPP__

#include "Stream.hpp"
#include "debugging/Color.hpp"
#include "model/Vec2Double.hpp"
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>
#include <variant>

namespace debugging {


// Circle
class Circle {
public:
    // Center
    model::Vec2Double pos;
    // Radius
    double radius;
    // Color
    debugging::Color color;

    Circle(model::Vec2Double pos, double radius, debugging::Color color);

    // Read Circle from input stream
    static Circle readFrom(InputStream& stream);

    // Write Circle to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Circle
    std::string toString() const;
};

// Line (segment)
class Line {
public:
    // First end
    model::Vec2Double point1;
    // Other end
    model::Vec2Double point2;
    // Thickness
    double width;
    // Color
    debugging::Color color;

    Line(model::Vec2Double point1, model::Vec2Double point2, double width, debugging::Color color);

    // Read Line from input stream
    static Line readFrom(InputStream& stream);

    // Write Line to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Line
    std::string toString() const;
};

// Rectangle
class Rect {
public:
    // One of the corners
    model::Vec2Double corner1;
    // Opposite corner
    model::Vec2Double corner2;
    // Color
    debugging::Color color;

    Rect(model::Vec2Double corner1, model::Vec2Double corner2, debugging::Color color);

    // Read Rect from input stream
    static Rect readFrom(InputStream& stream);

    // Write Rect to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Rect
    std::string toString() const;
};

// Text
class Text {
public:
    // Text to draw
    std::string text;
    // Position
    model::Vec2Double pos;
    // Font size
    double size;
    // Alignment (0 - left, 0.5 - center, 1 - right)
    double align;
    // Color
    debugging::Color color;

    Text(std::string text, model::Vec2Double pos, double size, double align, debugging::Color color);

    // Read Text from input stream
    static Text readFrom(InputStream& stream);

    // Write Text to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Text
    std::string toString() const;
};

// Data for debug rendering
typedef std::variant<Circle, Line, Rect, Text> DebugData;

// Read DebugData from input stream
DebugData readDebugData(InputStream& stream);

// Write DebugData to output stream
void writeDebugData(const DebugData& value, OutputStream& stream);

// Get string representation of DebugData
std::string debugDataToString(const DebugData& value);

}

#endif