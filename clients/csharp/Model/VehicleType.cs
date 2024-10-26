namespace Komus24.Model
{
    /// <summary>
    /// Vehicle type options
    /// </summary>
    public struct VehicleType
    {
        /// <summary>
        /// Name
        /// </summary>
        public string Name { get; set; }
        /// <summary>
        /// Radius
        /// </summary>
        public double Radius { get; set; }
        /// <summary>
        /// Weight
        /// </summary>
        public double Weight { get; set; }
        /// <summary>
        /// Maximal backwads movement speed
        /// </summary>
        public double MaxBackwardsSpeed { get; set; }
        /// <summary>
        /// Maximal forward movement speed
        /// </summary>
        public double MaxSpeed { get; set; }
        /// <summary>
        /// Acceleration
        /// </summary>
        public double Acceleration { get; set; }
        /// <summary>
        /// Friction coefficient
        /// </summary>
        public double Friction { get; set; }
        /// <summary>
        /// Maximal rotation speed
        /// </summary>
        public double MaxRotateSpeed { get; set; }
        /// <summary>
        /// Rotational acceleration
        /// </summary>
        public double RotateAcceleration { get; set; }
        /// <summary>
        /// Maximal amount of fuel
        /// </summary>
        public double MaxFuel { get; set; }
        /// <summary>
        /// Fuel usage speed
        /// </summary>
        public double FuelUseSpeed { get; set; }
    
        public VehicleType(string name, double radius, double weight, double maxBackwardsSpeed, double maxSpeed, double acceleration, double friction, double maxRotateSpeed, double rotateAcceleration, double maxFuel, double fuelUseSpeed)
        {
            this.Name = name;
            this.Radius = radius;
            this.Weight = weight;
            this.MaxBackwardsSpeed = maxBackwardsSpeed;
            this.MaxSpeed = maxSpeed;
            this.Acceleration = acceleration;
            this.Friction = friction;
            this.MaxRotateSpeed = maxRotateSpeed;
            this.RotateAcceleration = rotateAcceleration;
            this.MaxFuel = maxFuel;
            this.FuelUseSpeed = fuelUseSpeed;
        }
    
        /// <summary> Read VehicleType from reader </summary>
        public static VehicleType ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new VehicleType();
            result.Name = System.Text.Encoding.UTF8.GetString(reader.ReadBytes(reader.ReadInt32()));
            result.Radius = reader.ReadDouble();
            result.Weight = reader.ReadDouble();
            result.MaxBackwardsSpeed = reader.ReadDouble();
            result.MaxSpeed = reader.ReadDouble();
            result.Acceleration = reader.ReadDouble();
            result.Friction = reader.ReadDouble();
            result.MaxRotateSpeed = reader.ReadDouble();
            result.RotateAcceleration = reader.ReadDouble();
            result.MaxFuel = reader.ReadDouble();
            result.FuelUseSpeed = reader.ReadDouble();
            return result;
        }
    
        /// <summary> Write VehicleType to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            var nameData = System.Text.Encoding.UTF8.GetBytes(Name);
            writer.Write(nameData.Length);
            writer.Write(nameData);
            writer.Write(Radius);
            writer.Write(Weight);
            writer.Write(MaxBackwardsSpeed);
            writer.Write(MaxSpeed);
            writer.Write(Acceleration);
            writer.Write(Friction);
            writer.Write(MaxRotateSpeed);
            writer.Write(RotateAcceleration);
            writer.Write(MaxFuel);
            writer.Write(FuelUseSpeed);
        }
    
        /// <summary> Get string representation of VehicleType </summary>
        public override string ToString() {
            string stringResult = "VehicleType { ";
            stringResult += "Name: ";
            stringResult += "\"" + Name + "\"";
            stringResult += ", ";
            stringResult += "Radius: ";
            stringResult += Radius.ToString();
            stringResult += ", ";
            stringResult += "Weight: ";
            stringResult += Weight.ToString();
            stringResult += ", ";
            stringResult += "MaxBackwardsSpeed: ";
            stringResult += MaxBackwardsSpeed.ToString();
            stringResult += ", ";
            stringResult += "MaxSpeed: ";
            stringResult += MaxSpeed.ToString();
            stringResult += ", ";
            stringResult += "Acceleration: ";
            stringResult += Acceleration.ToString();
            stringResult += ", ";
            stringResult += "Friction: ";
            stringResult += Friction.ToString();
            stringResult += ", ";
            stringResult += "MaxRotateSpeed: ";
            stringResult += MaxRotateSpeed.ToString();
            stringResult += ", ";
            stringResult += "RotateAcceleration: ";
            stringResult += RotateAcceleration.ToString();
            stringResult += ", ";
            stringResult += "MaxFuel: ";
            stringResult += MaxFuel.ToString();
            stringResult += ", ";
            stringResult += "FuelUseSpeed: ";
            stringResult += FuelUseSpeed.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}