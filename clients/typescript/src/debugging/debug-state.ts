import { Stream } from "../stream";

/**
 * App state for debugging
 */
export class DebugState {
    /**
     * Currently pressed keys
     */
    pressedKeys: Array<string>

    constructor(pressedKeys: Array<string>) {
        this.pressedKeys = pressedKeys;
    }

    /**
     * Read DebugState from input stream
     */
    static async readFrom(stream: Stream): Promise<DebugState> {
        let pressedKeys;
        pressedKeys = [];
        for (let pressedKeysCount = await stream.readInt(); pressedKeysCount > 0; pressedKeysCount--) {
            let pressedKeysElement;
            pressedKeysElement = await stream.readString();
            pressedKeys.push(pressedKeysElement);
        }
        return new DebugState(pressedKeys)
    }

    /**
     * Write DebugState to output stream
     */
    async writeTo(stream: Stream) {
        let pressedKeys = this.pressedKeys;
        await stream.writeInt(pressedKeys.length);
        for (let pressedKeysElement of pressedKeys) {
            await stream.writeString(pressedKeysElement);
        }
    }
}