package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class MinMaxRangeLong {
    /**
     * TODO - Document
     */
    private long min;

    /**
     * TODO - Document
     */
    public long getMin() {
        return min;
    }

    /**
     * TODO - Document
     */
    public void setMin(long value) {
        this.min = value;
    }
    /**
     * TODO - Document
     */
    private long max;

    /**
     * TODO - Document
     */
    public long getMax() {
        return max;
    }

    /**
     * TODO - Document
     */
    public void setMax(long value) {
        this.max = value;
    }

    public MinMaxRangeLong(long min, long max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Read MinMaxRangeLong from input stream
     */
    public static MinMaxRangeLong readFrom(java.io.InputStream stream) throws java.io.IOException {
        long min;
        min = StreamUtil.readLong(stream);
        long max;
        max = StreamUtil.readLong(stream);
        return new MinMaxRangeLong(min, max);
    }

    /**
     * Write MinMaxRangeLong to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeLong(stream, min);
        StreamUtil.writeLong(stream, max);
    }

    /**
     * Get string representation of MinMaxRangeLong
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MinMaxRangeLong { ");
        stringBuilder.append("min: ");
        stringBuilder.append(String.valueOf(min));
        stringBuilder.append(", ");
        stringBuilder.append("max: ");
        stringBuilder.append(String.valueOf(max));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}