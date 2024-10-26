from model.vec2_int import Vec2Int
from stream_wrapper import StreamWrapper
from typing import List

class CityType:
    """City type"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "CityType":
        """Read CityType from input stream
        """
        tag = stream.read_int()
        if tag == Manhattan.TAG:
            return CityType.Manhattan.read_from(stream)
        if tag == Inline.TAG:
            return CityType.Inline.read_from(stream)
        raise Exception("Unexpected tag value")

class Manhattan(CityType):
    """Auto generated manhattan map"""

    TAG = 0

    __slots__ = ("size","block_size","refills",)

    size: Vec2Int
    block_size: Vec2Int
    refills: int

    def __init__(self, size: Vec2Int, block_size: Vec2Int, refills: int):
        self.size = size
        """Map size"""
        self.block_size = block_size
        """Size of a single block"""
        self.refills = refills
        """Number of refill stations"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Manhattan":
        """Read Manhattan from input stream
        """
        size = Vec2Int.read_from(stream)
        block_size = Vec2Int.read_from(stream)
        refills = stream.read_int()
        return Manhattan(size, block_size, refills)
    
    def write_to(self, stream: StreamWrapper):
        """Write Manhattan to output stream
        """
        stream.write_int(self.TAG)
        self.size.write_to(stream)
        self.block_size.write_to(stream)
        stream.write_int(self.refills)
    
    def __repr__(self):
        return "Manhattan(" + \
            repr(self.size) + \
            ", " + \
            repr(self.block_size) + \
            ", " + \
            repr(self.refills) + \
            ")"

CityType.Manhattan = Manhattan

class Inline(CityType):
    """Fixed map"""

    TAG = 1

    __slots__ = ("cells",)

    cells: List[str]

    def __init__(self, cells: List[str]):
        self.cells = cells
        """Each string represents a row in the city"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Inline":
        """Read Inline from input stream
        """
        cells = []
        for _ in range(stream.read_int()):
            cells_element = stream.read_string()
            cells.append(cells_element)
        return Inline(cells)
    
    def write_to(self, stream: StreamWrapper):
        """Write Inline to output stream
        """
        stream.write_int(self.TAG)
        stream.write_int(len(self.cells))
        for element in self.cells:
            stream.write_string(element)
    
    def __repr__(self):
        return "Inline(" + \
            repr(self.cells) + \
            ")"

CityType.Inline = Inline