/**
 * TODO - Document
 */
class CityCell {
    constructor(name, tag) {
        this.name = name;
        this.tag = tag;
    }

    /**
     * TODO - Document
     */
    static ROAD = new CityCell("ROAD", 0);
    /**
     * TODO - Document
     */
    static BUILDING = new CityCell("BUILDING", 1);
    /**
     * TODO - Document
     */
    static REFILL_STATION = new CityCell("REFILL_STATION", 2);

    /**
     * Read CityCell from input stream
     */
    static async readFrom(stream) {
        const tag = await stream.readInt();
        if (tag == CityCell.ROAD.tag) {
            return CityCell.ROAD;
        }
        if (tag == CityCell.BUILDING.tag) {
            return CityCell.BUILDING;
        }
        if (tag == CityCell.REFILL_STATION.tag) {
            return CityCell.REFILL_STATION;
        }
        throw new Error("Unexpected tag value");
    }

    /**
     * Write CityCell to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(this.tag);
    }

    [Symbol.for('nodejs.util.inspect.custom')]() {
        return this.name;
    }
}

module.exports = CityCell;