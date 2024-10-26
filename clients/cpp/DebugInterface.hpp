#ifndef _DEBUG_INTERFACE_HPP_
#define _DEBUG_INTERFACE_HPP_

#include "TcpStream.hpp"
#include "debugging/DebugCommand.hpp"
#include "debugging/DebugState.hpp"
#include <memory>

class DebugInterface {
public:
    DebugInterface(TcpStream* stream);

    void addCircle(model::Vec2Double pos, double radius, debugging::Color color);
    void addLine(model::Vec2Double point1, model::Vec2Double point2, double width, debugging::Color color);
    void addRect(model::Vec2Double corner1, model::Vec2Double corner2, debugging::Color color);
    void addText(std::string text, model::Vec2Double pos, double size, double align, debugging::Color color);
    void add(debugging::DebugData debugData);
    void clear();
    void setAutoFlush(bool enable);
    void flush();
    void send(debugging::DebugCommand command);
    debugging::DebugState getState();

private:
    TcpStream* stream;
};

#endif