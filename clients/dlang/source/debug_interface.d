import stream;
import codegame.client_message;
import debugging.debug_data;
import debugging.color;
import model.vec2_double;

class DebugInterface
{
    this(Stream stream)
    {
        this.stream = stream;
    }

    void addCircle(model.Vec2Double pos, double radius, debugging.Color color) {
        add(new debugging.DebugData.Circle(pos, radius, color));
    }
    
    void addLine(model.Vec2Double point1, model.Vec2Double point2, double width, debugging.Color color) {
        add(new debugging.DebugData.Line(point1, point2, width, color));
    }
    
    void addRect(model.Vec2Double corner1, model.Vec2Double corner2, debugging.Color color) {
        add(new debugging.DebugData.Rect(corner1, corner2, color));
    }
    
    void addText(string text, model.Vec2Double pos, double size, double align, debugging.Color color) {
        add(new debugging.DebugData.Text(text, pos, size, align, color));
    }

    void add(debugging.DebugData debugData) {
        send(new debugging.DebugCommand.Add(debugData));
    }
    
    void clear() {
        send(new debugging.DebugCommand.Clear());
    }
    
    void setAutoFlush(bool enable) {
        send(new debugging.DebugCommand.SetAutoFlush(enable));
    }
    
    void flush() {
        send(new debugging.DebugCommand.Flush());
    }

    void send(debugging.DebugCommand command)
    {
        new codegame.ClientMessage.DebugMessage(command).writeTo(stream);
        stream.flush();
    }

    debugging.DebugState getState()
    {
        new codegame.ClientMessage.RequestDebugState().writeTo(stream);
        stream.flush();
        return debugging.DebugState.readFrom(stream);
    }

private:
    Stream stream;
}