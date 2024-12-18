const Vec2Int = require.main.require('./model/vec2-int');
/**
 * A delivery quest
 */
class Quest {
    /**
     * Cell where to pick delivery from
     */
    pickupCell;
    /**
     * Cell to drop the delivery at
     */
    dropCell;
    /**
     * Score for completing the quest
     */
    score;

    constructor(pickupCell, dropCell, score) {
        this.pickupCell = pickupCell;
        this.dropCell = dropCell;
        this.score = score;
    }

    /**
     * Read Quest from input stream
     */
    static async readFrom(stream) {
        let pickupCell;
        pickupCell = await Vec2Int.readFrom(stream);
        let dropCell;
        dropCell = await Vec2Int.readFrom(stream);
        let score;
        score = await stream.readLong();
        return new Quest(pickupCell, dropCell, score);
    }

    /**
     * Write Quest to output stream
     */
    async writeTo(stream) {
        let pickupCell = this.pickupCell;
        await pickupCell.writeTo(stream);
        let dropCell = this.dropCell;
        await dropCell.writeTo(stream);
        let score = this.score;
        await stream.writeLong(score);
    }
}
module.exports = Quest