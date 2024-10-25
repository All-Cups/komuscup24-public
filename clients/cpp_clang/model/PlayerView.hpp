#ifndef __MODEL_PLAYER_VIEW_HPP__
#define __MODEL_PLAYER_VIEW_HPP__

#include "Stream.hpp"
#include "model/Player.hpp"
#include "model/Quest.hpp"
#include "model/Vec2Double.hpp"
#include "model/Vec2Int.hpp"
#include "model/Vehicle.hpp"
#include <optional>
#include <sstream>
#include <stdexcept>
#include <string>
#include <vector>

namespace model {

// Current game's state
class PlayerView {
public:
    // Current tick number
    int currentTick;
    // Your player
    model::Player you;
    // Other players
    std::vector<model::Player> other;
    // Available quests
    std::vector<model::Quest> quests;

    PlayerView(int currentTick, model::Player you, std::vector<model::Player> other, std::vector<model::Quest> quests);

    // Read PlayerView from input stream
    static PlayerView readFrom(InputStream& stream);

    // Write PlayerView to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of PlayerView
    std::string toString() const;
};

}

#endif