package komus24.debugging

import komus24.util.StreamUtil

/**
 * Data for debug rendering
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
                Line.TAG -> return Line.readFrom(stream)
                Rect.TAG -> return Rect.readFrom(stream)
                Text.TAG -> return Text.readFrom(stream)
                else -> throw java.io.IOException("Unexpected tag value")
            }
        }
    }

    /**
     * Circle
     */
    class Circle : DebugData {
        /**
         * Center
         */
        var pos: komus24.model.Vec2Double
        /**
         * Radius
         */
        var radius: Double
        /**
         * Color
         */
        var color: komus24.debugging.Color
    
        constructor(pos: komus24.model.Vec2Double, radius: Double, color: komus24.debugging.Color) {
            this.pos = pos
            this.radius = radius
            this.color = color
        }
    
        /**
         * Write Circle to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, radius)
            color.writeTo(stream)
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
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
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
                var color: komus24.debugging.Color
                color = komus24.debugging.Color.readFrom(stream)
                return Circle(pos, radius, color)
            }
        }
    }

    /**
     * Line (segment)
     */
    class Line : DebugData {
        /**
         * First end
         */
        var point1: komus24.model.Vec2Double
        /**
         * Other end
         */
        var point2: komus24.model.Vec2Double
        /**
         * Thickness
         */
        var width: Double
        /**
         * Color
         */
        var color: komus24.debugging.Color
    
        constructor(point1: komus24.model.Vec2Double, point2: komus24.model.Vec2Double, width: Double, color: komus24.debugging.Color) {
            this.point1 = point1
            this.point2 = point2
            this.width = width
            this.color = color
        }
    
        /**
         * Write Line to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            point1.writeTo(stream)
            point2.writeTo(stream)
            StreamUtil.writeDouble(stream, width)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Line
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Line { ")
            stringBuilder.append("point1: ")
            stringBuilder.append(point1)
            stringBuilder.append(", ")
            stringBuilder.append("point2: ")
            stringBuilder.append(point2)
            stringBuilder.append(", ")
            stringBuilder.append("width: ")
            stringBuilder.append(width)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 1
    
            /**
             * Read Line from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Line {
                var point1: komus24.model.Vec2Double
                point1 = komus24.model.Vec2Double.readFrom(stream)
                var point2: komus24.model.Vec2Double
                point2 = komus24.model.Vec2Double.readFrom(stream)
                var width: Double
                width = StreamUtil.readDouble(stream)
                var color: komus24.debugging.Color
                color = komus24.debugging.Color.readFrom(stream)
                return Line(point1, point2, width, color)
            }
        }
    }

    /**
     * Rectangle
     */
    class Rect : DebugData {
        /**
         * One of the corners
         */
        var corner1: komus24.model.Vec2Double
        /**
         * Opposite corner
         */
        var corner2: komus24.model.Vec2Double
        /**
         * Color
         */
        var color: komus24.debugging.Color
    
        constructor(corner1: komus24.model.Vec2Double, corner2: komus24.model.Vec2Double, color: komus24.debugging.Color) {
            this.corner1 = corner1
            this.corner2 = corner2
            this.color = color
        }
    
        /**
         * Write Rect to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            corner1.writeTo(stream)
            corner2.writeTo(stream)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Rect
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Rect { ")
            stringBuilder.append("corner1: ")
            stringBuilder.append(corner1)
            stringBuilder.append(", ")
            stringBuilder.append("corner2: ")
            stringBuilder.append(corner2)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 2
    
            /**
             * Read Rect from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Rect {
                var corner1: komus24.model.Vec2Double
                corner1 = komus24.model.Vec2Double.readFrom(stream)
                var corner2: komus24.model.Vec2Double
                corner2 = komus24.model.Vec2Double.readFrom(stream)
                var color: komus24.debugging.Color
                color = komus24.debugging.Color.readFrom(stream)
                return Rect(corner1, corner2, color)
            }
        }
    }

    /**
     * Text
     */
    class Text : DebugData {
        /**
         * Text to draw
         */
        var text: String
        /**
         * Position
         */
        var pos: komus24.model.Vec2Double
        /**
         * Font size
         */
        var size: Double
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        var align: Double
        /**
         * Color
         */
        var color: komus24.debugging.Color
    
        constructor(text: String, pos: komus24.model.Vec2Double, size: Double, align: Double, color: komus24.debugging.Color) {
            this.text = text
            this.pos = pos
            this.size = size
            this.align = align
            this.color = color
        }
    
        /**
         * Write Text to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            StreamUtil.writeString(stream, text)
            pos.writeTo(stream)
            StreamUtil.writeDouble(stream, size)
            StreamUtil.writeDouble(stream, align)
            color.writeTo(stream)
        }
    
        /**
         * Get string representation of Text
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Text { ")
            stringBuilder.append("text: ")
            stringBuilder.append('"' + text + '"')
            stringBuilder.append(", ")
            stringBuilder.append("pos: ")
            stringBuilder.append(pos)
            stringBuilder.append(", ")
            stringBuilder.append("size: ")
            stringBuilder.append(size)
            stringBuilder.append(", ")
            stringBuilder.append("align: ")
            stringBuilder.append(align)
            stringBuilder.append(", ")
            stringBuilder.append("color: ")
            stringBuilder.append(color)
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 3
    
            /**
             * Read Text from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Text {
                var text: String
                text = StreamUtil.readString(stream)
                var pos: komus24.model.Vec2Double
                pos = komus24.model.Vec2Double.readFrom(stream)
                var size: Double
                size = StreamUtil.readDouble(stream)
                var align: Double
                align = StreamUtil.readDouble(stream)
                var color: komus24.debugging.Color
                color = komus24.debugging.Color.readFrom(stream)
                return Text(text, pos, size, align, color)
            }
        }
    }
}