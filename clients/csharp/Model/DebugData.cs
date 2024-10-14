namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public abstract class DebugData
    {
        /// <summary> Write DebugData to writer </summary>
        public abstract void WriteTo(System.IO.BinaryWriter writer);

        /// <summary> Read DebugData from reader </summary>
        public static DebugData ReadFrom(System.IO.BinaryReader reader)
        {
            switch (reader.ReadInt32())
            {
                case Circle.TAG:
                    return Circle.ReadFrom(reader);
                default:
                    throw new System.Exception("Unexpected tag value");
            }
        }

        /// <summary>
        /// TODO - Document
        /// </summary>
        public class Circle : DebugData
        {
            public const int TAG = 0;
        
            /// <summary>
            /// TODO - Document
            /// </summary>
            public Komus24.Model.Vec2Double Pos { get; set; }
            /// <summary>
            /// TODO - Document
            /// </summary>
            public double Radius { get; set; }
        
            public Circle() { }
        
            public Circle(Komus24.Model.Vec2Double pos, double radius)
            {
                this.Pos = pos;
                this.Radius = radius;
            }
        
            /// <summary> Read Circle from reader </summary>
            public static new Circle ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Circle();
                result.Pos = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Radius = reader.ReadDouble();
                return result;
            }
        
            /// <summary> Write Circle to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                Pos.WriteTo(writer);
                writer.Write(Radius);
            }
        
            /// <summary> Get string representation of Circle </summary>
            public override string ToString() {
                string stringResult = "Circle { ";
                stringResult += "Pos: ";
                stringResult += Pos.ToString();
                stringResult += ", ";
                stringResult += "Radius: ";
                stringResult += Radius.ToString();
                stringResult += " }";
                return stringResult;
            }
        }
    }
}