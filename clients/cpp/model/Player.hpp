#ifndef __MODEL_PLAYER_HPP__
#define __MODEL_PLAYER_HPP__

#include "Stream.hpp"
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

// Player (game participant)
class Player {
public:
    // Index
    int index;
    // Current score
    long long score;
    // List of player's vehicles
    std::vector<model::Vehicle> vehicles;

    Player(int index, long long score, std::vector<model::Vehicle> vehicles);

    // Read Player from input stream
    static Player readFrom(InputStream& stream);

    // Write Player to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Player
    std::string toString() const;
};

}

#endif