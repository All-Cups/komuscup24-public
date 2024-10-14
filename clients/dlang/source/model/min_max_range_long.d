module model.min_max_range_long;

import stream;
import std.conv;
import std.typecons : Nullable;


/// TODO - Document
struct MinMaxRangeLong {
    /// TODO - Document
    long min;
    /// TODO - Document
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