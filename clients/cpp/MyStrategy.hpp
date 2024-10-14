#ifndef _MY_STRATEGY_HPP_
#define _MY_STRATEGY_HPP_

#include "DebugInterface.hpp"
#include "model/PlayerView.hpp"
#include "model/Order.hpp"
#include "model/Constants.hpp"

class MyStrategy {
public:
    MyStrategy(const model::Constants& constants);
    model::Order getOrder(const model::PlayerView& playerView, DebugInterface* debugInterface);
    void debugUpdate(int displayedTick, DebugInterface& debugInterface);
    void finish();
};

#endif