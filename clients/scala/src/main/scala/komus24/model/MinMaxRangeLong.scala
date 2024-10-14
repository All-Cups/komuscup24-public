package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param min TODO - Document
 * @param max TODO - Document
 */
case class MinMaxRangeLong(min: Long, max: Long) {
    /**
     * Write MinMaxRangeLong to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeLong(stream, min)
        StreamUtil.writeLong(stream, max)
    }

    /**
     * Get string representation of MinMaxRangeLong
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("MinMaxRangeLong { ")
        stringBuilder.append("min: ")
        stringBuilder.append(min)
        stringBuilder.append(", ")
        stringBuilder.append("max: ")
        stringBuilder.append(max)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object MinMaxRangeLong {
    /**
     * Read MinMaxRangeLong from input stream
     */
    def readFrom(stream: java.io.InputStream): MinMaxRangeLong = MinMaxRangeLong(
        StreamUtil.readLong(stream),
        StreamUtil.readLong(stream)
    )
}