package komus24.model

import komus24.util.StreamUtil

/**
 * TODO - Document
 */
enum class CityCell private constructor(val tag: Int) {
    /**
     * TODO - Document
     */
    ROAD(0),
    /**
     * TODO - Document
     */
    BUILDING(1),
    /**
     * TODO - Document
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