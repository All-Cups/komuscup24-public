const Vec2Double = require.main.require('./model/vec2-double');

/**
 * TODO - Document
 */
class DebugData {
    /**
     * Read DebugData from input stream
     */
    static async readFrom(stream) {
        let tag = await stream.readInt();
        if (tag == DebugData.Circle.TAG) {
            return await DebugData.Circle.readFrom(stream);
        }
        throw new Error("Unexpected tag value");
    }
}
/**
 * TODO - Document
 */
class Circle extends DebugData {
    /**
     * TODO - Document
     */
    pos;
    /**
     * TODO - Document
     */
    radius;

    constructor(pos, radius) {
        super();
        this.pos = pos;
        this.radius = radius;
    }

    /**
     * Read Circle from input stream
     */
    static async readFrom(stream) {
        let pos;
        pos = await Vec2Double.readFrom(stream);
        let radius;
        radius = await stream.readDouble();
        return new Circle(pos, radius);
    }

    /**
     * Write Circle to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Circle.TAG);
        let pos = this.pos;
        await pos.writeTo(stream);
        let radius = this.radius;
        await stream.writeDouble(radius);
    }
}

Circle.TAG = 0;
DebugData.Circle = Circle;
module.exports = DebugData;