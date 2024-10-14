package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param position TODO - Document
 * @param velocity TODO - Document
 * @param speed TODO - Document
 * @param rotationSpeed TODO - Document
 * @param rotation TODO - Document
 * @param typeIndex TODO - Document
 * @param quest TODO maybe multiple quests at the same time?
 * @param fuel TODO - Document
 */
case class Vehicle(position: komus24.model.Vec2Double, velocity: komus24.model.Vec2Double, speed: Double, rotationSpeed: Double, rotation: Double, typeIndex: Int, quest: Option[komus24.model.Quest], fuel: Double) {
    /**
     * Write Vehicle to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        position.writeTo(stream)
        velocity.writeTo(stream)
        StreamUtil.writeDouble(stream, speed)
        StreamUtil.writeDouble(stream, rotationSpeed)
        StreamUtil.writeDouble(stream, rotation)
        StreamUtil.writeInt(stream, typeIndex)
        quest match {
            case None => StreamUtil.writeBoolean(stream, false)
            case Some(value) => {
                StreamUtil.writeBoolean(stream, true)
                value.writeTo(stream)
            }
        }
        StreamUtil.writeDouble(stream, fuel)
    }

    /**
     * Get string representation of Vehicle
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Vehicle { ")
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
        stringBuilder.toString()
    }
}

object Vehicle {
    /**
     * Read Vehicle from input stream
     */
    def readFrom(stream: java.io.InputStream): Vehicle = Vehicle(
        komus24.model.Vec2Double.readFrom(stream),
        komus24.model.Vec2Double.readFrom(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readInt(stream),
        if (StreamUtil.readBoolean(stream)) Some(
            komus24.model.Quest.readFrom(stream)
        ) else None,
        StreamUtil.readDouble(stream)
    )
}