#include "Order.hpp"

namespace model {

Order::Order(std::vector<model::VehicleOrder> vehicles) : vehicles(vehicles) { }

// Read Order from input stream
Order Order::readFrom(InputStream& stream) {
    std::vector<model::VehicleOrder> vehicles = std::vector<model::VehicleOrder>();
    size_t vehiclesSize = stream.readInt();
    vehicles.reserve(vehiclesSize);
    for (size_t vehiclesIndex = 0; vehiclesIndex < vehiclesSize; vehiclesIndex++) {
        model::VehicleOrder vehiclesElement = model::VehicleOrder::readFrom(stream);
        vehicles.emplace_back(vehiclesElement);
    }
    return Order(vehicles);
}

// Write Order to output stream
void Order::writeTo(OutputStream& stream) const {
    stream.write((int)(vehicles.size()));
    for (const model::VehicleOrder& vehiclesElement : vehicles) {
        vehiclesElement.writeTo(stream);
    }
}

// Get string representation of Order
std::string Order::toString() const {
    std::stringstream ss;
    ss << "Order { ";
    ss << "vehicles: ";
    ss << "[ ";
    for (size_t vehiclesIndex = 0; vehiclesIndex < vehicles.size(); vehiclesIndex++) {
        const model::VehicleOrder& vehiclesElement = vehicles[vehiclesIndex];
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