import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class DebugInterface(private val inputStream: InputStream, private val outputStream: OutputStream) {
    fun addCircle(pos: komus24.model.Vec2Double, radius: Double, color: komus24.debugging.Color) {
        this.add(komus24.debugging.DebugData.Circle(pos, radius, color))
    }
    
    fun addLine(point1: komus24.model.Vec2Double, point2: komus24.model.Vec2Double, width: Double, color: komus24.debugging.Color) {
        this.add(komus24.debugging.DebugData.Line(point1, point2, width, color))
    }
    
    fun addRect(corner1: komus24.model.Vec2Double, corner2: komus24.model.Vec2Double, color: komus24.debugging.Color) {
        this.add(komus24.debugging.DebugData.Rect(corner1, corner2, color))
    }
    
    fun addText(text: String, pos: komus24.model.Vec2Double, size: Double, align: Double, color: komus24.debugging.Color) {
        this.add(komus24.debugging.DebugData.Text(text, pos, size, align, color))
    }

    fun add(debugData: komus24.debugging.DebugData) {
        this.send(komus24.debugging.DebugCommand.Add(debugData))
    }
    
    fun clear() {
        this.send(komus24.debugging.DebugCommand.Clear())
    }
    
    fun setAutoFlush(enable: Boolean) {
        this.send(komus24.debugging.DebugCommand.SetAutoFlush(enable))
    }
    
    fun flush() {
        this.send(komus24.debugging.DebugCommand.Flush())
    }

    fun send(command: komus24.debugging.DebugCommand) {
        try {
            komus24.codegame.ClientMessage.DebugMessage(command).writeTo(outputStream)
            outputStream.flush()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    fun getState(): komus24.debugging.DebugState {
        try {
            komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream)
            outputStream.flush()
            return komus24.debugging.DebugState.readFrom(inputStream)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}