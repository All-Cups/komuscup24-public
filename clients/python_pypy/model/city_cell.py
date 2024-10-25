from enum import IntEnum

class CityCell(IntEnum):
    """City cell"""

    ROAD = 0
    """Road"""
    BUILDING = 1
    """Building"""
    REFILL_STATION = 2
    """Refill station"""

    def __repr__(self):
        return str(self)