import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class DebugInterface(private val inputStream: InputStream, private val outputStream: OutputStream) {
    fun addCircle(pos: komus24.model.Vec2Double, radius: Double) {
        this.add(komus24.model.DebugData.Circle(pos, radius))
    }

    fun add(debugData: komus24.model.DebugData) {
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

    fun getState(): komus24.model.DebugState {
        try {
            komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream)
            outputStream.flush()
            return komus24.model.DebugState.readFrom(inputStream)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}