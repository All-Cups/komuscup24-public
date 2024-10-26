#ifndef __MODEL_MIN_MAX_RANGE_LONG_HPP__
#define __MODEL_MIN_MAX_RANGE_LONG_HPP__

#include "Stream.hpp"
#include <sstream>
#include <string>

namespace model {

// Range of values
class MinMaxRangeLong {
public:
    // Minimal value
    long long min;
    // Maximal  value
    long long max;

    MinMaxRangeLong(long long min, long long max);

    // Read MinMaxRangeLong from input stream
    static MinMaxRangeLong readFrom(InputStream& stream);

    // Write MinMaxRangeLong to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of MinMaxRangeLong
    std::string toString() const;

    bool operator ==(const MinMaxRangeLong& other) const;
};

}

namespace std {
    template<>
    struct hash<model::MinMaxRangeLong> {
        size_t operator ()(const model::MinMaxRangeLong& value) const;
    };
}

#endif