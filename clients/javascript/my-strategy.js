const Order = require('./model/order');
const VehicleOrder = require.main.require('./model/vehicle-order');

class MyStrategy {
    constructor(constants) {}
    async getOrder(playerView, debugInterface) {
        return new Order([]);
    }
    async debugUpdate(displayedTick, debugInterface) {}
    finish() {}
}

module.exports = MyStrategy;