package komus24.model;

import komus24.util.StreamUtil;

/**
 * Vehicle type options
 */
public class VehicleType {
    /**
     * Name
     */
    private String name;

    /**
     * Name
     */
    public String getName() {
        return name;
    }

    /**
     * Name
     */
    public void setName(String value) {
        this.name = value;
    }
    /**
     * Radius
     */
    private double radius;

    /**
     * Radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Radius
     */
    public void setRadius(double value) {
        this.radius = value;
    }
    /**
     * Weight
     */
    private double weight;

    /**
     * Weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Weight
     */
    public void setWeight(double value) {
        this.weight = value;
    }
    /**
     * Maximal backwads movement speed
     */
    private double maxBackwardsSpeed;

    /**
     * Maximal backwads movement speed
     */
    public double getMaxBackwardsSpeed() {
        return maxBackwardsSpeed;
    }

    /**
     * Maximal backwads movement speed
     */
    public void setMaxBackwardsSpeed(double value) {
        this.maxBackwardsSpeed = value;
    }
    /**
     * Maximal forward movement speed
     */
    private double maxSpeed;

    /**
     * Maximal forward movement speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Maximal forward movement speed
     */
    public void setMaxSpeed(double value) {
        this.maxSpeed = value;
    }
    /**
     * Acceleration
     */
    private double acceleration;

    /**
     * Acceleration
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Acceleration
     */
    public void setAcceleration(double value) {
        this.acceleration = value;
    }
    /**
     * Friction coefficient
     */
    private double friction;

    /**
     * Friction coefficient
     */
    public double getFriction() {
        return friction;
    }

    /**
     * Friction coefficient
     */
    public void setFriction(double value) {
        this.friction = value;
    }
    /**
     * Maximal rotation speed
     */
    private double maxRotateSpeed;

    /**
     * Maximal rotation speed
     */
    public double getMaxRotateSpeed() {
        return maxRotateSpeed;
    }

    /**
     * Maximal rotation speed
     */
    public void setMaxRotateSpeed(double value) {
        this.maxRotateSpeed = value;
    }
    /**
     * Rotational acceleration
     */
    private double rotateAcceleration;

    /**
     * Rotational acceleration
     */
    public double getRotateAcceleration() {
        return rotateAcceleration;
    }

    /**
     * Rotational acceleration
     */
    public void setRotateAcceleration(double value) {
        this.rotateAcceleration = value;
    }
    /**
     * Maximal amount of fuel
     */
    private double maxFuel;

    /**
     * Maximal amount of fuel
     */
    public double getMaxFuel() {
        return maxFuel;
    }

    /**
     * Maximal amount of fuel
     */
    public void setMaxFuel(double value) {
        this.maxFuel = value;
    }
    /**
     * Fuel usage speed
     */
    private double fuelUseSpeed;

    /**
     * Fuel usage speed
     */
    public double getFuelUseSpeed() {
        return fuelUseSpeed;
    }

    /**
     * Fuel usage speed
     */
    public void setFuelUseSpeed(double value) {
        this.fuelUseSpeed = value;
    }

    public VehicleType(String name, double radius, double weight, double maxBackwardsSpeed, double maxSpeed, double acceleration, double friction, double maxRotateSpeed, double rotateAcceleration, double maxFuel, double fuelUseSpeed) {
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
    public static VehicleType readFrom(java.io.InputStream stream) throws java.io.IOException {
        String name;
        name = StreamUtil.readString(stream);
        double radius;
        radius = StreamUtil.readDouble(stream);
        double weight;
        weight = StreamUtil.readDouble(stream);
        double maxBackwardsSpeed;
        maxBackwardsSpeed = StreamUtil.readDouble(stream);
        double maxSpeed;
        maxSpeed = StreamUtil.readDouble(stream);
        double acceleration;
        acceleration = StreamUtil.readDouble(stream);
        double friction;
        friction = StreamUtil.readDouble(stream);
        double maxRotateSpeed;
        maxRotateSpeed = StreamUtil.readDouble(stream);
        double rotateAcceleration;
        rotateAcceleration = StreamUtil.readDouble(stream);
        double maxFuel;
        maxFuel = StreamUtil.readDouble(stream);
        double fuelUseSpeed;
        fuelUseSpeed = StreamUtil.readDouble(stream);
        return new VehicleType(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed);
    }

    /**
     * Write VehicleType to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeString(stream, name);
        StreamUtil.writeDouble(stream, radius);
        StreamUtil.writeDouble(stream, weight);
        StreamUtil.writeDouble(stream, maxBackwardsSpeed);
        StreamUtil.writeDouble(stream, maxSpeed);
        StreamUtil.writeDouble(stream, acceleration);
        StreamUtil.writeDouble(stream, friction);
        StreamUtil.writeDouble(stream, maxRotateSpeed);
        StreamUtil.writeDouble(stream, rotateAcceleration);
        StreamUtil.writeDouble(stream, maxFuel);
        StreamUtil.writeDouble(stream, fuelUseSpeed);
    }

    /**
     * Get string representation of VehicleType
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VehicleType { ");
        stringBuilder.append("name: ");
        stringBuilder.append('"' + name + '"');
        stringBuilder.append(", ");
        stringBuilder.append("radius: ");
        stringBuilder.append(String.valueOf(radius));
        stringBuilder.append(", ");
        stringBuilder.append("weight: ");
        stringBuilder.append(String.valueOf(weight));
        stringBuilder.append(", ");
        stringBuilder.append("maxBackwardsSpeed: ");
        stringBuilder.append(String.valueOf(maxBackwardsSpeed));
        stringBuilder.append(", ");
        stringBuilder.append("maxSpeed: ");
        stringBuilder.append(String.valueOf(maxSpeed));
        stringBuilder.append(", ");
        stringBuilder.append("acceleration: ");
        stringBuilder.append(String.valueOf(acceleration));
        stringBuilder.append(", ");
        stringBuilder.append("friction: ");
        stringBuilder.append(String.valueOf(friction));
        stringBuilder.append(", ");
        stringBuilder.append("maxRotateSpeed: ");
        stringBuilder.append(String.valueOf(maxRotateSpeed));
        stringBuilder.append(", ");
        stringBuilder.append("rotateAcceleration: ");
        stringBuilder.append(String.valueOf(rotateAcceleration));
        stringBuilder.append(", ");
        stringBuilder.append("maxFuel: ");
        stringBuilder.append(String.valueOf(maxFuel));
        stringBuilder.append(", ");
        stringBuilder.append("fuelUseSpeed: ");
        stringBuilder.append(String.valueOf(fuelUseSpeed));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}