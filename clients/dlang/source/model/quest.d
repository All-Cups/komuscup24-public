module model.quest;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vec2_int;

/// TODO - Document
struct Quest {
    /// TODO - Document
    model.Vec2Int pickupCell;
    /// TODO - Document
    model.Vec2Int dropCell;
    /// TODO - Document
    long score;

    this(model.Vec2Int pickupCell, model.Vec2Int dropCell, long score) {
        this.pickupCell = pickupCell;
        this.dropCell = dropCell;
        this.score = score;
    }

    /// Read Quest from reader
    static Quest readFrom(Stream reader) {
        model.Vec2Int pickupCell;
        pickupCell = model.Vec2Int.readFrom(reader);
        model.Vec2Int dropCell;
        dropCell = model.Vec2Int.readFrom(reader);
        long score;
        score = reader.readLong();
        return Quest(pickupCell, dropCell, score);
    }

    /// Write Quest to writer
    void writeTo(Stream writer) const {
        pickupCell.writeTo(writer);
        dropCell.writeTo(writer);
        writer.write(score);
    }
}