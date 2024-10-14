package komus24;

public class MyStrategy {
    public MyStrategy(komus24.model.Constants constants) {}
    public komus24.model.Order getOrder(komus24.model.PlayerView playerView, DebugInterface debugInterface) {
        return new komus24.model.Order(new komus24.model.VehicleOrder[0]);
    }
    public void debugUpdate(int displayedTick, DebugInterface debugInterface) {}
    public void finish() {}
}