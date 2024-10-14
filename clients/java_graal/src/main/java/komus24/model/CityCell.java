package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public enum CityCell {
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