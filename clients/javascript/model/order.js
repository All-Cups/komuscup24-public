const VehicleOrder = require.main.require('./model/vehicle-order');
/**
 * Player's orders
 */
class Order {
    /**
     * TODO - Document
     */
    vehicles;

    constructor(vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Read Order from input stream
     */
    static async readFrom(stream) {
        let vehicles;
        vehicles = [];
        for (let vehiclesCount = await stream.readInt(); vehiclesCount > 0; vehiclesCount--) {
            let vehiclesElement;
            vehiclesElement = await VehicleOrder.readFrom(stream);
            vehicles.push(vehiclesElement);
        }
        return new Order(vehicles);
    }

    /**
     * Write Order to output stream
     */
    async writeTo(stream) {
        let vehicles = this.vehicles;
        await stream.writeInt(vehicles.length);
        for (let vehiclesElement of vehicles) {
            await vehiclesElement.writeTo(stream);
        }
    }
}
module.exports = Order