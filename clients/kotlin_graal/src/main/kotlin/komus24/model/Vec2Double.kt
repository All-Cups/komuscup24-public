package komus24.model

import komus24.util.StreamUtil

/**
 * 2 dimensional vector.
 */
class Vec2Double {
    /**
     * `x` coordinate of the vector
     */
    var x: Double
    /**
     * `y` coordinate of the vector
     */
    var y: Double

    constructor(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    /**
     * Write Vec2Double to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeDouble(stream, x)
        StreamUtil.writeDouble(stream, y)
    }

    /**
     * Get string representation of Vec2Double
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Vec2Double { ")
        stringBuilder.append("x: ")
        stringBuilder.append(x)
        stringBuilder.append(", ")
        stringBuilder.append("y: ")
        stringBuilder.append(y)
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Vec2Double from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Vec2Double {
            var x: Double
            x = StreamUtil.readDouble(stream)
            var y: Double
            y = StreamUtil.readDouble(stream)
            return Vec2Double(x, y)
        }
    }
}