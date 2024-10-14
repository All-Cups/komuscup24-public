/// TODO - Document
public struct MinMaxRangeLong {
    /// TODO - Document
    let min: Int64

    /// TODO - Document
    let max: Int64

    /// Read MinMaxRangeLong from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> MinMaxRangeLong {
        var min: Int64
        min = stream.readInt64()
        var max: Int64
        max = stream.readInt64()
        return MinMaxRangeLong(min: min, max: max)
    }

    /// Write MinMaxRangeLong to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt64(min)
        stream.writeInt64(max)
    }
}