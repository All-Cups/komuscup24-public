package komus24.model

import komus24.util.StreamUtil

/**
 * Current game's state
 *
 * @param currentTick Current tick number
 * @param you TODO - Document
 * @param other TODO - Document
 * @param quests TODO - Document
 */
case class PlayerView(currentTick: Int, you: komus24.model.Player, other: Seq[komus24.model.Player], quests: Seq[komus24.model.Quest]) {
    /**
     * Write PlayerView to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, currentTick)
        you.writeTo(stream)
        StreamUtil.writeInt(stream, other.length)
        other.foreach { value =>
            value.writeTo(stream)
        }
        StreamUtil.writeInt(stream, quests.length)
        quests.foreach { value =>
            value.writeTo(stream)
        }
    }

    /**
     * Get string representation of PlayerView
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("PlayerView { ")
        stringBuilder.append("currentTick: ")
        stringBuilder.append(currentTick)
        stringBuilder.append(", ")
        stringBuilder.append("you: ")
        stringBuilder.append(you)
        stringBuilder.append(", ")
        stringBuilder.append("other: ")
        stringBuilder.append(other)
        stringBuilder.append(", ")
        stringBuilder.append("quests: ")
        stringBuilder.append(quests)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object PlayerView {
    /**
     * Read PlayerView from input stream
     */
    def readFrom(stream: java.io.InputStream): PlayerView = PlayerView(
        StreamUtil.readInt(stream),
        komus24.model.Player.readFrom(stream),
        (0 until StreamUtil.readInt(stream)).map { _ =>
            komus24.model.Player.readFrom(stream)
        },
        (0 until StreamUtil.readInt(stream)).map { _ =>
            komus24.model.Quest.readFrom(stream)
        }
    )
}