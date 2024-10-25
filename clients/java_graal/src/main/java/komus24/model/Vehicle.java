package komus24.model;

import komus24.util.StreamUtil;

/**
 * A vehicle
 */
public class Vehicle {
    /**
     * Current position (center)
     */
    private komus24.model.Vec2Double position;

    /**
     * Current position (center)
     */
    public komus24.model.Vec2Double getPosition() {
        return position;
    }

    /**
     * Current position (center)
     */
    public void setPosition(komus24.model.Vec2Double value) {
        this.position = value;
    }
    /**
     * Velocity vector
     */
    private komus24.model.Vec2Double velocity;

    /**
     * Velocity vector
     */
    public komus24.model.Vec2Double getVelocity() {
        return velocity;
    }

    /**
     * Velocity vector
     */
    public void setVelocity(komus24.model.Vec2Double value) {
        this.velocity = value;
    }
    /**
     * Speed of wheels
     */
    private double speed;

    /**
     * Speed of wheels
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Speed of wheels
     */
    public void setSpeed(double value) {
        this.speed = value;
    }
    /**
     * Rotation speed (radians/second)
     */
    private double rotationSpeed;

    /**
     * Rotation speed (radians/second)
     */
    public double getRotationSpeed() {
        return rotationSpeed;
    }

    /**
     * Rotation speed (radians/second)
     */
    public void setRotationSpeed(double value) {
        this.rotationSpeed = value;
    }
    /**
     * Current rotation
     */
    private double rotation;

    /**
     * Current rotation
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Current rotation
     */
    public void setRotation(double value) {
        this.rotation = value;
    }
    /**
     * Vehicle type index
     */
    private int typeIndex;

    /**
     * Vehicle type index
     */
    public int getTypeIndex() {
        return typeIndex;
    }

    /**
     * Vehicle type index
     */
    public void setTypeIndex(int value) {
        this.typeIndex = value;
    }
    /**
     * Current quest, if any
     */
    private komus24.model.Quest quest;

    /**
     * Current quest, if any
     */
    public komus24.model.Quest getQuest() {
        return quest;
    }

    /**
     * Current quest, if any
     */
    public void setQuest(komus24.model.Quest value) {
        this.quest = value;
    }
    /**
     * Remaining fuel
     */
    private double fuel;

    /**
     * Remaining fuel
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Remaining fuel
     */
    public void setFuel(double value) {
        this.fuel = value;
    }

    public Vehicle(komus24.model.Vec2Double position, komus24.model.Vec2Double velocity, double speed, double rotationSpeed, double rotation, int typeIndex, komus24.model.Quest quest, double fuel) {
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
    public static Vehicle readFrom(java.io.InputStream stream) throws java.io.IOException {
        komus24.model.Vec2Double position;
        position = komus24.model.Vec2Double.readFrom(stream);
        komus24.model.Vec2Double velocity;
        velocity = komus24.model.Vec2Double.readFrom(stream);
        double speed;
        speed = StreamUtil.readDouble(stream);
        double rotationSpeed;
        rotationSpeed = StreamUtil.readDouble(stream);
        double rotation;
        rotation = StreamUtil.readDouble(stream);
        int typeIndex;
        typeIndex = StreamUtil.readInt(stream);
        komus24.model.Quest quest;
        if (StreamUtil.readBoolean(stream)) {
            quest = komus24.model.Quest.readFrom(stream);
        } else {
            quest = null;
        }
        double fuel;
        fuel = StreamUtil.readDouble(stream);
        return new Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel);
    }

    /**
     * Write Vehicle to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        position.writeTo(stream);
        velocity.writeTo(stream);
        StreamUtil.writeDouble(stream, speed);
        StreamUtil.writeDouble(stream, rotationSpeed);
        StreamUtil.writeDouble(stream, rotation);
        StreamUtil.writeInt(stream, typeIndex);
        if (quest == null) {
            StreamUtil.writeBoolean(stream, false);
        } else {
            StreamUtil.writeBoolean(stream, true);
            quest.writeTo(stream);
        }
        StreamUtil.writeDouble(stream, fuel);
    }

    /**
     * Get string representation of Vehicle
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Vehicle { ");
        stringBuilder.append("position: ");
        stringBuilder.append(String.valueOf(position));
        stringBuilder.append(", ");
        stringBuilder.append("velocity: ");
        stringBuilder.append(String.valueOf(velocity));
        stringBuilder.append(", ");
        stringBuilder.append("speed: ");
        stringBuilder.append(String.valueOf(speed));
        stringBuilder.append(", ");
        stringBuilder.append("rotationSpeed: ");
        stringBuilder.append(String.valueOf(rotationSpeed));
        stringBuilder.append(", ");
        stringBuilder.append("rotation: ");
        stringBuilder.append(String.valueOf(rotation));
        stringBuilder.append(", ");
        stringBuilder.append("typeIndex: ");
        stringBuilder.append(String.valueOf(typeIndex));
        stringBuilder.append(", ");
        stringBuilder.append("quest: ");
        stringBuilder.append(String.valueOf(quest));
        stringBuilder.append(", ");
        stringBuilder.append("fuel: ");
        stringBuilder.append(String.valueOf(fuel));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}