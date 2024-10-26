module model.city_cell;

import stream;

/// City cell
enum CityCell : int {
    /// Road
    Road = 0,
    /// Building
    Building = 1,
    /// Refill station
    RefillStation = 2,
}

/// Read CityCell from reader
CityCell readCityCell(Stream reader) {
    switch (reader.readInt()) {
        case CityCell.Road:
            return CityCell.Road;
        case CityCell.Building:
            return CityCell.Building;
        case CityCell.RefillStation:
            return CityCell.RefillStation;
        default:
            throw new Exception("Unexpected tag value");
    }
}