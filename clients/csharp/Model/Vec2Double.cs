namespace Komus24.Model
{
    /// <summary>
    /// 2 dimensional vector.
    /// </summary>
    public struct Vec2Double
    {
        /// <summary>
        /// `x` coordinate of the vector
        /// </summary>
        public double X { get; set; }
        /// <summary>
        /// `y` coordinate of the vector
        /// </summary>
        public double Y { get; set; }
    
        public Vec2Double(double x, double y)
        {
            this.X = x;
            this.Y = y;
        }
    
        /// <summary> Read Vec2Double from reader </summary>
        public static Vec2Double ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Vec2Double();
            result.X = reader.ReadDouble();
            result.Y = reader.ReadDouble();
            return result;
        }
    
        /// <summary> Write Vec2Double to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(X);
            writer.Write(Y);
        }
    
        /// <summary> Get string representation of Vec2Double </summary>
        public override string ToString() {
            string stringResult = "Vec2Double { ";
            stringResult += "X: ";
            stringResult += X.ToString();
            stringResult += ", ";
            stringResult += "Y: ";
            stringResult += Y.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}