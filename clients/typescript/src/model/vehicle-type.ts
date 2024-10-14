import { Stream } from "../stream";

/**
 * TODO - Document
 */
export class VehicleType {
    /**
     * TODO - Document
     */
    name: string
    /**
     * TODO - Document
     */
    radius: number
    /**
     * TODO - Document
     */
    weight: number
    /**
     * TODO - Document
     */
    maxBackwardsSpeed: number
    /**
     * TODO - Document
     */
    maxSpeed: number
    /**
     * TODO - Document
     */
    acceleration: number
    /**
     * TODO - Document
     */
    friction: number
    /**
     * TODO - Document
     */
    maxRotateSpeed: number
    /**
     * TODO - Document
     */
    rotateAcceleration: number
    /**
     * TODO - Document
     */
    maxFuel: number
    /**
     * TODO - Document
     */
    fuelUseSpeed: number

    constructor(name: string, radius: number, weight: number, maxBackwardsSpeed: number, maxSpeed: number, acceleration: number, friction: number, maxRotateSpeed: number, rotateAcceleration: number, maxFuel: number, fuelUseSpeed: number) {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.friction = friction;
        this.maxRotateSpeed = maxRotateSpeed;
        this.rotateAcceleration = rotateAcceleration;
        this.maxFuel = maxFuel;
        this.fuelUseSpeed = fuelUseSpeed;
    }

    /**
     * Read VehicleType from input stream
     */
    static async readFrom(stream: Stream): Promise<VehicleType> {
        let name;
        name = await stream.readString();
        let radius;
        radius = await stream.readDouble();
        let weight;
        weight = await stream.readDouble();
        let maxBackwardsSpeed;
        maxBackwardsSpeed = await stream.readDouble();
        let maxSpeed;
        maxSpeed = await stream.readDouble();
        let acceleration;
        acceleration = await stream.readDouble();
        let friction;
        friction = await stream.readDouble();
        let maxRotateSpeed;
        maxRotateSpeed = await stream.readDouble();
        let rotateAcceleration;
        rotateAcceleration = await stream.readDouble();
        let maxFuel;
        maxFuel = await stream.readDouble();
        let fuelUseSpeed;
        fuelUseSpeed = await stream.readDouble();
        return new VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed)
    }

    /**
     * Write VehicleType to output stream
     */
    async writeTo(stream: Stream) {
        let name = this.name;
        await stream.writeString(name);
        let radius = this.radius;
        await stream.writeDouble(radius);
        let weight = this.weight;
        await stream.writeDouble(weight);
        let maxBackwardsSpeed = this.maxBackwardsSpeed;
        await stream.writeDouble(maxBackwardsSpeed);
        let maxSpeed = this.maxSpeed;
        await stream.writeDouble(maxSpeed);
        let acceleration = this.acceleration;
        await stream.writeDouble(acceleration);
        let friction = this.friction;
        await stream.writeDouble(friction);
        let maxRotateSpeed = this.maxRotateSpeed;
        await stream.writeDouble(maxRotateSpeed);
        let rotateAcceleration = this.rotateAcceleration;
        await stream.writeDouble(rotateAcceleration);
        let maxFuel = this.maxFuel;
        await stream.writeDouble(maxFuel);
        let fuelUseSpeed = this.fuelUseSpeed;
        await stream.writeDouble(fuelUseSpeed);
    }
}