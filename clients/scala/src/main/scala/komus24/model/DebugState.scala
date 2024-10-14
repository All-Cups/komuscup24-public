package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param pressedKeys TODO - Document
 */
case class DebugState(pressedKeys: Seq[String]) {
    /**
     * Write DebugState to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, pressedKeys.length)
        pressedKeys.foreach { value =>
            StreamUtil.writeString(stream, value)
        }
    }

    /**
     * Get string representation of DebugState
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("DebugState { ")
        stringBuilder.append("pressedKeys: ")
        stringBuilder.append(pressedKeys)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object DebugState {
    /**
     * Read DebugState from input stream
     */
    def readFrom(stream: java.io.InputStream): DebugState = DebugState(
        (0 until StreamUtil.readInt(stream)).map { _ =>
            StreamUtil.readString(stream)
        }
    )
}