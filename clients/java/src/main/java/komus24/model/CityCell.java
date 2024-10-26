package komus24.model;

import komus24.util.StreamUtil;

/**
 * City cell
 */
public enum CityCell {
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

    public int tag;

    CityCell(int tag) {
        this.tag = tag;
    }

    /**
     * Read CityCell from input stream
     */
    public static CityCell readFrom(java.io.InputStream stream) throws java.io.IOException {
        switch (StreamUtil.readInt(stream)) {
        case 0:
            return ROAD;
        case 1:
            return BUILDING;
        case 2:
            return REFILL_STATION;
        default:
            throw new java.io.IOException("Unexpected tag value");
        }
    }
}