module model.debug_data;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vec2_double;

/// TODO - Document
abstract class DebugData {
    /// Write DebugData to writer
    abstract void writeTo(Stream writer) const;

    /// Read DebugData from reader
    static DebugData readFrom(Stream reader) {
        switch (reader.readInt()) {
            case Circle.TAG:
                return Circle.readFrom(reader);
            default:
                throw new Exception("Unexpected tag value");
        }
    }
    
    /// TODO - Document
    static class Circle : DebugData {
        static const int TAG = 0;
    
        /// TODO - Document
        model.Vec2Double pos;
        /// TODO - Document
        double radius;
    
        this() {}
    
        this(model.Vec2Double pos, double radius) {
            this.pos = pos;
            this.radius = radius;
        }
    
        /// Read Circle from reader
        static Circle readFrom(Stream reader) {
            model.Vec2Double pos;
            pos = model.Vec2Double.readFrom(reader);
            double radius;
            radius = reader.readDouble();
            return new Circle(pos, radius);
        }
    
        /// Write Circle to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            pos.writeTo(writer);
            writer.write(radius);
        }
    }
}