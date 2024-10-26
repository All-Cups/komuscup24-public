package komus24.model

import komus24.util.StreamUtil

/**
 * City cell
 */
sealed abstract class CityCell (val tag: Int) {
    /**
     * Write CityCell to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, tag)
    }
}

object CityCell {
    /**
     * Road
     */
    case object ROAD extends CityCell(0)
    /**
     * Building
     */
    case object BUILDING extends CityCell(1)
    /**
     * Refill station
     */
    case object REFILL_STATION extends CityCell(2)

    /**
     * Read CityCell from input stream
     */
    def readFrom(stream: java.io.InputStream): CityCell =
        StreamUtil.readInt(stream) match {
            case ROAD.tag => ROAD
            case BUILDING.tag => BUILDING
            case REFILL_STATION.tag => REFILL_STATION
            case _ => throw new java.io.IOException("Unexpected tag value")
        }
}