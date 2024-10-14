import { Vec2Double } from "./vec2-double";
import { Stream } from "../stream";

/**
 * TODO - Document
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
        throw new Error("Unexpected tag value");
    }
}

export namespace DebugData {
    /**
     * TODO - Document
     */
    export class Circle extends DebugData {
        /**
         * TODO - Document
         */
        pos: Vec2Double
        /**
         * TODO - Document
         */
        radius: number
    
        constructor(pos: Vec2Double, radius: number) {
            super();
            this.pos = pos;
            this.radius = radius;
        }
    
        /**
         * Read Circle from input stream
         */
        static async readFrom(stream: Stream): Promise<DebugData.Circle> {
            let pos;
            pos = await Vec2Double.readFrom(stream);
            let radius;
            radius = await stream.readDouble();
            return new Circle(pos, radius)
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
        }
    }
    
    export namespace Circle {
        export const TAG = 0;
    }
}