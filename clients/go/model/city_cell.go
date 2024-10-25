package model

import "io"
import . "komus24/stream"

// City cell
type CityCell int32

const (
    // Road
    CityCellRoad CityCell = 0
    // Building
    CityCellBuilding CityCell = 1
    // Refill station
    CityCellRefillStation CityCell = 2
)

// Read CityCell from reader
func ReadCityCell(reader io.Reader) CityCell {
    switch ReadInt32(reader) {
    case 0:
        return CityCellRoad
    case 1:
        return CityCellBuilding
    case 2:
        return CityCellRefillStation
    }
    panic("Unexpected tag value")
}

// Get string representation of CityCell
func CityCellToString(cityCell CityCell) string {
    switch cityCell {
    case CityCellRoad:
        return "Road"
    case CityCellBuilding:
        return "Building"
    case CityCellRefillStation:
        return "RefillStation"
    }
    panic("Impossible happened")
}