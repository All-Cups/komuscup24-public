/// City type
enum CityType {
    /// Auto generated manhattan map
    ///
    /// - size: Map size
    /// - blockSize: Size of a single block
    /// - refills: Number of refill stations
    case manhattan(size: Vec2Int, blockSize: Vec2Int, refills: Int32)

    /// Fixed map
    ///
    /// - cells: Each string represents a row in the city
    case inline(cells: [String])

    /// Read CityType from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> CityType {
        switch stream.readInt32() {
            case 0:
                var size: Vec2Int
                size = Vec2Int.readFrom(stream)
                var blockSize: Vec2Int
                blockSize = Vec2Int.readFrom(stream)
                var refills: Int32
                refills = stream.readInt32()
                return CityType.manhattan(size: size, blockSize: blockSize, refills: refills)
            case 1:
                var cells: [String]
                let cellsSize = stream.readInt32()
                cells = (0..<cellsSize).map{ _ in
                    var cellsSize: String
                    cellsSize = stream.readString()
                    return cellsSize
                }
                return CityType.inline(cells: cells)
            default:
                fatalError("Unexpected tag value")
        }
    }

    /// Write CityType to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        switch self {
            case let .manhattan(size, blockSize, refills):
                stream.writeInt32(0)
                size.writeTo(stream)
                blockSize.writeTo(stream)
                stream.writeInt32(refills)
            case let .inline(cells):
                stream.writeInt32(1)
                stream.writeInt32(Int32(cells.count))
                for cellsElement in cells {
                    stream.writeString(cellsElement)
                }
        }
    }
}