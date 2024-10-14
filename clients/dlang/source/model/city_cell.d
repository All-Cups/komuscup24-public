module model.city_cell;

import stream;

/// TODO - Document
enum CityCell : int {
    /// TODO - Document
    Road = 0,
    /// TODO - Document
    Building = 1,
    /// TODO - Document
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