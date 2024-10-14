/// Player's orders
public struct Order {
    /// TODO - Document
    let vehicles: [VehicleOrder]

    /// Read Order from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> Order {
        var vehicles: [VehicleOrder]
        let vehiclesSize = stream.readInt32()
        vehicles = (0..<vehiclesSize).map{ _ in
            var vehiclesSize: VehicleOrder
            vehiclesSize = VehicleOrder.readFrom(stream)
            return vehiclesSize
        }
        return Order(vehicles: vehicles)
    }

    /// Write Order to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(Int32(vehicles.count))
        for vehiclesElement in vehicles {
            vehiclesElement.writeTo(stream)
        }
    }
}