module model.min_max_range_long;

import stream;
import std.conv;
import std.typecons : Nullable;


/// Range of values
struct MinMaxRangeLong {
    /// Minimal value
    long min;
    /// Maximal  value
    long max;

    this(long min, long max) {
        this.min = min;
        this.max = max;
    }

    /// Read MinMaxRangeLong from reader
    static MinMaxRangeLong readFrom(Stream reader) {
        long min;
        min = reader.readLong();
        long max;
        max = reader.readLong();
        return MinMaxRangeLong(min, max);
    }

    /// Write MinMaxRangeLong to writer
    void writeTo(Stream writer) const {
        writer.write(min);
        writer.write(max);
    }
}