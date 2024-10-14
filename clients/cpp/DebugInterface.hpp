#ifndef _DEBUG_INTERFACE_HPP_
#define _DEBUG_INTERFACE_HPP_

#include "TcpStream.hpp"
#include "debugging/DebugCommand.hpp"
#include "model/DebugState.hpp"
#include <memory>

class DebugInterface {
public:
    DebugInterface(TcpStream* stream);

    void addCircle(model::Vec2Double pos, double radius);
    void add(model::DebugData debugData);
    void clear();
    void setAutoFlush(bool enable);
    void flush();
    void send(debugging::DebugCommand command);
    model::DebugState getState();

private:
    TcpStream* stream;
};

#endif