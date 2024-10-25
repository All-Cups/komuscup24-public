package komus24.model

import komus24.util.StreamUtil

/**
 * Player (game participant)
 */
class Player {
    /**
     * Index
     */
    var index: Int
    /**
     * Current score
     */
    var score: Long
    /**
     * List of player's vehicles
     */
    var vehicles: Array<komus24.model.Vehicle>

    constructor(index: Int, score: Long, vehicles: Array<komus24.model.Vehicle>) {
        this.index = index
        this.score = score
        this.vehicles = vehicles
    }

    /**
     * Write Player to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeInt(stream, index)
        StreamUtil.writeLong(stream, score)
        StreamUtil.writeInt(stream, vehicles.size)
        for (vehiclesElement in vehicles) {
            vehiclesElement.writeTo(stream)
        }
    }

    /**
     * Get string representation of Player
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Player { ")
        stringBuilder.append("index: ")
        stringBuilder.append(index)
        stringBuilder.append(", ")
        stringBuilder.append("score: ")
        stringBuilder.append(score)
        stringBuilder.append(", ")
        stringBuilder.append("vehicles: ")
        stringBuilder.append("[ ")
        var vehiclesIndex = 0
        for (vehiclesElement in vehicles) {
            if (vehiclesIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(vehiclesElement)
            vehiclesIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Player from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Player {
            var index: Int
            index = StreamUtil.readInt(stream)
            var score: Long
            score = StreamUtil.readLong(stream)
            var vehicles: Array<komus24.model.Vehicle>
            vehicles = Array(StreamUtil.readInt(stream), {
                var vehiclesElement: komus24.model.Vehicle
                vehiclesElement = komus24.model.Vehicle.readFrom(stream)
                vehiclesElement
            })
            return Player(index, score, vehicles)
        }
    }
}