class MyStrategy(constants: komus24.model.Constants) {
    fun getOrder(playerView: komus24.model.PlayerView, debugInterface: DebugInterface?): komus24.model.Order {
        return komus24.model.Order(emptyArray())
    }
    fun debugUpdate(displayedTick: Int, debugInterface: DebugInterface?) {}
    fun finish() {}
}