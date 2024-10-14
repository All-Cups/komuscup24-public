from enum import IntEnum

class CityCell(IntEnum):
    """TODO - Document"""

    ROAD = 0
    """TODO - Document"""
    BUILDING = 1
    """TODO - Document"""
    REFILL_STATION = 2
    """TODO - Document"""

    def __repr__(self):
        return str(self)