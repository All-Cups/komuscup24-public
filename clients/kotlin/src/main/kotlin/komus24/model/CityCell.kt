package komus24.model

import komus24.util.StreamUtil

/**
 * City cell
 */
enum class CityCell private constructor(val tag: Int) {
    /**
     * Road
     */
    ROAD(0),
    /**
     * Building
     */
    BUILDING(1),
    /**
     * Refill station
     */
    REFILL_STATION(2);

    companion object {
        /**
         * Read CityCell from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): CityCell {
            return when (StreamUtil.readInt(stream)) {
            ROAD.tag -> ROAD
            BUILDING.tag -> BUILDING
            REFILL_STATION.tag -> REFILL_STATION
            else -> throw java.io.IOException("Unexpected tag value")
            }
        }
    }
}