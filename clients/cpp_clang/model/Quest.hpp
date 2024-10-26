#ifndef __MODEL_QUEST_HPP__
#define __MODEL_QUEST_HPP__

#include "Stream.hpp"
#include "model/Vec2Int.hpp"
#include <sstream>
#include <stdexcept>
#include <string>

namespace model {

// A delivery quest
class Quest {
public:
    // Cell where to pick delivery from
    model::Vec2Int pickupCell;
    // Cell to drop the delivery at
    model::Vec2Int dropCell;
    // Score for completing the quest
    long long score;

    Quest(model::Vec2Int pickupCell, model::Vec2Int dropCell, long long score);

    // Read Quest from input stream
    static Quest readFrom(InputStream& stream);

    // Write Quest to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Quest
    std::string toString() const;

    bool operator ==(const Quest& other) const;
};

}

namespace std {
    template<>
    struct hash<model::Quest> {
        size_t operator ()(const model::Quest& value) const;
    };
}

#endif