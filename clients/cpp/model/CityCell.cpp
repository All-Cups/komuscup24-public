#include "CityCell.hpp"
#include <stdexcept>

namespace model {

// Read CityCell from input stream
CityCell readCityCell(InputStream& stream) {
    switch (stream.readInt()) {
    case 0:
        return CityCell::ROAD;
    case 1:
        return CityCell::BUILDING;
    case 2:
        return CityCell::REFILL_STATION;
    default:
        throw std::runtime_error("Unexpected tag value");
    }
}

// Get string representation of CityCell
std::string cityCellToString(CityCell value) {
    switch (value) {
    case CityCell::ROAD:
        return "ROAD";
    case CityCell::BUILDING:
        return "BUILDING";
    case CityCell::REFILL_STATION:
        return "REFILL_STATION";
    default:
        throw std::runtime_error("Impossible happened");
    }
}

}