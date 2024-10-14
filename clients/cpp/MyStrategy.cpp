#include "MyStrategy.hpp"
#include <exception>

MyStrategy::MyStrategy(const model::Constants& constants) {}

model::Order MyStrategy::getOrder(const model::PlayerView& playerView, DebugInterface* debugInterface)
{
    return model::Order(std::vector<model::VehicleOrder>());
}

void MyStrategy::debugUpdate(int displayedTick, DebugInterface& debugInterface) {}

void MyStrategy::finish() {}