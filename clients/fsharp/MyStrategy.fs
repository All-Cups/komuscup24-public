namespace Komus24

type MyStrategy(constants: Model.Constants) =
    member this.getOrder(playerView: Model.PlayerView, debugInterface: option<DebugInterface>): Model.Order =
        {
            Vehicles = Array.empty
        }

    member this.debugUpdate(displayedTick: int, debugInterface: DebugInterface) = ()

    member this.finish() = ()