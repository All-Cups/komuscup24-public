using System.IO;

namespace Komus24
{
    public class DebugInterface
    {
        private BinaryWriter writer;
        private BinaryReader reader;
        public DebugInterface(BinaryReader reader, BinaryWriter writer)
        {
            this.reader = reader;
            this.writer = writer;
        }

        public void AddCircle(Komus24.Model.Vec2Double pos, double radius, Komus24.Debugging.Color color)
        {
            Add(new Komus24.Debugging.DebugData.Circle(pos, radius, color));
        }
        
        public void AddLine(Komus24.Model.Vec2Double point1, Komus24.Model.Vec2Double point2, double width, Komus24.Debugging.Color color)
        {
            Add(new Komus24.Debugging.DebugData.Line(point1, point2, width, color));
        }
        
        public void AddRect(Komus24.Model.Vec2Double corner1, Komus24.Model.Vec2Double corner2, Komus24.Debugging.Color color)
        {
            Add(new Komus24.Debugging.DebugData.Rect(corner1, corner2, color));
        }
        
        public void AddText(string text, Komus24.Model.Vec2Double pos, double size, double align, Komus24.Debugging.Color color)
        {
            Add(new Komus24.Debugging.DebugData.Text(text, pos, size, align, color));
        }

        public void Add(Komus24.Debugging.DebugData debugData)
        {
            Send(new Komus24.Debugging.DebugCommand.Add(debugData));
        }
        
        public void Clear()
        {
            Send(new Komus24.Debugging.DebugCommand.Clear());
        }
        
        public void SetAutoFlush(bool enable)
        {
            Send(new Komus24.Debugging.DebugCommand.SetAutoFlush(enable));
        }
        
        public void Flush()
        {
            Send(new Komus24.Debugging.DebugCommand.Flush());
        }

        public void Send(Komus24.Debugging.DebugCommand command)
        {
            new Komus24.Codegame.ClientMessage.DebugMessage(command).WriteTo(writer);
            writer.Flush();
        }

        public Komus24.Debugging.DebugState GetState()
        {
            new Komus24.Codegame.ClientMessage.RequestDebugState().WriteTo(writer);
            writer.Flush();
            return Komus24.Debugging.DebugState.ReadFrom(reader);
        }
    }
}