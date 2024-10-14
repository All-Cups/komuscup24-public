package komus24.model

import komus24.util.StreamUtil

/**
 * 2 dimensional vector.
 *
 * @param x `x` coordinate of the vector
 * @param y `y` coordinate of the vector
 */
case class Vec2Double(x: Double, y: Double) {
    /**
     * Write Vec2Double to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeDouble(stream, x)
        StreamUtil.writeDouble(stream, y)
    }

    /**
     * Get string representation of Vec2Double
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Vec2Double { ")
        stringBuilder.append("x: ")
        stringBuilder.append(x)
        stringBuilder.append(", ")
        stringBuilder.append("y: ")
        stringBuilder.append(y)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Vec2Double {
    /**
     * Read Vec2Double from input stream
     */
    def readFrom(stream: java.io.InputStream): Vec2Double = Vec2Double(
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream)
    )
}