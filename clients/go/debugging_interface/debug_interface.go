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

func (debugInterface DebugInterface) AddCircle(pos Vec2Float64, radius float64, color Color) {
    debugInterface.Add(NewDebugDataCircle(pos, radius, color))
}

func (debugInterface DebugInterface) AddLine(point1 Vec2Float64, point2 Vec2Float64, width float64, color Color) {
    debugInterface.Add(NewDebugDataLine(point1, point2, width, color))
}

func (debugInterface DebugInterface) AddRect(corner1 Vec2Float64, corner2 Vec2Float64, color Color) {
    debugInterface.Add(NewDebugDataRect(corner1, corner2, color))
}

func (debugInterface DebugInterface) AddText(text string, pos Vec2Float64, size float64, align float64, color Color) {
    debugInterface.Add(NewDebugDataText(text, pos, size, align, color))
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