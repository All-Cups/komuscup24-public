import java.io.InputStream
import java.io.OutputStream

class DebugInterface(private val inputStream: InputStream, private val outputStream: OutputStream) {
  def addCircle(pos: komus24.model.Vec2Double, radius: Double): scala.Unit = {
      add(komus24.model.DebugData.Circle(pos, radius))
  }

  def add(debugData: komus24.model.DebugData): scala.Unit = {
      send(komus24.debugging.DebugCommand.Add(debugData))
  }
  
  def clear(): scala.Unit = {
      send(komus24.debugging.DebugCommand.Clear())
  }
  
  def setAutoFlush(enable: Boolean): scala.Unit = {
      send(komus24.debugging.DebugCommand.SetAutoFlush(enable))
  }
  
  def flush(): scala.Unit = {
      send(komus24.debugging.DebugCommand.Flush())
  }

  def send(command: komus24.debugging.DebugCommand): scala.Unit = {
    komus24.codegame.ClientMessage.DebugMessage(command).writeTo(outputStream)
    outputStream.flush()
  }

  def getState(): komus24.model.DebugState = {
    komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream)
    outputStream.flush()
    komus24.model.DebugState.readFrom(inputStream)
  }
}