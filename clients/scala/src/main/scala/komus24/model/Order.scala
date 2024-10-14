package komus24.model

import komus24.util.StreamUtil

/**
 * Player's orders
 *
 * @param vehicles TODO - Document
 */
case class Order(vehicles: Seq[komus24.model.VehicleOrder]) {
    /**
     * Write Order to output stream
     */
    def writeTo(stream: java.io.OutputStream): scala.Unit = {
        StreamUtil.writeInt(stream, vehicles.length)
        vehicles.foreach { value =>
            value.writeTo(stream)
        }
    }

    /**
     * Get string representation of Order
     */
    override def toString(): String = {
        var stringBuilder = new StringBuilder("Order { ")
        stringBuilder.append("vehicles: ")
        stringBuilder.append(vehicles)
        stringBuilder.append(" }")
        stringBuilder.toString()
    }
}

object Order {
    /**
     * Read Order from input stream
     */
    def readFrom(stream: java.io.InputStream): Order = Order(
        (0 until StreamUtil.readInt(stream)).map { _ =>
            komus24.model.VehicleOrder.readFrom(stream)
        }
    )
}