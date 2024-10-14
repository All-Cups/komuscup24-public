package komus24.model;

import komus24.util.StreamUtil;

/**
 * Player's orders
 */
public class Order {
    /**
     * TODO - Document
     */
    private komus24.model.VehicleOrder[] vehicles;

    /**
     * TODO - Document
     */
    public komus24.model.VehicleOrder[] getVehicles() {
        return vehicles;
    }

    /**
     * TODO - Document
     */
    public void setVehicles(komus24.model.VehicleOrder[] value) {
        this.vehicles = value;
    }

    public Order(komus24.model.VehicleOrder[] vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Read Order from input stream
     */
    public static Order readFrom(java.io.InputStream stream) throws java.io.IOException {
        komus24.model.VehicleOrder[] vehicles;
        vehicles = new komus24.model.VehicleOrder[StreamUtil.readInt(stream)];
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            komus24.model.VehicleOrder vehiclesElement;
            vehiclesElement = komus24.model.VehicleOrder.readFrom(stream);
            vehicles[vehiclesIndex] = vehiclesElement;
        }
        return new Order(vehicles);
    }

    /**
     * Write Order to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, vehicles.length);
        for (komus24.model.VehicleOrder vehiclesElement : vehicles) {
            vehiclesElement.writeTo(stream);
        }
    }

    /**
     * Get string representation of Order
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Order { ");
        stringBuilder.append("vehicles: ");
        stringBuilder.append("[ ");
        for (int vehiclesIndex = 0; vehiclesIndex < vehicles.length; vehiclesIndex++) {
            if (vehiclesIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.VehicleOrder vehiclesElement = vehicles[vehiclesIndex];
            stringBuilder.append(String.valueOf(vehiclesElement));
        }
        stringBuilder.append(" ]");
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}