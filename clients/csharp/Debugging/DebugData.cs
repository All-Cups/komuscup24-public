namespace Komus24.Debugging
{
    /// <summary>
    /// Data for debug rendering
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
                case Line.TAG:
                    return Line.ReadFrom(reader);
                case Rect.TAG:
                    return Rect.ReadFrom(reader);
                case Text.TAG:
                    return Text.ReadFrom(reader);
                default:
                    throw new System.Exception("Unexpected tag value");
            }
        }

        /// <summary>
        /// Circle
        /// </summary>
        public class Circle : DebugData
        {
            public const int TAG = 0;
        
            /// <summary>
            /// Center
            /// </summary>
            public Komus24.Model.Vec2Double Pos { get; set; }
            /// <summary>
            /// Radius
            /// </summary>
            public double Radius { get; set; }
            /// <summary>
            /// Color
            /// </summary>
            public Komus24.Debugging.Color Color { get; set; }
        
            public Circle() { }
        
            public Circle(Komus24.Model.Vec2Double pos, double radius, Komus24.Debugging.Color color)
            {
                this.Pos = pos;
                this.Radius = radius;
                this.Color = color;
            }
        
            /// <summary> Read Circle from reader </summary>
            public static new Circle ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Circle();
                result.Pos = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Radius = reader.ReadDouble();
                result.Color = Komus24.Debugging.Color.ReadFrom(reader);
                return result;
            }
        
            /// <summary> Write Circle to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                Pos.WriteTo(writer);
                writer.Write(Radius);
                Color.WriteTo(writer);
            }
        
            /// <summary> Get string representation of Circle </summary>
            public override string ToString() {
                string stringResult = "Circle { ";
                stringResult += "Pos: ";
                stringResult += Pos.ToString();
                stringResult += ", ";
                stringResult += "Radius: ";
                stringResult += Radius.ToString();
                stringResult += ", ";
                stringResult += "Color: ";
                stringResult += Color.ToString();
                stringResult += " }";
                return stringResult;
            }
        }

        /// <summary>
        /// Line (segment)
        /// </summary>
        public class Line : DebugData
        {
            public const int TAG = 1;
        
            /// <summary>
            /// First end
            /// </summary>
            public Komus24.Model.Vec2Double Point1 { get; set; }
            /// <summary>
            /// Other end
            /// </summary>
            public Komus24.Model.Vec2Double Point2 { get; set; }
            /// <summary>
            /// Thickness
            /// </summary>
            public double Width { get; set; }
            /// <summary>
            /// Color
            /// </summary>
            public Komus24.Debugging.Color Color { get; set; }
        
            public Line() { }
        
            public Line(Komus24.Model.Vec2Double point1, Komus24.Model.Vec2Double point2, double width, Komus24.Debugging.Color color)
            {
                this.Point1 = point1;
                this.Point2 = point2;
                this.Width = width;
                this.Color = color;
            }
        
            /// <summary> Read Line from reader </summary>
            public static new Line ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Line();
                result.Point1 = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Point2 = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Width = reader.ReadDouble();
                result.Color = Komus24.Debugging.Color.ReadFrom(reader);
                return result;
            }
        
            /// <summary> Write Line to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                Point1.WriteTo(writer);
                Point2.WriteTo(writer);
                writer.Write(Width);
                Color.WriteTo(writer);
            }
        
            /// <summary> Get string representation of Line </summary>
            public override string ToString() {
                string stringResult = "Line { ";
                stringResult += "Point1: ";
                stringResult += Point1.ToString();
                stringResult += ", ";
                stringResult += "Point2: ";
                stringResult += Point2.ToString();
                stringResult += ", ";
                stringResult += "Width: ";
                stringResult += Width.ToString();
                stringResult += ", ";
                stringResult += "Color: ";
                stringResult += Color.ToString();
                stringResult += " }";
                return stringResult;
            }
        }

        /// <summary>
        /// Rectangle
        /// </summary>
        public class Rect : DebugData
        {
            public const int TAG = 2;
        
            /// <summary>
            /// One of the corners
            /// </summary>
            public Komus24.Model.Vec2Double Corner1 { get; set; }
            /// <summary>
            /// Opposite corner
            /// </summary>
            public Komus24.Model.Vec2Double Corner2 { get; set; }
            /// <summary>
            /// Color
            /// </summary>
            public Komus24.Debugging.Color Color { get; set; }
        
            public Rect() { }
        
            public Rect(Komus24.Model.Vec2Double corner1, Komus24.Model.Vec2Double corner2, Komus24.Debugging.Color color)
            {
                this.Corner1 = corner1;
                this.Corner2 = corner2;
                this.Color = color;
            }
        
            /// <summary> Read Rect from reader </summary>
            public static new Rect ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Rect();
                result.Corner1 = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Corner2 = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Color = Komus24.Debugging.Color.ReadFrom(reader);
                return result;
            }
        
            /// <summary> Write Rect to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                Corner1.WriteTo(writer);
                Corner2.WriteTo(writer);
                Color.WriteTo(writer);
            }
        
            /// <summary> Get string representation of Rect </summary>
            public override string ToString() {
                string stringResult = "Rect { ";
                stringResult += "Corner1: ";
                stringResult += Corner1.ToString();
                stringResult += ", ";
                stringResult += "Corner2: ";
                stringResult += Corner2.ToString();
                stringResult += ", ";
                stringResult += "Color: ";
                stringResult += Color.ToString();
                stringResult += " }";
                return stringResult;
            }
        }

        /// <summary>
        /// Text
        /// </summary>
        public class Text : DebugData
        {
            public const int TAG = 3;
        
            /// <summary>
            /// Text to draw
            /// </summary>
            public string Text { get; set; }
            /// <summary>
            /// Position
            /// </summary>
            public Komus24.Model.Vec2Double Pos { get; set; }
            /// <summary>
            /// Font size
            /// </summary>
            public double Size { get; set; }
            /// <summary>
            /// Alignment (0 - left, 0.5 - center, 1 - right)
            /// </summary>
            public double Align { get; set; }
            /// <summary>
            /// Color
            /// </summary>
            public Komus24.Debugging.Color Color { get; set; }
        
            public Text() { }
        
            public Text(string text, Komus24.Model.Vec2Double pos, double size, double align, Komus24.Debugging.Color color)
            {
                this.Text = text;
                this.Pos = pos;
                this.Size = size;
                this.Align = align;
                this.Color = color;
            }
        
            /// <summary> Read Text from reader </summary>
            public static new Text ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Text();
                result.Text = System.Text.Encoding.UTF8.GetString(reader.ReadBytes(reader.ReadInt32()));
                result.Pos = Komus24.Model.Vec2Double.ReadFrom(reader);
                result.Size = reader.ReadDouble();
                result.Align = reader.ReadDouble();
                result.Color = Komus24.Debugging.Color.ReadFrom(reader);
                return result;
            }
        
            /// <summary> Write Text to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                var textData = System.Text.Encoding.UTF8.GetBytes(Text);
                writer.Write(textData.Length);
                writer.Write(textData);
                Pos.WriteTo(writer);
                writer.Write(Size);
                writer.Write(Align);
                Color.WriteTo(writer);
            }
        
            /// <summary> Get string representation of Text </summary>
            public override string ToString() {
                string stringResult = "Text { ";
                stringResult += "Text: ";
                stringResult += "\"" + Text + "\"";
                stringResult += ", ";
                stringResult += "Pos: ";
                stringResult += Pos.ToString();
                stringResult += ", ";
                stringResult += "Size: ";
                stringResult += Size.ToString();
                stringResult += ", ";
                stringResult += "Align: ";
                stringResult += Align.ToString();
                stringResult += ", ";
                stringResult += "Color: ";
                stringResult += Color.ToString();
                stringResult += " }";
                return stringResult;
            }
        }
    }
}