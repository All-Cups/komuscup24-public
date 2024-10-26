#include "DebugData.hpp"
#include <stdexcept>

namespace debugging {

Circle::Circle(model::Vec2Double pos, double radius, debugging::Color color) : pos(pos), radius(radius), color(color) { }

// Read Circle from input stream
Circle Circle::readFrom(InputStream& stream) {
    model::Vec2Double pos = model::Vec2Double::readFrom(stream);
    double radius = stream.readDouble();
    debugging::Color color = debugging::Color::readFrom(stream);
    return Circle(pos, radius, color);
}

// Write Circle to output stream
void Circle::writeTo(OutputStream& stream) const {
    pos.writeTo(stream);
    stream.write(radius);
    color.writeTo(stream);
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
    ss << ", ";
    ss << "color: ";
    ss << color.toString();
    ss << " }";
    return ss.str();
}

Line::Line(model::Vec2Double point1, model::Vec2Double point2, double width, debugging::Color color) : point1(point1), point2(point2), width(width), color(color) { }

// Read Line from input stream
Line Line::readFrom(InputStream& stream) {
    model::Vec2Double point1 = model::Vec2Double::readFrom(stream);
    model::Vec2Double point2 = model::Vec2Double::readFrom(stream);
    double width = stream.readDouble();
    debugging::Color color = debugging::Color::readFrom(stream);
    return Line(point1, point2, width, color);
}

// Write Line to output stream
void Line::writeTo(OutputStream& stream) const {
    point1.writeTo(stream);
    point2.writeTo(stream);
    stream.write(width);
    color.writeTo(stream);
}

// Get string representation of Line
std::string Line::toString() const {
    std::stringstream ss;
    ss << "Line { ";
    ss << "point1: ";
    ss << point1.toString();
    ss << ", ";
    ss << "point2: ";
    ss << point2.toString();
    ss << ", ";
    ss << "width: ";
    ss << width;
    ss << ", ";
    ss << "color: ";
    ss << color.toString();
    ss << " }";
    return ss.str();
}

Rect::Rect(model::Vec2Double corner1, model::Vec2Double corner2, debugging::Color color) : corner1(corner1), corner2(corner2), color(color) { }

// Read Rect from input stream
Rect Rect::readFrom(InputStream& stream) {
    model::Vec2Double corner1 = model::Vec2Double::readFrom(stream);
    model::Vec2Double corner2 = model::Vec2Double::readFrom(stream);
    debugging::Color color = debugging::Color::readFrom(stream);
    return Rect(corner1, corner2, color);
}

// Write Rect to output stream
void Rect::writeTo(OutputStream& stream) const {
    corner1.writeTo(stream);
    corner2.writeTo(stream);
    color.writeTo(stream);
}

// Get string representation of Rect
std::string Rect::toString() const {
    std::stringstream ss;
    ss << "Rect { ";
    ss << "corner1: ";
    ss << corner1.toString();
    ss << ", ";
    ss << "corner2: ";
    ss << corner2.toString();
    ss << ", ";
    ss << "color: ";
    ss << color.toString();
    ss << " }";
    return ss.str();
}

Text::Text(std::string text, model::Vec2Double pos, double size, double align, debugging::Color color) : text(text), pos(pos), size(size), align(align), color(color) { }

// Read Text from input stream
Text Text::readFrom(InputStream& stream) {
    std::string text = stream.readString();
    model::Vec2Double pos = model::Vec2Double::readFrom(stream);
    double size = stream.readDouble();
    double align = stream.readDouble();
    debugging::Color color = debugging::Color::readFrom(stream);
    return Text(text, pos, size, align, color);
}

// Write Text to output stream
void Text::writeTo(OutputStream& stream) const {
    stream.write(text);
    pos.writeTo(stream);
    stream.write(size);
    stream.write(align);
    color.writeTo(stream);
}

// Get string representation of Text
std::string Text::toString() const {
    std::stringstream ss;
    ss << "Text { ";
    ss << "text: ";
    ss << '"' << text << '"';
    ss << ", ";
    ss << "pos: ";
    ss << pos.toString();
    ss << ", ";
    ss << "size: ";
    ss << size;
    ss << ", ";
    ss << "align: ";
    ss << align;
    ss << ", ";
    ss << "color: ";
    ss << color.toString();
    ss << " }";
    return ss.str();
}

    
// Read DebugData from input stream
DebugData readDebugData(InputStream& stream) {
    switch (stream.readInt()) {
    case 0:
        return Circle::readFrom(stream);
    case 1:
        return Line::readFrom(stream);
    case 2:
        return Rect::readFrom(stream);
    case 3:
        return Text::readFrom(stream);
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
        if constexpr (std::is_same_v<T, Line>) {
            stream.write((int) 1);
        }
        if constexpr (std::is_same_v<T, Rect>) {
            stream.write((int) 2);
        }
        if constexpr (std::is_same_v<T, Text>) {
            stream.write((int) 3);
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