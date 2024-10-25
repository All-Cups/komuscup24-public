package komus24.model;

import komus24.util.StreamUtil;

/**
 * Order for controlling a single vehicle
 */
public class VehicleOrder {
    /**
     * Acceleration (-1 - fully backwards, +1 - fully forward)
     */
    private double accelerate;

    /**
     * Acceleration (-1 - fully backwards, +1 - fully forward)
     */
    public double getAccelerate() {
        return accelerate;
    }

    /**
     * Acceleration (-1 - fully backwards, +1 - fully forward)
     */
    public void setAccelerate(double value) {
        this.accelerate = value;
    }
    /**
     * Hand brakes
     */
    private boolean brakes;

    /**
     * Hand brakes
     */
    public boolean isBrakes() {
        return brakes;
    }

    /**
     * Hand brakes
     */
    public void setBrakes(boolean value) {
        this.brakes = value;
    }
    /**
     * Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
     */
    private double rotate;

    /**
     * Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
     */
    public double getRotate() {
        return rotate;
    }

    /**
     * Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
     */
    public void setRotate(double value) {
        this.rotate = value;
    }

    public VehicleOrder(double accelerate, boolean brakes, double rotate) {
        this.accelerate = accelerate;
        this.brakes = brakes;
        this.rotate = rotate;
    }

    /**
     * Read VehicleOrder from input stream
     */
    public static VehicleOrder readFrom(java.io.InputStream stream) throws java.io.IOException {
        double accelerate;
        accelerate = StreamUtil.readDouble(stream);
        boolean brakes;
        brakes = StreamUtil.readBoolean(stream);
        double rotate;
        rotate = StreamUtil.readDouble(stream);
        return new VehicleOrder(accelerate, brakes, rotate);
    }

    /**
     * Write VehicleOrder to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeDouble(stream, accelerate);
        StreamUtil.writeBoolean(stream, brakes);
        StreamUtil.writeDouble(stream, rotate);
    }

    /**
     * Get string representation of VehicleOrder
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VehicleOrder { ");
        stringBuilder.append("accelerate: ");
        stringBuilder.append(String.valueOf(accelerate));
        stringBuilder.append(", ");
        stringBuilder.append("brakes: ");
        stringBuilder.append(String.valueOf(brakes));
        stringBuilder.append(", ");
        stringBuilder.append("rotate: ");
        stringBuilder.append(String.valueOf(rotate));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}