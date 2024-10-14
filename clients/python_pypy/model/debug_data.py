from model.vec2_double import Vec2Double
from stream_wrapper import StreamWrapper

class DebugData:
    """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "DebugData":
        """Read DebugData from input stream
        """
        tag = stream.read_int()
        if tag == Circle.TAG:
            return DebugData.Circle.read_from(stream)
        raise Exception("Unexpected tag value")

class Circle(DebugData):
    """TODO - Document"""

    TAG = 0

    __slots__ = ("pos","radius",)

    pos: Vec2Double
    radius: float

    def __init__(self, pos: Vec2Double, radius: float):
        self.pos = pos
        """TODO - Document"""
        self.radius = radius
        """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Circle":
        """Read Circle from input stream
        """
        pos = Vec2Double.read_from(stream)
        radius = stream.read_double()
        return Circle(pos, radius)
    
    def write_to(self, stream: StreamWrapper):
        """Write Circle to output stream
        """
        stream.write_int(self.TAG)
        self.pos.write_to(stream)
        stream.write_double(self.radius)
    
    def __repr__(self):
        return "Circle(" + \
            repr(self.pos) + \
            ", " + \
            repr(self.radius) + \
            ")"

DebugData.Circle = Circle