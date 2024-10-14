use crate::debug_interface::DebugInterface;
use komus24::*;

pub struct MyStrategy {}

impl MyStrategy {
    pub fn new(constants: model::Constants) -> Self {
        Self {}
    }
    pub fn get_order(
        &mut self,
        player_view: &model::PlayerView,
        debug_interface: Option<&mut DebugInterface>,
    ) -> model::Order {
        komus24::model::Order {
            vehicles: vec![],}
    }
    pub fn debug_update(
        &mut self,
        displayed_tick: i32,
        debug_interface: &mut DebugInterface,
    ) {}
    pub fn finish(&mut self) {}
}