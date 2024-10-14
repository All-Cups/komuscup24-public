package komus24.model;

import komus24.util.StreamUtil;

/**
 * 2 dimensional vector.
 */
public class Vec2Double {
    /**
     * `x` coordinate of the vector
     */
    private double x;

    /**
     * `x` coordinate of the vector
     */
    public double getX() {
        return x;
    }

    /**
     * `x` coordinate of the vector
     */
    public void setX(double value) {
        this.x = value;
    }
    /**
     * `y` coordinate of the vector
     */
    private double y;

    /**
     * `y` coordinate of the vector
     */
    public double getY() {
        return y;
    }

    /**
     * `y` coordinate of the vector
     */
    public void setY(double value) {
        this.y = value;
    }

    public Vec2Double(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Read Vec2Double from input stream
     */
    public static Vec2Double readFrom(java.io.InputStream stream) throws java.io.IOException {
        double x;
        x = StreamUtil.readDouble(stream);
        double y;
        y = StreamUtil.readDouble(stream);
        return new Vec2Double(x, y);
    }

    /**
     * Write Vec2Double to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeDouble(stream, x);
        StreamUtil.writeDouble(stream, y);
    }

    /**
     * Get string representation of Vec2Double
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Vec2Double { ");
        stringBuilder.append("x: ");
        stringBuilder.append(String.valueOf(x));
        stringBuilder.append(", ");
        stringBuilder.append("y: ");
        stringBuilder.append(String.valueOf(y));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}