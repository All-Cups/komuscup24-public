package model

import "io"
import . "komus24/stream"

// TODO - Document
type DebugState struct {
    // TODO - Document
    PressedKeys []string
}

func NewDebugState(pressedKeys []string) DebugState {
    return DebugState {
        PressedKeys: pressedKeys,
    }
}

// Read DebugState from reader
func ReadDebugState(reader io.Reader) DebugState {
    var pressedKeys []string
    pressedKeys = make([]string, ReadInt32(reader))
    for pressedKeysIndex := range pressedKeys {
        var pressedKeysElement string
        pressedKeysElement = ReadString(reader)
        pressedKeys[pressedKeysIndex] = pressedKeysElement
    }
    return DebugState {
        PressedKeys: pressedKeys,
    }
}

// Write DebugState to writer
func (debugState DebugState) Write(writer io.Writer) {
    pressedKeys := debugState.PressedKeys
    WriteInt32(writer, int32(len(pressedKeys)))
    for _, pressedKeysElement := range pressedKeys {
        WriteString(writer, pressedKeysElement)
    }
}

// Get string representation of DebugState
func (debugState DebugState) String() string {
    stringResult := "{ "
    stringResult += "PressedKeys: "
    pressedKeys := debugState.PressedKeys
    stringResult += "[ "
    for pressedKeysIndex, pressedKeysElement := range pressedKeys {
        if pressedKeysIndex != 0 {
            stringResult += ", "
        }
        stringResult += "\"" + pressedKeysElement + "\""
    }
    stringResult += " ]"
    stringResult += " }"
    return stringResult
}