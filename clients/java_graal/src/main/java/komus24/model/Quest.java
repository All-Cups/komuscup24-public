package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class Quest {
    /**
     * TODO - Document
     */
    private komus24.model.Vec2Int pickupCell;

    /**
     * TODO - Document
     */
    public komus24.model.Vec2Int getPickupCell() {
        return pickupCell;
    }

    /**
     * TODO - Document
     */
    public void setPickupCell(komus24.model.Vec2Int value) {
        this.pickupCell = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Vec2Int dropCell;

    /**
     * TODO - Document
     */
    public komus24.model.Vec2Int getDropCell() {
        return dropCell;
    }

    /**
     * TODO - Document
     */
    public void setDropCell(komus24.model.Vec2Int value) {
        this.dropCell = value;
    }
    /**
     * TODO - Document
     */
    private long score;

    /**
     * TODO - Document
     */
    public long getScore() {
        return score;
    }

    /**
     * TODO - Document
     */
    public void setScore(long value) {
        this.score = value;
    }

    public Quest(komus24.model.Vec2Int pickupCell, komus24.model.Vec2Int dropCell, long score) {
        this.pickupCell = pickupCell;
        this.dropCell = dropCell;
        this.score = score;
    }

    /**
     * Read Quest from input stream
     */
    public static Quest readFrom(java.io.InputStream stream) throws java.io.IOException {
        komus24.model.Vec2Int pickupCell;
        pickupCell = komus24.model.Vec2Int.readFrom(stream);
        komus24.model.Vec2Int dropCell;
        dropCell = komus24.model.Vec2Int.readFrom(stream);
        long score;
        score = StreamUtil.readLong(stream);
        return new Quest(pickupCell, dropCell, score);
    }

    /**
     * Write Quest to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        pickupCell.writeTo(stream);
        dropCell.writeTo(stream);
        StreamUtil.writeLong(stream, score);
    }

    /**
     * Get string representation of Quest
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Quest { ");
        stringBuilder.append("pickupCell: ");
        stringBuilder.append(String.valueOf(pickupCell));
        stringBuilder.append(", ");
        stringBuilder.append("dropCell: ");
        stringBuilder.append(String.valueOf(dropCell));
        stringBuilder.append(", ");
        stringBuilder.append("score: ");
        stringBuilder.append(String.valueOf(score));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}