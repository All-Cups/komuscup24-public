#include "DebugState.hpp"

namespace model {

DebugState::DebugState(std::vector<std::string> pressedKeys) : pressedKeys(pressedKeys) { }

// Read DebugState from input stream
DebugState DebugState::readFrom(InputStream& stream) {
    std::vector<std::string> pressedKeys = std::vector<std::string>();
    size_t pressedKeysSize = stream.readInt();
    pressedKeys.reserve(pressedKeysSize);
    for (size_t pressedKeysIndex = 0; pressedKeysIndex < pressedKeysSize; pressedKeysIndex++) {
        std::string pressedKeysElement = stream.readString();
        pressedKeys.emplace_back(pressedKeysElement);
    }
    return DebugState(pressedKeys);
}

// Write DebugState to output stream
void DebugState::writeTo(OutputStream& stream) const {
    stream.write((int)(pressedKeys.size()));
    for (const std::string& pressedKeysElement : pressedKeys) {
        stream.write(pressedKeysElement);
    }
}

// Get string representation of DebugState
std::string DebugState::toString() const {
    std::stringstream ss;
    ss << "DebugState { ";
    ss << "pressedKeys: ";
    ss << "[ ";
    for (size_t pressedKeysIndex = 0; pressedKeysIndex < pressedKeys.size(); pressedKeysIndex++) {
        const std::string& pressedKeysElement = pressedKeys[pressedKeysIndex];
        if (pressedKeysIndex != 0) {
            ss << ", ";
        }
        ss << '"' << pressedKeysElement << '"';
    }
    ss << " ]";
    ss << " }";
    return ss.str();
}

}