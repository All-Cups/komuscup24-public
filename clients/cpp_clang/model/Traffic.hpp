#ifndef __MODEL_TRAFFIC_HPP__
#define __MODEL_TRAFFIC_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// TODO - Document
class Traffic {
public:
    // TODO - Document
    int amount;
    // TODO - Document
    double moveTime;
    // TODO - Document
    double radius;
    // TODO - Document
    double weight;
    // TODO - Document
    double crashDeceleration;
    // TODO - Document
    double crashLifetime;

    Traffic(int amount, double moveTime, double radius, double weight, double crashDeceleration, double crashLifetime);

    // Read Traffic from input stream
    static Traffic readFrom(InputStream& stream);

    // Write Traffic to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Traffic
    std::string toString() const;
};

}

#endif