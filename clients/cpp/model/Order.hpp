#ifndef __MODEL_ORDER_HPP__
#define __MODEL_ORDER_HPP__

#include "Stream.hpp"
#include "model/VehicleOrder.hpp"
#include <sstream>
#include <stdexcept>
#include <string>
#include <vector>

namespace model {

// Player's orders
class Order {
public:
    // TODO - Document
    std::vector<model::VehicleOrder> vehicles;

    Order(std::vector<model::VehicleOrder> vehicles);

    // Read Order from input stream
    static Order readFrom(InputStream& stream);

    // Write Order to output stream
    void writeTo(OutputStream& stream) const;

    // Get string representation of Order
    std::string toString() const;
};

}

#endif