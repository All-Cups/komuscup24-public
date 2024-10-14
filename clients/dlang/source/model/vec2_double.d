module model.vec2_double;

import stream;
import std.conv;
import std.typecons : Nullable;


/// 2 dimensional vector.
struct Vec2Double {
    /// `x` coordinate of the vector
    double x;
    /// `y` coordinate of the vector
    double y;

    this(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /// Read Vec2Double from reader
    static Vec2Double readFrom(Stream reader) {
        double x;
        x = reader.readDouble();
        double y;
        y = reader.readDouble();
        return Vec2Double(x, y);
    }

    /// Write Vec2Double to writer
    void writeTo(Stream writer) const {
        writer.write(x);
        writer.write(y);
    }
}