#ifndef __MODEL_CITY_TYPE_HPP__
#define __MODEL_CITY_TYPE_HPP__

#include "Stream.hpp"
#include "model/Vec2Int.hpp"
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>
#include <variant>
#include <vector>

namespace model {


// TODO - Document
class Manhattan {
public:
    // TODO - Document
    model::Vec2Int size;
    // TODO - Document
    model::Vec2Int blockSize;
    // TODO - Document
    int refills;

    Manhattan(model::Vec2Int size, model::Vec2Int blockSize, int refills);

    // Read Manhattan from input stream
    static Manhattan readFrom(InputStream& stream);

    // Write Manhattan to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Manhattan
    std::string toString() const;

    bool operator ==(const Manhattan& other) const;
};

// TODO - Document
class Inline {
public:
    // TODO - Document
    std::vector<std::string> cells;

    Inline(std::vector<std::string> cells);

    // Read Inline from input stream
    static Inline readFrom(InputStream& stream);

    // Write Inline to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Inline
    std::string toString() const;
};

// TODO - Document
typedef std::variant<Manhattan, Inline> CityType;

// Read CityType from input stream
CityType readCityType(InputStream& stream);

// Write CityType to output stream
void writeCityType(const CityType& value, OutputStream& stream);

// Get string representation of CityType
std::string cityTypeToString(const CityType& value);

}

#endif