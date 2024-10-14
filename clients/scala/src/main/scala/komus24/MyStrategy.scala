class MyStrategy(constants: komus24.model.Constants) {
  def getOrder(playerView: komus24.model.PlayerView, debugInterface: Option[DebugInterface]): komus24.model.Order =
    komus24.model.Order(Seq.empty)
  def debugUpdate(displayedTick: Int, debugInterface: DebugInterface): scala.Unit = ()
  def finish(): scala.Unit = ()
}