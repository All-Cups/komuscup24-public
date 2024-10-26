#include "PlayerView.hpp"

namespace model {

PlayerView::PlayerView(int currentTick, model::Player you, std::vector<model::Player> other, std::vector<model::Quest> quests) : currentTick(currentTick), you(you), other(other), quests(quests) { }

// Read PlayerView from input stream
PlayerView PlayerView::readFrom(InputStream& stream) {
    int currentTick = stream.readInt();
    model::Player you = model::Player::readFrom(stream);
    std::vector<model::Player> other = std::vector<model::Player>();
    size_t otherSize = stream.readInt();
    other.reserve(otherSize);
    for (size_t otherIndex = 0; otherIndex < otherSize; otherIndex++) {
        model::Player otherElement = model::Player::readFrom(stream);
        other.emplace_back(otherElement);
    }
    std::vector<model::Quest> quests = std::vector<model::Quest>();
    size_t questsSize = stream.readInt();
    quests.reserve(questsSize);
    for (size_t questsIndex = 0; questsIndex < questsSize; questsIndex++) {
        model::Quest questsElement = model::Quest::readFrom(stream);
        quests.emplace_back(questsElement);
    }
    return PlayerView(currentTick, you, other, quests);
}

// Write PlayerView to output stream
void PlayerView::writeTo(OutputStream& stream) const {
    stream.write(currentTick);
    you.writeTo(stream);
    stream.write((int)(other.size()));
    for (const model::Player& otherElement : other) {
        otherElement.writeTo(stream);
    }
    stream.write((int)(quests.size()));
    for (const model::Quest& questsElement : quests) {
        questsElement.writeTo(stream);
    }
}

// Get string representation of PlayerView
std::string PlayerView::toString() const {
    std::stringstream ss;
    ss << "PlayerView { ";
    ss << "currentTick: ";
    ss << currentTick;
    ss << ", ";
    ss << "you: ";
    ss << you.toString();
    ss << ", ";
    ss << "other: ";
    ss << "[ ";
    for (size_t otherIndex = 0; otherIndex < other.size(); otherIndex++) {
        const model::Player& otherElement = other[otherIndex];
        if (otherIndex != 0) {
            ss << ", ";
        }
        ss << otherElement.toString();
    }
    ss << " ]";
    ss << ", ";
    ss << "quests: ";
    ss << "[ ";
    for (size_t questsIndex = 0; questsIndex < quests.size(); questsIndex++) {
        const model::Quest& questsElement = quests[questsIndex];
        if (questsIndex != 0) {
            ss << ", ";
        }
        ss << questsElement.toString();
    }
    ss << " ]";
    ss << " }";
    return ss.str();
}

}