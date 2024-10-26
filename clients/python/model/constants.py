from model.city_cell import CityCell
from model.city_type import CityType
from model.min_max_range_long import MinMaxRangeLong
from model.traffic import Traffic
from model.vehicle_type import VehicleType
from stream_wrapper import StreamWrapper
from typing import List

class Constants:
    """Game constants"""

    __slots__ = ("max_tick_count","max_game_time_seconds","ticks_per_second","microticks","cell_size","collision_bounciness","city_type","vehicle_types","refill_speed","quest_count","quest_score","traffic","collision_penalty_modifier","city",)

    max_tick_count: int
    max_game_time_seconds: float
    ticks_per_second: float
    microticks: int
    cell_size: float
    collision_bounciness: float
    city_type: CityType
    vehicle_types: List[VehicleType]
    refill_speed: float
    quest_count: int
    quest_score: MinMaxRangeLong
    traffic: Traffic
    collision_penalty_modifier: float
    city: List[List[CityCell]]

    def __init__(self, max_tick_count: int, max_game_time_seconds: float, ticks_per_second: float, microticks: int, cell_size: float, collision_bounciness: float, city_type: CityType, vehicle_types: List[VehicleType], refill_speed: float, quest_count: int, quest_score: MinMaxRangeLong, traffic: Traffic, collision_penalty_modifier: float, city: List[List[CityCell]]):
        self.max_tick_count = max_tick_count
        """Max duration of the game in ticks"""
        self.max_game_time_seconds = max_game_time_seconds
        """Max game time in seconds"""
        self.ticks_per_second = ticks_per_second
        """Ticks per second"""
        self.microticks = microticks
        """Subticks for physics simulation"""
        self.cell_size = cell_size
        """Size of a single city cell"""
        self.collision_bounciness = collision_bounciness
        """Collision bounciness"""
        self.city_type = city_type
        """City type"""
        self.vehicle_types = vehicle_types
        """List of vehicle types"""
        self.refill_speed = refill_speed
        """Speed of refueling at a station"""
        self.quest_count = quest_count
        """Number of available quests"""
        self.quest_score = quest_score
        """Score range for quests"""
        self.traffic = traffic
        """Traffic options"""
        self.collision_penalty_modifier = collision_penalty_modifier
        """Collision penalty modifier"""
        self.city = city
        """Map of the city"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Constants":
        """Read Constants from input stream
        """
        max_tick_count = stream.read_int()
        max_game_time_seconds = stream.read_double()
        ticks_per_second = stream.read_double()
        microticks = stream.read_int()
        cell_size = stream.read_double()
        collision_bounciness = stream.read_double()
        city_type = CityType.read_from(stream)
        vehicle_types = []
        for _ in range(stream.read_int()):
            vehicle_types_element = VehicleType.read_from(stream)
            vehicle_types.append(vehicle_types_element)
        refill_speed = stream.read_double()
        quest_count = stream.read_int()
        quest_score = MinMaxRangeLong.read_from(stream)
        traffic = Traffic.read_from(stream)
        collision_penalty_modifier = stream.read_double()
        city = []
        for _ in range(stream.read_int()):
            city_element = []
            for _ in range(stream.read_int()):
                city_element_element = CityCell(stream.read_int())
                city_element.append(city_element_element)
            city.append(city_element)
        return Constants(max_tick_count, max_game_time_seconds, ticks_per_second, microticks, cell_size, collision_bounciness, city_type, vehicle_types, refill_speed, quest_count, quest_score, traffic, collision_penalty_modifier, city)
    
    def write_to(self, stream: StreamWrapper):
        """Write Constants to output stream
        """
        stream.write_int(self.max_tick_count)
        stream.write_double(self.max_game_time_seconds)
        stream.write_double(self.ticks_per_second)
        stream.write_int(self.microticks)
        stream.write_double(self.cell_size)
        stream.write_double(self.collision_bounciness)
        self.city_type.write_to(stream)
        stream.write_int(len(self.vehicle_types))
        for element in self.vehicle_types:
            element.write_to(stream)
        stream.write_double(self.refill_speed)
        stream.write_int(self.quest_count)
        self.quest_score.write_to(stream)
        self.traffic.write_to(stream)
        stream.write_double(self.collision_penalty_modifier)
        stream.write_int(len(self.city))
        for element in self.city:
            stream.write_int(len(element))
            for element in element:
                stream.write_int(element)
    
    def __repr__(self):
        return "Constants(" + \
            repr(self.max_tick_count) + \
            ", " + \
            repr(self.max_game_time_seconds) + \
            ", " + \
            repr(self.ticks_per_second) + \
            ", " + \
            repr(self.microticks) + \
            ", " + \
            repr(self.cell_size) + \
            ", " + \
            repr(self.collision_bounciness) + \
            ", " + \
            repr(self.city_type) + \
            ", " + \
            repr(self.vehicle_types) + \
            ", " + \
            repr(self.refill_speed) + \
            ", " + \
            repr(self.quest_count) + \
            ", " + \
            repr(self.quest_score) + \
            ", " + \
            repr(self.traffic) + \
            ", " + \
            repr(self.collision_penalty_modifier) + \
            ", " + \
            repr(self.city) + \
            ")"