package komus24.model

import komus24.util.StreamUtil

/**
 * Order for controlling a single vehicle
 *
 * @param accelerate Acceleration (-1 - fully backwards, +1 - fully forward)
 * @param brakes Hand brakes
 * @param rotate Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
 */
case class VehicleOrder(accelerate: Double, brakes: Boolean, rotate: Double) {
    /**
     * Write VehicleOrder to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeDouble(stream, accelerate)
        StreamUtil.writeBoolean(stream, brakes)
        StreamUtil.writeDouble(stream, rotate)
    }

    /**
     * Get string representation of VehicleOrder
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("VehicleOrder { ")
        stringBuilder.append("accelerate: ")
        stringBuilder.append(accelerate)
        stringBuilder.append(", ")
        stringBuilder.append("brakes: ")
        stringBuilder.append(brakes)
        stringBuilder.append(", ")
        stringBuilder.append("rotate: ")
        stringBuilder.append(rotate)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object VehicleOrder {
    /**
     * Read VehicleOrder from input stream
     */
    def readFrom(stream: java.io.InputStream): VehicleOrder = VehicleOrder(
        StreamUtil.readDouble(stream),
        StreamUtil.readBoolean(stream),
        StreamUtil.readDouble(stream)
    )
}