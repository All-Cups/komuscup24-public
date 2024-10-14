namespace Komus24
{
    public class MyStrategy
    {
        public MyStrategy(Komus24.Model.Constants constants) {}
        public Komus24.Model.Order GetOrder(Komus24.Model.PlayerView playerView, DebugInterface debugInterface)
        {
            return new Komus24.Model.Order(new Komus24.Model.VehicleOrder[0]);
        }
        public void DebugUpdate(int displayedTick, DebugInterface debugInterface) {}
        public void Finish() {}
    }
}