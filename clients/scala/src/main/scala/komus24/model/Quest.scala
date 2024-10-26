package komus24.model

import komus24.util.StreamUtil

/**
 * A delivery quest
 *
 * @param pickupCell Cell where to pick delivery from
 * @param dropCell Cell to drop the delivery at
 * @param score Score for completing the quest
 */
case class Quest(pickupCell: komus24.model.Vec2Int, dropCell: komus24.model.Vec2Int, score: Long) {
    /**
     * Write Quest to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        pickupCell.writeTo(stream)
        dropCell.writeTo(stream)
        StreamUtil.writeLong(stream, score)
    }

    /**
     * Get string representation of Quest
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Quest { ")
        stringBuilder.append("pickupCell: ")
        stringBuilder.append(pickupCell)
        stringBuilder.append(", ")
        stringBuilder.append("dropCell: ")
        stringBuilder.append(dropCell)
        stringBuilder.append(", ")
        stringBuilder.append("score: ")
        stringBuilder.append(score)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Quest {
    /**
     * Read Quest from input stream
     */
    def readFrom(stream: java.io.InputStream): Quest = Quest(
        komus24.model.Vec2Int.readFrom(stream),
        komus24.model.Vec2Int.readFrom(stream),
        StreamUtil.readLong(stream)
    )
}