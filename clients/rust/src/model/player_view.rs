use super::*;

/// Current game's state
#[derive(Clone, Debug)]
pub struct PlayerView {
    /// Current tick number
    pub current_tick: i32,
    /// Your player
    pub you: model::Player,
    /// Other players
    pub other: Vec<model::Player>,
    /// Available quests
    pub quests: Vec<model::Quest>,
}

impl trans::Trans for PlayerView {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.current_tick.write_to(writer)?;
        self.you.write_to(writer)?;
        self.other.write_to(writer)?;
        self.quests.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let current_tick: i32 = trans::Trans::read_from(reader)?;
        let you: model::Player = trans::Trans::read_from(reader)?;
        let other: Vec<model::Player> = trans::Trans::read_from(reader)?;
        let quests: Vec<model::Quest> = trans::Trans::read_from(reader)?;
        Ok(Self {
            current_tick,
            you,
            other,
            quests,
        })
    }
}