module MyStrategy (MyStrategy, createMyStrategy, getOrder) where

import Control.Monad.Trans.State.Lazy (State)
import Model.Constants
import Model.PlayerView
import Model.Order
import Model.VehicleOrder

data MyStrategy = MyStrategy

createMyStrategy :: Constants -> MyStrategy
createMyStrategy _ = MyStrategy

getOrder :: PlayerView -> State MyStrategy Order
getOrder _ = return Order { vehicles = [] }