import { Vec2Int } from "./vec2-int";
import { Stream } from "../stream";

/**
 * TODO - Document
 */
export abstract class CityType {
    /**
     * Write CityType to output stream
     */
    abstract writeTo(stream: Stream): Promise<void>;

    /**
     * Read CityType from input stream
     */
    static async readFrom(stream: Stream): Promise<CityType> {
        const tag = await stream.readInt();
        if (tag == CityType.Manhattan.TAG) {
            return await CityType.Manhattan.readFrom(stream);
        }
        if (tag == CityType.Inline.TAG) {
            return await CityType.Inline.readFrom(stream);
        }
        throw new Error("Unexpected tag value");
    }
}

export namespace CityType {
    /**
     * TODO - Document
     */
    export class Manhattan extends CityType {
        /**
         * TODO - Document
         */
        size: Vec2Int
        /**
         * TODO - Document
         */
        blockSize: Vec2Int
        /**
         * TODO - Document
         */
        refills: number
    
        constructor(size: Vec2Int, blockSize: Vec2Int, refills: number) {
            super();
            this.size = size;
            this.blockSize = blockSize;
            this.refills = refills;
        }
    
        /**
         * Read Manhattan from input stream
         */
        static async readFrom(stream: Stream): Promise<CityType.Manhattan> {
            let size;
            size = await Vec2Int.readFrom(stream);
            let blockSize;
            blockSize = await Vec2Int.readFrom(stream);
            let refills;
            refills = await stream.readInt();
            return new Manhattan(size, blockSize, refills)
        }
    
        /**
         * Write Manhattan to output stream
         */
        async writeTo(stream: Stream) {
            await stream.writeInt(Manhattan.TAG);
            let size = this.size;
            await size.writeTo(stream);
            let blockSize = this.blockSize;
            await blockSize.writeTo(stream);
            let refills = this.refills;
            await stream.writeInt(refills);
        }
    }
    
    export namespace Manhattan {
        export const TAG = 0;
    }
    /**
     * TODO - Document
     */
    export class Inline extends CityType {
        /**
         * TODO - Document
         */
        cells: Array<string>
    
        constructor(cells: Array<string>) {
            super();
            this.cells = cells;
        }
    
        /**
         * Read Inline from input stream
         */
        static async readFrom(stream: Stream): Promise<CityType.Inline> {
            let cells;
            cells = [];
            for (let cellsCount = await stream.readInt(); cellsCount > 0; cellsCount--) {
                let cellsElement;
                cellsElement = await stream.readString();
                cells.push(cellsElement);
            }
            return new Inline(cells)
        }
    
        /**
         * Write Inline to output stream
         */
        async writeTo(stream: Stream) {
            await stream.writeInt(Inline.TAG);
            let cells = this.cells;
            await stream.writeInt(cells.length);
            for (let cellsElement of cells) {
                await stream.writeString(cellsElement);
            }
        }
    }
    
    export namespace Inline {
        export const TAG = 1;
    }
}