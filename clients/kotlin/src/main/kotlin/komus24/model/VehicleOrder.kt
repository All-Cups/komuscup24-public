package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class VehicleOrder {
    /**
     * -1..+1
     */
    var accelerate: Double
    /**
     * TODO - Document
     */
    var brakes: Boolean
    /**
     * -1..+1
     */
    var rotate: Double

    constructor(accelerate: Double, brakes: Boolean, rotate: Double) {
        this.accelerate = accelerate
        this.brakes = brakes
        this.rotate = rotate
    }

    /**
     * Write VehicleOrder to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeDouble(stream, accelerate)
        StreamUtil.writeBoolean(stream, brakes)
        StreamUtil.writeDouble(stream, rotate)
    }

    /**
     * Get string representation of VehicleOrder
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("VehicleOrder { ")
        stringBuilder.append("accelerate: ")
        stringBuilder.append(accelerate)
        stringBuilder.append(", ")
        stringBuilder.append("brakes: ")
        stringBuilder.append(brakes)
        stringBuilder.append(", ")
        stringBuilder.append("rotate: ")
        stringBuilder.append(rotate)
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read VehicleOrder from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): VehicleOrder {
            var accelerate: Double
            accelerate = StreamUtil.readDouble(stream)
            var brakes: Boolean
            brakes = StreamUtil.readBoolean(stream)
            var rotate: Double
            rotate = StreamUtil.readDouble(stream)
            return VehicleOrder(accelerate, brakes, rotate)
        }
    }
}