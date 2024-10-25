const Vec2Int = require.main.require('./model/vec2-int');

/**
 * City type
 */
class CityType {
    /**
     * Read CityType from input stream
     */
    static async readFrom(stream) {
        let tag = await stream.readInt();
        if (tag == CityType.Manhattan.TAG) {
            return await CityType.Manhattan.readFrom(stream);
        }
        if (tag == CityType.Inline.TAG) {
            return await CityType.Inline.readFrom(stream);
        }
        throw new Error("Unexpected tag value");
    }
}
/**
 * Auto generated manhattan map
 */
class Manhattan extends CityType {
    /**
     * Map size
     */
    size;
    /**
     * Size of a single block
     */
    blockSize;
    /**
     * Number of refill stations
     */
    refills;

    constructor(size, blockSize, refills) {
        super();
        this.size = size;
        this.blockSize = blockSize;
        this.refills = refills;
    }

    /**
     * Read Manhattan from input stream
     */
    static async readFrom(stream) {
        let size;
        size = await Vec2Int.readFrom(stream);
        let blockSize;
        blockSize = await Vec2Int.readFrom(stream);
        let refills;
        refills = await stream.readInt();
        return new Manhattan(size, blockSize, refills);
    }

    /**
     * Write Manhattan to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Manhattan.TAG);
        let size = this.size;
        await size.writeTo(stream);
        let blockSize = this.blockSize;
        await blockSize.writeTo(stream);
        let refills = this.refills;
        await stream.writeInt(refills);
    }
}

Manhattan.TAG = 0;
CityType.Manhattan = Manhattan;
/**
 * Fixed map
 */
class Inline extends CityType {
    /**
     * Each string represents a row in the city
     */
    cells;

    constructor(cells) {
        super();
        this.cells = cells;
    }

    /**
     * Read Inline from input stream
     */
    static async readFrom(stream) {
        let cells;
        cells = [];
        for (let cellsCount = await stream.readInt(); cellsCount > 0; cellsCount--) {
            let cellsElement;
            cellsElement = await stream.readString();
            cells.push(cellsElement);
        }
        return new Inline(cells);
    }

    /**
     * Write Inline to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Inline.TAG);
        let cells = this.cells;
        await stream.writeInt(cells.length);
        for (let cellsElement of cells) {
            await stream.writeString(cellsElement);
        }
    }
}

Inline.TAG = 1;
CityType.Inline = Inline;
module.exports = CityType;