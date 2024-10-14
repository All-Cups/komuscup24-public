import { Vec2Int } from "./vec2-int";
import { Stream } from "../stream";

/**
 * TODO - Document
 */
export class Quest {
    /**
     * TODO - Document
     */
    pickupCell: Vec2Int
    /**
     * TODO - Document
     */
    dropCell: Vec2Int
    /**
     * TODO - Document
     */
    score: bigint

    constructor(pickupCell: Vec2Int, dropCell: Vec2Int, score: bigint) {
        this.pickupCell = pickupCell;
        this.dropCell = dropCell;
        this.score = score;
    }

    /**
     * Read Quest from input stream
     */
    static async readFrom(stream: Stream): Promise<Quest> {
        let pickupCell;
        pickupCell = await Vec2Int.readFrom(stream);
        let dropCell;
        dropCell = await Vec2Int.readFrom(stream);
        let score;
        score = await stream.readLong();
        return new Quest(pickupCell, dropCell, score)
    }

    /**
     * Write Quest to output stream
     */
    async writeTo(stream: Stream) {
        let pickupCell = this.pickupCell;
        await pickupCell.writeTo(stream);
        let dropCell = this.dropCell;
        await dropCell.writeTo(stream);
        let score = this.score;
        await stream.writeLong(score);
    }
}