use super::*;

/// TODO - Document
#[derive(Clone, Debug, PartialEq, Eq, Hash)]
pub struct MinMaxRangeI64 {
    /// TODO - Document
    pub min: i64,
    /// TODO - Document
    pub max: i64,
}

impl trans::Trans for MinMaxRangeI64 {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.min.write_to(writer)?;
        self.max.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let min: i64 = trans::Trans::read_from(reader)?;
        let max: i64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            min,
            max,
        })
    }
}