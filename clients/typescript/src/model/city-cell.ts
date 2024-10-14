import { Stream } from "../stream";

/**
 * TODO - Document
 */
export class CityCell {
    readonly name: string;
    readonly tag: number;

    constructor(name: string, tag: number) {
        this.name = name;
        this.tag = tag;
    }

    /**
     * TODO - Document
     */
    static readonly ROAD = new CityCell("ROAD", 0);
    /**
     * TODO - Document
     */
    static readonly BUILDING = new CityCell("BUILDING", 1);
    /**
     * TODO - Document
     */
    static readonly REFILL_STATION = new CityCell("REFILL_STATION", 2);

    /**
     * Read CityCell from input stream
     */
    static async readFrom(stream: Stream): Promise<CityCell> {
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
    async writeTo(stream: Stream) {
        await stream.writeInt(this.tag);
    }

    [Symbol.for('nodejs.util.inspect.custom')]() {
        return this.name;
    }
}