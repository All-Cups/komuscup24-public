import { Stream } from "../stream";

/**
 * 2 dimensional vector.
 */
export class Vec2Double {
    /**
     * `x` coordinate of the vector
     */
    x: number
    /**
     * `y` coordinate of the vector
     */
    y: number

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    /**
     * Read Vec2Double from input stream
     */
    static async readFrom(stream: Stream): Promise<Vec2Double> {
        let x;
        x = await stream.readDouble();
        let y;
        y = await stream.readDouble();
        return new Vec2Double(x, y)
    }

    /**
     * Write Vec2Double to output stream
     */
    async writeTo(stream: Stream) {
        let x = this.x;
        await stream.writeDouble(x);
        let y = this.y;
        await stream.writeDouble(y);
    }
}