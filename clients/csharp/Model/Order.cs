namespace Komus24.Model
{
    /// <summary>
    /// Player's orders
    /// </summary>
    public struct Order
    {
        /// <summary>
        /// Orders for each of the vehicles
        /// </summary>
        public Komus24.Model.VehicleOrder[] Vehicles { get; set; }
    
        public Order(Komus24.Model.VehicleOrder[] vehicles)
        {
            this.Vehicles = vehicles;
        }
    
        /// <summary> Read Order from reader </summary>
        public static Order ReadFrom(System.IO.BinaryReader reader)
        {
            var result = new Order();
            result.Vehicles = new Komus24.Model.VehicleOrder[reader.ReadInt32()];
            for (int vehiclesIndex = 0; vehiclesIndex < result.Vehicles.Length; vehiclesIndex++)
            {
                result.Vehicles[vehiclesIndex] = Komus24.Model.VehicleOrder.ReadFrom(reader);
            }
            return result;
        }
    
        /// <summary> Write Order to writer </summary>
        public void WriteTo(System.IO.BinaryWriter writer)
        {
            writer.Write(Vehicles.Length);
            foreach (var vehiclesElement in Vehicles)
            {
                vehiclesElement.WriteTo(writer);
            }
        }
    
        /// <summary> Get string representation of Order </summary>
        public override string ToString() {
            string stringResult = "Order { ";
            stringResult += "Vehicles: ";
            stringResult += "[ ";
            int vehiclesIndex = 0;
            foreach (var vehiclesElement in Vehicles)
            {
                if (vehiclesIndex != 0) {
                    stringResult += ", ";
                }
                stringResult += vehiclesElement.ToString();
                vehiclesIndex++;
            }
            stringResult += " ]";
            stringResult += " }";
            return stringResult;
        }
    }
}