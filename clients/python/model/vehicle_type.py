from stream_wrapper import StreamWrapper

class VehicleType:
    """Vehicle type options"""

    __slots__ = ("name","radius","weight","max_backwards_speed","max_speed","acceleration","friction","max_rotate_speed","rotate_acceleration","max_fuel","fuel_use_speed",)

    name: str
    radius: float
    weight: float
    max_backwards_speed: float
    max_speed: float
    acceleration: float
    friction: float
    max_rotate_speed: float
    rotate_acceleration: float
    max_fuel: float
    fuel_use_speed: float

    def __init__(self, name: str, radius: float, weight: float, max_backwards_speed: float, max_speed: float, acceleration: float, friction: float, max_rotate_speed: float, rotate_acceleration: float, max_fuel: float, fuel_use_speed: float):
        self.name = name
        """Name"""
        self.radius = radius
        """Radius"""
        self.weight = weight
        """Weight"""
        self.max_backwards_speed = max_backwards_speed
        """Maximal backwads movement speed"""
        self.max_speed = max_speed
        """Maximal forward movement speed"""
        self.acceleration = acceleration
        """Acceleration"""
        self.friction = friction
        """Friction coefficient"""
        self.max_rotate_speed = max_rotate_speed
        """Maximal rotation speed"""
        self.rotate_acceleration = rotate_acceleration
        """Rotational acceleration"""
        self.max_fuel = max_fuel
        """Maximal amount of fuel"""
        self.fuel_use_speed = fuel_use_speed
        """Fuel usage speed"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "VehicleType":
        """Read VehicleType from input stream
        """
        name = stream.read_string()
        radius = stream.read_double()
        weight = stream.read_double()
        max_backwards_speed = stream.read_double()
        max_speed = stream.read_double()
        acceleration = stream.read_double()
        friction = stream.read_double()
        max_rotate_speed = stream.read_double()
        rotate_acceleration = stream.read_double()
        max_fuel = stream.read_double()
        fuel_use_speed = stream.read_double()
        return VehicleType(name, radius, weight, max_backwards_speed, max_speed, acceleration, friction, max_rotate_speed, rotate_acceleration, max_fuel, fuel_use_speed)
    
    def write_to(self, stream: StreamWrapper):
        """Write VehicleType to output stream
        """
        stream.write_string(self.name)
        stream.write_double(self.radius)
        stream.write_double(self.weight)
        stream.write_double(self.max_backwards_speed)
        stream.write_double(self.max_speed)
        stream.write_double(self.acceleration)
        stream.write_double(self.friction)
        stream.write_double(self.max_rotate_speed)
        stream.write_double(self.rotate_acceleration)
        stream.write_double(self.max_fuel)
        stream.write_double(self.fuel_use_speed)
    
    def __repr__(self):
        return "VehicleType(" + \
            repr(self.name) + \
            ", " + \
            repr(self.radius) + \
            ", " + \
            repr(self.weight) + \
            ", " + \
            repr(self.max_backwards_speed) + \
            ", " + \
            repr(self.max_speed) + \
            ", " + \
            repr(self.acceleration) + \
            ", " + \
            repr(self.friction) + \
            ", " + \
            repr(self.max_rotate_speed) + \
            ", " + \
            repr(self.rotate_acceleration) + \
            ", " + \
            repr(self.max_fuel) + \
            ", " + \
            repr(self.fuel_use_speed) + \
            ")"