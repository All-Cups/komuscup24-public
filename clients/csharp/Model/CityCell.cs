namespace Komus24.Model
{
    /// <summary>
    /// TODO - Document
    /// </summary>
    public enum CityCell
    {
        /// <summary>
        /// TODO - Document
        /// </summary>
        Road = 0,
        /// <summary>
        /// TODO - Document
        /// </summary>
        Building = 1,
        /// <summary>
        /// TODO - Document
        /// </summary>
        RefillStation = 2,
    }

    public static class CityCellHelper {
        /// <summary> Read CityCell from reader </summary>
        public static CityCell ReadFrom(System.IO.BinaryReader reader) {
            switch (reader.ReadInt32())
            {
                case 0:
                    return CityCell.Road;
                case 1:
                    return CityCell.Building;
                case 2:
                    return CityCell.RefillStation;
                default:
                    throw new System.Exception("Unexpected tag value");
            }
        }
    }
}