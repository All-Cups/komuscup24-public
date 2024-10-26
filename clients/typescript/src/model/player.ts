import { Vehicle } from "./vehicle";
import { Stream } from "../stream";

/**
 * Player (game participant)
 */
export class Player {
    /**
     * Index
     */
    index: number
    /**
     * Current score
     */
    score: bigint
    /**
     * List of player's vehicles
     */
    vehicles: Array<Vehicle>

    constructor(index: number, score: bigint, vehicles: Array<Vehicle>) {
        this.index = index;
        this.score = score;
        this.vehicles = vehicles;
    }

    /**
     * Read Player from input stream
     */
    static async readFrom(stream: Stream): Promise<Player> {
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
        return new Player(index, score, vehicles)
    }

    /**
     * Write Player to output stream
     */
    async writeTo(stream: Stream) {
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