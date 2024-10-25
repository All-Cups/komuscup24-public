const Vehicle = require.main.require('./model/vehicle');
/**
 * Player (game participant)
 */
class Player {
    /**
     * Index
     */
    index;
    /**
     * Current score
     */
    score;
    /**
     * List of player's vehicles
     */
    vehicles;

    constructor(index, score, vehicles) {
        this.index = index;
        this.score = score;
        this.vehicles = vehicles;
    }

    /**
     * Read Player from input stream
     */
    static async readFrom(stream) {
        let index;
        index = await stream.readInt();
        let score;
        score = await stream.readLong();
        let vehicles;
        vehicles = [];
        for (let vehiclesCount = await stream.readInt(); vehiclesCount > 0; vehiclesCount--) {
            let vehiclesElement;
            vehiclesElement = await Vehicle.readFrom(stream);
            vehicles.push(vehiclesElement);
        }
        return new Player(index, score, vehicles);
    }

    /**
     * Write Player to output stream
     */
    async writeTo(stream) {
        let index = this.index;
        await stream.writeInt(index);
        let score = this.score;
        await stream.writeLong(score);
        let vehicles = this.vehicles;
        await stream.writeInt(vehicles.length);
        for (let vehiclesElement of vehicles) {
            await vehiclesElement.writeTo(stream);
        }
    }
}
module.exports = Player