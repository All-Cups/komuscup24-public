/// TODO - Document
public struct Quest {
    /// TODO - Document
    let pickupCell: Vec2Int

    /// TODO - Document
    let dropCell: Vec2Int

    /// TODO - Document
    let score: Int64

    /// Read Quest from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> Quest {
        var pickupCell: Vec2Int
        pickupCell = Vec2Int.readFrom(stream)
        var dropCell: Vec2Int
        dropCell = Vec2Int.readFrom(stream)
        var score: Int64
        score = stream.readInt64()
        return Quest(pickupCell: pickupCell, dropCell: dropCell, score: score)
    }

    /// Write Quest to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        pickupCell.writeTo(stream)
        dropCell.writeTo(stream)
        stream.writeInt64(score)
    }
}