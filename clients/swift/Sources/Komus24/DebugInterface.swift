class DebugInterface {
    private let inputStream: BufferedInputStream
    private let outputStream: BufferedOutputStream

    init(_ inputStream: BufferedInputStream, _ outputStream: BufferedOutputStream) {
        self.inputStream = inputStream
        self.outputStream = outputStream
    }

    func send(_ command: DebugCommand) {
        ClientMessage.debugMessage(command: command).writeTo(outputStream)
        outputStream.flush()
    }

    func getState() -> DebugState {
        ClientMessage.requestDebugState.writeTo(outputStream)
        outputStream.flush()
        return DebugState.readFrom(inputStream)
    }

    func addCircle(_ pos: Vec2Double, _ radius: Double) {
        self.add(DebugData.circle(pos: pos, radius: radius))
    }

    func add(_ debugData: DebugData) {
        self.send(DebugCommand.add(debugData: debugData))
    }
    func clear() {
        self.send(DebugCommand.clear)
    }
    func setAutoFlush(_ enable: Bool) {
        self.send(DebugCommand.setAutoFlush(enable: enable))
    }
    func flush() {
        self.send(DebugCommand.flush)
    }
}