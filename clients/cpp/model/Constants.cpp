#include "Constants.hpp"

namespace model {

Constants::Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, model::CityType cityType, std::vector<model::VehicleType> vehicleTypes, double refillSpeed, int questCount, model::MinMaxRangeLong questScore, model::Traffic traffic, std::vector<std::vector<model::CityCell>> city) : maxTickCount(maxTickCount), maxGameTimeSeconds(maxGameTimeSeconds), ticksPerSecond(ticksPerSecond), microticks(microticks), cellSize(cellSize), collisionBounciness(collisionBounciness), cityType(cityType), vehicleTypes(vehicleTypes), refillSpeed(refillSpeed), questCount(questCount), questScore(questScore), traffic(traffic), city(city) { }

// Read Constants from input stream
Constants Constants::readFrom(InputStream& stream) {
    int maxTickCount = stream.readInt();
    double maxGameTimeSeconds = stream.readDouble();
    double ticksPerSecond = stream.readDouble();
    int microticks = stream.readInt();
    double cellSize = stream.readDouble();
    double collisionBounciness = stream.readDouble();
    model::CityType cityType = model::readCityType(stream);
    std::vector<model::VehicleType> vehicleTypes = std::vector<model::VehicleType>();
    size_t vehicleTypesSize = stream.readInt();
    vehicleTypes.reserve(vehicleTypesSize);
    for (size_t vehicleTypesIndex = 0; vehicleTypesIndex < vehicleTypesSize; vehicleTypesIndex++) {
        model::VehicleType vehicleTypesElement = model::VehicleType::readFrom(stream);
        vehicleTypes.emplace_back(vehicleTypesElement);
    }
    double refillSpeed = stream.readDouble();
    int questCount = stream.readInt();
    model::MinMaxRangeLong questScore = model::MinMaxRangeLong::readFrom(stream);
    model::Traffic traffic = model::Traffic::readFrom(stream);
    std::vector<std::vector<model::CityCell>> city = std::vector<std::vector<model::CityCell>>();
    size_t citySize = stream.readInt();
    city.reserve(citySize);
    for (size_t cityIndex = 0; cityIndex < citySize; cityIndex++) {
        std::vector<model::CityCell> cityElement = std::vector<model::CityCell>();
        size_t cityElementSize = stream.readInt();
        cityElement.reserve(cityElementSize);
        for (size_t cityElementIndex = 0; cityElementIndex < cityElementSize; cityElementIndex++) {
            model::CityCell cityElementElement = readCityCell(stream);
            cityElement.emplace_back(cityElementElement);
        }
        city.emplace_back(cityElement);
    }
    return Constants(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, city);
}

// Write Constants to output stream
void Constants::writeTo(OutputStream& stream) const {
    stream.write(maxTickCount);
    stream.write(maxGameTimeSeconds);
    stream.write(ticksPerSecond);
    stream.write(microticks);
    stream.write(cellSize);
    stream.write(collisionBounciness);
    writeCityType(cityType, stream);
    stream.write((int)(vehicleTypes.size()));
    for (const model::VehicleType& vehicleTypesElement : vehicleTypes) {
        vehicleTypesElement.writeTo(stream);
    }
    stream.write(refillSpeed);
    stream.write(questCount);
    questScore.writeTo(stream);
    traffic.writeTo(stream);
    stream.write((int)(city.size()));
    for (const std::vector<model::CityCell>& cityElement : city) {
        stream.write((int)(cityElement.size()));
        for (const model::CityCell& cityElementElement : cityElement) {
            stream.write((int)(cityElementElement));
        }
    }
}

// Get string representation of Constants
std::string Constants::toString() const {
    std::stringstream ss;
    ss << "Constants { ";
    ss << "maxTickCount: ";
    ss << maxTickCount;
    ss << ", ";
    ss << "maxGameTimeSeconds: ";
    ss << maxGameTimeSeconds;
    ss << ", ";
    ss << "ticksPerSecond: ";
    ss << ticksPerSecond;
    ss << ", ";
    ss << "microticks: ";
    ss << microticks;
    ss << ", ";
    ss << "cellSize: ";
    ss << cellSize;
    ss << ", ";
    ss << "collisionBounciness: ";
    ss << collisionBounciness;
    ss << ", ";
    ss << "cityType: ";
    ss << cityTypeToString(cityType);
    ss << ", ";
    ss << "vehicleTypes: ";
    ss << "[ ";
    for (size_t vehicleTypesIndex = 0; vehicleTypesIndex < vehicleTypes.size(); vehicleTypesIndex++) {
        const model::VehicleType& vehicleTypesElement = vehicleTypes[vehicleTypesIndex];
        if (vehicleTypesIndex != 0) {
            ss << ", ";
        }
        ss << vehicleTypesElement.toString();
    }
    ss << " ]";
    ss << ", ";
    ss << "refillSpeed: ";
    ss << refillSpeed;
    ss << ", ";
    ss << "questCount: ";
    ss << questCount;
    ss << ", ";
    ss << "questScore: ";
    ss << questScore.toString();
    ss << ", ";
    ss << "traffic: ";
    ss << traffic.toString();
    ss << ", ";
    ss << "city: ";
    ss << "[ ";
    for (size_t cityIndex = 0; cityIndex < city.size(); cityIndex++) {
        const std::vector<model::CityCell>& cityElement = city[cityIndex];
        if (cityIndex != 0) {
            ss << ", ";
        }
        ss << "[ ";
        for (size_t cityElementIndex = 0; cityElementIndex < cityElement.size(); cityElementIndex++) {
            const model::CityCell& cityElementElement = cityElement[cityElementIndex];
            if (cityElementIndex != 0) {
                ss << ", ";
            }
            ss << cityCellToString(cityElementElement);
        }
        ss << " ]";
    }
    ss << " ]";
    ss << " }";
    return ss.str();
}

}