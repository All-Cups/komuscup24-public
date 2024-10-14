package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class VehicleType {
    /**
     * TODO - Document
     */
    private String name;

    /**
     * TODO - Document
     */
    public String getName() {
        return name;
    }

    /**
     * TODO - Document
     */
    public void setName(String value) {
        this.name = value;
    }
    /**
     * TODO - Document
     */
    private double radius;

    /**
     * TODO - Document
     */
    public double getRadius() {
        return radius;
    }

    /**
     * TODO - Document
     */
    public void setRadius(double value) {
        this.radius = value;
    }
    /**
     * TODO - Document
     */
    private double weight;

    /**
     * TODO - Document
     */
    public double getWeight() {
        return weight;
    }

    /**
     * TODO - Document
     */
    public void setWeight(double value) {
        this.weight = value;
    }
    /**
     * TODO - Document
     */
    private double maxBackwardsSpeed;

    /**
     * TODO - Document
     */
    public double getMaxBackwardsSpeed() {
        return maxBackwardsSpeed;
    }

    /**
     * TODO - Document
     */
    public void setMaxBackwardsSpeed(double value) {
        this.maxBackwardsSpeed = value;
    }
    /**
     * TODO - Document
     */
    private double maxSpeed;

    /**
     * TODO - Document
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * TODO - Document
     */
    public void setMaxSpeed(double value) {
        this.maxSpeed = value;
    }
    /**
     * TODO - Document
     */
    private double acceleration;

    /**
     * TODO - Document
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * TODO - Document
     */
    public void setAcceleration(double value) {
        this.acceleration = value;
    }
    /**
     * TODO - Document
     */
    private double friction;

    /**
     * TODO - Document
     */
    public double getFriction() {
        return friction;
    }

    /**
     * TODO - Document
     */
    public void setFriction(double value) {
        this.friction = value;
    }
    /**
     * TODO - Document
     */
    private double maxRotateSpeed;

    /**
     * TODO - Document
     */
    public double getMaxRotateSpeed() {
        return maxRotateSpeed;
    }

    /**
     * TODO - Document
     */
    public void setMaxRotateSpeed(double value) {
        this.maxRotateSpeed = value;
    }
    /**
     * TODO - Document
     */
    private double rotateAcceleration;

    /**
     * TODO - Document
     */
    public double getRotateAcceleration() {
        return rotateAcceleration;
    }

    /**
     * TODO - Document
     */
    public void setRotateAcceleration(double value) {
        this.rotateAcceleration = value;
    }
    /**
     * TODO - Document
     */
    private double maxFuel;

    /**
     * TODO - Document
     */
    public double getMaxFuel() {
        return maxFuel;
    }

    /**
     * TODO - Document
     */
    public void setMaxFuel(double value) {
        this.maxFuel = value;
    }
    /**
     * TODO - Document
     */
    private double fuelUseSpeed;

    /**
     * TODO - Document
     */
    public double getFuelUseSpeed() {
        return fuelUseSpeed;
    }

    /**
     * TODO - Document
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