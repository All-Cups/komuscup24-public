const Color = require.main.require('./debugging/color');
const Vec2Double = require.main.require('./model/vec2-double');

/**
 * Data for debug rendering
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
        if (tag == DebugData.Line.TAG) {
            return await DebugData.Line.readFrom(stream);
        }
        if (tag == DebugData.Rect.TAG) {
            return await DebugData.Rect.readFrom(stream);
        }
        if (tag == DebugData.Text.TAG) {
            return await DebugData.Text.readFrom(stream);
        }
        throw new Error("Unexpected tag value");
    }
}
/**
 * Circle
 */
class Circle extends DebugData {
    /**
     * Center
     */
    pos;
    /**
     * Radius
     */
    radius;
    /**
     * Color
     */
    color;

    constructor(pos, radius, color) {
        super();
        this.pos = pos;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Read Circle from input stream
     */
    static async readFrom(stream) {
        let pos;
        pos = await Vec2Double.readFrom(stream);
        let radius;
        radius = await stream.readDouble();
        let color;
        color = await Color.readFrom(stream);
        return new Circle(pos, radius, color);
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
        let color = this.color;
        await color.writeTo(stream);
    }
}

Circle.TAG = 0;
DebugData.Circle = Circle;
/**
 * Line (segment)
 */
class Line extends DebugData {
    /**
     * First end
     */
    point1;
    /**
     * Other end
     */
    point2;
    /**
     * Thickness
     */
    width;
    /**
     * Color
     */
    color;

    constructor(point1, point2, width, color) {
        super();
        this.point1 = point1;
        this.point2 = point2;
        this.width = width;
        this.color = color;
    }

    /**
     * Read Line from input stream
     */
    static async readFrom(stream) {
        let point1;
        point1 = await Vec2Double.readFrom(stream);
        let point2;
        point2 = await Vec2Double.readFrom(stream);
        let width;
        width = await stream.readDouble();
        let color;
        color = await Color.readFrom(stream);
        return new Line(point1, point2, width, color);
    }

    /**
     * Write Line to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Line.TAG);
        let point1 = this.point1;
        await point1.writeTo(stream);
        let point2 = this.point2;
        await point2.writeTo(stream);
        let width = this.width;
        await stream.writeDouble(width);
        let color = this.color;
        await color.writeTo(stream);
    }
}

Line.TAG = 1;
DebugData.Line = Line;
/**
 * Rectangle
 */
class Rect extends DebugData {
    /**
     * One of the corners
     */
    corner1;
    /**
     * Opposite corner
     */
    corner2;
    /**
     * Color
     */
    color;

    constructor(corner1, corner2, color) {
        super();
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.color = color;
    }

    /**
     * Read Rect from input stream
     */
    static async readFrom(stream) {
        let corner1;
        corner1 = await Vec2Double.readFrom(stream);
        let corner2;
        corner2 = await Vec2Double.readFrom(stream);
        let color;
        color = await Color.readFrom(stream);
        return new Rect(corner1, corner2, color);
    }

    /**
     * Write Rect to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Rect.TAG);
        let corner1 = this.corner1;
        await corner1.writeTo(stream);
        let corner2 = this.corner2;
        await corner2.writeTo(stream);
        let color = this.color;
        await color.writeTo(stream);
    }
}

Rect.TAG = 2;
DebugData.Rect = Rect;
/**
 * Text
 */
class Text extends DebugData {
    /**
     * Text to draw
     */
    text;
    /**
     * Position
     */
    pos;
    /**
     * Font size
     */
    size;
    /**
     * Alignment (0 - left, 0.5 - center, 1 - right)
     */
    align;
    /**
     * Color
     */
    color;

    constructor(text, pos, size, align, color) {
        super();
        this.text = text;
        this.pos = pos;
        this.size = size;
        this.align = align;
        this.color = color;
    }

    /**
     * Read Text from input stream
     */
    static async readFrom(stream) {
        let text;
        text = await stream.readString();
        let pos;
        pos = await Vec2Double.readFrom(stream);
        let size;
        size = await stream.readDouble();
        let align;
        align = await stream.readDouble();
        let color;
        color = await Color.readFrom(stream);
        return new Text(text, pos, size, align, color);
    }

    /**
     * Write Text to output stream
     */
    async writeTo(stream) {
        await stream.writeInt(Text.TAG);
        let text = this.text;
        await stream.writeString(text);
        let pos = this.pos;
        await pos.writeTo(stream);
        let size = this.size;
        await stream.writeDouble(size);
        let align = this.align;
        await stream.writeDouble(align);
        let color = this.color;
        await color.writeTo(stream);
    }
}

Text.TAG = 3;
DebugData.Text = Text;
module.exports = DebugData;