namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public struct VehicleOrder
    {
        /// <summary>
        /// -1..+1
        /// </summary>
        public double Accelerate { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public bool Brakes { get; set; }
        /// <summary>
        /// -1..+1
        /// </summary>
        public double Rotate { get; set; }
    
        public VehicleOrder(double accelerate, bool brakes, double rotate)
        {
            this.Accelerate = accelerate;
            this.Brakes = brakes;
            this.Rotate = rotate;
        }
    
        /// <summary> Read VehicleOrder from reader </summary>
        public static VehicleOrder ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new VehicleOrder();
            result.Accelerate = reader.ReadDouble();
            result.Brakes = reader.ReadBoolean();
            result.Rotate = reader.ReadDouble();
            return result;
        }
    
        /// <summary> Write VehicleOrder to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(Accelerate);
            writer.Write(Brakes);
            writer.Write(Rotate);
        }
    
        /// <summary> Get string representation of VehicleOrder </summary>
        public override string ToString() {
            string stringResult = "VehicleOrder { ";
            stringResult += "Accelerate: ";
            stringResult += Accelerate.ToString();
            stringResult += ", ";
            stringResult += "Brakes: ";
            stringResult += Brakes.ToString();
            stringResult += ", ";
            stringResult += "Rotate: ";
            stringResult += Rotate.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}