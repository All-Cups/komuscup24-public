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

    func addCircle(_ pos: Vec2Double, _ radius: Double, _ color: Color) {
        self.add(DebugData.circle(pos: pos, radius: radius, color: color))
    }
    func addLine(_ point1: Vec2Double, _ point2: Vec2Double, _ width: Double, _ color: Color) {
        self.add(DebugData.line(point1: point1, point2: point2, width: width, color: color))
    }
    func addRect(_ corner1: Vec2Double, _ corner2: Vec2Double, _ color: Color) {
        self.add(DebugData.rect(corner1: corner1, corner2: corner2, color: color))
    }
    func addText(_ text: String, _ pos: Vec2Double, _ size: Double, _ align: Double, _ color: Color) {
        self.add(DebugData.text(text: text, pos: pos, size: size, align: align, color: color))
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