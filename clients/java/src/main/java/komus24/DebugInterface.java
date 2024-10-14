package komus24;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DebugInterface {
    private InputStream inputStream;
    private OutputStream outputStream;

    public DebugInterface(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void addCircle(komus24.model.Vec2Double pos, double radius) {
        this.add(new komus24.model.DebugData.Circle(pos, radius));
    }

    public void add(komus24.model.DebugData debugData) {
        this.send(new komus24.debugging.DebugCommand.Add(debugData));
    }
    
    public void clear() {
        this.send(new komus24.debugging.DebugCommand.Clear());
    }
    
    public void setAutoFlush(boolean enable) {
        this.send(new komus24.debugging.DebugCommand.SetAutoFlush(enable));
    }
    
    public void flush() {
        this.send(new komus24.debugging.DebugCommand.Flush());
    }

    public void send(komus24.debugging.DebugCommand command) {
        try {
            new komus24.codegame.ClientMessage.DebugMessage(command).writeTo(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public komus24.model.DebugState getState() {
        try {
            new komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream);
            outputStream.flush();
            return komus24.model.DebugState.readFrom(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}