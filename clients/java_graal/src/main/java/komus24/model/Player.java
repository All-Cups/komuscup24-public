package komus24.model;

import komus24.util.StreamUtil;

/**
 * Player (game participant)
 */
public class Player {
    /**
     * Index
     */
    private int index;

    /**
     * Index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Index
     */
    public void setIndex(int value) {
        this.index = value;
    }
    /**
     * Current score
     */
    private long score;

    /**
     * Current score
     */
    public long getScore() {
        return score;
    }

    /**
     * Current score
     */
    public void setScore(long value) {
        this.score = value;
    }
    /**
     * List of player's vehicles
     */
    private komus24.model.Vehicle[] vehicles;

    /**
     * List of player's vehicles
     */
    public komus24.model.Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * List of player's vehicles
     */
    public void setVehicles(komus24.model.Vehicle[] value) {
        this.vehicles = value;
    }

    public Player(int index, long score, komus24.model.Vehicle[] vehicles) {
        this.index = index;
        this.score = score;
        this.vehicles = vehicles;
    }

    /**
     * Read Player from input stream
     */
    public static Player readFrom(java.io.InputStream stream) throws java.io.IOException {
        int index;
        index = StreamUtil.readInt(stream);
        long score;
        score = StreamUtil.readLong(stream);
        komus24.model.Vehicle[] vehicles;
        vehicles = new komus24.model.Vehicle[StreamUtil.readInt(stream)];
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            komus24.model.Vehicle vehiclesElement;
            vehiclesElement = komus24.model.Vehicle.readFrom(stream);
            vehicles[vehiclesIndex] = vehiclesElement;
        }
        return new Player(index, score, vehicles);
    }

    /**
     * Write Player to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, index);
        StreamUtil.writeLong(stream, score);
        StreamUtil.writeInt(stream, vehicles.length);
        for (komus24.model.Vehicle vehiclesElement : vehicles) {
            vehiclesElement.writeTo(stream);
        }
    }

    /**
     * Get string representation of Player
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Player { ");
        stringBuilder.append("index: ");
        stringBuilder.append(String.valueOf(index));
        stringBuilder.append(", ");
        stringBuilder.append("score: ");
        stringBuilder.append(String.valueOf(score));
        stringBuilder.append(", ");
        stringBuilder.append("vehicles: ");
        stringBuilder.append("[ ");
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            if (vehiclesIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.Vehicle vehiclesElement = vehicles[vehiclesIndex];
            stringBuilder.append(String.valueOf(vehiclesElement));
        }
        stringBuilder.append(" ]");
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}