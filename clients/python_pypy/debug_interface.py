from codegame.client_message import ClientMessage
from debugging.debug_command import DebugCommand
from model.debug_state import DebugState
from model.debug_data import DebugData
from stream_wrapper import StreamWrapper
from model.vec2_double import Vec2Double
from stream_wrapper import StreamWrapper

class DebugInterface:
    def __init__(self, reader, writer):
        self.reader = reader
        self.writer = writer
        
    def add_circle(self, pos: Vec2Double, radius: float):
        self.add(DebugData.Circle(pos, radius))

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