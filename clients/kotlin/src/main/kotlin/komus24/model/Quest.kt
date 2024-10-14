package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class Quest {
    /**
     * TODO - Document
     */
    var pickupCell: komus24.model.Vec2Int
    /**
     * TODO - Document
     */
    var dropCell: komus24.model.Vec2Int
    /**
     * TODO - Document
     */
    var score: Long

    constructor(pickupCell: komus24.model.Vec2Int, dropCell: komus24.model.Vec2Int, score: Long) {
        this.pickupCell = pickupCell
        this.dropCell = dropCell
        this.score = score
    }

    /**
     * Write Quest to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        pickupCell.writeTo(stream)
        dropCell.writeTo(stream)
        StreamUtil.writeLong(stream, score)
    }

    /**
     * Get string representation of Quest
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Quest { ")
        stringBuilder.append("pickupCell: ")
        stringBuilder.append(pickupCell)
        stringBuilder.append(", ")
        stringBuilder.append("dropCell: ")
        stringBuilder.append(dropCell)
        stringBuilder.append(", ")
        stringBuilder.append("score: ")
        stringBuilder.append(score)
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Quest from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Quest {
            var pickupCell: komus24.model.Vec2Int
            pickupCell = komus24.model.Vec2Int.readFrom(stream)
            var dropCell: komus24.model.Vec2Int
            dropCell = komus24.model.Vec2Int.readFrom(stream)
            var score: Long
            score = StreamUtil.readLong(stream)
            return Quest(pickupCell, dropCell, score)
        }
    }
}