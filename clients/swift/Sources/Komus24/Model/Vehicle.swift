/// A vehicle
public struct Vehicle {
    /// Current position (center)
    let position: Vec2Double

    /// Velocity vector
    let velocity: Vec2Double

    /// Speed of wheels
    let speed: Double

    /// Rotation speed (radians/second)
    let rotationSpeed: Double

    /// Current rotation
    let rotation: Double

    /// Vehicle type index
    let typeIndex: Int32

    /// Current quest, if any
    let quest: Quest?

    /// Remaining fuel
    let fuel: Double

    /// Read Vehicle from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> Vehicle {
        var position: Vec2Double
        position = Vec2Double.readFrom(stream)
        var velocity: Vec2Double
        velocity = Vec2Double.readFrom(stream)
        var speed: Double
        speed = stream.readDouble()
        var rotationSpeed: Double
        rotationSpeed = stream.readDouble()
        var rotation: Double
        rotation = stream.readDouble()
        var typeIndex: Int32
        typeIndex = stream.readInt32()
        var quest: Quest?
        if stream.readBool() {
            quest = Quest.readFrom(stream)
        } else {
            quest = nil
        }
        var fuel: Double
        fuel = stream.readDouble()
        return Vehicle(position: position, velocity: velocity, speed: speed, rotationSpeed: rotationSpeed, rotation: rotation, typeIndex: typeIndex, quest: quest, fuel: fuel)
    }

    /// Write Vehicle to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        position.writeTo(stream)
        velocity.writeTo(stream)
        stream.writeDouble(speed)
        stream.writeDouble(rotationSpeed)
        stream.writeDouble(rotation)
        stream.writeInt32(typeIndex)
        if quest == nil {
            stream.writeBool(false)
        } else {
            stream.writeBool(true)
            let questValue = quest!
            questValue.writeTo(stream)
        }
        stream.writeDouble(fuel)
    }
}