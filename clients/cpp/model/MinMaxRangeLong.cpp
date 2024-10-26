#include "MinMaxRangeLong.hpp"

namespace model {

MinMaxRangeLong::MinMaxRangeLong(long long min, long long max) : min(min), max(max) { }

// Read MinMaxRangeLong from input stream
MinMaxRangeLong MinMaxRangeLong::readFrom(InputStream& stream) {
    long long min = stream.readLongLong();
    long long max = stream.readLongLong();
    return MinMaxRangeLong(min, max);
}

// Write MinMaxRangeLong to output stream
void MinMaxRangeLong::writeTo(OutputStream& stream) const {
    stream.write(min);
    stream.write(max);
}

// Get string representation of MinMaxRangeLong
std::string MinMaxRangeLong::toString() const {
    std::stringstream ss;
    ss << "MinMaxRangeLong { ";
    ss << "min: ";
    ss << min;
    ss << ", ";
    ss << "max: ";
    ss << max;
    ss << " }";
    return ss.str();
}

bool MinMaxRangeLong::operator ==(const MinMaxRangeLong& other) const {
    return min == other.min && max == other.max;
}

}

size_t std::hash<model::MinMaxRangeLong>::operator ()(const model::MinMaxRangeLong& value) const {
    size_t result = 0;
    result ^= std::hash<long long>{}(value.min) + 0x9e3779b9 + (result << 6) + (result >> 2);
    result ^= std::hash<long long>{}(value.max) + 0x9e3779b9 + (result << 6) + (result >> 2);
    return result;
}