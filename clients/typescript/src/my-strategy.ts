import { PlayerView } from "./model/player-view";
import { Order } from "./model/order";
import { VehicleOrder } from "./model/vehicle-order";
import { Constants } from "./model/constants";
import { DebugInterface } from "./debug-interface";

export class MyStrategy {
    constructor(constants: Constants) {}
    async getOrder(playerView: PlayerView, debug_interface: DebugInterface | null): Promise<Order> {
        return new Order([]);
    }
    async debugUpdate(displayed_tick: number, debug_interface: DebugInterface) {}
    finish() {}
}