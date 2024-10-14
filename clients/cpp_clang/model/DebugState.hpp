#ifndef __MODEL_DEBUG_STATE_HPP__
#define __MODEL_DEBUG_STATE_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>
#include <vector>

namespace model {

// TODO - Document
class DebugState {
public:
    // TODO - Document
    std::vector<std::string> pressedKeys;

    DebugState(std::vector<std::string> pressedKeys);

    // Read DebugState from input stream
    static DebugState readFrom(InputStream& stream);

    // Write DebugState to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of DebugState
    std::string toString() const;
};

}

#endif