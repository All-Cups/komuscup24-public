namespace Komus24.Model
{
    /// <summary>
    /// Current game's state
    /// </summary>
    public struct PlayerView
    {
        /// <summary>
        /// Current tick number
        /// </summary>
        public int CurrentTick { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public Komus24.Model.Player You { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public Komus24.Model.Player[] Other { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public Komus24.Model.Quest[] Quests { get; set; }
    
        public PlayerView(int currentTick, Komus24.Model.Player you, Komus24.Model.Player[] other, Komus24.Model.Quest[] quests)
        {
            this.CurrentTick = currentTick;
            this.You = you;
            this.Other = other;
            this.Quests = quests;
        }
    
        /// <summary> Read PlayerView from reader </summary>
        public static PlayerView ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new PlayerView();
            result.CurrentTick = reader.ReadInt32();
            result.You = Komus24.Model.Player.ReadFrom(reader);
            result.Other = new Komus24.Model.Player[reader.ReadInt32()];
            for (int otherIndex = 0; otherIndex < result.Other.Length; otherIndex++)
            {
                result.Other[otherIndex] = Komus24.Model.Player.ReadFrom(reader);
            }
            result.Quests = new Komus24.Model.Quest[reader.ReadInt32()];
            for (int questsIndex = 0; questsIndex < result.Quests.Length; questsIndex++)
            {
                result.Quests[questsIndex] = Komus24.Model.Quest.ReadFrom(reader);
            }
            return result;
        }
    
        /// <summary> Write PlayerView to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(CurrentTick);
            You.WriteTo(writer);
            writer.Write(Other.Length);
            foreach (var otherElement in Other)
            {
                otherElement.WriteTo(writer);
            }
            writer.Write(Quests.Length);
            foreach (var questsElement in Quests)
            {
                questsElement.WriteTo(writer);
            }
        }
    
        /// <summary> Get string representation of PlayerView </summary>
        public override string ToString() {
            string stringResult = "PlayerView { ";
            stringResult += "CurrentTick: ";
            stringResult += CurrentTick.ToString();
            stringResult += ", ";
            stringResult += "You: ";
            stringResult += You.ToString();
            stringResult += ", ";
            stringResult += "Other: ";
            stringResult += "[ ";
            int otherIndex = 0;
            foreach (var otherElement in Other)
            {
                if (otherIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += otherElement.ToString();
                otherIndex++;
            }
            stringResult += " ]";
            stringResult += ", ";
            stringResult += "Quests: ";
            stringResult += "[ ";
            int questsIndex = 0;
            foreach (var questsElement in Quests)
            {
                if (questsIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += questsElement.ToString();
                questsIndex++;
            }
            stringResult += " ]";
            stringResult += " }";
            return stringResult;
        }
    }
}