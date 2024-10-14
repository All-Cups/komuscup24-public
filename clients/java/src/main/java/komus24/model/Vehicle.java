package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class Vehicle {
    /**
     * TODO - Document
     */
    private komus24.model.Vec2Double position;

    /**
     * TODO - Document
     */
    public komus24.model.Vec2Double getPosition() {
        return position;
    }

    /**
     * TODO - Document
     */
    public void setPosition(komus24.model.Vec2Double value) {
        this.position = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Vec2Double velocity;

    /**
     * TODO - Document
     */
    public komus24.model.Vec2Double getVelocity() {
        return velocity;
    }

    /**
     * TODO - Document
     */
    public void setVelocity(komus24.model.Vec2Double value) {
        this.velocity = value;
    }
    /**
     * TODO - Document
     */
    private double speed;

    /**
     * TODO - Document
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * TODO - Document
     */
    public void setSpeed(double value) {
        this.speed = value;
    }
    /**
     * TODO - Document
     */
    private double rotationSpeed;

    /**
     * TODO - Document
     */
    public double getRotationSpeed() {
        return rotationSpeed;
    }

    /**
     * TODO - Document
     */
    public void setRotationSpeed(double value) {
        this.rotationSpeed = value;
    }
    /**
     * TODO - Document
     */
    private double rotation;

    /**
     * TODO - Document
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * TODO - Document
     */
    public void setRotation(double value) {
        this.rotation = value;
    }
    /**
     * TODO - Document
     */
    private int typeIndex;

    /**
     * TODO - Document
     */
    public int getTypeIndex() {
        return typeIndex;
    }

    /**
     * TODO - Document
     */
    public void setTypeIndex(int value) {
        this.typeIndex = value;
    }
    /**
     * TODO maybe multiple quests at the same time?
     */
    private komus24.model.Quest quest;

    /**
     * TODO maybe multiple quests at the same time?
     */
    public komus24.model.Quest getQuest() {
        return quest;
    }

    /**
     * TODO maybe multiple quests at the same time?
     */
    public void setQuest(komus24.model.Quest value) {
        this.quest = value;
    }
    /**
     * TODO - Document
     */
    private double fuel;

    /**
     * TODO - Document
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * TODO - Document
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