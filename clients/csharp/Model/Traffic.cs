namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public struct Traffic
    {
        /// <summary>
        /// TODO - Document
        /// </summary>
        public int Amount { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public double MoveTime { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public double Radius { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public double Weight { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public double CrashDeceleration { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public double CrashLifetime { get; set; }
    
        public Traffic(int amount, double moveTime, double radius, double weight, double crashDeceleration, double crashLifetime)
        {
            this.Amount = amount;
            this.MoveTime = moveTime;
            this.Radius = radius;
            this.Weight = weight;
            this.CrashDeceleration = crashDeceleration;
            this.CrashLifetime = crashLifetime;
        }
    
        /// <summary> Read Traffic from reader </summary>
        public static Traffic ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Traffic();
            result.Amount = reader.ReadInt32();
            result.MoveTime = reader.ReadDouble();
            result.Radius = reader.ReadDouble();
            result.Weight = reader.ReadDouble();
            result.CrashDeceleration = reader.ReadDouble();
            result.CrashLifetime = reader.ReadDouble();
            return result;
        }
    
        /// <summary> Write Traffic to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(Amount);
            writer.Write(MoveTime);
            writer.Write(Radius);
            writer.Write(Weight);
            writer.Write(CrashDeceleration);
            writer.Write(CrashLifetime);
        }
    
        /// <summary> Get string representation of Traffic </summary>
        public override string ToString() {
            string stringResult = "Traffic { ";
            stringResult += "Amount: ";
            stringResult += Amount.ToString();
            stringResult += ", ";
            stringResult += "MoveTime: ";
            stringResult += MoveTime.ToString();
            stringResult += ", ";
            stringResult += "Radius: ";
            stringResult += Radius.ToString();
            stringResult += ", ";
            stringResult += "Weight: ";
            stringResult += Weight.ToString();
            stringResult += ", ";
            stringResult += "CrashDeceleration: ";
            stringResult += CrashDeceleration.ToString();
            stringResult += ", ";
            stringResult += "CrashLifetime: ";
            stringResult += CrashLifetime.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}