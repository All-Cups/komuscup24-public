const ClientMessage = require('./codegame/client-message');
const DebugState = require('./debugging/debug-state');
const DebugCommand = require('./debugging/debug-command');
const DebugData = require('./debugging/debug-data');

class DebugInterface {
    constructor(stream) {
        this.stream = stream;
    }

    async addCircle(pos, radius, color) {
        await this.add(new DebugData.Circle(pos, radius, color));
    }
    
    async addLine(point1, point2, width, color) {
        await this.add(new DebugData.Line(point1, point2, width, color));
    }
    
    async addRect(corner1, corner2, color) {
        await this.add(new DebugData.Rect(corner1, corner2, color));
    }
    
    async addText(text, pos, size, align, color) {
        await this.add(new DebugData.Text(text, pos, size, align, color));
    }

    async add(debugData) {
        await this.send(new DebugCommand.Add(debugData));
    }
    
    async clear() {
        await this.send(new DebugCommand.Clear());
    }
    
    async setAutoFlush(enable) {
        await this.send(new DebugCommand.SetAutoFlush(enable));
    }
    
    async flush() {
        await this.send(new DebugCommand.Flush());
    }

    async send(command) {
        await (new ClientMessage.DebugMessage(command)).writeTo(this.stream);
        await this.stream.flush();
    }

    async getState() {
        await (new ClientMessage.RequestDebugState()).writeTo(this.stream);
        await this.stream.flush();
        return await DebugState.readFrom(this.stream);
    }
}

module.exports = DebugInterface;