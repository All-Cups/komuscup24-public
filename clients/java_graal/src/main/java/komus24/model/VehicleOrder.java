package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class VehicleOrder {
    /**
     * -1..+1
     */
    private double accelerate;

    /**
     * -1..+1
     */
    public double getAccelerate() {
        return accelerate;
    }

    /**
     * -1..+1
     */
    public void setAccelerate(double value) {
        this.accelerate = value;
    }
    /**
     * TODO - Document
     */
    private boolean brakes;

    /**
     * TODO - Document
     */
    public boolean isBrakes() {
        return brakes;
    }

    /**
     * TODO - Document
     */
    public void setBrakes(boolean value) {
        this.brakes = value;
    }
    /**
     * -1..+1
     */
    private double rotate;

    /**
     * -1..+1
     */
    public double getRotate() {
        return rotate;
    }

    /**
     * -1..+1
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