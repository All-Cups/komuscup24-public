/// City cell
public enum CityCell: Int32 {
    /// Road
    case road = 0

    /// Building
    case building = 1

    /// Refill station
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