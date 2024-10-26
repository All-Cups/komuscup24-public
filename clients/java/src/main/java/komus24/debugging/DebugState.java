package komus24.debugging;

import komus24.util.StreamUtil;

/**
 * App state for debugging
 */
public class DebugState {
    /**
     * Currently pressed keys
     */
    private String[] pressedKeys;

    /**
     * Currently pressed keys
     */
    public String[] getPressedKeys() {
        return pressedKeys;
    }

    /**
     * Currently pressed keys
     */
    public void setPressedKeys(String[] value) {
        this.pressedKeys = value;
    }

    public DebugState(String[] pressedKeys) {
        this.pressedKeys = pressedKeys;
    }

    /**
     * Read DebugState from input stream
     */
    public static DebugState readFrom(java.io.InputStream stream) throws java.io.IOException {
        String[] pressedKeys;
        pressedKeys = new String[StreamUtil.readInt(stream)];
        for (int pressedKeysIndex = 0; pressedKeysIndex < pressedKeys.length; pressedKeysIndex++) {
            String pressedKeysElement;
            pressedKeysElement = StreamUtil.readString(stream);
            pressedKeys[pressedKeysIndex] = pressedKeysElement;
        }
        return new DebugState(pressedKeys);
    }

    /**
     * Write DebugState to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, pressedKeys.length);
        for (String pressedKeysElement : pressedKeys) {
            StreamUtil.writeString(stream, pressedKeysElement);
        }
    }

    /**
     * Get string representation of DebugState
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DebugState { ");
        stringBuilder.append("pressedKeys: ");
        stringBuilder.append("[ ");
        for (int pressedKeysIndex = 0; pressedKeysIndex < pressedKeys.length; pressedKeysIndex++) {
            if (pressedKeysIndex != 0) {
                stringBuilder.append(", ");
            }
            String pressedKeysElement = pressedKeys[pressedKeysIndex];
            stringBuilder.append('"' + pressedKeysElement + '"');
        }
        stringBuilder.append(" ]");
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}