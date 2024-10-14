/**
 * TODO - Document
 */
class Traffic {
    /**
     * TODO - Document
     */
    amount;
    /**
     * TODO - Document
     */
    moveTime;
    /**
     * TODO - Document
     */
    radius;
    /**
     * TODO - Document
     */
    weight;
    /**
     * TODO - Document
     */
    crashDeceleration;
    /**
     * TODO - Document
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