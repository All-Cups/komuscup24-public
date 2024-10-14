/// TODO - Document
public struct VehicleType {
    /// TODO - Document
    let name: String

    /// TODO - Document
    let radius: Double

    /// TODO - Document
    let weight: Double

    /// TODO - Document
    let maxBackwardsSpeed: Double

    /// TODO - Document
    let maxSpeed: Double

    /// TODO - Document
    let acceleration: Double

    /// TODO - Document
    let friction: Double

    /// TODO - Document
    let maxRotateSpeed: Double

    /// TODO - Document
    let rotateAcceleration: Double

    /// TODO - Document
    let maxFuel: Double

    /// TODO - Document
    let fuelUseSpeed: Double

    /// Read VehicleType from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> VehicleType {
        var name: String
        name = stream.readString()
        var radius: Double
        radius = stream.readDouble()
        var weight: Double
        weight = stream.readDouble()
        var maxBackwardsSpeed: Double
        maxBackwardsSpeed = stream.readDouble()
        var maxSpeed: Double
        maxSpeed = stream.readDouble()
        var acceleration: Double
        acceleration = stream.readDouble()
        var friction: Double
        friction = stream.readDouble()
        var maxRotateSpeed: Double
        maxRotateSpeed = stream.readDouble()
        var rotateAcceleration: Double
        rotateAcceleration = stream.readDouble()
        var maxFuel: Double
        maxFuel = stream.readDouble()
        var fuelUseSpeed: Double
        fuelUseSpeed = stream.readDouble()
        return VehicleType(name: name, radius: radius, weight: weight, maxBackwardsSpeed: maxBackwardsSpeed, maxSpeed: maxSpeed, acceleration: acceleration, friction: friction, maxRotateSpeed: maxRotateSpeed, rotateAcceleration: rotateAcceleration, maxFuel: maxFuel, fuelUseSpeed: fuelUseSpeed)
    }

    /// Write VehicleType to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeString(name)
        stream.writeDouble(radius)
        stream.writeDouble(weight)
        stream.writeDouble(maxBackwardsSpeed)
        stream.writeDouble(maxSpeed)
        stream.writeDouble(acceleration)
        stream.writeDouble(friction)
        stream.writeDouble(maxRotateSpeed)
        stream.writeDouble(rotateAcceleration)
        stream.writeDouble(maxFuel)
        stream.writeDouble(fuelUseSpeed)
    }
}