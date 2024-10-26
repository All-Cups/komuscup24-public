namespace Komus24.Model
{
    /// <summary>
    /// A vehicle
    /// </summary>
    public struct Vehicle
    {
        /// <summary>
        /// Current position (center)
        /// </summary>
        public Komus24.Model.Vec2Double Position { get; set; }
        /// <summary>
        /// Velocity vector
        /// </summary>
        public Komus24.Model.Vec2Double Velocity { get; set; }
        /// <summary>
        /// Speed of wheels
        /// </summary>
        public double Speed { get; set; }
        /// <summary>
        /// Rotation speed (radians/second)
        /// </summary>
        public double RotationSpeed { get; set; }
        /// <summary>
        /// Current rotation
        /// </summary>
        public double Rotation { get; set; }
        /// <summary>
        /// Vehicle type index
        /// </summary>
        public int TypeIndex { get; set; }
        /// <summary>
        /// Current quest, if any
        /// </summary>
        public Komus24.Model.Quest? Quest { get; set; }
        /// <summary>
        /// Remaining fuel
        /// </summary>
        public double Fuel { get; set; }
    
        public Vehicle(Komus24.Model.Vec2Double position, Komus24.Model.Vec2Double velocity, double speed, double rotationSpeed, double rotation, int typeIndex, Komus24.Model.Quest? quest, double fuel)
        {
            this.Position = position;
            this.Velocity = velocity;
            this.Speed = speed;
            this.RotationSpeed = rotationSpeed;
            this.Rotation = rotation;
            this.TypeIndex = typeIndex;
            this.Quest = quest;
            this.Fuel = fuel;
        }
    
        /// <summary> Read Vehicle from reader </summary>
        public static Vehicle ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Vehicle();
            result.Position = Komus24.Model.Vec2Double.ReadFrom(reader);
            result.Velocity = Komus24.Model.Vec2Double.ReadFrom(reader);
            result.Speed = reader.ReadDouble();
            result.RotationSpeed = reader.ReadDouble();
            result.Rotation = reader.ReadDouble();
            result.TypeIndex = reader.ReadInt32();
            if (reader.ReadBoolean())
            {
                result.Quest = Komus24.Model.Quest.ReadFrom(reader);
            } else
            {
                result.Quest = null;
            }
            result.Fuel = reader.ReadDouble();
            return result;
        }
    
        /// <summary> Write Vehicle to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            Position.WriteTo(writer);
            Velocity.WriteTo(writer);
            writer.Write(Speed);
            writer.Write(RotationSpeed);
            writer.Write(Rotation);
            writer.Write(TypeIndex);
            if (!Quest.HasValue)
            {
                writer.Write(false);
            } else
            {
                writer.Write(true);
                Quest.Value.WriteTo(writer);
            }
            writer.Write(Fuel);
        }
    
        /// <summary> Get string representation of Vehicle </summary>
        public override string ToString() {
            string stringResult = "Vehicle { ";
            stringResult += "Position: ";
            stringResult += Position.ToString();
            stringResult += ", ";
            stringResult += "Velocity: ";
            stringResult += Velocity.ToString();
            stringResult += ", ";
            stringResult += "Speed: ";
            stringResult += Speed.ToString();
            stringResult += ", ";
            stringResult += "RotationSpeed: ";
            stringResult += RotationSpeed.ToString();
            stringResult += ", ";
            stringResult += "Rotation: ";
            stringResult += Rotation.ToString();
            stringResult += ", ";
            stringResult += "TypeIndex: ";
            stringResult += TypeIndex.ToString();
            stringResult += ", ";
            stringResult += "Quest: ";
            if (!Quest.HasValue)
            {
                stringResult += "null";
            } else
            {
                stringResult += Quest.Value.ToString();
            }
            stringResult += ", ";
            stringResult += "Fuel: ";
            stringResult += Fuel.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}