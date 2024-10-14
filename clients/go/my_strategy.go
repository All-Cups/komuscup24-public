package main

import (
    . "komus24/model"
    . "komus24/debugging_interface"
)

type MyStrategy struct{}

func NewMyStrategy(constants Constants) *MyStrategy {
    return &MyStrategy{}
}

func (strategy MyStrategy) getOrder(playerView PlayerView, debugInterface *DebugInterface) Order {
    return Order {
               Vehicles: make([]VehicleOrder, 0),
           }
}

func (strategy MyStrategy) debugUpdate(displayedTick int32, debugInterface DebugInterface) {}

func (strategy MyStrategy) finish() {}