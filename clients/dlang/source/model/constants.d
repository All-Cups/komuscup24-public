module model.constants;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.city_cell;
import model.city_type;
import model.min_max_range_long;
import model.traffic;
import model.vehicle_type;

/// TODO - Document
struct Constants {
    /// TODO - Document
    int maxTickCount;
    /// TODO - Document
    double maxGameTimeSeconds;
    /// TODO - Document
    double ticksPerSecond;
    /// TODO - Document
    int microticks;
    /// TODO - Document
    double cellSize;
    /// TODO - Document
    double collisionBounciness;
    /// TODO - Document
    model.CityType cityType;
    /// TODO - Document
    model.VehicleType[] vehicleTypes;
    /// TODO - Document
    double refillSpeed;
    /// TODO - Document
    int questCount;
    /// TODO - Document
    model.MinMaxRangeLong questScore;
    /// TODO - Document
    model.Traffic traffic;
    /// TODO - Document
    model.CityCell[][] city;

    this(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, model.CityType cityType, model.VehicleType[] vehicleTypes, double refillSpeed, int questCount, model.MinMaxRangeLong questScore, model.Traffic traffic, model.CityCell[][] city) {
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
        return Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, city);
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
        writer.write(cast(int)(city.length));
        foreach (cityElement; city) {
            writer.write(cast(int)(cityElement.length));
            foreach (cityElementElement; cityElement) {
                writer.write(cast(int)(cityElementElement));
            }
        }
    }
}