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

        public void AddCircle(Komus24.Model.Vec2Double pos, double radius)
        {
            Add(new Komus24.Model.DebugData.Circle(pos, radius));
        }

        public void Add(Komus24.Model.DebugData debugData)
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

        public Komus24.Model.DebugState GetState()
        {
            new Komus24.Codegame.ClientMessage.RequestDebugState().WriteTo(writer);
            writer.Flush();
            return Komus24.Model.DebugState.ReadFrom(reader);
        }
    }
}