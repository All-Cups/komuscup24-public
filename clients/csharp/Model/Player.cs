namespace Komus24.Model
{
    /// <summary>
    /// Player (game participant)
    /// </summary>
    public struct Player
    {
        /// <summary>
        /// Index
        /// </summary>
        public int Index { get; set; }
        /// <summary>
        /// Current score
        /// </summary>
        public long Score { get; set; }
        /// <summary>
        /// List of player's vehicles
        /// </summary>
        public Komus24.Model.Vehicle[] Vehicles { get; set; }
    
        public Player(int index, long score, Komus24.Model.Vehicle[] vehicles)
        {
            this.Index = index;
            this.Score = score;
            this.Vehicles = vehicles;
        }
    
        /// <summary> Read Player from reader </summary>
        public static Player ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Player();
            result.Index = reader.ReadInt32();
            result.Score = reader.ReadInt64();
            result.Vehicles = new Komus24.Model.Vehicle[reader.ReadInt32()];
            for (int vehiclesIndex = 0; vehiclesIndex < result.Vehicles.Length; vehiclesIndex++)
            {
                result.Vehicles[vehiclesIndex] = Komus24.Model.Vehicle.ReadFrom(reader);
            }
            return result;
        }
    
        /// <summary> Write Player to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(Index);
            writer.Write(Score);
            writer.Write(Vehicles.Length);
            foreach (var vehiclesElement in Vehicles)
            {
                vehiclesElement.WriteTo(writer);
            }
        }
    
        /// <summary> Get string representation of Player </summary>
        public override string ToString() {
            string stringResult = "Player { ";
            stringResult += "Index: ";
            stringResult += Index.ToString();
            stringResult += ", ";
            stringResult += "Score: ";
            stringResult += Score.ToString();
            stringResult += ", ";
            stringResult += "Vehicles: ";
            stringResult += "[ ";
            int vehiclesIndex = 0;
            foreach (var vehiclesElement in Vehicles)
            {
                if (vehiclesIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += vehiclesElement.ToString();
                vehiclesIndex++;
            }
            stringResult += " ]";
            stringResult += " }";
            return stringResult;
        }
    }
}