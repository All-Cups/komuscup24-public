import java.io.InputStream
import java.io.OutputStream

class DebugInterface(private val inputStream: InputStream, private val outputStream: OutputStream) {
  def addCircle(pos: komus24.model.Vec2Double, radius: Double, color: komus24.debugging.Color): scala.Unit = {
      add(komus24.debugging.DebugData.Circle(pos, radius, color))
  }
  
  def addLine(point1: komus24.model.Vec2Double, point2: komus24.model.Vec2Double, width: Double, color: komus24.debugging.Color): scala.Unit = {
      add(komus24.debugging.DebugData.Line(point1, point2, width, color))
  }
  
  def addRect(corner1: komus24.model.Vec2Double, corner2: komus24.model.Vec2Double, color: komus24.debugging.Color): scala.Unit = {
      add(komus24.debugging.DebugData.Rect(corner1, corner2, color))
  }
  
  def addText(text: String, pos: komus24.model.Vec2Double, size: Double, align: Double, color: komus24.debugging.Color): scala.Unit = {
      add(komus24.debugging.DebugData.Text(text, pos, size, align, color))
  }

  def add(debugData: komus24.debugging.DebugData): scala.Unit = {
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

  def getState(): komus24.debugging.DebugState = {
    komus24.codegame.ClientMessage.RequestDebugState().writeTo(outputStream)
    outputStream.flush()
    komus24.debugging.DebugState.readFrom(inputStream)
  }
}