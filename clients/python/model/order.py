from model.vehicle_order import VehicleOrder
from stream_wrapper import StreamWrapper
from typing import List

class Order:
    """Player's orders"""

    __slots__ = ("vehicles",)

    vehicles: List[VehicleOrder]

    def __init__(self, vehicles: List[VehicleOrder]):
        self.vehicles = vehicles
        """Orders for each of the vehicles"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Order":
        """Read Order from input stream
        """
        vehicles = []
        for _ in range(stream.read_int()):
            vehicles_element = VehicleOrder.read_from(stream)
            vehicles.append(vehicles_element)
        return Order(vehicles)
    
    def write_to(self, stream: StreamWrapper):
        """Write Order to output stream
        """
        stream.write_int(len(self.vehicles))
        for element in self.vehicles:
            element.write_to(stream)
    
    def __repr__(self):
        return "Order(" + \
            repr(self.vehicles) + \
            ")"