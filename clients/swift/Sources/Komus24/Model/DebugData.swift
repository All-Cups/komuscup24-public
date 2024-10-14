/// TODO - Document
enum DebugData {
    /// TODO - Document
    ///
    /// - pos: TODO - Document
    /// - radius: TODO - Document
    case circle(pos: Vec2Double, radius: Double)

    /// Read DebugData from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> DebugData {
        switch stream.readInt32() {
            case 0:
                var pos: Vec2Double
                pos = Vec2Double.readFrom(stream)
                var radius: Double
                radius = stream.readDouble()
                return DebugData.circle(pos: pos, radius: radius)
            default:
                fatalError("Unexpected tag value")
        }
    }

    /// Write DebugData to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        switch self {
            case let .circle(pos, radius):
                stream.writeInt32(0)
                pos.writeTo(stream)
                stream.writeDouble(radius)
        }
    }
}