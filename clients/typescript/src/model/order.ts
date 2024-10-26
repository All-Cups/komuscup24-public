import { VehicleOrder } from "./vehicle-order";
import { Stream } from "../stream";

/**
 * Player's orders
 */
export class Order {
    /**
     * Orders for each of the vehicles
     */
    vehicles: Array<VehicleOrder>

    constructor(vehicles: Array<VehicleOrder>) {
        this.vehicles = vehicles;
    }

    /**
     * Read Order from input stream
     */
    static async readFrom(stream: Stream): Promise<Order> {
        let vehicles;
        vehicles = [];
        for (let vehiclesCount = await stream.readInt(); vehiclesCount > 0; vehiclesCount--) {
            let vehiclesElement;
            vehiclesElement = await VehicleOrder.readFrom(stream);
            vehicles.push(vehiclesElement);
        }
        return new Order(vehicles)
    }

    /**
     * Write Order to output stream
     */
    async writeTo(stream: Stream) {
        let vehicles = this.vehicles;
        await stream.writeInt(vehicles.length);
        for (let vehiclesElement of vehicles) {
            await vehiclesElement.writeTo(stream);
        }
    }
}