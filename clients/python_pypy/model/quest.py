from model.vec2_int import Vec2Int
from stream_wrapper import StreamWrapper

class Quest:
    """TODO - Document"""

    __slots__ = ("pickup_cell","drop_cell","score",)

    pickup_cell: Vec2Int
    drop_cell: Vec2Int
    score: int

    def __init__(self, pickup_cell: Vec2Int, drop_cell: Vec2Int, score: int):
        self.pickup_cell = pickup_cell
        """TODO - Document"""
        self.drop_cell = drop_cell
        """TODO - Document"""
        self.score = score
        """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Quest":
        """Read Quest from input stream
        """
        pickup_cell = Vec2Int.read_from(stream)
        drop_cell = Vec2Int.read_from(stream)
        score = stream.read_long()
        return Quest(pickup_cell, drop_cell, score)
    
    def write_to(self, stream: StreamWrapper):
        """Write Quest to output stream
        """
        self.pickup_cell.write_to(stream)
        self.drop_cell.write_to(stream)
        stream.write_long(self.score)
    
    def __repr__(self):
        return "Quest(" + \
            repr(self.pickup_cell) + \
            ", " + \
            repr(self.drop_cell) + \
            ", " + \
            repr(self.score) + \
            ")"