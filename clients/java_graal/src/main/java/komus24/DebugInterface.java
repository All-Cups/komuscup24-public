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

    public void addCircle(komus24.model.Vec2Double pos, double radius, komus24.debugging.Color color) {
        this.add(new komus24.debugging.DebugData.Circle(pos, radius, color));
    }
    
    public void addLine(komus24.model.Vec2Double point1, komus24.model.Vec2Double point2, double width, komus24.debugging.Color color) {
        this.add(new komus24.debugging.DebugData.Line(point1, point2, width, color));
    }
    
    public void addRect(komus24.model.Vec2Double corner1, komus24.model.Vec2Double corner2, komus24.debugging.Color color) {
        this.add(new komus24.debugging.DebugData.Rect(corner1, corner2, color));
    }
    
    public void addText(String text, komus24.model.Vec2Double pos, double size, double align, komus24.debugging.Color color) {
        this.add(new komus24.debugging.DebugData.Text(text, pos, size, align, color));
    }

    public void add(komus24.debugging.DebugData debugData) {
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

    public komus24.debugging.DebugState getState() {
        try {
            new komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream);
            outputStream.flush();
            return komus24.debugging.DebugState.readFrom(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}