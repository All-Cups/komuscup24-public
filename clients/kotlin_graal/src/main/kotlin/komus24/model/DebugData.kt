package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
abstract class DebugData {
    /**
     * Write DebugData to output stream
     */
    @Throws(java.io.IOException::class)
    abstract fun writeTo(stream: java.io.OutputStream)

    companion object {
        /**
         * Read DebugData from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): DebugData {
            when (StreamUtil.readInt(stream)) {
                Circle.TAG -> return Circle.readFrom(stream)
                else -> throw java.io.IOException("Unexpected tag value")
            }
        }
    }

    /**
     * TODO - Document
     */
    class Circle : DebugData {
        /**
         * TODO - Document
         */
        var pos: komus24.model.Vec2Double
        /**
         * TODO - Document
         */
        var radius: Double
    
        constructor(pos: komus24.model.Vec2Double, radius: Double) {
            this.pos = pos
            this.radius = radius
        }
    
        /**
         * Write Circle to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, radius)
        }
    
        /**
         * Get string representation of Circle
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Circle { ")
            stringBuilder.append("pos: ")
            stringBuilder.append(pos)
            stringBuilder.append(", ")
            stringBuilder.append("radius: ")
            stringBuilder.append(radius)
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 0
    
            /**
             * Read Circle from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Circle {
                var pos: komus24.model.Vec2Double
                pos = komus24.model.Vec2Double.readFrom(stream)
                var radius: Double
                radius = StreamUtil.readDouble(stream)
                return Circle(pos, radius)
            }
        }
    }
}