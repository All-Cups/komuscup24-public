class MyStrategy {
    init(_ constants: Constants) {}
    func getOrder(_ playerView: PlayerView, _ debugInterface: DebugInterface?) -> Order {
        return Order(vehicles: [])
    }
    func debugUpdate(_ displayedTick: Int32, _ debugInterface: DebugInterface) {}
    func finish() {}
}