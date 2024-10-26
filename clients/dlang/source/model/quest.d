module model.quest;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vec2_int;

/// A delivery quest
struct Quest {
    /// Cell where to pick delivery from
    model.Vec2Int pickupCell;
    /// Cell to drop the delivery at
    model.Vec2Int dropCell;
    /// Score for completing the quest
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