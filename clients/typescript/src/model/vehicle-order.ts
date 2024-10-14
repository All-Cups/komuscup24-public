import { Stream } from "../stream";

/**
 * TODO - Document
 */
export class VehicleOrder {
    /**
     * -1..+1
     */
    accelerate: number
    /**
     * TODO - Document
     */
    brakes: boolean
    /**
     * -1..+1
     */
    rotate: number

    constructor(accelerate: number, brakes: boolean, rotate: number) {
        this.accelerate = accelerate;
        this.brakes = brakes;
        this.rotate = rotate;
    }

    /**
     * Read VehicleOrder from input stream
     */
    static async readFrom(stream: Stream): Promise<VehicleOrder> {
        let accelerate;
        accelerate = await stream.readDouble();
        let brakes;
        brakes = await stream.readBool();
        let rotate;
        rotate = await stream.readDouble();
        return new VehicleOrder(accelerate, brakes, rotate)
    }

    /**
     * Write VehicleOrder to output stream
     */
    async writeTo(stream: Stream) {
        let accelerate = this.accelerate;
        await stream.writeDouble(accelerate);
        let brakes = this.brakes;
        await stream.writeBool(brakes);
        let rotate = this.rotate;
        await stream.writeDouble(rotate);
    }
}