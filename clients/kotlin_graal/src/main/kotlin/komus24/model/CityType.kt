package komus24.model

import komus24.util.StreamUtil

/**
 * City type
 */
abstract class CityType {
    /**
     * Write CityType to output stream
     */
    @Throws(java.io.IOException::class)
    abstract fun writeTo(stream: java.io.OutputStream)

    companion object {
        /**
         * Read CityType from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): CityType {
            when (StreamUtil.readInt(stream)) {
                Manhattan.TAG -> return Manhattan.readFrom(stream)
                Inline.TAG -> return Inline.readFrom(stream)
                else -> throw java.io.IOException("Unexpected tag value")
            }
        }
    }

    /**
     * Auto generated manhattan map
     */
    class Manhattan : CityType {
        /**
         * Map size
         */
        var size: komus24.model.Vec2Int
        /**
         * Size of a single block
         */
        var blockSize: komus24.model.Vec2Int
        /**
         * Number of refill stations
         */
        var refills: Int
    
        constructor(size: komus24.model.Vec2Int, blockSize: komus24.model.Vec2Int, refills: Int) {
            this.size = size
            this.blockSize = blockSize
            this.refills = refills
        }
    
        /**
         * Write Manhattan to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            size.writeTo(stream)
            blockSize.writeTo(stream)
            StreamUtil.writeInt(stream, refills)
        }
    
        /**
         * Get string representation of Manhattan
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Manhattan { ")
            stringBuilder.append("size: ")
            stringBuilder.append(size)
            stringBuilder.append(", ")
            stringBuilder.append("blockSize: ")
            stringBuilder.append(blockSize)
            stringBuilder.append(", ")
            stringBuilder.append("refills: ")
            stringBuilder.append(refills)
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 0
    
            /**
             * Read Manhattan from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Manhattan {
                var size: komus24.model.Vec2Int
                size = komus24.model.Vec2Int.readFrom(stream)
                var blockSize: komus24.model.Vec2Int
                blockSize = komus24.model.Vec2Int.readFrom(stream)
                var refills: Int
                refills = StreamUtil.readInt(stream)
                return Manhattan(size, blockSize, refills)
            }
        }
    }

    /**
     * Fixed map
     */
    class Inline : CityType {
        /**
         * Each string represents a row in the city
         */
        var cells: Array<String>
    
        constructor(cells: Array<String>) {
            this.cells = cells
        }
    
        /**
         * Write Inline to output stream
         */
        @Throws(java.io.IOException::class)
        override fun writeTo(stream: java.io.OutputStream) {
            StreamUtil.writeInt(stream, TAG)
            StreamUtil.writeInt(stream, cells.size)
            for (cellsElement in cells) {
                StreamUtil.writeString(stream, cellsElement)
            }
        }
    
        /**
         * Get string representation of Inline
         */
        override fun toString(): String {
            var stringBuilder = StringBuilder("Inline { ")
            stringBuilder.append("cells: ")
            stringBuilder.append("[ ")
            var cellsIndex = 0
            for (cellsElement in cells) {
                if (cellsIndex != 0) {
                    stringBuilder.append(", ")
                }
                stringBuilder.append('"' + cellsElement + '"')
                cellsIndex++
            }
            stringBuilder.append(" ]")
            stringBuilder.append(" }")
            return stringBuilder.toString()
        }
    
        companion object {
            val TAG = 1
    
            /**
             * Read Inline from input stream
             */
            @Throws(java.io.IOException::class)
            fun readFrom(stream: java.io.InputStream): Inline {
                var cells: Array<String>
                cells = Array(StreamUtil.readInt(stream), {
                    var cellsElement: String
                    cellsElement = StreamUtil.readString(stream)
                    cellsElement
                })
                return Inline(cells)
            }
        }
    }
}