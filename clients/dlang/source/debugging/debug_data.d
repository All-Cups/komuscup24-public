module debugging.debug_data;

import stream;
import std.conv;
import std.typecons : Nullable;
import debugging.color;
import model.vec2_double;

/// Data for debug rendering
abstract class DebugData {
    /// Write DebugData to writer
    abstract void writeTo(Stream writer) const;

    /// Read DebugData from reader
    static DebugData readFrom(Stream reader) {
        switch (reader.readInt()) {
            case Circle.TAG:
                return Circle.readFrom(reader);
            case Line.TAG:
                return Line.readFrom(reader);
            case Rect.TAG:
                return Rect.readFrom(reader);
            case Text.TAG:
                return Text.readFrom(reader);
            default:
                throw new Exception("Unexpected tag value");
        }
    }
    
    /// Circle
    static class Circle : DebugData {
        static const int TAG = 0;
    
        /// Center
        model.Vec2Double pos;
        /// Radius
        double radius;
        /// Color
        debugging.Color color;
    
        this() {}
    
        this(model.Vec2Double pos, double radius, debugging.Color color) {
            this.pos = pos;
            this.radius = radius;
            this.color = color;
        }
    
        /// Read Circle from reader
        static Circle readFrom(Stream reader) {
            model.Vec2Double pos;
            pos = model.Vec2Double.readFrom(reader);
            double radius;
            radius = reader.readDouble();
            debugging.Color color;
            color = debugging.Color.readFrom(reader);
            return new Circle(pos, radius, color);
        }
    
        /// Write Circle to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            pos.writeTo(writer);
            writer.write(radius);
            color.writeTo(writer);
        }
    }
    
    /// Line (segment)
    static class Line : DebugData {
        static const int TAG = 1;
    
        /// First end
        model.Vec2Double point1;
        /// Other end
        model.Vec2Double point2;
        /// Thickness
        double width;
        /// Color
        debugging.Color color;
    
        this() {}
    
        this(model.Vec2Double point1, model.Vec2Double point2, double width, debugging.Color color) {
            this.point1 = point1;
            this.point2 = point2;
            this.width = width;
            this.color = color;
        }
    
        /// Read Line from reader
        static Line readFrom(Stream reader) {
            model.Vec2Double point1;
            point1 = model.Vec2Double.readFrom(reader);
            model.Vec2Double point2;
            point2 = model.Vec2Double.readFrom(reader);
            double width;
            width = reader.readDouble();
            debugging.Color color;
            color = debugging.Color.readFrom(reader);
            return new Line(point1, point2, width, color);
        }
    
        /// Write Line to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            point1.writeTo(writer);
            point2.writeTo(writer);
            writer.write(width);
            color.writeTo(writer);
        }
    }
    
    /// Rectangle
    static class Rect : DebugData {
        static const int TAG = 2;
    
        /// One of the corners
        model.Vec2Double corner1;
        /// Opposite corner
        model.Vec2Double corner2;
        /// Color
        debugging.Color color;
    
        this() {}
    
        this(model.Vec2Double corner1, model.Vec2Double corner2, debugging.Color color) {
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.color = color;
        }
    
        /// Read Rect from reader
        static Rect readFrom(Stream reader) {
            model.Vec2Double corner1;
            corner1 = model.Vec2Double.readFrom(reader);
            model.Vec2Double corner2;
            corner2 = model.Vec2Double.readFrom(reader);
            debugging.Color color;
            color = debugging.Color.readFrom(reader);
            return new Rect(corner1, corner2, color);
        }
    
        /// Write Rect to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            corner1.writeTo(writer);
            corner2.writeTo(writer);
            color.writeTo(writer);
        }
    }
    
    /// Text
    static class Text : DebugData {
        static const int TAG = 3;
    
        /// Text to draw
        string text;
        /// Position
        model.Vec2Double pos;
        /// Font size
        double size;
        /// Alignment (0 - left, 0.5 - center, 1 - right)
        double align;
        /// Color
        debugging.Color color;
    
        this() {}
    
        this(string text, model.Vec2Double pos, double size, double align, debugging.Color color) {
            this.text = text;
            this.pos = pos;
            this.size = size;
            this.align = align;
            this.color = color;
        }
    
        /// Read Text from reader
        static Text readFrom(Stream reader) {
            string text;
            text = reader.readString();
            model.Vec2Double pos;
            pos = model.Vec2Double.readFrom(reader);
            double size;
            size = reader.readDouble();
            double align;
            align = reader.readDouble();
            debugging.Color color;
            color = debugging.Color.readFrom(reader);
            return new Text(text, pos, size, align, color);
        }
    
        /// Write Text to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            writer.write(text);
            pos.writeTo(writer);
            writer.write(size);
            writer.write(align);
            color.writeTo(writer);
        }
    }
}