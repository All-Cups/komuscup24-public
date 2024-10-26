#include "Player.hpp"

namespace model {

Player::Player(int index, long long score, std::vector<model::Vehicle> vehicles) : index(index), score(score), vehicles(vehicles) { }

// Read Player from input stream
Player Player::readFrom(InputStream& stream) {
    int index = stream.readInt();
    long long score = stream.readLongLong();
    std::vector<model::Vehicle> vehicles = std::vector<model::Vehicle>();
    size_t vehiclesSize = stream.readInt();
    vehicles.reserve(vehiclesSize);
    for (size_t vehiclesIndex = 0; vehiclesIndex < vehiclesSize; vehiclesIndex++) {
        model::Vehicle vehiclesElement = model::Vehicle::readFrom(stream);
        vehicles.emplace_back(vehiclesElement);
    }
    return Player(index, score, vehicles);
}

// Write Player to output stream
void Player::writeTo(OutputStream& stream) const {
    stream.write(index);
    stream.write(score);
    stream.write((int)(vehicles.size()));
    for (const model::Vehicle& vehiclesElement : vehicles) {
        vehiclesElement.writeTo(stream);
    }
}

// Get string representation of Player
std::string Player::toString() const {
    std::stringstream ss;
    ss << "Player { ";
    ss << "index: ";
    ss << index;
    ss << ", ";
    ss << "score: ";
    ss << score;
    ss << ", ";
    ss << "vehicles: ";
    ss << "[ ";
    for (size_t vehiclesIndex = 0; vehiclesIndex < vehicles.size(); vehiclesIndex++) {
        const model::Vehicle& vehiclesElement = vehicles[vehiclesIndex];
        if (vehiclesIndex != 0) {
            ss << ", ";
        }
        ss << vehiclesElement.toString();
    }
    ss << " ]";
    ss << " }";
    return ss.str();
}

}