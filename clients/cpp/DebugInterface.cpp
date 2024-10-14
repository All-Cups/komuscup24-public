#include "DebugInterface.hpp"
#include "codegame/ClientMessage.hpp"

DebugInterface::DebugInterface(TcpStream* stream): stream(stream) {}

void DebugInterface::addCircle(model::Vec2Double pos, double radius)
{
    add(model::DebugData(model::Circle(pos, radius)));
}

void DebugInterface::add(model::DebugData debugData)
{
    send(debugging::DebugCommand(debugging::Add(debugData)));
}

void DebugInterface::clear()
{
    send(debugging::DebugCommand(debugging::Clear()));
}

void DebugInterface::setAutoFlush(bool enable)
{
    send(debugging::DebugCommand(debugging::SetAutoFlush(enable)));
}

void DebugInterface::flush()
{
    send(debugging::DebugCommand(debugging::Flush()));
}

void DebugInterface::send(debugging::DebugCommand command)
{
    codegame::ClientMessage message = codegame::DebugMessage(command);
    codegame::writeClientMessage(message, *stream);
    stream->flush();
}

model::DebugState DebugInterface::getState()
{
    codegame::ClientMessage message = codegame::RequestDebugState();
    codegame::writeClientMessage(message, *stream);
    stream->flush();
    return model::DebugState::readFrom(*stream);
}