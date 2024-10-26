use super::*;

/// A delivery quest
#[derive(Clone, Debug, PartialEq, Eq, Hash)]
pub struct Quest {
    /// Cell where to pick delivery from
    pub pickup_cell: model::Vec2I32,
    /// Cell to drop the delivery at
    pub drop_cell: model::Vec2I32,
    /// Score for completing the quest
    pub score: i64,
}

impl trans::Trans for Quest {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.pickup_cell.write_to(writer)?;
        self.drop_cell.write_to(writer)?;
        self.score.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let pickup_cell: model::Vec2I32 = trans::Trans::read_from(reader)?;
        let drop_cell: model::Vec2I32 = trans::Trans::read_from(reader)?;
        let score: i64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            pickup_cell,
            drop_cell,
            score,
        })
    }
}