/// TODO - Document
public enum CityCell: Int32 {
    /// TODO - Document
    case road = 0

    /// TODO - Document
    case building = 1

    /// TODO - Document
    case refillStation = 2

    /// Read CityCell from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> CityCell {
        return CityCell(rawValue: stream.readInt32())!
    }

    /// Write CityCell to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(rawValue)
    }
}