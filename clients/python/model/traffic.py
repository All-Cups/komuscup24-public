from stream_wrapper import StreamWrapper

class Traffic:
    """TODO - Document"""

    __slots__ = ("amount","move_time","radius","weight","crash_deceleration","crash_lifetime",)

    amount: int
    move_time: float
    radius: float
    weight: float
    crash_deceleration: float
    crash_lifetime: float

    def __init__(self, amount: int, move_time: float, radius: float, weight: float, crash_deceleration: float, crash_lifetime: float):
        self.amount = amount
        """TODO - Document"""
        self.move_time = move_time
        """TODO - Document"""
        self.radius = radius
        """TODO - Document"""
        self.weight = weight
        """TODO - Document"""
        self.crash_deceleration = crash_deceleration
        """TODO - Document"""
        self.crash_lifetime = crash_lifetime
        """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Traffic":
        """Read Traffic from input stream
        """
        amount = stream.read_int()
        move_time = stream.read_double()
        radius = stream.read_double()
        weight = stream.read_double()
        crash_deceleration = stream.read_double()
        crash_lifetime = stream.read_double()
        return Traffic(amount, move_time, radius, weight, crash_deceleration, crash_lifetime)
    
    def write_to(self, stream: StreamWrapper):
        """Write Traffic to output stream
        """
        stream.write_int(self.amount)
        stream.write_double(self.move_time)
        stream.write_double(self.radius)
        stream.write_double(self.weight)
        stream.write_double(self.crash_deceleration)
        stream.write_double(self.crash_lifetime)
    
    def __repr__(self):
        return "Traffic(" + \
            repr(self.amount) + \
            ", " + \
            repr(self.move_time) + \
            ", " + \
            repr(self.radius) + \
            ", " + \
            repr(self.weight) + \
            ", " + \
            repr(self.crash_deceleration) + \
            ", " + \
            repr(self.crash_lifetime) + \
            ")"