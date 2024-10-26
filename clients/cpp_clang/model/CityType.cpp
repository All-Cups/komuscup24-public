#include "CityType.hpp"
#include <stdexcept>

namespace model {

Manhattan::Manhattan(model::Vec2Int size, model::Vec2Int blockSize, int refills) : size(size), blockSize(blockSize), refills(refills) { }

// Read Manhattan from input stream
Manhattan Manhattan::readFrom(InputStream& stream) {
    model::Vec2Int size = model::Vec2Int::readFrom(stream);
    model::Vec2Int blockSize = model::Vec2Int::readFrom(stream);
    int refills = stream.readInt();
    return Manhattan(size, blockSize, refills);
}

// Write Manhattan to output stream
void Manhattan::writeTo(OutputStream& stream) const {
    size.writeTo(stream);
    blockSize.writeTo(stream);
    stream.write(refills);
}

// Get string representation of Manhattan
std::string Manhattan::toString() const {
    std::stringstream ss;
    ss << "Manhattan { ";
    ss << "size: ";
    ss << size.toString();
    ss << ", ";
    ss << "blockSize: ";
    ss << blockSize.toString();
    ss << ", ";
    ss << "refills: ";
    ss << refills;
    ss << " }";
    return ss.str();
}

bool Manhattan::operator ==(const Manhattan& other) const {
    return size == other.size && blockSize == other.blockSize && refills == other.refills;
}

Inline::Inline(std::vector<std::string> cells) : cells(cells) { }

// Read Inline from input stream
Inline Inline::readFrom(InputStream& stream) {
    std::vector<std::string> cells = std::vector<std::string>();
    size_t cellsSize = stream.readInt();
    cells.reserve(cellsSize);
    for (size_t cellsIndex = 0; cellsIndex < cellsSize; cellsIndex++) {
        std::string cellsElement = stream.readString();
        cells.emplace_back(cellsElement);
    }
    return Inline(cells);
}

// Write Inline to output stream
void Inline::writeTo(OutputStream& stream) const {
    stream.write((int)(cells.size()));
    for (const std::string& cellsElement : cells) {
        stream.write(cellsElement);
    }
}

// Get string representation of Inline
std::string Inline::toString() const {
    std::stringstream ss;
    ss << "Inline { ";
    ss << "cells: ";
    ss << "[ ";
    for (size_t cellsIndex = 0; cellsIndex < cells.size(); cellsIndex++) {
        const std::string& cellsElement = cells[cellsIndex];
        if (cellsIndex != 0) {
            ss << ", ";
        }
        ss << '"' << cellsElement << '"';
    }
    ss << " ]";
    ss << " }";
    return ss.str();
}

    
// Read CityType from input stream
CityType readCityType(InputStream& stream) {
    switch (stream.readInt()) {
    case 0:
        return Manhattan::readFrom(stream);
    case 1:
        return Inline::readFrom(stream);
    default:
        throw std::runtime_error("Unexpected tag value");
    }
}

// Write CityType to output stream
void writeCityType(const CityType& value, OutputStream& stream) {
    std::visit([&](auto& arg) {
        using T = std::decay_t<decltype(arg)>;
        if constexpr (std::is_same_v<T, Manhattan>) {
            stream.write((int) 0);
        }
        if constexpr (std::is_same_v<T, Inline>) {
            stream.write((int) 1);
        }
        arg.writeTo(stream);
    }, value);
}

// Get string representation of CityType
std::string cityTypeToString(const CityType& value) {
    return std::visit([](auto& arg) {
        return arg.toString();
    }, value);
}


}