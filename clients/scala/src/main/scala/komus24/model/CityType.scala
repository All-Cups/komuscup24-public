package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
sealed trait CityType {
    /**
     * Write CityType to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit
}

object CityType {
    /**
     * TODO - Document
     *
     * @param size TODO - Document
     * @param blockSize TODO - Document
     * @param refills TODO - Document
     */
    case class Manhattan(size: komus24.model.Vec2Int, blockSize: komus24.model.Vec2Int, refills: Int) extends CityType {
        /**
         * Write Manhattan to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Manhattan.TAG)
            size.writeTo(stream)
            blockSize.writeTo(stream)
            StreamUtil.writeInt(stream, refills)
        }
    
        /**
         * Get string representation of Manhattan
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Manhattan { ")
            stringBuilder.append("size: ")
            stringBuilder.append(size)
            stringBuilder.append(", ")
            stringBuilder.append("blockSize: ")
            stringBuilder.append(blockSize)
            stringBuilder.append(", ")
            stringBuilder.append("refills: ")
            stringBuilder.append(refills)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Manhattan {
        val TAG: Int = 0
    
        /**
         * Read Manhattan from input stream
         */
        def readFrom(stream: java.io.InputStream): Manhattan = Manhattan(
            komus24.model.Vec2Int.readFrom(stream),
            komus24.model.Vec2Int.readFrom(stream),
            StreamUtil.readInt(stream)
        )
    }

    /**
     * TODO - Document
     *
     * @param cells TODO - Document
     */
    case class Inline(cells: Seq[String]) extends CityType {
        /**
         * Write Inline to output stream
         */
        override def writeTo(stream: java.io.OutputStream): scala.Unit = {
            StreamUtil.writeInt(stream, Inline.TAG)
            StreamUtil.writeInt(stream, cells.length)
            cells.foreach { value =>
                StreamUtil.writeString(stream, value)
            }
        }
    
        /**
         * Get string representation of Inline
         */
        override def toString(): String = {
            var stringBuilder = new StringBuilder("Inline { ")
            stringBuilder.append("cells: ")
            stringBuilder.append(cells)
            stringBuilder.append(" }")
            stringBuilder.toString()
        }
    }
    
    object Inline {
        val TAG: Int = 1
    
        /**
         * Read Inline from input stream
         */
        def readFrom(stream: java.io.InputStream): Inline = Inline(
            (0 until StreamUtil.readInt(stream)).map { _ =>
                StreamUtil.readString(stream)
            }
        )
    }

    /**
     * Read CityType from input stream
     */
    def readFrom(stream: java.io.InputStream): CityType = {
        StreamUtil.readInt(stream) match {
            case Manhattan.TAG => Manhattan.readFrom(stream)
            case Inline.TAG => Inline.readFrom(stream)
            case _ => throw new java.io.IOException("Unexpected tag value")
        }
    }
}