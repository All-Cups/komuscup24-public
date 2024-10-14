package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
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
            default:
                throw new java.io.IOException("Unexpected tag value");
        }
    }

    /**
     * TODO - Document
     */
    public static class Circle extends DebugData {
        public static final int TAG = 0;
    
        /**
         * TODO - Document
         */
        private komus24.model.Vec2Double pos;
    
        /**
         * TODO - Document
         */
        public komus24.model.Vec2Double getPos() {
            return pos;
        }
    
        /**
         * TODO - Document
         */
        public void setPos(komus24.model.Vec2Double value) {
            this.pos = value;
        }
        /**
         * TODO - Document
         */
        private double radius;
    
        /**
         * TODO - Document
         */
        public double getRadius() {
            return radius;
        }
    
        /**
         * TODO - Document
         */
        public void setRadius(double value) {
            this.radius = value;
        }
    
        public Circle(komus24.model.Vec2Double pos, double radius) {
            this.pos = pos;
            this.radius = radius;
        }
    
        /**
         * Read Circle from input stream
         */
        public static Circle readFrom(java.io.InputStream stream) throws java.io.IOException {
            komus24.model.Vec2Double pos;
            pos = komus24.model.Vec2Double.readFrom(stream);
            double radius;
            radius = StreamUtil.readDouble(stream);
            return new Circle(pos, radius);
        }
    
        /**
         * Write Circle to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            pos.writeTo(stream);
            StreamUtil.writeDouble(stream, radius);
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
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }
}