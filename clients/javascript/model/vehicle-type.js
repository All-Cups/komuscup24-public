/**
 * Vehicle type options
 */
class VehicleType {
    /**
     * Name
     */
    name;
    /**
     * Radius
     */
    radius;
    /**
     * Weight
     */
    weight;
    /**
     * Maximal backwads movement speed
     */
    maxBackwardsSpeed;
    /**
     * Maximal forward movement speed
     */
    maxSpeed;
    /**
     * Acceleration
     */
    acceleration;
    /**
     * Friction coefficient
     */
    friction;
    /**
     * Maximal rotation speed
     */
    maxRotateSpeed;
    /**
     * Rotational acceleration
     */
    rotateAcceleration;
    /**
     * Maximal amount of fuel
     */
    maxFuel;
    /**
     * Fuel usage speed
     */
    fuelUseSpeed;

    constructor(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed) {
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
    static async readFrom(stream) {
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
        return new VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed);
    }

    /**
     * Write VehicleType to output stream
     */
    async writeTo(stream) {
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
module.exports = VehicleType