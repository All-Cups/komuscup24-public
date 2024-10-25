package komus24.model

import komus24.util.StreamUtil

/**
 * Current game's state
 */
class PlayerView {
    /**
     * Current tick number
     */
    var currentTick: Int
    /**
     * Your player
     */
    var you: komus24.model.Player
    /**
     * Other players
     */
    var other: Array<komus24.model.Player>
    /**
     * Available quests
     */
    var quests: Array<komus24.model.Quest>

    constructor(currentTick: Int, you: komus24.model.Player, other: Array<komus24.model.Player>, quests: Array<komus24.model.Quest>) {
        this.currentTick = currentTick
        this.you = you
        this.other = other
        this.quests = quests
    }

    /**
     * Write PlayerView to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeInt(stream, currentTick)
        you.writeTo(stream)
        StreamUtil.writeInt(stream, other.size)
        for (otherElement in other) {
            otherElement.writeTo(stream)
        }
        StreamUtil.writeInt(stream, quests.size)
        for (questsElement in quests) {
            questsElement.writeTo(stream)
        }
    }

    /**
     * Get string representation of PlayerView
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("PlayerView { ")
        stringBuilder.append("currentTick: ")
        stringBuilder.append(currentTick)
        stringBuilder.append(", ")
        stringBuilder.append("you: ")
        stringBuilder.append(you)
        stringBuilder.append(", ")
        stringBuilder.append("other: ")
        stringBuilder.append("[ ")
        var otherIndex = 0
        for (otherElement in other) {
            if (otherIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(otherElement)
            otherIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(", ")
        stringBuilder.append("quests: ")
        stringBuilder.append("[ ")
        var questsIndex = 0
        for (questsElement in quests) {
            if (questsIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(questsElement)
            questsIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read PlayerView from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): PlayerView {
            var currentTick: Int
            currentTick = StreamUtil.readInt(stream)
            var you: komus24.model.Player
            you = komus24.model.Player.readFrom(stream)
            var other: Array<komus24.model.Player>
            other = Array(StreamUtil.readInt(stream), {
                var otherElement: komus24.model.Player
                otherElement = komus24.model.Player.readFrom(stream)
                otherElement
            })
            var quests: Array<komus24.model.Quest>
            quests = Array(StreamUtil.readInt(stream), {
                var questsElement: komus24.model.Quest
                questsElement = komus24.model.Quest.readFrom(stream)
                questsElement
            })
            return PlayerView(currentTick, you, other, quests)
        }
    }
}