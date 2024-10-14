package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
class DebugState {
    /**
     * TODO - Document
     */
    var pressedKeys: Array<String>

    constructor(pressedKeys: Array<String>) {
        this.pressedKeys = pressedKeys
    }

    /**
     * Write DebugState to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeInt(stream, pressedKeys.size)
        for (pressedKeysElement in pressedKeys) {
            StreamUtil.writeString(stream, pressedKeysElement)
        }
    }

    /**
     * Get string representation of DebugState
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("DebugState { ")
        stringBuilder.append("pressedKeys: ")
        stringBuilder.append("[ ")
        var pressedKeysIndex = 0
        for (pressedKeysElement in pressedKeys) {
            if (pressedKeysIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append('"' + pressedKeysElement + '"')
            pressedKeysIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read DebugState from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): DebugState {
            var pressedKeys: Array<String>
            pressedKeys = Array(StreamUtil.readInt(stream), {
                var pressedKeysElement: String
                pressedKeysElement = StreamUtil.readString(stream)
                pressedKeysElement
            })
            return DebugState(pressedKeys)
        }
    }
}