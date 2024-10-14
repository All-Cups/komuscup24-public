package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 *
 * @param maxTickCount TODO - Document
 * @param maxGameTimeSeconds TODO - Document
 * @param ticksPerSecond TODO - Document
 * @param microticks TODO - Document
 * @param cellSize TODO - Document
 * @param collisionBounciness TODO - Document
 * @param cityType TODO - Document
 * @param vehicleTypes TODO - Document
 * @param refillSpeed TODO - Document
 * @param questCount TODO - Document
 * @param questScore TODO - Document
 * @param traffic TODO - Document
 * @param city TODO - Document
 */
case class Constants(maxTickCount: Int, maxGameTimeSeconds: Double, ticksPerSecond: Double, microticks: Int, cellSize: Double, collisionBounciness: Double, cityType: komus24.model.CityType, vehicleTypes: Seq[komus24.model.VehicleType], refillSpeed: Double, questCount: Int, questScore: komus24.model.MinMaxRangeLong, traffic: komus24.model.Traffic, city: Seq[Seq[komus24.model.CityCell]]) {
    /**
     * Write Constants to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, maxTickCount)
        StreamUtil.writeDouble(stream, maxGameTimeSeconds)
        StreamUtil.writeDouble(stream, ticksPerSecond)
        StreamUtil.writeInt(stream, microticks)
        StreamUtil.writeDouble(stream, cellSize)
        StreamUtil.writeDouble(stream, collisionBounciness)
        cityType.writeTo(stream)
        StreamUtil.writeInt(stream, vehicleTypes.length)
        vehicleTypes.foreach { value =>
            value.writeTo(stream)
        }
        StreamUtil.writeDouble(stream, refillSpeed)
        StreamUtil.writeInt(stream, questCount)
        questScore.writeTo(stream)
        traffic.writeTo(stream)
        StreamUtil.writeInt(stream, city.length)
        city.foreach { value =>
            StreamUtil.writeInt(stream, value.length)
            value.foreach { value =>
                value.writeTo(stream)
            }
        }
    }

    /**
     * Get string representation of Constants
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Constants { ")
        stringBuilder.append("maxTickCount: ")
        stringBuilder.append(maxTickCount)
        stringBuilder.append(", ")
        stringBuilder.append("maxGameTimeSeconds: ")
        stringBuilder.append(maxGameTimeSeconds)
        stringBuilder.append(", ")
        stringBuilder.append("ticksPerSecond: ")
        stringBuilder.append(ticksPerSecond)
        stringBuilder.append(", ")
        stringBuilder.append("microticks: ")
        stringBuilder.append(microticks)
        stringBuilder.append(", ")
        stringBuilder.append("cellSize: ")
        stringBuilder.append(cellSize)
        stringBuilder.append(", ")
        stringBuilder.append("collisionBounciness: ")
        stringBuilder.append(collisionBounciness)
        stringBuilder.append(", ")
        stringBuilder.append("cityType: ")
        stringBuilder.append(cityType)
        stringBuilder.append(", ")
        stringBuilder.append("vehicleTypes: ")
        stringBuilder.append(vehicleTypes)
        stringBuilder.append(", ")
        stringBuilder.append("refillSpeed: ")
        stringBuilder.append(refillSpeed)
        stringBuilder.append(", ")
        stringBuilder.append("questCount: ")
        stringBuilder.append(questCount)
        stringBuilder.append(", ")
        stringBuilder.append("questScore: ")
        stringBuilder.append(questScore)
        stringBuilder.append(", ")
        stringBuilder.append("traffic: ")
        stringBuilder.append(traffic)
        stringBuilder.append(", ")
        stringBuilder.append("city: ")
        stringBuilder.append(city)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Constants {
    /**
     * Read Constants from input stream
     */
    def readFrom(stream: java.io.InputStream): Constants = Constants(
        StreamUtil.readInt(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readInt(stream),
        StreamUtil.readDouble(stream),
        StreamUtil.readDouble(stream),
        komus24.model.CityType.readFrom(stream),
        (0 until StreamUtil.readInt(stream)).map { _ =>
            komus24.model.VehicleType.readFrom(stream)
        },
        StreamUtil.readDouble(stream),
        StreamUtil.readInt(stream),
        komus24.model.MinMaxRangeLong.readFrom(stream),
        komus24.model.Traffic.readFrom(stream),
        (0 until StreamUtil.readInt(stream)).map { _ =>
            (0 until StreamUtil.readInt(stream)).map { _ =>
                komus24.model.CityCell.readFrom(stream)
            }
        }
    )
}