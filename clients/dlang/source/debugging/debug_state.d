module debugging.debug_state;

import stream;
import std.conv;
import std.typecons : Nullable;


/// App state for debugging
struct DebugState {
    /// Currently pressed keys
    string[] pressedKeys;

    this(string[] pressedKeys) {
        this.pressedKeys = pressedKeys;
    }

    /// Read DebugState from reader
    static DebugState readFrom(Stream reader) {
        string[] pressedKeys;
        pressedKeys = new string[reader.readInt()];
        for (int pressedKeysIndex = 0; pressedKeysIndex < pressedKeys.length; pressedKeysIndex++) {
            string pressedKeysKey;
            pressedKeysKey = reader.readString();
            pressedKeys[pressedKeysIndex] = pressedKeysKey;
        }
        return DebugState(pressedKeys);
    }

    /// Write DebugState to writer
    void writeTo(Stream writer) const {
        writer.write(cast(int)(pressedKeys.length));
        foreach (pressedKeysElement; pressedKeys) {
            writer.write(pressedKeysElement);
        }
    }
}