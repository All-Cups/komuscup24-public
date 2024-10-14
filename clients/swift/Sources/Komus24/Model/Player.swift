/// TODO - Document
public struct Player {
    /// TODO - Document
    let index: Int32

    /// TODO - Document
    let score: Int64

    /// TODO - Document
    let vehicles: [Vehicle]

    /// Read Player from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> Player {
        var index: Int32
        index = stream.readInt32()
        var score: Int64
        score = stream.readInt64()
        var vehicles: [Vehicle]
        let vehiclesSize = stream.readInt32()
        vehicles = (0..<vehiclesSize).map{ _ in
            var vehiclesSize: Vehicle
            vehiclesSize = Vehicle.readFrom(stream)
            return vehiclesSize
        }
        return Player(index: index, score: score, vehicles: vehicles)
    }

    /// Write Player to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(index)
        stream.writeInt64(score)
        stream.writeInt32(Int32(vehicles.count))
        for vehiclesElement in vehicles {
            vehiclesElement.writeTo(stream)
        }
    }
}