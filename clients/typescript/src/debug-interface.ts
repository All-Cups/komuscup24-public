import { TcpStream } from "./tcp-stream";
import { ClientMessage } from "./codegame/client-message";
import { DebugState } from "./debugging/debug-state";
import { Color } from "./debugging/color";
import { DebugCommand } from "./debugging/debug-command";
import { DebugData } from "./debugging/debug-data";
import { Vec2Double } from "./model/vec2-double";

export class DebugInterface {
    private stream: TcpStream;

    constructor(stream: TcpStream) {
        this.stream = stream;
    }

    async addCircle(pos: Vec2Double, radius: number, color: Color) {
        await this.add(new DebugData.Circle(pos, radius, color));
    }
    
    async addLine(point1: Vec2Double, point2: Vec2Double, width: number, color: Color) {
        await this.add(new DebugData.Line(point1, point2, width, color));
    }
    
    async addRect(corner1: Vec2Double, corner2: Vec2Double, color: Color) {
        await this.add(new DebugData.Rect(corner1, corner2, color));
    }
    
    async addText(text: string, pos: Vec2Double, size: number, align: number, color: Color) {
        await this.add(new DebugData.Text(text, pos, size, align, color));
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