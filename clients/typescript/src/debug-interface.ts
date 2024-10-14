import { TcpStream } from "./tcp-stream";
import { ClientMessage } from "./codegame/client-message";
import { DebugState } from "./model/debug-state";
import { DebugCommand } from "./debugging/debug-command";
import { DebugData } from "./model/debug-data";
import { Vec2Double } from "./model/vec2-double";

export class DebugInterface {
    private stream: TcpStream;

    constructor(stream: TcpStream) {
        this.stream = stream;
    }

    async addCircle(pos: Vec2Double, radius: number) {
        await this.add(new DebugData.Circle(pos, radius));
    }

    async add(debugData: DebugData) {
        await this.send(new DebugCommand.Add(debugData));
    }
    
    async clear() {
        await this.send(new DebugCommand.Clear());
    }
    
    async setAutoFlush(enable: boolean) {
        await this.send(new DebugCommand.SetAutoFlush(enable));
    }
    
    async flush() {
        await this.send(new DebugCommand.Flush());
    }

    async send(command: DebugCommand) {
        await (new ClientMessage.DebugMessage(command)).writeTo(this.stream);
        await this.stream.flush();
    }

    async getState(): Promise<DebugState> {
        await (new ClientMessage.RequestDebugState()).writeTo(this.stream);
        await this.stream.flush();
        return await DebugState.readFrom(this.stream);
    }
}