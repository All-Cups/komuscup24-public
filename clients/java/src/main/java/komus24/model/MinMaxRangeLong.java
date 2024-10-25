package komus24.model;

import komus24.util.StreamUtil;

/**
 * Range of values
 */
public class MinMaxRangeLong {
    /**
     * Minimal value
     */
    private long min;

    /**
     * Minimal value
     */
    public long getMin() {
        return min;
    }

    /**
     * Minimal value
     */
    public void setMin(long value) {
        this.min = value;
    }
    /**
     * Maximal  value
     */
    private long max;

    /**
     * Maximal  value
     */
    public long getMax() {
        return max;
    }

    /**
     * Maximal  value
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