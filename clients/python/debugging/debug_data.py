from debugging.color import Color
from model.vec2_double import Vec2Double
from stream_wrapper import StreamWrapper

class DebugData:
    """Data for debug rendering"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "DebugData":
        """Read DebugData from input stream
        """
        tag = stream.read_int()
        if tag == Circle.TAG:
            return DebugData.Circle.read_from(stream)
        if tag == Line.TAG:
            return DebugData.Line.read_from(stream)
        if tag == Rect.TAG:
            return DebugData.Rect.read_from(stream)
        if tag == Text.TAG:
            return DebugData.Text.read_from(stream)
        raise Exception("Unexpected tag value")

class Circle(DebugData):
    """Circle"""

    TAG = 0

    __slots__ = ("pos","radius","color",)

    pos: Vec2Double
    radius: float
    color: Color

    def __init__(self, pos: Vec2Double, radius: float, color: Color):
        self.pos = pos
        """Center"""
        self.radius = radius
        """Radius"""
        self.color = color
        """Color"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Circle":
        """Read Circle from input stream
        """
        pos = Vec2Double.read_from(stream)
        radius = stream.read_double()
        color = Color.read_from(stream)
        return Circle(pos, radius, color)
    
    def write_to(self, stream: StreamWrapper):
        """Write Circle to output stream
        """
        stream.write_int(self.TAG)
        self.pos.write_to(stream)
        stream.write_double(self.radius)
        self.color.write_to(stream)
    
    def __repr__(self):
        return "Circle(" + \
            repr(self.pos) + \
            ", " + \
            repr(self.radius) + \
            ", " + \
            repr(self.color) + \
            ")"

DebugData.Circle = Circle

class Line(DebugData):
    """Line (segment)"""

    TAG = 1

    __slots__ = ("point1","point2","width","color",)

    point1: Vec2Double
    point2: Vec2Double
    width: float
    color: Color

    def __init__(self, point1: Vec2Double, point2: Vec2Double, width: float, color: Color):
        self.point1 = point1
        """First end"""
        self.point2 = point2
        """Other end"""
        self.width = width
        """Thickness"""
        self.color = color
        """Color"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Line":
        """Read Line from input stream
        """
        point1 = Vec2Double.read_from(stream)
        point2 = Vec2Double.read_from(stream)
        width = stream.read_double()
        color = Color.read_from(stream)
        return Line(point1, point2, width, color)
    
    def write_to(self, stream: StreamWrapper):
        """Write Line to output stream
        """
        stream.write_int(self.TAG)
        self.point1.write_to(stream)
        self.point2.write_to(stream)
        stream.write_double(self.width)
        self.color.write_to(stream)
    
    def __repr__(self):
        return "Line(" + \
            repr(self.point1) + \
            ", " + \
            repr(self.point2) + \
            ", " + \
            repr(self.width) + \
            ", " + \
            repr(self.color) + \
            ")"

DebugData.Line = Line

class Rect(DebugData):
    """Rectangle"""

    TAG = 2

    __slots__ = ("corner1","corner2","color",)

    corner1: Vec2Double
    corner2: Vec2Double
    color: Color

    def __init__(self, corner1: Vec2Double, corner2: Vec2Double, color: Color):
        self.corner1 = corner1
        """One of the corners"""
        self.corner2 = corner2
        """Opposite corner"""
        self.color = color
        """Color"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Rect":
        """Read Rect from input stream
        """
        corner1 = Vec2Double.read_from(stream)
        corner2 = Vec2Double.read_from(stream)
        color = Color.read_from(stream)
        return Rect(corner1, corner2, color)
    
    def write_to(self, stream: StreamWrapper):
        """Write Rect to output stream
        """
        stream.write_int(self.TAG)
        self.corner1.write_to(stream)
        self.corner2.write_to(stream)
        self.color.write_to(stream)
    
    def __repr__(self):
        return "Rect(" + \
            repr(self.corner1) + \
            ", " + \
            repr(self.corner2) + \
            ", " + \
            repr(self.color) + \
            ")"

DebugData.Rect = Rect

class Text(DebugData):
    """Text"""

    TAG = 3

    __slots__ = ("text","pos","size","align","color",)

    text: str
    pos: Vec2Double
    size: float
    align: float
    color: Color

    def __init__(self, text: str, pos: Vec2Double, size: float, align: float, color: Color):
        self.text = text
        """Text to draw"""
        self.pos = pos
        """Position"""
        self.size = size
        """Font size"""
        self.align = align
        """Alignment (0 - left, 0.5 - center, 1 - right)"""
        self.color = color
        """Color"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "Text":
        """Read Text from input stream
        """
        text = stream.read_string()
        pos = Vec2Double.read_from(stream)
        size = stream.read_double()
        align = stream.read_double()
        color = Color.read_from(stream)
        return Text(text, pos, size, align, color)
    
    def write_to(self, stream: StreamWrapper):
        """Write Text to output stream
        """
        stream.write_int(self.TAG)
        stream.write_string(self.text)
        self.pos.write_to(stream)
        stream.write_double(self.size)
        stream.write_double(self.align)
        self.color.write_to(stream)
    
    def __repr__(self):
        return "Text(" + \
            repr(self.text) + \
            ", " + \
            repr(self.pos) + \
            ", " + \
            repr(self.size) + \
            ", " + \
            repr(self.align) + \
            ", " + \
            repr(self.color) + \
            ")"

DebugData.Text = Text