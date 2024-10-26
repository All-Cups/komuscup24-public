import { Stream } from "../stream";

/**
 * Order for controlling a single vehicle
 */
export class VehicleOrder {
    /**
     * Acceleration (-1 - fully backwards, +1 - fully forward)
     */
    accelerate: number
    /**
     * Hand brakes
     */
    brakes: boolean
    /**
     * Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
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