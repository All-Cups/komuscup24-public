package debugging_interface

import (
    "bufio"
    . "komus24/model"
    . "komus24/debugging"
    . "komus24/codegame"
)

type DebugInterface struct {
    Reader *bufio.Reader
    Writer *bufio.Writer
}

func (debugInterface DebugInterface) AddCircle(pos Vec2Float64, radius float64) {
    debugInterface.Add(NewDebugDataCircle(pos, radius))
}

func (debugInterface DebugInterface) Add(debugData DebugData) {
    debugInterface.Send(NewDebugCommandAdd(debugData))
}

func (debugInterface DebugInterface) Clear() {
    debugInterface.Send(NewDebugCommandClear())
}

func (debugInterface DebugInterface) SetAutoFlush(enable bool) {
    debugInterface.Send(NewDebugCommandSetAutoFlush(enable))
}

func (debugInterface DebugInterface) Flush() {
    debugInterface.Send(NewDebugCommandFlush())
}

func (debugInterface DebugInterface) Send(command DebugCommand) {
    ClientMessageDebugMessage{
        Command: command,
    }.Write(debugInterface.Writer)
    err := debugInterface.Writer.Flush()
    if err != nil {
        panic(err)
    }
}

func (debugInterface DebugInterface) GetState() DebugState {
    ClientMessageRequestDebugState{}.Write(debugInterface.Writer)
    err := debugInterface.Writer.Flush()
    if err != nil {
        panic(err)
    }
    return ReadDebugState(debugInterface.Reader)
}