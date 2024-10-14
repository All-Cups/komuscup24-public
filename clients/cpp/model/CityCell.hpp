#ifndef __MODEL_CITY_CELL_HPP__
#define __MODEL_CITY_CELL_HPP__

#include "Stream.hpp"

namespace model {

// TODO - Document
enum class CityCell {
    // TODO - Document
    ROAD = 0,
    // TODO - Document
    BUILDING = 1,
    // TODO - Document
    REFILL_STATION = 2
};

// Read CityCell from input stream
CityCell readCityCell(InputStream& stream);

// Get string representation of CityCell
std::string cityCellToString(CityCell value);

}

#endif