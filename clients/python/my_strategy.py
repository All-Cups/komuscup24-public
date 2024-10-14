from model.player_view import PlayerView
from model.order import Order
from model.vehicle_order import VehicleOrder
from stream_wrapper import StreamWrapper
from typing import List
from model.constants import Constants
from typing import Optional
from debug_interface import DebugInterface


class MyStrategy:
    def __init__(self, constants: Constants):
        pass
    def get_order(self, player_view: PlayerView, debug_interface: Optional[DebugInterface]) -> Order:
        return Order([])
    def debug_update(self, displayed_tick: int, debug_interface: DebugInterface):
        pass
    def finish(self):
        pass