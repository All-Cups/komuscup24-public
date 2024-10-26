import { Vec2Int } from "./vec2-int";
import { Stream } from "../stream";

/**
 * A delivery quest
 */
export class Quest {
    /**
     * Cell where to pick delivery from
     */
    pickupCell: Vec2Int
    /**
     * Cell to drop the delivery at
     */
    dropCell: Vec2Int
    /**
     * Score for completing the quest
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