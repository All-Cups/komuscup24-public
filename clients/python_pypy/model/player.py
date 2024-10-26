from model.vehicle import Vehicle
from stream_wrapper import StreamWrapper
from typing import List

class Player:
    """Player (game participant)"""

    __slots__ = ("index","score","vehicles",)

    index: int
    score: int
    vehicles: List[Vehicle]

    def __init__(self, index: int, score: int, vehicles: List[Vehicle]):
        self.index = index
        """Index"""
        self.score = score
        """Current score"""
        self.vehicles = vehicles
        """List of player's vehicles"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Player":
        """Read Player from input stream
        """
        index = stream.read_int()
        score = stream.read_long()
        vehicles = []
        for _ in range(stream.read_int()):
            vehicles_element = Vehicle.read_from(stream)
            vehicles.append(vehicles_element)
        return Player(index, score, vehicles)
    
    def write_to(self, stream: StreamWrapper):
        """Write Player to output stream
        """
        stream.write_int(self.index)
        stream.write_long(self.score)
        stream.write_int(len(self.vehicles))
        for element in self.vehicles:
            element.write_to(stream)
    
    def __repr__(self):
        return "Player(" + \
            repr(self.index) + \
            ", " + \
            repr(self.score) + \
            ", " + \
            repr(self.vehicles) + \
            ")"