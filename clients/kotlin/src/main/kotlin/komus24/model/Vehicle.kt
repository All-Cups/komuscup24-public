package komus24.model

import komus24.util.StreamUtil

/**
 * A vehicle
 */
class Vehicle {
    /**
     * Current position (center)
     */
    var position: komus24.model.Vec2Double
    /**
     * Velocity vector
     */
    var velocity: komus24.model.Vec2Double
    /**
     * Speed of wheels
     */
    var speed: Double
    /**
     * Rotation speed (radians/second)
     */
    var rotationSpeed: Double
    /**
     * Current rotation
     */
    var rotation: Double
    /**
     * Vehicle type index
     */
    var typeIndex: Int
    /**
     * Current quest, if any
     */
    var quest: komus24.model.Quest?
    /**
     * Remaining fuel
     */
    var fuel: Double

    constructor(position: komus24.model.Vec2Double, velocity: komus24.model.Vec2Double, speed: Double, rotationSpeed: Double, rotation: Double, typeIndex: Int, quest: komus24.model.Quest?, fuel: Double) {
        this.position = position
        this.velocity = velocity
        this.speed = speed
        this.rotationSpeed = rotationSpeed
        this.rotation = rotation
        this.typeIndex = typeIndex
        this.quest = quest
        this.fuel = fuel
    }

    /**
     * Write Vehicle to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        position.writeTo(stream)
        velocity.writeTo(stream)
        StreamUtil.writeDouble(stream, speed)
        StreamUtil.writeDouble(stream, rotationSpeed)
        StreamUtil.writeDouble(stream, rotation)
        StreamUtil.writeInt(stream, typeIndex)
        val questValue = quest
        if (questValue == null) {
            StreamUtil.writeBoolean(stream, false)
        } else {
            StreamUtil.writeBoolean(stream, true)
            questValue.writeTo(stream)
        }
        StreamUtil.writeDouble(stream, fuel)
    }

    /**
     * Get string representation of Vehicle
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Vehicle { ")
        stringBuilder.append("position: ")
        stringBuilder.append(position)
        stringBuilder.append(", ")
        stringBuilder.append("velocity: ")
        stringBuilder.append(velocity)
        stringBuilder.append(", ")
        stringBuilder.append("speed: ")
        stringBuilder.append(speed)
        stringBuilder.append(", ")
        stringBuilder.append("rotationSpeed: ")
        stringBuilder.append(rotationSpeed)
        stringBuilder.append(", ")
        stringBuilder.append("rotation: ")
        stringBuilder.append(rotation)
        stringBuilder.append(", ")
        stringBuilder.append("typeIndex: ")
        stringBuilder.append(typeIndex)
        stringBuilder.append(", ")
        stringBuilder.append("quest: ")
        stringBuilder.append(quest)
        stringBuilder.append(", ")
        stringBuilder.append("fuel: ")
        stringBuilder.append(fuel)
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Vehicle from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Vehicle {
            var position: komus24.model.Vec2Double
            position = komus24.model.Vec2Double.readFrom(stream)
            var velocity: komus24.model.Vec2Double
            velocity = komus24.model.Vec2Double.readFrom(stream)
            var speed: Double
            speed = StreamUtil.readDouble(stream)
            var rotationSpeed: Double
            rotationSpeed = StreamUtil.readDouble(stream)
            var rotation: Double
            rotation = StreamUtil.readDouble(stream)
            var typeIndex: Int
            typeIndex = StreamUtil.readInt(stream)
            var quest: komus24.model.Quest?
            if (StreamUtil.readBoolean(stream)) {
                quest = komus24.model.Quest.readFrom(stream)
            } else {
                quest = null
            }
            var fuel: Double
            fuel = StreamUtil.readDouble(stream)
            return Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel)
        }
    }
}