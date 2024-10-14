from model.quest import Quest
from model.vec2_double import Vec2Double
from stream_wrapper import StreamWrapper
from typing import Optional

class Vehicle:
    """TODO - Document"""

    __slots__ = ("position","velocity","speed","rotation_speed","rotation","type_index","quest","fuel",)

    position: Vec2Double
    velocity: Vec2Double
    speed: float
    rotation_speed: float
    rotation: float
    type_index: int
    quest: Optional[Quest]
    fuel: float

    def __init__(self, position: Vec2Double, velocity: Vec2Double, speed: float, rotation_speed: float, rotation: float, type_index: int, quest: Optional[Quest], fuel: float):
        self.position = position
        """TODO - Document"""
        self.velocity = velocity
        """TODO - Document"""
        self.speed = speed
        """TODO - Document"""
        self.rotation_speed = rotation_speed
        """TODO - Document"""
        self.rotation = rotation
        """TODO - Document"""
        self.type_index = type_index
        """TODO - Document"""
        self.quest = quest
        """TODO maybe multiple quests at the same time?"""
        self.fuel = fuel
        """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Vehicle":
        """Read Vehicle from input stream
        """
        position = Vec2Double.read_from(stream)
        velocity = Vec2Double.read_from(stream)
        speed = stream.read_double()
        rotation_speed = stream.read_double()
        rotation = stream.read_double()
        type_index = stream.read_int()
        if stream.read_bool():
            quest = Quest.read_from(stream)
        else:
            quest = None
        fuel = stream.read_double()
        return Vehicle(position, velocity, speed, rotation_speed, rotation, type_index, quest, fuel)
    
    def write_to(self, stream: StreamWrapper):
        """Write Vehicle to output stream
        """
        self.position.write_to(stream)
        self.velocity.write_to(stream)
        stream.write_double(self.speed)
        stream.write_double(self.rotation_speed)
        stream.write_double(self.rotation)
        stream.write_int(self.type_index)
        if self.quest is None:
            stream.write_bool(False)
        else:
            stream.write_bool(True)
            self.quest.write_to(stream)
        stream.write_double(self.fuel)
    
    def __repr__(self):
        return "Vehicle(" + \
            repr(self.position) + \
            ", " + \
            repr(self.velocity) + \
            ", " + \
            repr(self.speed) + \
            ", " + \
            repr(self.rotation_speed) + \
            ", " + \
            repr(self.rotation) + \
            ", " + \
            repr(self.type_index) + \
            ", " + \
            repr(self.quest) + \
            ", " + \
            repr(self.fuel) + \
            ")"