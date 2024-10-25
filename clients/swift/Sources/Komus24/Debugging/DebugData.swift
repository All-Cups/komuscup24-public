/// Data for debug rendering
enum DebugData {
    /// Circle
    ///
    /// - pos: Center
    /// - radius: Radius
    /// - color: Color
    case circle(pos: Vec2Double, radius: Double, color: Color)

    /// Line (segment)
    ///
    /// - point1: First end
    /// - point2: Other end
    /// - width: Thickness
    /// - color: Color
    case line(point1: Vec2Double, point2: Vec2Double, width: Double, color: Color)

    /// Rectangle
    ///
    /// - corner1: One of the corners
    /// - corner2: Opposite corner
    /// - color: Color
    case rect(corner1: Vec2Double, corner2: Vec2Double, color: Color)

    /// Text
    ///
    /// - text: Text to draw
    /// - pos: Position
    /// - size: Font size
    /// - align: Alignment (0 - left, 0.5 - center, 1 - right)
    /// - color: Color
    case text(text: String, pos: Vec2Double, size: Double, align: Double, color: Color)

    /// Read DebugData from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> DebugData {
        switch stream.readInt32() {
            case 0:
                var pos: Vec2Double
                pos = Vec2Double.readFrom(stream)
                var radius: Double
                radius = stream.readDouble()
                var color: Color
                color = Color.readFrom(stream)
                return DebugData.circle(pos: pos, radius: radius, color: color)
            case 1:
                var point1: Vec2Double
                point1 = Vec2Double.readFrom(stream)
                var point2: Vec2Double
                point2 = Vec2Double.readFrom(stream)
                var width: Double
                width = stream.readDouble()
                var color: Color
                color = Color.readFrom(stream)
                return DebugData.line(point1: point1, point2: point2, width: width, color: color)
            case 2:
                var corner1: Vec2Double
                corner1 = Vec2Double.readFrom(stream)
                var corner2: Vec2Double
                corner2 = Vec2Double.readFrom(stream)
                var color: Color
                color = Color.readFrom(stream)
                return DebugData.rect(corner1: corner1, corner2: corner2, color: color)
            case 3:
                var text: String
                text = stream.readString()
                var pos: Vec2Double
                pos = Vec2Double.readFrom(stream)
                var size: Double
                size = stream.readDouble()
                var align: Double
                align = stream.readDouble()
                var color: Color
                color = Color.readFrom(stream)
                return DebugData.text(text: text, pos: pos, size: size, align: align, color: color)
            default:
                fatalError("Unexpected tag value")
        }
    }

    /// Write DebugData to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        switch self {
            case let .circle(pos, radius, color):
                stream.writeInt32(0)
                pos.writeTo(stream)
                stream.writeDouble(radius)
                color.writeTo(stream)
            case let .line(point1, point2, width, color):
                stream.writeInt32(1)
                point1.writeTo(stream)
                point2.writeTo(stream)
                stream.writeDouble(width)
                color.writeTo(stream)
            case let .rect(corner1, corner2, color):
                stream.writeInt32(2)
                corner1.writeTo(stream)
                corner2.writeTo(stream)
                color.writeTo(stream)
            case let .text(text, pos, size, align, color):
                stream.writeInt32(3)
                stream.writeString(text)
                pos.writeTo(stream)
                stream.writeDouble(size)
                stream.writeDouble(align)
                color.writeTo(stream)
        }
    }
}