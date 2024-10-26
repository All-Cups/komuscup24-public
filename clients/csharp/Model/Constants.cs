namespace Komus24.Model
{
    /// <summary>
    /// Game constants
    /// </summary>
    public struct Constants
    {
        /// <summary>
        /// Max duration of the game in ticks
        /// </summary>
        public int MaxTickCount { get; set; }
        /// <summary>
        /// Max game time in seconds
        /// </summary>
        public double MaxGameTimeSeconds { get; set; }
        /// <summary>
        /// Ticks per second
        /// </summary>
        public double TicksPerSecond { get; set; }
        /// <summary>
        /// Subticks for physics simulation
        /// </summary>
        public int Microticks { get; set; }
        /// <summary>
        /// Size of a single city cell
        /// </summary>
        public double CellSize { get; set; }
        /// <summary>
        /// Collision bounciness
        /// </summary>
        public double CollisionBounciness { get; set; }
        /// <summary>
        /// City type
        /// </summary>
        public Komus24.Model.CityType CityType { get; set; }
        /// <summary>
        /// List of vehicle types
        /// </summary>
        public Komus24.Model.VehicleType[] VehicleTypes { get; set; }
        /// <summary>
        /// Speed of refueling at a station
        /// </summary>
        public double RefillSpeed { get; set; }
        /// <summary>
        /// Number of available quests
        /// </summary>
        public int QuestCount { get; set; }
        /// <summary>
        /// Score range for quests
        /// </summary>
        public Komus24.Model.MinMaxRangeLong QuestScore { get; set; }
        /// <summary>
        /// Traffic options
        /// </summary>
        public Komus24.Model.Traffic Traffic { get; set; }
        /// <summary>
        /// Collision penalty modifier
        /// </summary>
        public double CollisionPenaltyModifier { get; set; }
        /// <summary>
        /// Map of the city
        /// </summary>
        public Komus24.Model.CityCell[][] City { get; set; }
    
        public Constants(int maxTickCount, double maxGameTimeSeconds, double ticksPerSecond, int microticks, double cellSize, double collisionBounciness, Komus24.Model.CityType cityType, Komus24.Model.VehicleType[] vehicleTypes, double refillSpeed, int questCount, Komus24.Model.MinMaxRangeLong questScore, Komus24.Model.Traffic traffic, double collisionPenaltyModifier, Komus24.Model.CityCell[][] city)
        {
            this.MaxTickCount = maxTickCount;
            this.MaxGameTimeSeconds = maxGameTimeSeconds;
            this.TicksPerSecond = ticksPerSecond;
            this.Microticks = microticks;
            this.CellSize = cellSize;
            this.CollisionBounciness = collisionBounciness;
            this.CityType = cityType;
            this.VehicleTypes = vehicleTypes;
            this.RefillSpeed = refillSpeed;
            this.QuestCount = questCount;
            this.QuestScore = questScore;
            this.Traffic = traffic;
            this.CollisionPenaltyModifier = collisionPenaltyModifier;
            this.City = city;
        }
    
        /// <summary> Read Constants from reader </summary>
        public static Constants ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Constants();
            result.MaxTickCount = reader.ReadInt32();
            result.MaxGameTimeSeconds = reader.ReadDouble();
            result.TicksPerSecond = reader.ReadDouble();
            result.Microticks = reader.ReadInt32();
            result.CellSize = reader.ReadDouble();
            result.CollisionBounciness = reader.ReadDouble();
            result.CityType = Komus24.Model.CityType.ReadFrom(reader);
            result.VehicleTypes = new Komus24.Model.VehicleType[reader.ReadInt32()];
            for (int vehicleTypesIndex = 0; vehicleTypesIndex < result.VehicleTypes.Length; vehicleTypesIndex++)
            {
                result.VehicleTypes[vehicleTypesIndex] = Komus24.Model.VehicleType.ReadFrom(reader);
            }
            result.RefillSpeed = reader.ReadDouble();
            result.QuestCount = reader.ReadInt32();
            result.QuestScore = Komus24.Model.MinMaxRangeLong.ReadFrom(reader);
            result.Traffic = Komus24.Model.Traffic.ReadFrom(reader);
            result.CollisionPenaltyModifier = reader.ReadDouble();
            result.City = new Komus24.Model.CityCell[reader.ReadInt32()][];
            for (int cityIndex = 0; cityIndex < result.City.Length; cityIndex++)
            {
                result.City[cityIndex] = new Komus24.Model.CityCell[reader.ReadInt32()];
                for (int cityElementIndex = 0; cityElementIndex < result.City[cityIndex].Length; cityElementIndex++)
                {
                    result.City[cityIndex][cityElementIndex] = CityCellHelper.ReadFrom(reader);
                }
            }
            return result;
        }
    
        /// <summary> Write Constants to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(MaxTickCount);
            writer.Write(MaxGameTimeSeconds);
            writer.Write(TicksPerSecond);
            writer.Write(Microticks);
            writer.Write(CellSize);
            writer.Write(CollisionBounciness);
            CityType.WriteTo(writer);
            writer.Write(VehicleTypes.Length);
            foreach (var vehicleTypesElement in VehicleTypes)
            {
                vehicleTypesElement.WriteTo(writer);
            }
            writer.Write(RefillSpeed);
            writer.Write(QuestCount);
            QuestScore.WriteTo(writer);
            Traffic.WriteTo(writer);
            writer.Write(CollisionPenaltyModifier);
            writer.Write(City.Length);
            foreach (var cityElement in City)
            {
                writer.Write(cityElement.Length);
                foreach (var cityElementElement in cityElement)
                {
                    writer.Write((int) (cityElementElement));
                }
            }
        }
    
        /// <summary> Get string representation of Constants </summary>
        public override string ToString() {
            string stringResult = "Constants { ";
            stringResult += "MaxTickCount: ";
            stringResult += MaxTickCount.ToString();
            stringResult += ", ";
            stringResult += "MaxGameTimeSeconds: ";
            stringResult += MaxGameTimeSeconds.ToString();
            stringResult += ", ";
            stringResult += "TicksPerSecond: ";
            stringResult += TicksPerSecond.ToString();
            stringResult += ", ";
            stringResult += "Microticks: ";
            stringResult += Microticks.ToString();
            stringResult += ", ";
            stringResult += "CellSize: ";
            stringResult += CellSize.ToString();
            stringResult += ", ";
            stringResult += "CollisionBounciness: ";
            stringResult += CollisionBounciness.ToString();
            stringResult += ", ";
            stringResult += "CityType: ";
            stringResult += CityType.ToString();
            stringResult += ", ";
            stringResult += "VehicleTypes: ";
            stringResult += "[ ";
            int vehicleTypesIndex = 0;
            foreach (var vehicleTypesElement in VehicleTypes)
            {
                if (vehicleTypesIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += vehicleTypesElement.ToString();
                vehicleTypesIndex++;
            }
            stringResult += " ]";
            stringResult += ", ";
            stringResult += "RefillSpeed: ";
            stringResult += RefillSpeed.ToString();
            stringResult += ", ";
            stringResult += "QuestCount: ";
            stringResult += QuestCount.ToString();
            stringResult += ", ";
            stringResult += "QuestScore: ";
            stringResult += QuestScore.ToString();
            stringResult += ", ";
            stringResult += "Traffic: ";
            stringResult += Traffic.ToString();
            stringResult += ", ";
            stringResult += "CollisionPenaltyModifier: ";
            stringResult += CollisionPenaltyModifier.ToString();
            stringResult += ", ";
            stringResult += "City: ";
            stringResult += "[ ";
            int cityIndex = 0;
            foreach (var cityElement in City)
            {
                if (cityIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += "[ ";
                int cityElementIndex = 0;
                foreach (var cityElementElement in cityElement)
                {
                    if (cityElementIndex != 0) {
                        stringResult += ", ";
                    }
                    stringResult += cityElementElement.ToString();
                    cityElementIndex++;
                }
                stringResult += " ]";
                cityIndex++;
            }
            stringResult += " ]";
            stringResult += " }";
            return stringResult;
        }
    }
}