module model.order;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.vehicle_order;

/// Player's orders
struct Order {
    /// Orders for each of the vehicles
    model.VehicleOrder[] vehicles;

    this(model.VehicleOrder[] vehicles) {
        this.vehicles = vehicles;
    }

    /// Read Order from reader
    static Order readFrom(Stream reader) {
        model.VehicleOrder[] vehicles;
        vehicles = new model.VehicleOrder[reader.readInt()];
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            model.VehicleOrder vehiclesKey;
            vehiclesKey = model.VehicleOrder.readFrom(reader);
            vehicles[vehiclesIndex] = vehiclesKey;
        }
        return Order(vehicles);
    }

    /// Write Order to writer
    void writeTo(Stream writer) const {
        writer.write(cast(int)(vehicles.length));
        foreach (vehiclesElement; vehicles) {
            vehiclesElement.writeTo(writer);
        }
    }
}