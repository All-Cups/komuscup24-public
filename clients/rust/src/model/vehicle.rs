use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub struct Vehicle {
    /// TODO - Document
    pub position: model::Vec2F64,
    /// TODO - Document
    pub velocity: model::Vec2F64,
    /// TODO - Document
    pub speed: f64,
    /// TODO - Document
    pub rotation_speed: f64,
    /// TODO - Document
    pub rotation: f64,
    /// TODO - Document
    pub type_index: i32,
    /// TODO maybe multiple quests at the same time?
    pub quest: Option<model::Quest>,
    /// TODO - Document
    pub fuel: f64,
}

impl trans::Trans for Vehicle {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.position.write_to(writer)?;
        self.velocity.write_to(writer)?;
        self.speed.write_to(writer)?;
        self.rotation_speed.write_to(writer)?;
        self.rotation.write_to(writer)?;
        self.type_index.write_to(writer)?;
        self.quest.write_to(writer)?;
        self.fuel.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let position: model::Vec2F64 = trans::Trans::read_from(reader)?;
        let velocity: model::Vec2F64 = trans::Trans::read_from(reader)?;
        let speed: f64 = trans::Trans::read_from(reader)?;
        let rotation_speed: f64 = trans::Trans::read_from(reader)?;
        let rotation: f64 = trans::Trans::read_from(reader)?;
        let type_index: i32 = trans::Trans::read_from(reader)?;
        let quest: Option<model::Quest> = trans::Trans::read_from(reader)?;
        let fuel: f64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            position,
            velocity,
            speed,
            rotation_speed,
            rotation,
            type_index,
            quest,
            fuel,
        })
    }
}