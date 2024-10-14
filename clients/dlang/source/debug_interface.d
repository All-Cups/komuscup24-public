import stream;
import codegame.client_message;
import model.debug_data;
import model.vec2_double;

class DebugInterface
{
    this(Stream stream)
    {
        this.stream = stream;
    }

    void addCircle(model.Vec2Double pos, double radius) {
        add(new model.DebugData.Circle(pos, radius));
    }

    void add(model.DebugData debugData) {
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

    model.DebugState getState()
    {
        new codegame.ClientMessage.RequestDebugState().writeTo(stream);
        stream.flush();
        return model.DebugState.readFrom(stream);
    }

private:
    Stream stream;
}