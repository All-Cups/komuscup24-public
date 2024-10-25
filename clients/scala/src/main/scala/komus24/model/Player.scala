package komus24.model

import komus24.util.StreamUtil

/**
 * Player (game participant)
 *
 * @param index Index
 * @param score Current score
 * @param vehicles List of player's vehicles
 */
case class Player(index: Int, score: Long, vehicles: Seq[komus24.model.Vehicle]) {
    /**
     * Write Player to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, index)
        StreamUtil.writeLong(stream, score)
        StreamUtil.writeInt(stream, vehicles.length)
        vehicles.foreach { value =>
            value.writeTo(stream)
        }
    }

    /**
     * Get string representation of Player
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Player { ")
        stringBuilder.append("index: ")
        stringBuilder.append(index)
        stringBuilder.append(", ")
        stringBuilder.append("score: ")
        stringBuilder.append(score)
        stringBuilder.append(", ")
        stringBuilder.append("vehicles: ")
        stringBuilder.append(vehicles)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Player {
    /**
     * Read Player from input stream
     */
    def readFrom(stream: java.io.InputStream): Player = Player(
        StreamUtil.readInt(stream),
        StreamUtil.readLong(stream),
        (0 until StreamUtil.readInt(stream)).map { _ =>
            komus24.model.Vehicle.readFrom(stream)
        }
    )
}