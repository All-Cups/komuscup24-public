package komus24.debugging;

import komus24.util.StreamUtil;

/**
 * Data for debug rendering
 */
public abstract class DebugData {
    /**
     * Write DebugData to output stream
     */
    public abstract void writeTo(java.io.OutputStream stream) throws java.io.IOException;

    /**
     * Read DebugData from input stream
     */
    public static DebugData readFrom(java.io.InputStream stream) throws java.io.IOException {
        switch (StreamUtil.readInt(stream)) {
            case Circle.TAG:
                return Circle.readFrom(stream);
            case Line.TAG:
                return Line.readFrom(stream);
            case Rect.TAG:
                return Rect.readFrom(stream);
            case Text.TAG:
                return Text.readFrom(stream);
            default:
                throw new java.io.IOException("Unexpected tag value");
        }
    }

    /**
     * Circle
     */
    public static class Circle extends DebugData {
        public static final int TAG = 0;
    
        /**
         * Center
         */
        private komus24.model.Vec2Double pos;
    
        /**
         * Center
         */
        public komus24.model.Vec2Double getPos() {
            return pos;
        }
    
        /**
         * Center
         */
        public void setPos(komus24.model.Vec2Double value) {
            this.pos = value;
        }
        /**
         * Radius
         */
        private double radius;
    
        /**
         * Radius
         */
        public double getRadius() {
            return radius;
        }
    
        /**
         * Radius
         */
        public void setRadius(double value) {
            this.radius = value;
        }
        /**
         * Color
         */
        private komus24.debugging.Color color;
    
        /**
         * Color
         */
        public komus24.debugging.Color getColor() {
            return color;
        }
    
        /**
         * Color
         */
        public void setColor(komus24.debugging.Color value) {
            this.color = value;
        }
    
        public Circle(komus24.model.Vec2Double pos, double radius, komus24.debugging.Color color) {
            this.pos = pos;
            this.radius = radius;
            this.color = color;
        }
    
        /**
         * Read Circle from input stream
         */
        public static Circle readFrom(java.io.InputStream stream) throws java.io.IOException {
            komus24.model.Vec2Double pos;
            pos = komus24.model.Vec2Double.readFrom(stream);
            double radius;
            radius = StreamUtil.readDouble(stream);
            komus24.debugging.Color color;
            color = komus24.debugging.Color.readFrom(stream);
            return new Circle(pos, radius, color);
        }
    
        /**
         * Write Circle to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            pos.writeTo(stream);
            StreamUtil.writeDouble(stream, radius);
            color.writeTo(stream);
        }
    
        /**
         * Get string representation of Circle
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Circle { ");
            stringBuilder.append("pos: ");
            stringBuilder.append(String.valueOf(pos));
            stringBuilder.append(", ");
            stringBuilder.append("radius: ");
            stringBuilder.append(String.valueOf(radius));
            stringBuilder.append(", ");
            stringBuilder.append("color: ");
            stringBuilder.append(String.valueOf(color));
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    /**
     * Line (segment)
     */
    public static class Line extends DebugData {
        public static final int TAG = 1;
    
        /**
         * First end
         */
        private komus24.model.Vec2Double point1;
    
        /**
         * First end
         */
        public komus24.model.Vec2Double getPoint1() {
            return point1;
        }
    
        /**
         * First end
         */
        public void setPoint1(komus24.model.Vec2Double value) {
            this.point1 = value;
        }
        /**
         * Other end
         */
        private komus24.model.Vec2Double point2;
    
        /**
         * Other end
         */
        public komus24.model.Vec2Double getPoint2() {
            return point2;
        }
    
        /**
         * Other end
         */
        public void setPoint2(komus24.model.Vec2Double value) {
            this.point2 = value;
        }
        /**
         * Thickness
         */
        private double width;
    
        /**
         * Thickness
         */
        public double getWidth() {
            return width;
        }
    
        /**
         * Thickness
         */
        public void setWidth(double value) {
            this.width = value;
        }
        /**
         * Color
         */
        private komus24.debugging.Color color;
    
        /**
         * Color
         */
        public komus24.debugging.Color getColor() {
            return color;
        }
    
        /**
         * Color
         */
        public void setColor(komus24.debugging.Color value) {
            this.color = value;
        }
    
        public Line(komus24.model.Vec2Double point1, komus24.model.Vec2Double point2, double width, komus24.debugging.Color color) {
            this.point1 = point1;
            this.point2 = point2;
            this.width = width;
            this.color = color;
        }
    
        /**
         * Read Line from input stream
         */
        public static Line readFrom(java.io.InputStream stream) throws java.io.IOException {
            komus24.model.Vec2Double point1;
            point1 = komus24.model.Vec2Double.readFrom(stream);
            komus24.model.Vec2Double point2;
            point2 = komus24.model.Vec2Double.readFrom(stream);
            double width;
            width = StreamUtil.readDouble(stream);
            komus24.debugging.Color color;
            color = komus24.debugging.Color.readFrom(stream);
            return new Line(point1, point2, width, color);
        }
    
        /**
         * Write Line to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            point1.writeTo(stream);
            point2.writeTo(stream);
            StreamUtil.writeDouble(stream, width);
            color.writeTo(stream);
        }
    
        /**
         * Get string representation of Line
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Line { ");
            stringBuilder.append("point1: ");
            stringBuilder.append(String.valueOf(point1));
            stringBuilder.append(", ");
            stringBuilder.append("point2: ");
            stringBuilder.append(String.valueOf(point2));
            stringBuilder.append(", ");
            stringBuilder.append("width: ");
            stringBuilder.append(String.valueOf(width));
            stringBuilder.append(", ");
            stringBuilder.append("color: ");
            stringBuilder.append(String.valueOf(color));
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    /**
     * Rectangle
     */
    public static class Rect extends DebugData {
        public static final int TAG = 2;
    
        /**
         * One of the corners
         */
        private komus24.model.Vec2Double corner1;
    
        /**
         * One of the corners
         */
        public komus24.model.Vec2Double getCorner1() {
            return corner1;
        }
    
        /**
         * One of the corners
         */
        public void setCorner1(komus24.model.Vec2Double value) {
            this.corner1 = value;
        }
        /**
         * Opposite corner
         */
        private komus24.model.Vec2Double corner2;
    
        /**
         * Opposite corner
         */
        public komus24.model.Vec2Double getCorner2() {
            return corner2;
        }
    
        /**
         * Opposite corner
         */
        public void setCorner2(komus24.model.Vec2Double value) {
            this.corner2 = value;
        }
        /**
         * Color
         */
        private komus24.debugging.Color color;
    
        /**
         * Color
         */
        public komus24.debugging.Color getColor() {
            return color;
        }
    
        /**
         * Color
         */
        public void setColor(komus24.debugging.Color value) {
            this.color = value;
        }
    
        public Rect(komus24.model.Vec2Double corner1, komus24.model.Vec2Double corner2, komus24.debugging.Color color) {
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.color = color;
        }
    
        /**
         * Read Rect from input stream
         */
        public static Rect readFrom(java.io.InputStream stream) throws java.io.IOException {
            komus24.model.Vec2Double corner1;
            corner1 = komus24.model.Vec2Double.readFrom(stream);
            komus24.model.Vec2Double corner2;
            corner2 = komus24.model.Vec2Double.readFrom(stream);
            komus24.debugging.Color color;
            color = komus24.debugging.Color.readFrom(stream);
            return new Rect(corner1, corner2, color);
        }
    
        /**
         * Write Rect to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            corner1.writeTo(stream);
            corner2.writeTo(stream);
            color.writeTo(stream);
        }
    
        /**
         * Get string representation of Rect
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Rect { ");
            stringBuilder.append("corner1: ");
            stringBuilder.append(String.valueOf(corner1));
            stringBuilder.append(", ");
            stringBuilder.append("corner2: ");
            stringBuilder.append(String.valueOf(corner2));
            stringBuilder.append(", ");
            stringBuilder.append("color: ");
            stringBuilder.append(String.valueOf(color));
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    /**
     * Text
     */
    public static class Text extends DebugData {
        public static final int TAG = 3;
    
        /**
         * Text to draw
         */
        private String text;
    
        /**
         * Text to draw
         */
        public String getText() {
            return text;
        }
    
        /**
         * Text to draw
         */
        public void setText(String value) {
            this.text = value;
        }
        /**
         * Position
         */
        private komus24.model.Vec2Double pos;
    
        /**
         * Position
         */
        public komus24.model.Vec2Double getPos() {
            return pos;
        }
    
        /**
         * Position
         */
        public void setPos(komus24.model.Vec2Double value) {
            this.pos = value;
        }
        /**
         * Font size
         */
        private double size;
    
        /**
         * Font size
         */
        public double getSize() {
            return size;
        }
    
        /**
         * Font size
         */
        public void setSize(double value) {
            this.size = value;
        }
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        private double align;
    
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        public double getAlign() {
            return align;
        }
    
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        public void setAlign(double value) {
            this.align = value;
        }
        /**
         * Color
         */
        private komus24.debugging.Color color;
    
        /**
         * Color
         */
        public komus24.debugging.Color getColor() {
            return color;
        }
    
        /**
         * Color
         */
        public void setColor(komus24.debugging.Color value) {
            this.color = value;
        }
    
        public Text(String text, komus24.model.Vec2Double pos, double size, double align, komus24.debugging.Color color) {
            this.text = text;
            this.pos = pos;
            this.size = size;
            this.align = align;
            this.color = color;
        }
    
        /**
         * Read Text from input stream
         */
        public static Text readFrom(java.io.InputStream stream) throws java.io.IOException {
            String text;
            text = StreamUtil.readString(stream);
            komus24.model.Vec2Double pos;
            pos = komus24.model.Vec2Double.readFrom(stream);
            double size;
            size = StreamUtil.readDouble(stream);
            double align;
            align = StreamUtil.readDouble(stream);
            komus24.debugging.Color color;
            color = komus24.debugging.Color.readFrom(stream);
            return new Text(text, pos, size, align, color);
        }
    
        /**
         * Write Text to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            StreamUtil.writeString(stream, text);
            pos.writeTo(stream);
            StreamUtil.writeDouble(stream, size);
            StreamUtil.writeDouble(stream, align);
            color.writeTo(stream);
        }
    
        /**
         * Get string representation of Text
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Text { ");
            stringBuilder.append("text: ");
            stringBuilder.append('"' + text + '"');
            stringBuilder.append(", ");
            stringBuilder.append("pos: ");
            stringBuilder.append(String.valueOf(pos));
            stringBuilder.append(", ");
            stringBuilder.append("size: ");
            stringBuilder.append(String.valueOf(size));
            stringBuilder.append(", ");
            stringBuilder.append("align: ");
            stringBuilder.append(String.valueOf(align));
            stringBuilder.append(", ");
            stringBuilder.append("color: ");
            stringBuilder.append(String.valueOf(color));
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }
}