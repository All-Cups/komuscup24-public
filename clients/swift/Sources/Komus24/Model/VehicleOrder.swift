/// TODO - Document
public struct VehicleOrder {
    /// -1..+1
    let accelerate: Double

    /// TODO - Document
    let brakes: Bool

    /// -1..+1
    let rotate: Double

    /// Read VehicleOrder from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> VehicleOrder {
        var accelerate: Double
        accelerate = stream.readDouble()
        var brakes: Bool
        brakes = stream.readBool()
        var rotate: Double
        rotate = stream.readDouble()
        return VehicleOrder(accelerate: accelerate, brakes: brakes, rotate: rotate)
    }

    /// Write VehicleOrder to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeDouble(accelerate)
        stream.writeBool(brakes)
        stream.writeDouble(rotate)
    }
}