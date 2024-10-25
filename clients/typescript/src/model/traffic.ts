import { Stream } from "../stream";

/**
 * Options for traffic
 */
export class Traffic {
    /**
     * Number of traffic cars
     */
    amount: number
    /**
     * Time to move between adjacent keypoints
     */
    moveTime: number
    /**
     * Radius of each traffic car
     */
    radius: number
    /**
     * Weight of each traffic car
     */
    weight: number
    /**
     * Deceleration after crash
     */
    crashDeceleration: number
    /**
     * Lifetime after crash
     */
    crashLifetime: number

    constructor(amount: number, moveTime: number, radius: number, weight: number, crashDeceleration: number, crashLifetime: number) {
        this.amount = amount;
        this.moveTime = moveTime;
        this.radius = radius;
        this.weight = weight;
        this.crashDeceleration = crashDeceleration;
        this.crashLifetime = crashLifetime;
    }

    /**
     * Read Traffic from input stream
     */
    static async readFrom(stream: Stream): Promise<Traffic> {
        let amount;
        amount = await stream.readInt();
        let moveTime;
        moveTime = await stream.readDouble();
        let radius;
        radius = await stream.readDouble();
        let weight;
        weight = await stream.readDouble();
        let crashDeceleration;
        crashDeceleration = await stream.readDouble();
        let crashLifetime;
        crashLifetime = await stream.readDouble();
        return new Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime)
    }

    /**
     * Write Traffic to output stream
     */
    async writeTo(stream: Stream) {
        let amount = this.amount;
        await stream.writeInt(amount);
        let moveTime = this.moveTime;
        await stream.writeDouble(moveTime);
        let radius = this.radius;
        await stream.writeDouble(radius);
        let weight = this.weight;
        await stream.writeDouble(weight);
        let crashDeceleration = this.crashDeceleration;
        await stream.writeDouble(crashDeceleration);
        let crashLifetime = this.crashLifetime;
        await stream.writeDouble(crashLifetime);
    }
}