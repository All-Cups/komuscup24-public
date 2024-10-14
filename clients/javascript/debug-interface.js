const ClientMessage = require('./codegame/client-message');
const DebugState = require('./model/debug-state');
const DebugCommand = require('./debugging/debug-command');
const DebugData = require('./model/debug-data');

class DebugInterface {
    constructor(stream) {
        this.stream = stream;
    }

    async addCircle(pos, radius) {
        await this.add(new DebugData.Circle(pos, radius));
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