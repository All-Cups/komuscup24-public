from stream_wrapper import StreamWrapper

class MinMaxRangeLong:
    """Range of values"""

    __slots__ = ("min","max",)

    min: int
    max: int

    def __init__(self, min: int, max: int):
        self.min = min
        """Minimal value"""
        self.max = max
        """Maximal  value"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "MinMaxRangeLong":
        """Read MinMaxRangeLong from input stream
        """
        min = stream.read_long()
        max = stream.read_long()
        return MinMaxRangeLong(min, max)
    
    def write_to(self, stream: StreamWrapper):
        """Write MinMaxRangeLong to output stream
        """
        stream.write_long(self.min)
        stream.write_long(self.max)
    
    def __repr__(self):
        return "MinMaxRangeLong(" + \
            repr(self.min) + \
            ", " + \
            repr(self.max) + \
            ")"