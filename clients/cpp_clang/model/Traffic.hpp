#ifndef __MODEL_TRAFFIC_HPP__
#define __MODEL_TRAFFIC_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// Options for traffic
class Traffic {
public:
    // Number of traffic cars
    int amount;
    // Time to move between adjacent keypoints
    double moveTime;
    // Radius of each traffic car
    double radius;
    // Weight of each traffic car
    double weight;
    // Deceleration after crash
    double crashDeceleration;
    // Lifetime after crash
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