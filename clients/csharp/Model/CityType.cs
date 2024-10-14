namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public abstract class CityType
    {
        /// <summary> Write CityType to writer </summary>
        public abstract void WriteTo(System.IO.BinaryWriter writer);

        /// <summary> Read CityType from reader </summary>
        public static CityType ReadFrom(System.IO.BinaryReader reader)
        {
            switch (reader.ReadInt32())
            {
                case Manhattan.TAG:
                    return Manhattan.ReadFrom(reader);
                case Inline.TAG:
                    return Inline.ReadFrom(reader);
                default:
                    throw new System.Exception("Unexpected tag value");
            }
        }

        /// <summary>
        /// TODO - Document
        /// </summary>
        public class Manhattan : CityType
        {
            public const int TAG = 0;
        
            /// <summary>
            /// TODO - Document
            /// </summary>
            public Komus24.Model.Vec2Int Size { get; set; }
            /// <summary>
            /// TODO - Document
            /// </summary>
            public Komus24.Model.Vec2Int BlockSize { get; set; }
            /// <summary>
            /// TODO - Document
            /// </summary>
            public int Refills { get; set; }
        
            public Manhattan() { }
        
            public Manhattan(Komus24.Model.Vec2Int size, Komus24.Model.Vec2Int blockSize, int refills)
            {
                this.Size = size;
                this.BlockSize = blockSize;
                this.Refills = refills;
            }
        
            /// <summary> Read Manhattan from reader </summary>
            public static new Manhattan ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Manhattan();
                result.Size = Komus24.Model.Vec2Int.ReadFrom(reader);
                result.BlockSize = Komus24.Model.Vec2Int.ReadFrom(reader);
                result.Refills = reader.ReadInt32();
                return result;
            }
        
            /// <summary> Write Manhattan to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                Size.WriteTo(writer);
                BlockSize.WriteTo(writer);
                writer.Write(Refills);
            }
        
            /// <summary> Get string representation of Manhattan </summary>
            public override string ToString() {
                string stringResult = "Manhattan { ";
                stringResult += "Size: ";
                stringResult += Size.ToString();
                stringResult += ", ";
                stringResult += "BlockSize: ";
                stringResult += BlockSize.ToString();
                stringResult += ", ";
                stringResult += "Refills: ";
                stringResult += Refills.ToString();
                stringResult += " }";
                return stringResult;
            }
        }

        /// <summary>
        /// TODO - Document
        /// </summary>
        public class Inline : CityType
        {
            public const int TAG = 1;
        
            /// <summary>
            /// TODO - Document
            /// </summary>
            public string[] Cells { get; set; }
        
            public Inline() { }
        
            public Inline(string[] cells)
            {
                this.Cells = cells;
            }
        
            /// <summary> Read Inline from reader </summary>
            public static new Inline ReadFrom(System.IO.BinaryReader reader)
            {
                var result = new Inline();
                result.Cells = new string[reader.ReadInt32()];
                for (int cellsIndex = 0; cellsIndex < result.Cells.Length; cellsIndex++)
                {
                    result.Cells[cellsIndex] = System.Text.Encoding.UTF8.GetString(reader.ReadBytes(reader.ReadInt32()));
                }
                return result;
            }
        
            /// <summary> Write Inline to writer </summary>
            public override void WriteTo(System.IO.BinaryWriter writer)
            {
                writer.Write(TAG);
                writer.Write(Cells.Length);
                foreach (var cellsElement in Cells)
                {
                    var cellsElementData = System.Text.Encoding.UTF8.GetBytes(cellsElement);
                    writer.Write(cellsElementData.Length);
                    writer.Write(cellsElementData);
                }
            }
        
            /// <summary> Get string representation of Inline </summary>
            public override string ToString() {
                string stringResult = "Inline { ";
                stringResult += "Cells: ";
                stringResult += "[ ";
                int cellsIndex = 0;
                foreach (var cellsElement in Cells)
                {
                    if (cellsIndex != 0) {
                        stringResult += ", ";
                    }
                    stringResult += "\"" + cellsElement + "\"";
                    cellsIndex++;
                }
                stringResult += " ]";
                stringResult += " }";
                return stringResult;
            }
        }
    }
}