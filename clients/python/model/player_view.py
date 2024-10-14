from model.player import Player
from model.quest import Quest
from stream_wrapper import StreamWrapper
from typing import List

class PlayerView:
    """Current game's state"""

    __slots__ = ("current_tick","you","other","quests",)

    current_tick: int
    you: Player
    other: List[Player]
    quests: List[Quest]

    def __init__(self, current_tick: int, you: Player, other: List[Player], quests: List[Quest]):
        self.current_tick = current_tick
        """Current tick number"""
        self.you = you
        """TODO - Document"""
        self.other = other
        """TODO - Document"""
        self.quests = quests
        """TODO - Document"""

    @staticmethod
    def read_from(stream: StreamWrapper) -> "PlayerView":
        """Read PlayerView from input stream
        """
        current_tick = stream.read_int()
        you = Player.read_from(stream)
        other = []
        for _ in range(stream.read_int()):
            other_element = Player.read_from(stream)
            other.append(other_element)
        quests = []
        for _ in range(stream.read_int()):
            quests_element = Quest.read_from(stream)
            quests.append(quests_element)
        return PlayerView(current_tick, you, other, quests)
    
    def write_to(self, stream: StreamWrapper):
        """Write PlayerView to output stream
        """
        stream.write_int(self.current_tick)
        self.you.write_to(stream)
        stream.write_int(len(self.other))
        for element in self.other:
            element.write_to(stream)
        stream.write_int(len(self.quests))
        for element in self.quests:
            element.write_to(stream)
    
    def __repr__(self):
        return "PlayerView(" + \
            repr(self.current_tick) + \
            ", " + \
            repr(self.you) + \
            ", " + \
            repr(self.other) + \
            ", " + \
            repr(self.quests) + \
            ")"