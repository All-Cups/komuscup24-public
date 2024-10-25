import { Color } from "./color";
import { Vec2Double } from "../model/vec2-double";
import { Stream } from "../stream";

/**
 * Data for debug rendering
 */
export abstract class DebugData {
    /**
     * Write DebugData to output stream
     */
    abstract writeTo(stream: Stream): Promise<void>;

    /**
     * Read DebugData from input stream
     */
    static async readFrom(stream: Stream): Promise<DebugData> {
        const tag = await stream.readInt();
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

export namespace DebugData {
    /**
     * Circle
     */
    export class Circle extends DebugData {
        /**
         * Center
         */
        pos: Vec2Double
        /**
         * Radius
         */
        radius: number
        /**
         * Color
         */
        color: Color
    
        constructor(pos: Vec2Double, radius: number, color: Color) {
            super();
            this.pos = pos;
            this.radius = radius;
            this.color = color;
        }
    
        /**
         * Read Circle from input stream
         */
        static async readFrom(stream: Stream): Promise<DebugData.Circle> {
            let pos;
            pos = await Vec2Double.readFrom(stream);
            let radius;
            radius = await stream.readDouble();
            let color;
            color = await Color.readFrom(stream);
            return new Circle(pos, radius, color)
        }
    
        /**
         * Write Circle to output stream
         */
        async writeTo(stream: Stream) {
            await stream.writeInt(Circle.TAG);
            let pos = this.pos;
            await pos.writeTo(stream);
            let radius = this.radius;
            await stream.writeDouble(radius);
            let color = this.color;
            await color.writeTo(stream);
        }
    }
    
    export namespace Circle {
        export const TAG = 0;
    }
    /**
     * Line (segment)
     */
    export class Line extends DebugData {
        /**
         * First end
         */
        point1: Vec2Double
        /**
         * Other end
         */
        point2: Vec2Double
        /**
         * Thickness
         */
        width: number
        /**
         * Color
         */
        color: Color
    
        constructor(point1: Vec2Double, point2: Vec2Double, width: number, color: Color) {
            super();
            this.point1 = point1;
            this.point2 = point2;
            this.width = width;
            this.color = color;
        }
    
        /**
         * Read Line from input stream
         */
        static async readFrom(stream: Stream): Promise<DebugData.Line> {
            let point1;
            point1 = await Vec2Double.readFrom(stream);
            let point2;
            point2 = await Vec2Double.readFrom(stream);
            let width;
            width = await stream.readDouble();
            let color;
            color = await Color.readFrom(stream);
            return new Line(point1, point2, width, color)
        }
    
        /**
         * Write Line to output stream
         */
        async writeTo(stream: Stream) {
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
    
    export namespace Line {
        export const TAG = 1;
    }
    /**
     * Rectangle
     */
    export class Rect extends DebugData {
        /**
         * One of the corners
         */
        corner1: Vec2Double
        /**
         * Opposite corner
         */
        corner2: Vec2Double
        /**
         * Color
         */
        color: Color
    
        constructor(corner1: Vec2Double, corner2: Vec2Double, color: Color) {
            super();
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.color = color;
        }
    
        /**
         * Read Rect from input stream
         */
        static async readFrom(stream: Stream): Promise<DebugData.Rect> {
            let corner1;
            corner1 = await Vec2Double.readFrom(stream);
            let corner2;
            corner2 = await Vec2Double.readFrom(stream);
            let color;
            color = await Color.readFrom(stream);
            return new Rect(corner1, corner2, color)
        }
    
        /**
         * Write Rect to output stream
         */
        async writeTo(stream: Stream) {
            await stream.writeInt(Rect.TAG);
            let corner1 = this.corner1;
            await corner1.writeTo(stream);
            let corner2 = this.corner2;
            await corner2.writeTo(stream);
            let color = this.color;
            await color.writeTo(stream);
        }
    }
    
    export namespace Rect {
        export const TAG = 2;
    }
    /**
     * Text
     */
    export class Text extends DebugData {
        /**
         * Text to draw
         */
        text: string
        /**
         * Position
         */
        pos: Vec2Double
        /**
         * Font size
         */
        size: number
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        align: number
        /**
         * Color
         */
        color: Color
    
        constructor(text: string, pos: Vec2Double, size: number, align: number, color: Color) {
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
        static async readFrom(stream: Stream): Promise<DebugData.Text> {
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
            return new Text(text, pos, size, align, color)
        }
    
        /**
         * Write Text to output stream
         */
        async writeTo(stream: Stream) {
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
    
    export namespace Text {
        export const TAG = 3;
    }
}