namespace Komus24

type DebugInterface(reader, writer) =
    member this.addCircle(pos: Model.Vec2Double, radius: double, color: Debugging.Color) =
        this.add (Debugging.DebugData.Circle {
            Pos = pos
            Radius = radius
            Color = color
        })
    
    member this.addLine(point1: Model.Vec2Double, point2: Model.Vec2Double, width: double, color: Debugging.Color) =
        this.add (Debugging.DebugData.Line {
            Point1 = point1
            Point2 = point2
            Width = width
            Color = color
        })
    
    member this.addRect(corner1: Model.Vec2Double, corner2: Model.Vec2Double, color: Debugging.Color) =
        this.add (Debugging.DebugData.Rect {
            Corner1 = corner1
            Corner2 = corner2
            Color = color
        })
    
    member this.addText(text: string, pos: Model.Vec2Double, size: double, align: double, color: Debugging.Color) =
        this.add (Debugging.DebugData.Text {
            Text = text
            Pos = pos
            Size = size
            Align = align
            Color = color
        })

    member this.add(debugData: Debugging.DebugData) =
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

    member this.getState(): Debugging.DebugState =
        (new Codegame.ClientMessageRequestDebugState()).writeTo writer
        writer.Flush()
        Debugging.DebugState.readFrom reader