namespace Komus24.Model
{
    /// <summary>
    /// Range of values
    /// </summary>
    public struct MinMaxRangeLong
    {
        /// <summary>
        /// Minimal value
        /// </summary>
        public long Min { get; set; }
        /// <summary>
        /// Maximal  value
        /// </summary>
        public long Max { get; set; }
    
        public MinMaxRangeLong(long min, long max)
        {
            this.Min = min;
            this.Max = max;
        }
    
        /// <summary> Read MinMaxRangeLong from reader </summary>
        public static MinMaxRangeLong ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new MinMaxRangeLong();
            result.Min = reader.ReadInt64();
            result.Max = reader.ReadInt64();
            return result;
        }
    
        /// <summary> Write MinMaxRangeLong to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(Min);
            writer.Write(Max);
        }
    
        /// <summary> Get string representation of MinMaxRangeLong </summary>
        public override string ToString() {
            string stringResult = "MinMaxRangeLong { ";
            stringResult += "Min: ";
            stringResult += Min.ToString();
            stringResult += ", ";
            stringResult += "Max: ";
            stringResult += Max.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}