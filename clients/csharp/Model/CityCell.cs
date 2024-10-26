namespace Komus24.Model
{
    /// <summary>
    /// City cell
    /// </summary>
    public enum CityCell
    {
        /// <summary>
        /// Road
        /// </summary>
        Road = 0,
        /// <summary>
        /// Building
        /// </summary>
        Building = 1,
        /// <summary>
        /// Refill station
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