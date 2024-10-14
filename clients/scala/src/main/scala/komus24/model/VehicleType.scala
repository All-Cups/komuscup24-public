package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param name TODO - Document
 * @param radius TODO - Document
 * @param weight TODO - Document
 * @param maxBackwardsSpeed TODO - Document
 * @param maxSpeed TODO - Document
 * @param acceleration TODO - Document
 * @param friction TODO - Document
 * @param maxRotateSpeed TODO - Document
 * @param rotateAcceleration TODO - Document
 * @param maxFuel TODO - Document
 * @param fuelUseSpeed TODO - Document
 */
case class VehicleType(name: String, radius: Double, weight: Double, maxBackwardsSpeed: Double, maxSpeed: Double, acceleration: Double, friction: Double, maxRotateSpeed: Double, rotateAcceleration: Double, maxFuel: Double, fuelUseSpeed: Double) {
    /**
     * Write VehicleType to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeString(stream, name)
        StreamUtil.writeDouble(stream, radius)
        StreamUtil.writeDouble(stream, weight)
        StreamUtil.writeDouble(stream, maxBackwardsSpeed)
        StreamUtil.writeDouble(stream, maxSpeed)
        StreamUtil.writeDouble(stream, acceleration)
        StreamUtil.writeDouble(stream, friction)
        StreamUtil.writeDouble(stream, maxRotateSpeed)
        StreamUtil.writeDouble(stream, rotateAcceleration)
        StreamUtil.writeDouble(stream, maxFuel)
        StreamUtil.writeDouble(stream, fuelUseSpeed)
    }

    /**
     * Get string representation of VehicleType
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("VehicleType { ")
        stringBuilder.append("name: ")
        stringBuilder.append('"' + name + '"')
        stringBuilder.append(", ")
        stringBuilder.append("radius: ")
        stringBuilder.append(radius)
        stringBuilder.append(", ")
        stringBuilder.append("weight: ")
        stringBuilder.append(weight)
        stringBuilder.append(", ")
        stringBuilder.append("maxBackwardsSpeed: ")
        stringBuilder.append(maxBackwardsSpeed)
        stringBuilder.append(", ")
        stringBuilder.append("maxSpeed: ")
        stringBuilder.append(maxSpeed)
        stringBuilder.append(", ")
        stringBuilder.append("acceleration: ")
        stringBuilder.append(acceleration)
        stringBuilder.append(", ")
        stringBuilder.append("friction: ")
        stringBuilder.append(friction)
        stringBuilder.append(", ")
        stringBuilder.append("maxRotateSpeed: ")
        stringBuilder.append(maxRotateSpeed)
        stringBuilder.append(", ")
        stringBuilder.append("rotateAcceleration: ")
        stringBuilder.append(rotateAcceleration)
        stringBuilder.append(", ")
        stringBuilder.append("maxFuel: ")
        stringBuilder.append(maxFuel)
        stringBuilder.append(", ")
        stringBuilder.append("fuelUseSpeed: ")
        stringBuilder.append(fuelUseSpeed)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object VehicleType {
    /**
     * Read VehicleType from input stream
     */
    def readFrom(stream: java.io.InputStream): VehicleType = VehicleType(
        StreamUtil.readString(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream)
    )
}