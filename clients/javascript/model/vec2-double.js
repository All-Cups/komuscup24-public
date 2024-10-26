/**
 * 2 dimensional vector.
 */
class Vec2Double {
    /**
     * `x` coordinate of the vector
     */
    x;
    /**
     * `y` coordinate of the vector
     */
    y;

    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Read Vec2Double from input stream
     */
    static async readFrom(stream) {
        let x;
        x = await stream.readDouble();
        let y;
        y = await stream.readDouble();
        return new Vec2Double(x, y);
    }

    /**
     * Write Vec2Double to output stream
     */
    async writeTo(stream) {
        let x = this.x;
        await stream.writeDouble(x);
        let y = this.y;
        await stream.writeDouble(y);
    }
}
module.exports = Vec2Double