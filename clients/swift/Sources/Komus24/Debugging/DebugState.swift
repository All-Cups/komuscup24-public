/// App state for debugging
public struct DebugState {
    /// Currently pressed keys
    let pressedKeys: [String]

    /// Read DebugState from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> DebugState {
        var pressedKeys: [String]
        let pressedKeysSize = stream.readInt32()
        pressedKeys = (0..<pressedKeysSize).map{ _ in
            var pressedKeysSize: String
            pressedKeysSize = stream.readString()
            return pressedKeysSize
        }
        return DebugState(pressedKeys: pressedKeys)
    }

    /// Write DebugState to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(Int32(pressedKeys.count))
        for pressedKeysElement in pressedKeys {
            stream.writeString(pressedKeysElement)
        }
    }
}