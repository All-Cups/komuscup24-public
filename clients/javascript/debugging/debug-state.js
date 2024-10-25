/**
 * App state for debugging
 */
class DebugState {
    /**
     * Currently pressed keys
     */
    pressedKeys;

    constructor(pressedKeys) {
        this.pressedKeys = pressedKeys;
    }

    /**
     * Read DebugState from input stream
     */
    static async readFrom(stream) {
        let pressedKeys;
        pressedKeys = [];
        for (let pressedKeysCount = await stream.readInt(); pressedKeysCount > 0; pressedKeysCount--) {
            let pressedKeysElement;
            pressedKeysElement = await stream.readString();
            pressedKeys.push(pressedKeysElement);
        }
        return new DebugState(pressedKeys);
    }

    /**
     * Write DebugState to output stream
     */
    async writeTo(stream) {
        let pressedKeys = this.pressedKeys;
        await stream.writeInt(pressedKeys.length);
        for (let pressedKeysElement of pressedKeys) {
            await stream.writeString(pressedKeysElement);
        }
    }
}
module.exports = DebugState