/// Order for controlling a single vehicle
public struct VehicleOrder {
    /// Acceleration (-1 - fully backwards, +1 - fully forward)
    let accelerate: Double

    /// Hand brakes
    let brakes: Bool

    /// Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
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