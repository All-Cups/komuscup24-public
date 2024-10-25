module model.constants;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.city_cell;
import model.city_type;
import model.min_max_range_long;
import model.traffic;
import model.vehicle_type;

/// Game constants
struct Constants {
    /// Max duration of the game in ticks
    int maxTickCount;
    /// Max game time in seconds
    double maxGameTimeSeconds;
    /// Ticks per second
    double ticksPerSecond;
    /// Subticks for physics simulation
    int microticks;
    /// Size of a single city cell
    double cellSize;
    /// Collision bounciness
    double collisionBounciness;
    /// City type
    model.CityType cityType;
    /// List of vehicle types
    model.VehicleType[] vehicleTypes;
    /// Speed of refueling at a station
    double refillSpeed;
    /// Number of available quests
    int questCount;
    /// Score range for quests
    model.MinMaxRangeLong questScore;
    /// Traffic options
    model.Traffic traffic;
    /// Collision penalty modifier
    double collisionPenaltyModifier;
    /// Map of the city
    model.CityCell[][] city;

    this(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, model.CityType cityType, model.VehicleType[] vehicleTypes, double refillSpeed, int questCount, model.MinMaxRangeLong questScore, model.Traffic traffic, double collisionPenaltyModifier, model.CityCell[][] city) {
        this.maxTickCount = maxTickCount;
        this.maxGameTimeSeconds = maxGameTimeSeconds;
        this.ticksPerSecond = ticksPerSecond;
        this.microticks = microticks;
        this.cellSize = cellSize;
        this.collisionBounciness = collisionBounciness;
        this.cityType = cityType;
        this.vehicleTypes = vehicleTypes;
        this.refillSpeed = refillSpeed;
        this.questCount = questCount;
        this.questScore = questScore;
        this.traffic = traffic;
        this.collisionPenaltyModifier = collisionPenaltyModifier;
        this.city = city;
    }

    /// Read Constants from reader
    static Constants readFrom(Stream reader) {
        int maxTickCount;
        maxTickCount = reader.readInt();
        double maxGameTimeSeconds;
        maxGameTimeSeconds = reader.readDouble();
        double ticksPerSecond;
        ticksPerSecond = reader.readDouble();
        int microticks;
        microticks = reader.readInt();
        double cellSize;
        cellSize = reader.readDouble();
        double collisionBounciness;
        collisionBounciness = reader.readDouble();
        model.CityType cityType;
        cityType = model.CityType.readFrom(reader);
        model.VehicleType[] vehicleTypes;
        vehicleTypes = new model.VehicleType[reader.readInt()];
        for (int vehicleTypesIndex = 0; vehicleTypesIndex < vehicleTypes.length; vehicleTypesIndex++) {
            model.VehicleType vehicleTypesKey;
            vehicleTypesKey = model.VehicleType.readFrom(reader);
            vehicleTypes[vehicleTypesIndex] = vehicleTypesKey;
        }
        double refillSpeed;
        refillSpeed = reader.readDouble();
        int questCount;
        questCount = reader.readInt();
        model.MinMaxRangeLong questScore;
        questScore = model.MinMaxRangeLong.readFrom(reader);
        model.Traffic traffic;
        traffic = model.Traffic.readFrom(reader);
        double collisionPenaltyModifier;
        collisionPenaltyModifier = reader.readDouble();
        model.CityCell[][] city;
        city = new model.CityCell[][reader.readInt()];
        for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
            model.CityCell[] cityKey;
            cityKey = new model.CityCell[reader.readInt()];
            for (int cityKeyIndex = 0; cityKeyIndex < cityKey.length; cityKeyIndex++) {
                model.CityCell cityKeyKey;
                cityKeyKey = readCityCell(reader);
                cityKey[cityKeyIndex] = cityKeyKey;
            }
            city[cityIndex] = cityKey;
        }
        return Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, collisionPenaltyModifier, city);
    }

    /// Write Constants to writer
    void writeTo(Stream writer) const {
        writer.write(maxTickCount);
        writer.write(maxGameTimeSeconds);
        writer.write(ticksPerSecond);
        writer.write(microticks);
        writer.write(cellSize);
        writer.write(collisionBounciness);
        cityType.writeTo(writer);
        writer.write(cast(int)(vehicleTypes.length));
        foreach (vehicleTypesElement; vehicleTypes) {
            vehicleTypesElement.writeTo(writer);
        }
        writer.write(refillSpeed);
        writer.write(questCount);
        questScore.writeTo(writer);
        traffic.writeTo(writer);
        writer.write(collisionPenaltyModifier);
        writer.write(cast(int)(city.length));
        foreach (cityElement; city) {
            writer.write(cast(int)(cityElement.length));
            foreach (cityElementElement; cityElement) {
                writer.write(cast(int)(cityElementElement));
            }
        }
    }
}