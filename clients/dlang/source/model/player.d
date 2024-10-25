module model.player;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vehicle;

/// Player (game participant)
struct Player {
    /// Index
    int index;
    /// Current score
    long score;
    /// List of player's vehicles
    model.Vehicle[] vehicles;

    this(int index, long score, model.Vehicle[] vehicles) {
        this.index = index;
        this.score = score;
        this.vehicles = vehicles;
    }

    /// Read Player from reader
    static Player readFrom(Stream reader) {
        int index;
        index = reader.readInt();
        long score;
        score = reader.readLong();
        model.Vehicle[] vehicles;
        vehicles = new model.Vehicle[reader.readInt()];
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            model.Vehicle vehiclesKey;
            vehiclesKey = model.Vehicle.readFrom(reader);
            vehicles[vehiclesIndex] = vehiclesKey;
        }
        return Player(index, score, vehicles);
    }

    /// Write Player to writer
    void writeTo(Stream writer) const {
        writer.write(index);
        writer.write(score);
        writer.write(cast(int)(vehicles.length));
        foreach (vehiclesElement; vehicles) {
            vehiclesElement.writeTo(writer);
        }
    }
}