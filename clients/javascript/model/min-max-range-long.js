/**
 * Range of values
 */
class MinMaxRangeLong {
    /**
     * Minimal value
     */
    min;
    /**
     * Maximal  value
     */
    max;

    constructor(min, max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Read MinMaxRangeLong from input stream
     */
    static async readFrom(stream) {
        let min;
        min = await stream.readLong();
        let max;
        max = await stream.readLong();
        return new MinMaxRangeLong(min, max);
    }

    /**
     * Write MinMaxRangeLong to output stream
     */
    async writeTo(stream) {
        let min = this.min;
        await stream.writeLong(min);
        let max = this.max;
        await stream.writeLong(max);
    }
}
module.exports = MinMaxRangeLong