from stream_wrapper import StreamWrapper

class VehicleOrder:
    """TODO - Document"""

    __slots__ = ("accelerate","brakes","rotate",)

    accelerate: float
    brakes: bool
    rotate: float

    def __init__(self, accelerate: float, brakes: bool, rotate: float):
        self.accelerate = accelerate
        """-1..+1"""
        self.brakes = brakes
        """TODO - Document"""
        self.rotate = rotate
        """-1..+1"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "VehicleOrder":
        """Read VehicleOrder from input stream
        """
        accelerate = stream.read_double()
        brakes = stream.read_bool()
        rotate = stream.read_double()
        return VehicleOrder(accelerate, brakes, rotate)
    
    def write_to(self, stream: StreamWrapper):
        """Write VehicleOrder to output stream
        """
        stream.write_double(self.accelerate)
        stream.write_bool(self.brakes)
        stream.write_double(self.rotate)
    
    def __repr__(self):
        return "VehicleOrder(" + \
            repr(self.accelerate) + \
            ", " + \
            repr(self.brakes) + \
            ", " + \
            repr(self.rotate) + \
            ")"