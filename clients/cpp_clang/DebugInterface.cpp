#include "DebugInterface.hpp"
#include "codegame/ClientMessage.hpp"

DebugInterface::DebugInterface(TcpStream* stream): stream(stream) {}

void DebugInterface::addCircle(model::Vec2Double pos, double radius, debugging::Color color)
{
    add(debugging::DebugData(debugging::Circle(pos, radius, color)));
}

void DebugInterface::addLine(model::Vec2Double point1, model::Vec2Double point2, double width, debugging::Color color)
{
    add(debugging::DebugData(debugging::Line(point1, point2, width, color)));
}

void DebugInterface::addRect(model::Vec2Double corner1, model::Vec2Double corner2, debugging::Color color)
{
    add(debugging::DebugData(debugging::Rect(corner1, corner2, color)));
}

void DebugInterface::addText(std::string text, model::Vec2Double pos, double size, double align, debugging::Color color)
{
    add(debugging::DebugData(debugging::Text(text, pos, size, align, color)));
}

void DebugInterface::add(debugging::DebugData debugData)
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

debugging::DebugState DebugInterface::getState()
{
    codegame::ClientMessage message = codegame::RequestDebugState();
    codegame::writeClientMessage(message, *stream);
    stream->flush();
    return debugging::DebugState::readFrom(*stream);
}