from codegame.client_message import ClientMessage
from debugging.debug_command import DebugCommand
from debugging.debug_state import DebugState
from debugging.debug_data import DebugData
from stream_wrapper import StreamWrapper
from debugging.color import Color
from model.vec2_double import Vec2Double
from stream_wrapper import StreamWrapper

class DebugInterface:
    def __init__(self, reader, writer):
        self.reader = reader
        self.writer = writer
        
    def add_circle(self, pos: Vec2Double, radius: float, color: Color):
        self.add(DebugData.Circle(pos, radius, color))
    
    def add_line(self, point1: Vec2Double, point2: Vec2Double, width: float, color: Color):
        self.add(DebugData.Line(point1, point2, width, color))
    
    def add_rect(self, corner1: Vec2Double, corner2: Vec2Double, color: Color):
        self.add(DebugData.Rect(corner1, corner2, color))
    
    def add_text(self, text: str, pos: Vec2Double, size: float, align: float, color: Color):
        self.add(DebugData.Text(text, pos, size, align, color))

    def add(self, debug_data: DebugData):
        self.send(DebugCommand.Add(debug_data))
    
    def clear(self):
        self.send(DebugCommand.Clear())
    
    def set_auto_flush(self, enable: bool):
        self.send(DebugCommand.SetAutoFlush(enable))
    
    def flush(self):
        self.send(DebugCommand.Flush())

    def send(self, command: DebugCommand):
        ClientMessage.DebugMessage(command).write_to(self.writer)
        self.writer.flush()

    def get_state(self) -> DebugState:
        ClientMessage.RequestDebugState().write_to(self.writer)
        self.writer.flush()
        return DebugState.read_from(self.reader)