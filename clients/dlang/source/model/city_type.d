module model.city_type;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vec2_int;

/// City type
abstract class CityType {
    /// Write CityType to writer
    abstract void writeTo(Stream writer) const;

    /// Read CityType from reader
    static CityType readFrom(Stream reader) {
        switch (reader.readInt()) {
            case Manhattan.TAG:
                return Manhattan.readFrom(reader);
            case Inline.TAG:
                return Inline.readFrom(reader);
            default:
                throw new Exception("Unexpected tag value");
        }
    }
    
    /// Auto generated manhattan map
    static class Manhattan : CityType {
        static const int TAG = 0;
    
        /// Map size
        model.Vec2Int size;
        /// Size of a single block
        model.Vec2Int blockSize;
        /// Number of refill stations
        int refills;
    
        this() {}
    
        this(model.Vec2Int size, model.Vec2Int blockSize, int refills) {
            this.size = size;
            this.blockSize = blockSize;
            this.refills = refills;
        }
    
        /// Read Manhattan from reader
        static Manhattan readFrom(Stream reader) {
            model.Vec2Int size;
            size = model.Vec2Int.readFrom(reader);
            model.Vec2Int blockSize;
            blockSize = model.Vec2Int.readFrom(reader);
            int refills;
            refills = reader.readInt();
            return new Manhattan(size, blockSize, refills);
        }
    
        /// Write Manhattan to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            size.writeTo(writer);
            blockSize.writeTo(writer);
            writer.write(refills);
        }
    }
    
    /// Fixed map
    static class Inline : CityType {
        static const int TAG = 1;
    
        /// Each string represents a row in the city
        string[] cells;
    
        this() {}
    
        this(string[] cells) {
            this.cells = cells;
        }
    
        /// Read Inline from reader
        static Inline readFrom(Stream reader) {
            string[] cells;
            cells = new string[reader.readInt()];
            for (int cellsIndex = 0; cellsIndex < cells.length; cellsIndex++) {
                string cellsKey;
                cellsKey = reader.readString();
                cells[cellsIndex] = cellsKey;
            }
            return new Inline(cells);
        }
    
        /// Write Inline to writer
        override void writeTo(Stream writer) const {
            writer.write(TAG);
            writer.write(cast(int)(cells.length));
            foreach (cellsElement; cells) {
                writer.write(cellsElement);
            }
        }
    }
}