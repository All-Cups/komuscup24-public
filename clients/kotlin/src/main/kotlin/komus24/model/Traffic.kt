package komus24.model

import komus24.util.StreamUtil

/**
 * Options for traffic
 */
class Traffic {
    /**
     * Number of traffic cars
     */
    var amount: Int
    /**
     * Time to move between adjacent keypoints
     */
    var moveTime: Double
    /**
     * Radius of each traffic car
     */
    var radius: Double
    /**
     * Weight of each traffic car
     */
    var weight: Double
    /**
     * Deceleration after crash
     */
    var crashDeceleration: Double
    /**
     * Lifetime after crash
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