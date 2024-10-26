/**
 * Options for traffic
 */
class Traffic {
    /**
     * Number of traffic cars
     */
    amount;
    /**
     * Time to move between adjacent keypoints
     */
    moveTime;
    /**
     * Radius of each traffic car
     */
    radius;
    /**
     * Weight of each traffic car
     */
    weight;
    /**
     * Deceleration after crash
     */
    crashDeceleration;
    /**
     * Lifetime after crash
     */
    crashLifetime;

    constructor(amount, moveTime, radius, weight, crashDeceleration, crashLifetime) {
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
    static async readFrom(stream) {
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
        return new Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime);
    }

    /**
     * Write Traffic to output stream
     */
    async writeTo(stream) {
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
module.exports = Traffic