package komus24.model;

import komus24.util.StreamUtil;

/**
 * TODO - Document
 */
public class Constants {
    /**
     * TODO - Document
     */
    private int maxTickCount;

    /**
     * TODO - Document
     */
    public int getMaxTickCount() {
        return maxTickCount;
    }

    /**
     * TODO - Document
     */
    public void setMaxTickCount(int value) {
        this.maxTickCount = value;
    }
    /**
     * TODO - Document
     */
    private double maxGameTimeSeconds;

    /**
     * TODO - Document
     */
    public double getMaxGameTimeSeconds() {
        return maxGameTimeSeconds;
    }

    /**
     * TODO - Document
     */
    public void setMaxGameTimeSeconds(double value) {
        this.maxGameTimeSeconds = value;
    }
    /**
     * TODO - Document
     */
    private double ticksPerSecond;

    /**
     * TODO - Document
     */
    public double getTicksPerSecond() {
        return ticksPerSecond;
    }

    /**
     * TODO - Document
     */
    public void setTicksPerSecond(double value) {
        this.ticksPerSecond = value;
    }
    /**
     * TODO - Document
     */
    private int microticks;

    /**
     * TODO - Document
     */
    public int getMicroticks() {
        return microticks;
    }

    /**
     * TODO - Document
     */
    public void setMicroticks(int value) {
        this.microticks = value;
    }
    /**
     * TODO - Document
     */
    private double cellSize;

    /**
     * TODO - Document
     */
    public double getCellSize() {
        return cellSize;
    }

    /**
     * TODO - Document
     */
    public void setCellSize(double value) {
        this.cellSize = value;
    }
    /**
     * TODO - Document
     */
    private double collisionBounciness;

    /**
     * TODO - Document
     */
    public double getCollisionBounciness() {
        return collisionBounciness;
    }

    /**
     * TODO - Document
     */
    public void setCollisionBounciness(double value) {
        this.collisionBounciness = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.CityType cityType;

    /**
     * TODO - Document
     */
    public komus24.model.CityType getCityType() {
        return cityType;
    }

    /**
     * TODO - Document
     */
    public void setCityType(komus24.model.CityType value) {
        this.cityType = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.VehicleType[] vehicleTypes;

    /**
     * TODO - Document
     */
    public komus24.model.VehicleType[] getVehicleTypes() {
        return vehicleTypes;
    }

    /**
     * TODO - Document
     */
    public void setVehicleTypes(komus24.model.VehicleType[] value) {
        this.vehicleTypes = value;
    }
    /**
     * TODO - Document
     */
    private double refillSpeed;

    /**
     * TODO - Document
     */
    public double getRefillSpeed() {
        return refillSpeed;
    }

    /**
     * TODO - Document
     */
    public void setRefillSpeed(double value) {
        this.refillSpeed = value;
    }
    /**
     * TODO - Document
     */
    private int questCount;

    /**
     * TODO - Document
     */
    public int getQuestCount() {
        return questCount;
    }

    /**
     * TODO - Document
     */
    public void setQuestCount(int value) {
        this.questCount = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.MinMaxRangeLong questScore;

    /**
     * TODO - Document
     */
    public komus24.model.MinMaxRangeLong getQuestScore() {
        return questScore;
    }

    /**
     * TODO - Document
     */
    public void setQuestScore(komus24.model.MinMaxRangeLong value) {
        this.questScore = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Traffic traffic;

    /**
     * TODO - Document
     */
    public komus24.model.Traffic getTraffic() {
        return traffic;
    }

    /**
     * TODO - Document
     */
    public void setTraffic(komus24.model.Traffic value) {
        this.traffic = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.CityCell[][] city;

    /**
     * TODO - Document
     */
    public komus24.model.CityCell[][] getCity() {
        return city;
    }

    /**
     * TODO - Document
     */
    public void setCity(komus24.model.CityCell[][] value) {
        this.city = value;
    }

    public Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, komus24.model.CityType cityType, komus24.model.VehicleType[] vehicleTypes, double refillSpeed, int questCount, komus24.model.MinMaxRangeLong questScore, komus24.model.Traffic traffic, komus24.model.CityCell[][] city) {
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
        return new Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, city);
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