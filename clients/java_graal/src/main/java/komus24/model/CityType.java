package komus24.model;

import komus24.util.StreamUtil;

/**
 * City type
 */
public abstract class CityType {
    /**
     * Write CityType to output stream
     */
    public abstract void writeTo(java.io.OutputStream stream) throws java.io.IOException;

    /**
     * Read CityType from input stream
     */
    public static CityType readFrom(java.io.InputStream stream) throws java.io.IOException {
        switch (StreamUtil.readInt(stream)) {
            case Manhattan.TAG:
                return Manhattan.readFrom(stream);
            case Inline.TAG:
                return Inline.readFrom(stream);
            default:
                throw new java.io.IOException("Unexpected tag value");
        }
    }

    /**
     * Auto generated manhattan map
     */
    public static class Manhattan extends CityType {
        public static final int TAG = 0;
    
        /**
         * Map size
         */
        private komus24.model.Vec2Int size;
    
        /**
         * Map size
         */
        public komus24.model.Vec2Int getSize() {
            return size;
        }
    
        /**
         * Map size
         */
        public void setSize(komus24.model.Vec2Int value) {
            this.size = value;
        }
        /**
         * Size of a single block
         */
        private komus24.model.Vec2Int blockSize;
    
        /**
         * Size of a single block
         */
        public komus24.model.Vec2Int getBlockSize() {
            return blockSize;
        }
    
        /**
         * Size of a single block
         */
        public void setBlockSize(komus24.model.Vec2Int value) {
            this.blockSize = value;
        }
        /**
         * Number of refill stations
         */
        private int refills;
    
        /**
         * Number of refill stations
         */
        public int getRefills() {
            return refills;
        }
    
        /**
         * Number of refill stations
         */
        public void setRefills(int value) {
            this.refills = value;
        }
    
        public Manhattan(komus24.model.Vec2Int size, komus24.model.Vec2Int blockSize, int refills) {
            this.size = size;
            this.blockSize = blockSize;
            this.refills = refills;
        }
    
        /**
         * Read Manhattan from input stream
         */
        public static Manhattan readFrom(java.io.InputStream stream) throws java.io.IOException {
            komus24.model.Vec2Int size;
            size = komus24.model.Vec2Int.readFrom(stream);
            komus24.model.Vec2Int blockSize;
            blockSize = komus24.model.Vec2Int.readFrom(stream);
            int refills;
            refills = StreamUtil.readInt(stream);
            return new Manhattan(size, blockSize, refills);
        }
    
        /**
         * Write Manhattan to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            size.writeTo(stream);
            blockSize.writeTo(stream);
            StreamUtil.writeInt(stream, refills);
        }
    
        /**
         * Get string representation of Manhattan
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Manhattan { ");
            stringBuilder.append("size: ");
            stringBuilder.append(String.valueOf(size));
            stringBuilder.append(", ");
            stringBuilder.append("blockSize: ");
            stringBuilder.append(String.valueOf(blockSize));
            stringBuilder.append(", ");
            stringBuilder.append("refills: ");
            stringBuilder.append(String.valueOf(refills));
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    /**
     * Fixed map
     */
    public static class Inline extends CityType {
        public static final int TAG = 1;
    
        /**
         * Each string represents a row in the city
         */
        private String[] cells;
    
        /**
         * Each string represents a row in the city
         */
        public String[] getCells() {
            return cells;
        }
    
        /**
         * Each string represents a row in the city
         */
        public void setCells(String[] value) {
            this.cells = value;
        }
    
        public Inline(String[] cells) {
            this.cells = cells;
        }
    
        /**
         * Read Inline from input stream
         */
        public static Inline readFrom(java.io.InputStream stream) throws java.io.IOException {
            String[] cells;
            cells = new String[StreamUtil.readInt(stream)];
            for (int cellsIndex = 0; cellsIndex < cells.length; cellsIndex++) {
                String cellsElement;
                cellsElement = StreamUtil.readString(stream);
                cells[cellsIndex] = cellsElement;
            }
            return new Inline(cells);
        }
    
        /**
         * Write Inline to output stream
         */
        @Override
        public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
            StreamUtil.writeInt(stream, TAG);
            StreamUtil.writeInt(stream, cells.length);
            for (String cellsElement : cells) {
                StreamUtil.writeString(stream, cellsElement);
            }
        }
    
        /**
         * Get string representation of Inline
         */
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Inline { ");
            stringBuilder.append("cells: ");
            stringBuilder.append("[ ");
            for (int cellsIndex = 0; cellsIndex < cells.length; cellsIndex++) {
                if (cellsIndex != 0) {
                    stringBuilder.append(", ");
                }
                String cellsElement = cells[cellsIndex];
                stringBuilder.append('"' + cellsElement + '"');
            }
            stringBuilder.append(" ]");
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }
}