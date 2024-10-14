package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param amount TODO - Document
 * @param moveTime TODO - Document
 * @param radius TODO - Document
 * @param weight TODO - Document
 * @param crashDeceleration TODO - Document
 * @param crashLifetime TODO - Document
 */
case class Traffic(amount: Int, moveTime: Double, radius: Double, weight: Double, crashDeceleration: Double, crashLifetime: Double) {
    /**
     * Write Traffic to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, amount)
        StreamUtil.writeDouble(stream, moveTime)
        StreamUtil.writeDouble(stream, radius)
        StreamUtil.writeDouble(stream, weight)
        StreamUtil.writeDouble(stream, crashDeceleration)
        StreamUtil.writeDouble(stream, crashLifetime)
    }

    /**
     * Get string representation of Traffic
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Traffic { ")
        stringBuilder.append("amount: ")
        stringBuilder.append(amount)
        stringBuilder.append(", ")
        stringBuilder.append("moveTime: ")
        stringBuilder.append(moveTime)
        stringBuilder.append(", ")
        stringBuilder.append("radius: ")
        stringBuilder.append(radius)
        stringBuilder.append(", ")
        stringBuilder.append("weight: ")
        stringBuilder.append(weight)
        stringBuilder.append(", ")
        stringBuilder.append("crashDeceleration: ")
        stringBuilder.append(crashDeceleration)
        stringBuilder.append(", ")
        stringBuilder.append("crashLifetime: ")
        stringBuilder.append(crashLifetime)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Traffic {
    /**
     * Read Traffic from input stream
     */
    def readFrom(stream: java.io.InputStream): Traffic = Traffic(
        StreamUtil.readInt(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream)
    )
}