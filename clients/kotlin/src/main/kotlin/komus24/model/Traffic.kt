package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class Traffic {
    /**
     * TODO - Document
     */
    var amount: Int
    /**
     * TODO - Document
     */
    var moveTime: Double
    /**
     * TODO - Document
     */
    var radius: Double
    /**
     * TODO - Document
     */
    var weight: Double
    /**
     * TODO - Document
     */
    var crashDeceleration: Double
    /**
     * TODO - Document
     */
    var crashLifetime: Double

    constructor(amount: Int, moveTime: Double, radius: Double, weight: Double, crashDeceleration: Double, crashLifetime: Double) {
        this.amount = amount
        this.moveTime = moveTime
        this.radius = radius
        this.weight = weight
        this.crashDeceleration = crashDeceleration
        this.crashLifetime = crashLifetime
    }

    /**
     * Write Traffic to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
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
    override fun toString(): String {
        var stringBuilder = StringBuilder("Traffic { ")
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
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Traffic from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Traffic {
            var amount: Int
            amount = StreamUtil.readInt(stream)
            var moveTime: Double
            moveTime = StreamUtil.readDouble(stream)
            var radius: Double
            radius = StreamUtil.readDouble(stream)
            var weight: Double
            weight = StreamUtil.readDouble(stream)
            var crashDeceleration: Double
            crashDeceleration = StreamUtil.readDouble(stream)
            var crashLifetime: Double
            crashLifetime = StreamUtil.readDouble(stream)
            return Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime)
        }
    }
}