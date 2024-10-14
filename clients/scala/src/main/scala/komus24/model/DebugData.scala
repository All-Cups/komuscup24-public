package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
sealed trait DebugData {
    /**
     * Write DebugData to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit
}

object DebugData {
    /**
     * TODO - Document
     *
     * @param pos TODO - Document
     * @param radius TODO - Document
     */
    case class Circle(pos: komus24.model.Vec2Double, radius: Double) extends DebugData {
        /**
         * Write Circle to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Circle.TAG)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, radius)
        }
    
        /**
         * Get string representation of Circle
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Circle { ")
            stringBuilder.append("pos: ")
            stringBuilder.append(pos)
            stringBuilder.append(", ")
            stringBuilder.append("radius: ")
            stringBuilder.append(radius)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Circle {
        val TAG: Int = 0
    
        /**
         * Read Circle from input stream
         */
        def readFrom(stream: java.io.InputStream): Circle = Circle(
            komus24.model.Vec2Double.readFrom(stream),
            StreamUtil.readDouble(stream)
        )
    }

    /**
     * Read DebugData from input stream
     */
    def readFrom(stream: java.io.InputStream): DebugData = {
        StreamUtil.readInt(stream) match {
            case Circle.TAG => Circle.readFrom(stream)
            case _ => throw new java.io.IOException("Unexpected tag value")
        }
    }
}