package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class Traffic {
    /**
     * TODO - Document
     */
    private int amount;

    /**
     * TODO - Document
     */
    public int getAmount() {
        return amount;
    }

    /**
     * TODO - Document
     */
    public void setAmount(int value) {
        this.amount = value;
    }
    /**
     * TODO - Document
     */
    private double moveTime;

    /**
     * TODO - Document
     */
    public double getMoveTime() {
        return moveTime;
    }

    /**
     * TODO - Document
     */
    public void setMoveTime(double value) {
        this.moveTime = value;
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
    private double crashDeceleration;

    /**
     * TODO - Document
     */
    public double getCrashDeceleration() {
        return crashDeceleration;
    }

    /**
     * TODO - Document
     */
    public void setCrashDeceleration(double value) {
        this.crashDeceleration = value;
    }
    /**
     * TODO - Document
     */
    private double crashLifetime;

    /**
     * TODO - Document
     */
    public double getCrashLifetime() {
        return crashLifetime;
    }

    /**
     * TODO - Document
     */
    public void setCrashLifetime(double value) {
        this.crashLifetime = value;
    }

    public Traffic(int amount, double moveTime, double radius, double weight, double crashDeceleration, double crashLifetime) {
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
    public static Traffic readFrom(java.io.InputStream stream) throws java.io.IOException {
        int amount;
        amount = StreamUtil.readInt(stream);
        double moveTime;
        moveTime = StreamUtil.readDouble(stream);
        double radius;
        radius = StreamUtil.readDouble(stream);
        double weight;
        weight = StreamUtil.readDouble(stream);
        double crashDeceleration;
        crashDeceleration = StreamUtil.readDouble(stream);
        double crashLifetime;
        crashLifetime = StreamUtil.readDouble(stream);
        return new Traffic(amount, moveTime, radius, weight, crashDeceleration, crashLifetime);
    }

    /**
     * Write Traffic to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, amount);
        StreamUtil.writeDouble(stream, moveTime);
        StreamUtil.writeDouble(stream, radius);
        StreamUtil.writeDouble(stream, weight);
        StreamUtil.writeDouble(stream, crashDeceleration);
        StreamUtil.writeDouble(stream, crashLifetime);
    }

    /**
     * Get string representation of Traffic
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Traffic { ");
        stringBuilder.append("amount: ");
        stringBuilder.append(String.valueOf(amount));
        stringBuilder.append(", ");
        stringBuilder.append("moveTime: ");
        stringBuilder.append(String.valueOf(moveTime));
        stringBuilder.append(", ");
        stringBuilder.append("radius: ");
        stringBuilder.append(String.valueOf(radius));
        stringBuilder.append(", ");
        stringBuilder.append("weight: ");
        stringBuilder.append(String.valueOf(weight));
        stringBuilder.append(", ");
        stringBuilder.append("crashDeceleration: ");
        stringBuilder.append(String.valueOf(crashDeceleration));
        stringBuilder.append(", ");
        stringBuilder.append("crashLifetime: ");
        stringBuilder.append(String.valueOf(crashLifetime));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}