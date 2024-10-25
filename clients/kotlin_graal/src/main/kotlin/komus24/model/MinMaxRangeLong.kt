package komus24.model

import komus24.util.StreamUtil

/**
 * Range of values
 */
class MinMaxRangeLong {
    /**
     * Minimal value
     */
    var min: Long
    /**
     * Maximal  value
     */
    var max: Long

    constructor(min: Long, max: Long) {
        this.min = min
        this.max = max
    }

    /**
     * Write MinMaxRangeLong to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeLong(stream, min)
        StreamUtil.writeLong(stream, max)
    }

    /**
     * Get string representation of MinMaxRangeLong
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("MinMaxRangeLong { ")
        stringBuilder.append("min: ")
        stringBuilder.append(min)
        stringBuilder.append(", ")
        stringBuilder.append("max: ")
        stringBuilder.append(max)
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read MinMaxRangeLong from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): MinMaxRangeLong {
            var min: Long
            min = StreamUtil.readLong(stream)
            var max: Long
            max = StreamUtil.readLong(stream)
            return MinMaxRangeLong(min, max)
        }
    }
}