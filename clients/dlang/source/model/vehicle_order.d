module model.vehicle_order;

import stream;
import std.conv;
import std.typecons : Nullable;


/// TODO - Document
struct VehicleOrder {
    /// -1..+1
    double accelerate;
    /// TODO - Document
    bool brakes;
    /// -1..+1
    double rotate;

    this(double accelerate, bool brakes, double rotate) {
        this.accelerate = accelerate;
        this.brakes = brakes;
        this.rotate = rotate;
    }

    /// Read VehicleOrder from reader
    static VehicleOrder readFrom(Stream reader) {
        double accelerate;
        accelerate = reader.readDouble();
        bool brakes;
        brakes = reader.readBool();
        double rotate;
        rotate = reader.readDouble();
        return VehicleOrder(accelerate, brakes, rotate);
    }

    /// Write VehicleOrder to writer
    void writeTo(Stream writer) const {
        writer.write(accelerate);
        writer.write(brakes);
        writer.write(rotate);
    }
}