#ifndef __MODEL_CITY_CELL_HPP__
#define __MODEL_CITY_CELL_HPP__

#include "Stream.hpp"

namespace model {

// City cell
enum class CityCell {
    // Road
    ROAD = 0,
    // Building
    BUILDING = 1,
    // Refill station
    REFILL_STATION = 2
};

// Read CityCell from input stream
CityCell readCityCell(InputStream& stream);

// Get string representation of CityCell
std::string cityCellToString(CityCell value);

}

#endif