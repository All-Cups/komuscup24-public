package komus24.debugging

import komus24.util.StreamUtil

/**
 * Data for debug rendering
 */
sealed trait DebugData {
    /**
     * Write DebugData to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit
}

object DebugData {
    /**
     * Circle
     *
     * @param pos Center
     * @param radius Radius
     * @param color Color
     */
    case class Circle(pos: komus24.model.Vec2Double, radius: Double, color: komus24.debugging.Color) extends DebugData {
        /**
         * Write Circle to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Circle.TAG)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, radius)
            color.writeTo(stream)
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
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
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
            StreamUtil.readDouble(stream),
            komus24.debugging.Color.readFrom(stream)
        )
    }

    /**
     * Line (segment)
     *
     * @param point1 First end
     * @param point2 Other end
     * @param width Thickness
     * @param color Color
     */
    case class Line(point1: komus24.model.Vec2Double, point2: komus24.model.Vec2Double, width: Double, color: komus24.debugging.Color) extends DebugData {
        /**
         * Write Line to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Line.TAG)
            point1.writeTo(stream)
            point2.writeTo(stream)
            StreamUtil.writeDouble(stream, width)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Line
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Line { ")
            stringBuilder.append("point1: ")
            stringBuilder.append(point1)
            stringBuilder.append(", ")
            stringBuilder.append("point2: ")
            stringBuilder.append(point2)
            stringBuilder.append(", ")
            stringBuilder.append("width: ")
            stringBuilder.append(width)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Line {
        val TAG: Int = 1
    
        /**
         * Read Line from input stream
         */
        def readFrom(stream: java.io.InputStream): Line = Line(
            komus24.model.Vec2Double.readFrom(stream),
            komus24.model.Vec2Double.readFrom(stream),
            StreamUtil.readDouble(stream),
            komus24.debugging.Color.readFrom(stream)
        )
    }

    /**
     * Rectangle
     *
     * @param corner1 One of the corners
     * @param corner2 Opposite corner
     * @param color Color
     */
    case class Rect(corner1: komus24.model.Vec2Double, corner2: komus24.model.Vec2Double, color: komus24.debugging.Color) extends DebugData {
        /**
         * Write Rect to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Rect.TAG)
            corner1.writeTo(stream)
            corner2.writeTo(stream)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Rect
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Rect { ")
            stringBuilder.append("corner1: ")
            stringBuilder.append(corner1)
            stringBuilder.append(", ")
            stringBuilder.append("corner2: ")
            stringBuilder.append(corner2)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Rect {
        val TAG: Int = 2
    
        /**
         * Read Rect from input stream
         */
        def readFrom(stream: java.io.InputStream): Rect = Rect(
            komus24.model.Vec2Double.readFrom(stream),
            komus24.model.Vec2Double.readFrom(stream),
            komus24.debugging.Color.readFrom(stream)
        )
    }

    /**
     * Text
     *
     * @param text Text to draw
     * @param pos Position
     * @param size Font size
     * @param align Alignment (0 - left, 0.5 - center, 1 - right)
     * @param color Color
     */
    case class Text(text: String, pos: komus24.model.Vec2Double, size: Double, align: Double, color: komus24.debugging.Color) extends DebugData {
        /**
         * Write Text to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Text.TAG)
            StreamUtil.writeString(stream, text)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, size)
            StreamUtil.writeDouble(stream, align)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Text
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Text { ")
            stringBuilder.append("text: ")
            stringBuilder.append('"' + text + '"')
            stringBuilder.append(", ")
            stringBuilder.append("pos: ")
            stringBuilder.append(pos)
            stringBuilder.append(", ")
            stringBuilder.append("size: ")
            stringBuilder.append(size)
            stringBuilder.append(", ")
            stringBuilder.append("align: ")
            stringBuilder.append(align)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Text {
        val TAG: Int = 3
    
        /**
         * Read Text from input stream
         */
        def readFrom(stream: java.io.InputStream): Text = Text(
            StreamUtil.readString(stream),
            komus24.model.Vec2Double.readFrom(stream),
            StreamUtil.readDouble(stream),
            StreamUtil.readDouble(stream),
            komus24.debugging.Color.readFrom(stream)
        )
    }

    /**
     * Read DebugData from input stream
     */
    def readFrom(stream: java.io.InputStream): DebugData = {
        StreamUtil.readInt(stream) match {
            case Circle.TAG => Circle.readFrom(stream)
            case Line.TAG => Line.readFrom(stream)
            case Rect.TAG => Rect.readFrom(stream)
            case Text.TAG => Text.readFrom(stream)
            case _ => throw new java.io.IOException("Unexpected tag value")
        }
    }
}