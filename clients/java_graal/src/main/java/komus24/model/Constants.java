package komus24.model;

import komus24.util.StreamUtil;

/**
 * Game constants
 */
public class Constants {
    /**
     * Max duration of the game in ticks
     */
    private int maxTickCount;

    /**
     * Max duration of the game in ticks
     */
    public int getMaxTickCount() {
        return maxTickCount;
    }

    /**
     * Max duration of the game in ticks
     */
    public void setMaxTickCount(int value) {
        this.maxTickCount = value;
    }
    /**
     * Max game time in seconds
     */
    private double maxGameTimeSeconds;

    /**
     * Max game time in seconds
     */
    public double getMaxGameTimeSeconds() {
        return maxGameTimeSeconds;
    }

    /**
     * Max game time in seconds
     */
    public void setMaxGameTimeSeconds(double value) {
        this.maxGameTimeSeconds = value;
    }
    /**
     * Ticks per second
     */
    private double ticksPerSecond;

    /**
     * Ticks per second
     */
    public double getTicksPerSecond() {
        return ticksPerSecond;
    }

    /**
     * Ticks per second
     */
    public void setTicksPerSecond(double value) {
        this.ticksPerSecond = value;
    }
    /**
     * Subticks for physics simulation
     */
    private int microticks;

    /**
     * Subticks for physics simulation
     */
    public int getMicroticks() {
        return microticks;
    }

    /**
     * Subticks for physics simulation
     */
    public void setMicroticks(int value) {
        this.microticks = value;
    }
    /**
     * Size of a single city cell
     */
    private double cellSize;

    /**
     * Size of a single city cell
     */
    public double getCellSize() {
        return cellSize;
    }

    /**
     * Size of a single city cell
     */
    public void setCellSize(double value) {
        this.cellSize = value;
    }
    /**
     * Collision bounciness
     */
    private double collisionBounciness;

    /**
     * Collision bounciness
     */
    public double getCollisionBounciness() {
        return collisionBounciness;
    }

    /**
     * Collision bounciness
     */
    public void setCollisionBounciness(double value) {
        this.collisionBounciness = value;
    }
    /**
     * City type
     */
    private komus24.model.CityType cityType;

    /**
     * City type
     */
    public komus24.model.CityType getCityType() {
        return cityType;
    }

    /**
     * City type
     */
    public void setCityType(komus24.model.CityType value) {
        this.cityType = value;
    }
    /**
     * List of vehicle types
     */
    private komus24.model.VehicleType[] vehicleTypes;

    /**
     * List of vehicle types
     */
    public komus24.model.VehicleType[] getVehicleTypes() {
        return vehicleTypes;
    }

    /**
     * List of vehicle types
     */
    public void setVehicleTypes(komus24.model.VehicleType[] value) {
        this.vehicleTypes = value;
    }
    /**
     * Speed of refueling at a station
     */
    private double refillSpeed;

    /**
     * Speed of refueling at a station
     */
    public double getRefillSpeed() {
        return refillSpeed;
    }

    /**
     * Speed of refueling at a station
     */
    public void setRefillSpeed(double value) {
        this.refillSpeed = value;
    }
    /**
     * Number of available quests
     */
    private int questCount;

    /**
     * Number of available quests
     */
    public int getQuestCount() {
        return questCount;
    }

    /**
     * Number of available quests
     */
    public void setQuestCount(int value) {
        this.questCount = value;
    }
    /**
     * Score range for quests
     */
    private komus24.model.MinMaxRangeLong questScore;

    /**
     * Score range for quests
     */
    public komus24.model.MinMaxRangeLong getQuestScore() {
        return questScore;
    }

    /**
     * Score range for quests
     */
    public void setQuestScore(komus24.model.MinMaxRangeLong value) {
        this.questScore = value;
    }
    /**
     * Traffic options
     */
    private komus24.model.Traffic traffic;

    /**
     * Traffic options
     */
    public komus24.model.Traffic getTraffic() {
        return traffic;
    }

    /**
     * Traffic options
     */
    public void setTraffic(komus24.model.Traffic value) {
        this.traffic = value;
    }
    /**
     * Collision penalty modifier
     */
    private double collisionPenaltyModifier;

    /**
     * Collision penalty modifier
     */
    public double getCollisionPenaltyModifier() {
        return collisionPenaltyModifier;
    }

    /**
     * Collision penalty modifier
     */
    public void setCollisionPenaltyModifier(double value) {
        this.collisionPenaltyModifier = value;
    }
    /**
     * Map of the city
     */
    private komus24.model.CityCell[][] city;

    /**
     * Map of the city
     */
    public komus24.model.CityCell[][] getCity() {
        return city;
    }

    /**
     * Map of the city
     */
    public void setCity(komus24.model.CityCell[][] value) {
        this.city = value;
    }

    public Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, komus24.model.CityType cityType, komus24.model.VehicleType[] vehicleTypes, double refillSpeed, int questCount, komus24.model.MinMaxRangeLong questScore, komus24.model.Traffic traffic, double collisionPenaltyModifier, komus24.model.CityCell[][] city) {
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

    /**
     * Read Constants from input stream
     */
    public static Constants readFrom(java.io.InputStream stream) throws java.io.IOException {
        int maxTickCount;
        maxTickCount = StreamUtil.readInt(stream);
        double maxGameTimeSeconds;
        maxGameTimeSeconds = StreamUtil.readDouble(stream);
        double ticksPerSecond;
        ticksPerSecond = StreamUtil.readDouble(stream);
        int microticks;
        microticks = StreamUtil.readInt(stream);
        double cellSize;
        cellSize = StreamUtil.readDouble(stream);
        double collisionBounciness;
        collisionBounciness = StreamUtil.readDouble(stream);
        komus24.model.CityType cityType;
        cityType = komus24.model.CityType.readFrom(stream);
        komus24.model.VehicleType[] vehicleTypes;
        vehicleTypes = new komus24.model.VehicleType[StreamUtil.readInt(stream)];
        for (int vehicleTypesIndex = 0; vehicleTypesIndex < vehicleTypes.length; vehicleTypesIndex++) {
            komus24.model.VehicleType vehicleTypesElement;
            vehicleTypesElement = komus24.model.VehicleType.readFrom(stream);
            vehicleTypes[vehicleTypesIndex] = vehicleTypesElement;
        }
        double refillSpeed;
        refillSpeed = StreamUtil.readDouble(stream);
        int questCount;
        questCount = StreamUtil.readInt(stream);
        komus24.model.MinMaxRangeLong questScore;
        questScore = komus24.model.MinMaxRangeLong.readFrom(stream);
        komus24.model.Traffic traffic;
        traffic = komus24.model.Traffic.readFrom(stream);
        double collisionPenaltyModifier;
        collisionPenaltyModifier = StreamUtil.readDouble(stream);
        komus24.model.CityCell[][] city;
        city = new komus24.model.CityCell[StreamUtil.readInt(stream)][];
        for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
            komus24.model.CityCell[] cityElement;
            cityElement = new komus24.model.CityCell[StreamUtil.readInt(stream)];
            for (int cityElementIndex = 0; cityElementIndex < cityElement.length; cityElementIndex++) {
                komus24.model.CityCell cityElementElement;
                cityElementElement = komus24.model.CityCell.readFrom(stream);
                cityElement[cityElementIndex] = cityElementElement;
            }
            city[cityIndex] = cityElement;
        }
        return new Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, collisionPenaltyModifier, city);
    }

    /**
     * Write Constants to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, maxTickCount);
        StreamUtil.writeDouble(stream, maxGameTimeSeconds);
        StreamUtil.writeDouble(stream, ticksPerSecond);
        StreamUtil.writeInt(stream, microticks);
        StreamUtil.writeDouble(stream, cellSize);
        StreamUtil.writeDouble(stream, collisionBounciness);
        cityType.writeTo(stream);
        StreamUtil.writeInt(stream, vehicleTypes.length);
        for (komus24.model.VehicleType vehicleTypesElement : vehicleTypes) {
            vehicleTypesElement.writeTo(stream);
        }
        StreamUtil.writeDouble(stream, refillSpeed);
        StreamUtil.writeInt(stream, questCount);
        questScore.writeTo(stream);
        traffic.writeTo(stream);
        StreamUtil.writeDouble(stream, collisionPenaltyModifier);
        StreamUtil.writeInt(stream, city.length);
        for (komus24.model.CityCell[] cityElement : city) {
            StreamUtil.writeInt(stream, cityElement.length);
            for (komus24.model.CityCell cityElementElement : cityElement) {
                StreamUtil.writeInt(stream, cityElementElement.tag);
            }
        }
    }

    /**
     * Get string representation of Constants
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Constants { ");
        stringBuilder.append("maxTickCount: ");
        stringBuilder.append(String.valueOf(maxTickCount));
        stringBuilder.append(", ");
        stringBuilder.append("maxGameTimeSeconds: ");
        stringBuilder.append(String.valueOf(maxGameTimeSeconds));
        stringBuilder.append(", ");
        stringBuilder.append("ticksPerSecond: ");
        stringBuilder.append(String.valueOf(ticksPerSecond));
        stringBuilder.append(", ");
        stringBuilder.append("microticks: ");
        stringBuilder.append(String.valueOf(microticks));
        stringBuilder.append(", ");
        stringBuilder.append("cellSize: ");
        stringBuilder.append(String.valueOf(cellSize));
        stringBuilder.append(", ");
        stringBuilder.append("collisionBounciness: ");
        stringBuilder.append(String.valueOf(collisionBounciness));
        stringBuilder.append(", ");
        stringBuilder.append("cityType: ");
        stringBuilder.append(String.valueOf(cityType));
        stringBuilder.append(", ");
        stringBuilder.append("vehicleTypes: ");
        stringBuilder.append("[ ");
        for (int vehicleTypesIndex = 0; vehicleTypesIndex < vehicleTypes.length; vehicleTypesIndex++) {
            if (vehicleTypesIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.VehicleType vehicleTypesElement = vehicleTypes[vehicleTypesIndex];
            stringBuilder.append(String.valueOf(vehicleTypesElement));
        }
        stringBuilder.append(" ]");
        stringBuilder.append(", ");
        stringBuilder.append("refillSpeed: ");
        stringBuilder.append(String.valueOf(refillSpeed));
        stringBuilder.append(", ");
        stringBuilder.append("questCount: ");
        stringBuilder.append(String.valueOf(questCount));
        stringBuilder.append(", ");
        stringBuilder.append("questScore: ");
        stringBuilder.append(String.valueOf(questScore));
        stringBuilder.append(", ");
        stringBuilder.append("traffic: ");
        stringBuilder.append(String.valueOf(traffic));
        stringBuilder.append(", ");
        stringBuilder.append("collisionPenaltyModifier: ");
        stringBuilder.append(String.valueOf(collisionPenaltyModifier));
        stringBuilder.append(", ");
        stringBuilder.append("city: ");
        stringBuilder.append("[ ");
        for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
            if (cityIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.CityCell[] cityElement = city[cityIndex];
            stringBuilder.append("[ ");
            for (int cityElementIndex = 0; cityElementIndex < cityElement.length; cityElementIndex++) {
                if (cityElementIndex != 0) {
                    stringBuilder.append(", ");
                }
                komus24.model.CityCell cityElementElement = cityElement[cityElementIndex];
                stringBuilder.append(String.valueOf(cityElementElement));
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append(" ]");
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}