import model.order;
import model.player_view;
import model.constants;
import std.typecons;
import std.conv;
import debug_interface;

class MyStrategy
{
    this(model.Constants constants) {}
    model.Order getOrder(model.PlayerView playerView, DebugInterface debugInterface)
    {
        return model.Order(new model.VehicleOrder[0]);
    }
    void debugUpdate(int displayedTick, DebugInterface debugInterface) {}
    void finish() {}
}