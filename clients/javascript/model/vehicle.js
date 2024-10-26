const Quest = require.main.require('./model/quest');
const Vec2Double = require.main.require('./model/vec2-double');
/**
 * A vehicle
 */
class Vehicle {
    /**
     * Current position (center)
     */
    position;
    /**
     * Velocity vector
     */
    velocity;
    /**
     * Speed of wheels
     */
    speed;
    /**
     * Rotation speed (radians/second)
     */
    rotationSpeed;
    /**
     * Current rotation
     */
    rotation;
    /**
     * Vehicle type index
     */
    typeIndex;
    /**
     * Current quest, if any
     */
    quest;
    /**
     * Remaining fuel
     */
    fuel;

    constructor(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel) {
        this.position = position;
        this.velocity = velocity;
        this.speed = speed;
        this.rotationSpeed = rotationSpeed;
        this.rotation = rotation;
        this.typeIndex = typeIndex;
        this.quest = quest;
        this.fuel = fuel;
    }

    /**
     * Read Vehicle from input stream
     */
    static async readFrom(stream) {
        let position;
        position = await Vec2Double.readFrom(stream);
        let velocity;
        velocity = await Vec2Double.readFrom(stream);
        let speed;
        speed = await stream.readDouble();
        let rotationSpeed;
        rotationSpeed = await stream.readDouble();
        let rotation;
        rotation = await stream.readDouble();
        let typeIndex;
        typeIndex = await stream.readInt();
        let quest;
        if (await stream.readBool()) {
            quest = await Quest.readFrom(stream);
        } else {
            quest = null;
        }
        let fuel;
        fuel = await stream.readDouble();
        return new Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel);
    }

    /**
     * Write Vehicle to output stream
     */
    async writeTo(stream) {
        let position = this.position;
        await position.writeTo(stream);
        let velocity = this.velocity;
        await velocity.writeTo(stream);
        let speed = this.speed;
        await stream.writeDouble(speed);
        let rotationSpeed = this.rotationSpeed;
        await stream.writeDouble(rotationSpeed);
        let rotation = this.rotation;
        await stream.writeDouble(rotation);
        let typeIndex = this.typeIndex;
        await stream.writeInt(typeIndex);
        let quest = this.quest;
        if (quest === null) {
            await stream.writeBool(false);
        } else {
            await stream.writeBool(true);
            await quest.writeTo(stream);
        }
        let fuel = this.fuel;
        await stream.writeDouble(fuel);
    }
}
module.exports = Vehicle