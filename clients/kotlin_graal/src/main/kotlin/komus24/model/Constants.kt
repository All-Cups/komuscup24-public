package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class Constants {
    /**
     * TODO - Document
     */
    var maxTickCount: Int
    /**
     * TODO - Document
     */
    var maxGameTimeSeconds: Double
    /**
     * TODO - Document
     */
    var ticksPerSecond: Double
    /**
     * TODO - Document
     */
    var microticks: Int
    /**
     * TODO - Document
     */
    var cellSize: Double
    /**
     * TODO - Document
     */
    var collisionBounciness: Double
    /**
     * TODO - Document
     */
    var cityType: komus24.model.CityType
    /**
     * TODO - Document
     */
    var vehicleTypes: Array<komus24.model.VehicleType>
    /**
     * TODO - Document
     */
    var refillSpeed: Double
    /**
     * TODO - Document
     */
    var questCount: Int
    /**
     * TODO - Document
     */
    var questScore: komus24.model.MinMaxRangeLong
    /**
     * TODO - Document
     */
    var traffic: komus24.model.Traffic
    /**
     * TODO - Document
     */
    var city: Array<Array<komus24.model.CityCell>>

    constructor(maxTickCount: Int, maxGameTimeSeconds: Double, ticksPerSecond: Double, microticks: Int, cellSize: Double, collisionBounciness: Double, cityType: komus24.model.CityType, vehicleTypes: Array<komus24.model.VehicleType>, refillSpeed: Double, questCount: Int, questScore: komus24.model.MinMaxRangeLong, traffic: komus24.model.Traffic, city: Array<Array<komus24.model.CityCell>>) {
        this.maxTickCount = maxTickCount
        this.maxGameTimeSeconds = maxGameTimeSeconds
        this.ticksPerSecond = ticksPerSecond
        this.microticks = microticks
        this.cellSize = cellSize
        this.collisionBounciness = collisionBounciness
        this.cityType = cityType
        this.vehicleTypes = vehicleTypes
        this.refillSpeed = refillSpeed
        this.questCount = questCount
        this.questScore = questScore
        this.traffic = traffic
        this.city = city
    }

    /**
     * Write Constants to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeInt(stream, maxTickCount)
        StreamUtil.writeDouble(stream, maxGameTimeSeconds)
        StreamUtil.writeDouble(stream, ticksPerSecond)
        StreamUtil.writeInt(stream, microticks)
        StreamUtil.writeDouble(stream, cellSize)
        StreamUtil.writeDouble(stream, collisionBounciness)
        cityType.writeTo(stream)
        StreamUtil.writeInt(stream, vehicleTypes.size)
        for (vehicleTypesElement in vehicleTypes) {
            vehicleTypesElement.writeTo(stream)
        }
        StreamUtil.writeDouble(stream, refillSpeed)
        StreamUtil.writeInt(stream, questCount)
        questScore.writeTo(stream)
        traffic.writeTo(stream)
        StreamUtil.writeInt(stream, city.size)
        for (cityElement in city) {
            StreamUtil.writeInt(stream, cityElement.size)
            for (cityElementElement in cityElement) {
                StreamUtil.writeInt(stream, cityElementElement.tag)
            }
        }
    }

    /**
     * Get string representation of Constants
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Constants { ")
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
        stringBuilder.append("[ ")
        var vehicleTypesIndex = 0
        for (vehicleTypesElement in vehicleTypes) {
            if (vehicleTypesIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(vehicleTypesElement)
            vehicleTypesIndex++
        }
        stringBuilder.append(" ]")
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
        stringBuilder.append("[ ")
        var cityIndex = 0
        for (cityElement in city) {
            if (cityIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append("[ ")
            var cityElementIndex = 0
            for (cityElementElement in cityElement) {
                if (cityElementIndex != 0) {
                    stringBuilder.append(", ")
                }
                stringBuilder.append(cityElementElement)
                cityElementIndex++
            }
            stringBuilder.append(" ]")
            cityIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Constants from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Constants {
            var maxTickCount: Int
            maxTickCount = StreamUtil.readInt(stream)
            var maxGameTimeSeconds: Double
            maxGameTimeSeconds = StreamUtil.readDouble(stream)
            var ticksPerSecond: Double
            ticksPerSecond = StreamUtil.readDouble(stream)
            var microticks: Int
            microticks = StreamUtil.readInt(stream)
            var cellSize: Double
            cellSize = StreamUtil.readDouble(stream)
            var collisionBounciness: Double
            collisionBounciness = StreamUtil.readDouble(stream)
            var cityType: komus24.model.CityType
            cityType = komus24.model.CityType.readFrom(stream)
            var vehicleTypes: Array<komus24.model.VehicleType>
            vehicleTypes = Array(StreamUtil.readInt(stream), {
                var vehicleTypesElement: komus24.model.VehicleType
                vehicleTypesElement = komus24.model.VehicleType.readFrom(stream)
                vehicleTypesElement
            })
            var refillSpeed: Double
            refillSpeed = StreamUtil.readDouble(stream)
            var questCount: Int
            questCount = StreamUtil.readInt(stream)
            var questScore: komus24.model.MinMaxRangeLong
            questScore = komus24.model.MinMaxRangeLong.readFrom(stream)
            var traffic: komus24.model.Traffic
            traffic = komus24.model.Traffic.readFrom(stream)
            var city: Array<Array<komus24.model.CityCell>>
            city = Array(StreamUtil.readInt(stream), {
                var cityElement: Array<komus24.model.CityCell>
                cityElement = Array(StreamUtil.readInt(stream), {
                    var cityElementElement: komus24.model.CityCell
                    cityElementElement = komus24.model.CityCell.readFrom(stream)
                    cityElementElement
                })
                cityElement
            })
            return Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, city)
        }
    }
}