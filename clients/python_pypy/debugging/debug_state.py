from stream_wrapper import StreamWrapper
from typing import List

class DebugState:
    """App state for debugging"""

    __slots__ = ("pressed_keys",)

    pressed_keys: List[str]

    def __init__(self, pressed_keys: List[str]):
        self.pressed_keys = pressed_keys
        """Currently pressed keys"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "DebugState":
        """Read DebugState from input stream
        """
        pressed_keys = []
        for _ in range(stream.read_int()):
            pressed_keys_element = stream.read_string()
            pressed_keys.append(pressed_keys_element)
        return DebugState(pressed_keys)
    
    def write_to(self, stream: StreamWrapper):
        """Write DebugState to output stream
        """
        stream.write_int(len(self.pressed_keys))
        for element in self.pressed_keys:
            stream.write_string(element)
    
    def __repr__(self):
        return "DebugState(" + \
            repr(self.pressed_keys) + \
            ")"