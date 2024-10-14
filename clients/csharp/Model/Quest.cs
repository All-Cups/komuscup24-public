namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public struct Quest
    {
        /// <summary>
        /// TODO - Document
        /// </summary>
        public Komus24.Model.Vec2Int PickupCell { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public Komus24.Model.Vec2Int DropCell { get; set; }
        /// <summary>
        /// TODO - Document
        /// </summary>
        public long Score { get; set; }
    
        public Quest(Komus24.Model.Vec2Int pickupCell, Komus24.Model.Vec2Int dropCell, long score)
        {
            this.PickupCell = pickupCell;
            this.DropCell = dropCell;
            this.Score = score;
        }
    
        /// <summary> Read Quest from reader </summary>
        public static Quest ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Quest();
            result.PickupCell = Komus24.Model.Vec2Int.ReadFrom(reader);
            result.DropCell = Komus24.Model.Vec2Int.ReadFrom(reader);
            result.Score = reader.ReadInt64();
            return result;
        }
    
        /// <summary> Write Quest to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            PickupCell.WriteTo(writer);
            DropCell.WriteTo(writer);
            writer.Write(Score);
        }
    
        /// <summary> Get string representation of Quest </summary>
        public override string ToString() {
            string stringResult = "Quest { ";
            stringResult += "PickupCell: ";
            stringResult += PickupCell.ToString();
            stringResult += ", ";
            stringResult += "DropCell: ";
            stringResult += DropCell.ToString();
            stringResult += ", ";
            stringResult += "Score: ";
            stringResult += Score.ToString();
            stringResult += " }";
            return stringResult;
        }
    }
}