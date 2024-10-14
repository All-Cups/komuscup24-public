package komus24.model

import komus24.util.StreamUtil

/**
 * Player's orders
 */
class Order {
    /**
     * TODO - Document
     */
    var vehicles: Array<komus24.model.VehicleOrder>

    constructor(vehicles: Array<komus24.model.VehicleOrder>) {
        this.vehicles = vehicles
    }

    /**
     * Write Order to output stream
     */
    @Throws(java.io.IOException::class)
    fun writeTo(stream: java.io.OutputStream) {
        StreamUtil.writeInt(stream, vehicles.size)
        for (vehiclesElement in vehicles) {
            vehiclesElement.writeTo(stream)
        }
    }

    /**
     * Get string representation of Order
     */
    override fun toString(): String {
        var stringBuilder = StringBuilder("Order { ")
        stringBuilder.append("vehicles: ")
        stringBuilder.append("[ ")
        var vehiclesIndex = 0
        for (vehiclesElement in vehicles) {
            if (vehiclesIndex != 0) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(vehiclesElement)
            vehiclesIndex++
        }
        stringBuilder.append(" ]")
        stringBuilder.append(" }")
        return stringBuilder.toString()
    }

    companion object {
        /**
         * Read Order from input stream
         */
        @Throws(java.io.IOException::class)
        fun readFrom(stream: java.io.InputStream): Order {
            var vehicles: Array<komus24.model.VehicleOrder>
            vehicles = Array(StreamUtil.readInt(stream), {
                var vehiclesElement: komus24.model.VehicleOrder
                vehiclesElement = komus24.model.VehicleOrder.readFrom(stream)
                vehiclesElement
            })
            return Order(vehicles)
        }
    }
}