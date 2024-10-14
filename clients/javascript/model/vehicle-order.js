/**
 * TODO - Document
 */
class VehicleOrder {
    /**
     * -1..+1
     */
    accelerate;
    /**
     * TODO - Document
     */
    brakes;
    /**
     * -1..+1
     */
    rotate;

    constructor(accelerate, brakes, rotate) {
        this.accelerate = accelerate;
        this.brakes = brakes;
        this.rotate = rotate;
    }

    /**
     * Read VehicleOrder from input stream
     */
    static async readFrom(stream) {
        let accelerate;
        accelerate = await stream.readDouble();
        let brakes;
        brakes = await stream.readBool();
        let rotate;
        rotate = await stream.readDouble();
        return new VehicleOrder(accelerate, brakes, rotate);
    }

    /**
     * Write VehicleOrder to output stream
     */
    async writeTo(stream) {
        let accelerate = this.accelerate;
        await stream.writeDouble(accelerate);
        let brakes = this.brakes;
        await stream.writeBool(brakes);
        let rotate = this.rotate;
        await stream.writeDouble(rotate);
    }
}
module.exports = VehicleOrder