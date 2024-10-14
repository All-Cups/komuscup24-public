namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public struct DebugState
    {
        /// <summary>
        /// TODO - Document
        /// </summary>
        public string[] PressedKeys { get; set; }
    
        public DebugState(string[] pressedKeys)
        {
            this.PressedKeys = pressedKeys;
        }
    
        /// <summary> Read DebugState from reader </summary>
        public static DebugState ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new DebugState();
            result.PressedKeys = new string[reader.ReadInt32()];
            for (int pressedKeysIndex = 0; pressedKeysIndex < result.PressedKeys.Length; pressedKeysIndex++)
            {
                result.PressedKeys[pressedKeysIndex] = System.Text.Encoding.UTF8.GetString(reader.ReadBytes(reader.ReadInt32()));
            }
            return result;
        }
    
        /// <summary> Write DebugState to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(PressedKeys.Length);
            foreach (var pressedKeysElement in PressedKeys)
            {
                var pressedKeysElementData = System.Text.Encoding.UTF8.GetBytes(pressedKeysElement);
                writer.Write(pressedKeysElementData.Length);
                writer.Write(pressedKeysElementData);
            }
        }
    
        /// <summary> Get string representation of DebugState </summary>
        public override string ToString() {
            string stringResult = "DebugState { ";
            stringResult += "PressedKeys: ";
            stringResult += "[ ";
            int pressedKeysIndex = 0;
            foreach (var pressedKeysElement in PressedKeys)
            {
                if (pressedKeysIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += "\"" + pressedKeysElement + "\"";
                pressedKeysIndex++;
            }
            stringResult += " ]";
            stringResult += " }";
            return stringResult;
        }
    }
}