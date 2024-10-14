namespace Komus24

type DebugInterface(reader, writer) =
    member this.addCircle(pos: Model.Vec2Double, radius: double) =
        this.add (Model.DebugData.Circle {
            Pos = pos
            Radius = radius
        })

    member this.add(debugData: Model.DebugData) =
        this.send (Debugging.DebugCommand.Add {
            DebugData = debugData
        })
    
    member this.clear() =
        this.send (Debugging.DebugCommand.Clear (new Debugging.DebugCommandClear()))
    
    member this.setAutoFlush(enable: bool) =
        this.send (Debugging.DebugCommand.SetAutoFlush {
            Enable = enable
        })
    
    member this.flush() =
        this.send (Debugging.DebugCommand.Flush (new Debugging.DebugCommandFlush()))

    member this.send(command: Debugging.DebugCommand) =
        (Codegame.ClientMessage.DebugMessage { Command = command }).writeTo writer
        writer.Flush()

    member this.getState(): Model.DebugState =
        (new Codegame.ClientMessageRequestDebugState()).writeTo writer
        writer.Flush()
        Model.DebugState.readFrom reader