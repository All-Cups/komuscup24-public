package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class VehicleType {
    /**
     * TODO - Document
     */
    var name: String
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
    var maxBackwardsSpeed: Double
    /**
     * TODO - Document
     */
    var maxSpeed: Double
    /**
     * TODO - Document
     */
    var acceleration: Double
    /**
     * TODO - Document
     */
    var friction: Double
    /**
     * TODO - Document
     */
    var maxRotateSpeed: Double
    /**
     * TODO - Document
     */
    var rotateAcceleration: Double
    /**
     * TODO - Document
     */
    var maxFuel: Double
    /**
     * TODO - Document
     */
    var fuelUseSpeed: Double

    constructor(name: String, radius: Double, weight: Double, maxBackwardsSpeed: Double, maxSpeed: Double, acceleration: Double, friction: Double, maxRotateSpeed: Double, rotateAcceleration: Double, maxFuel: Double, fuelUseSpeed: Double) {
        this.name = name
        this.radius = radius
        this.weight = weight
        this.maxBackwardsSpeed = maxBackwardsSpeed
        this.maxSpeed = maxSpeed
        this.acceleration = acceleration
        this.friction = friction
        this.maxRotateSpeed = maxRotateSpeed
        this.rotateAcceleration = rotateAcceleration
        this.maxFuel = maxFuel
        this.fuelUseSpeed = fuelUseSpeed
    }

    /**
     * Write VehicleType to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
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
    override fun toString(): String {
        var stringBuilder = StringBuilder("VehicleType { ")
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
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read VehicleType from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): VehicleType {
            var name: String
            name = StreamUtil.readString(stream)
            var radius: Double
            radius = StreamUtil.readDouble(stream)
            var weight: Double
            weight = StreamUtil.readDouble(stream)
            var maxBackwardsSpeed: Double
            maxBackwardsSpeed = StreamUtil.readDouble(stream)
            var maxSpeed: Double
            maxSpeed = StreamUtil.readDouble(stream)
            var acceleration: Double
            acceleration = StreamUtil.readDouble(stream)
            var friction: Double
            friction = StreamUtil.readDouble(stream)
            var maxRotateSpeed: Double
            maxRotateSpeed = StreamUtil.readDouble(stream)
            var rotateAcceleration: Double
            rotateAcceleration = StreamUtil.readDouble(stream)
            var maxFuel: Double
            maxFuel = StreamUtil.readDouble(stream)
            var fuelUseSpeed: Double
            fuelUseSpeed = StreamUtil.readDouble(stream)
            return VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed)
        }
    }
}