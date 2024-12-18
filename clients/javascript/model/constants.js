const CityCell = require.main.require('./model/city-cell');
const CityType = require.main.require('./model/city-type');
const MinMaxRangeLong = require.main.require('./model/min-max-range-long');
const Traffic = require.main.require('./model/traffic');
const VehicleType = require.main.require('./model/vehicle-type');
/**
 * Game constants
 */
class Constants {
    /**
     * Max duration of the game in ticks
     */
    maxTickCount;
    /**
     * Max game time in seconds
     */
    maxGameTimeSeconds;
    /**
     * Ticks per second
     */
    ticksPerSecond;
    /**
     * Subticks for physics simulation
     */
    microticks;
    /**
     * Size of a single city cell
     */
    cellSize;
    /**
     * Collision bounciness
     */
    collisionBounciness;
    /**
     * City type
     */
    cityType;
    /**
     * List of vehicle types
     */
    vehicleTypes;
    /**
     * Speed of refueling at a station
     */
    refillSpeed;
    /**
     * Number of available quests
     */
    questCount;
    /**
     * Score range for quests
     */
    questScore;
    /**
     * Traffic options
     */
    traffic;
    /**
     * Collision penalty modifier
     */
    collisionPenaltyModifier;
    /**
     * Map of the city
     */
    city;

    constructor(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, collisionPenaltyModifier, city) {
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
    static async readFrom(stream) {
        let maxTickCount;
        maxTickCount = await stream.readInt();
        let maxGameTimeSeconds;
        maxGameTimeSeconds = await stream.readDouble();
        let ticksPerSecond;
        ticksPerSecond = await stream.readDouble();
        let microticks;
        microticks = await stream.readInt();
        let cellSize;
        cellSize = await stream.readDouble();
        let collisionBounciness;
        collisionBounciness = await stream.readDouble();
        let cityType;
        cityType = await CityType.readFrom(stream);
        let vehicleTypes;
        vehicleTypes = [];
        for (let vehicleTypesCount = await stream.readInt(); vehicleTypesCount > 0; vehicleTypesCount--) {
            let vehicleTypesElement;
            vehicleTypesElement = await VehicleType.readFrom(stream);
            vehicleTypes.push(vehicleTypesElement);
        }
        let refillSpeed;
        refillSpeed = await stream.readDouble();
        let questCount;
        questCount = await stream.readInt();
        let questScore;
        questScore = await MinMaxRangeLong.readFrom(stream);
        let traffic;
        traffic = await Traffic.readFrom(stream);
        let collisionPenaltyModifier;
        collisionPenaltyModifier = await stream.readDouble();
        let city;
        city = [];
        for (let cityCount = await stream.readInt(); cityCount > 0; cityCount--) {
            let cityElement;
            cityElement = [];
            for (let cityElementCount = await stream.readInt(); cityElementCount > 0; cityElementCount--) {
                let cityElementElement;
                cityElementElement = await CityCell.readFrom(stream);
                cityElement.push(cityElementElement);
            }
            city.push(cityElement);
        }
        return new Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, collisionPenaltyModifier, city);
    }

    /**
     * Write Constants to output stream
     */
    async writeTo(stream) {
        let maxTickCount = this.maxTickCount;
        await stream.writeInt(maxTickCount);
        let maxGameTimeSeconds = this.maxGameTimeSeconds;
        await stream.writeDouble(maxGameTimeSeconds);
        let ticksPerSecond = this.ticksPerSecond;
        await stream.writeDouble(ticksPerSecond);
        let microticks = this.microticks;
        await stream.writeInt(microticks);
        let cellSize = this.cellSize;
        await stream.writeDouble(cellSize);
        let collisionBounciness = this.collisionBounciness;
        await stream.writeDouble(collisionBounciness);
        let cityType = this.cityType;
        await cityType.writeTo(stream);
        let vehicleTypes = this.vehicleTypes;
        await stream.writeInt(vehicleTypes.length);
        for (let vehicleTypesElement of vehicleTypes) {
            await vehicleTypesElement.writeTo(stream);
        }
        let refillSpeed = this.refillSpeed;
        await stream.writeDouble(refillSpeed);
        let questCount = this.questCount;
        await stream.writeInt(questCount);
        let questScore = this.questScore;
        await questScore.writeTo(stream);
        let traffic = this.traffic;
        await traffic.writeTo(stream);
        let collisionPenaltyModifier = this.collisionPenaltyModifier;
        await stream.writeDouble(collisionPenaltyModifier);
        let city = this.city;
        await stream.writeInt(city.length);
        for (let cityElement of city) {
            await stream.writeInt(cityElement.length);
            for (let cityElementElement of cityElement) {
                await cityElementElement.writeTo(stream);
            }
        }
    }
}
module.exports = Constants