#include "Quest.hpp"

namespace model {

Quest::Quest(model::Vec2Int pickupCell, model::Vec2Int dropCell, long long score) : pickupCell(pickupCell), dropCell(dropCell), score(score) { }

// Read Quest from input stream
Quest Quest::readFrom(InputStream& stream) {
    model::Vec2Int pickupCell = model::Vec2Int::readFrom(stream);
    model::Vec2Int dropCell = model::Vec2Int::readFrom(stream);
    long long score = stream.readLongLong();
    return Quest(pickupCell, dropCell, score);
}

// Write Quest to output stream
void Quest::writeTo(OutputStream& stream) const {
    pickupCell.writeTo(stream);
    dropCell.writeTo(stream);
    stream.write(score);
}

// Get string representation of Quest
std::string Quest::toString() const {
    std::stringstream ss;
    ss << "Quest { ";
    ss << "pickupCell: ";
    ss << pickupCell.toString();
    ss << ", ";
    ss << "dropCell: ";
    ss << dropCell.toString();
    ss << ", ";
    ss << "score: ";
    ss << score;
    ss << " }";
    return ss.str();
}

bool Quest::operator ==(const Quest& other) const {
    return pickupCell == other.pickupCell && dropCell == other.dropCell && score == other.score;
}

}

size_t std::hash<model::Quest>::operator ()(const model::Quest& value) const {
    size_t result = 0;
    result ^= std::hash<model::Vec2Int>{}(value.pickupCell) + 0x9e3779b9 + (result << 6) + (result >> 2);
    result ^= std::hash<model::Vec2Int>{}(value.dropCell) + 0x9e3779b9 + (result << 6) + (result >> 2);
    result ^= std::hash<long long>{}(value.score) + 0x9e3779b9 + (result << 6) + (result >> 2);
    return result;
}