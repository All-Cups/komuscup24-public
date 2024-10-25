package komus24.model;

import komus24.util.StreamUtil;

/**
 * Options for traffic
 */
public class Traffic {
    /**
     * Number of traffic cars
     */
    private int amount;

    /**
     * Number of traffic cars
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Number of traffic cars
     */
    public void setAmount(int value) {
        this.amount = value;
    }
    /**
     * Time to move between adjacent keypoints
     */
    private double moveTime;

    /**
     * Time to move between adjacent keypoints
     */
    public double getMoveTime() {
        return moveTime;
    }

    /**
     * Time to move between adjacent keypoints
     */
    public void setMoveTime(double value) {
        this.moveTime = value;
    }
    /**
     * Radius of each traffic car
     */
    private double radius;

    /**
     * Radius of each traffic car
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Radius of each traffic car
     */
    public void setRadius(double value) {
        this.radius = value;
    }
    /**
     * Weight of each traffic car
     */
    private double weight;

    /**
     * Weight of each traffic car
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Weight of each traffic car
     */
    public void setWeight(double value) {
        this.weight = value;
    }
    /**
     * Deceleration after crash
     */
    private double crashDeceleration;

    /**
     * Deceleration after crash
     */
    public double getCrashDeceleration() {
        return crashDeceleration;
    }

    /**
     * Deceleration after crash
     */
    public void setCrashDeceleration(double value) {
        this.crashDeceleration = value;
    }
    /**
     * Lifetime after crash
     */
    private double crashLifetime;

    /**
     * Lifetime after crash
     */
    public double getCrashLifetime() {
        return crashLifetime;
    }

    /**
     * Lifetime after crash
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