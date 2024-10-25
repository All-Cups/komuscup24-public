import { Stream } from "../stream";

/**
 * Range of values
 */
export class MinMaxRangeLong {
    /**
     * Minimal value
     */
    min: bigint
    /**
     * Maximal  value
     */
    max: bigint

    constructor(min: bigint, max: bigint) {
        this.min = min;
        this.max = max;
    }

    /**
     * Read MinMaxRangeLong from input stream
     */
    static async readFrom(stream: Stream): Promise<MinMaxRangeLong> {
        let min;
        min = await stream.readLong();
        let max;
        max = await stream.readLong();
        return new MinMaxRangeLong(min, max)
    }

    /**
     * Write MinMaxRangeLong to output stream
     */
    async writeTo(stream: Stream) {
        let min = this.min;
        await stream.writeLong(min);
        let max = this.max;
        await stream.writeLong(max);
    }
}