use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub struct VehicleOrder {
    /// -1..+1
    pub accelerate: f64,
    /// TODO - Document
    pub brakes: bool,
    /// -1..+1
    pub rotate: f64,
}

impl trans::Trans for VehicleOrder {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.accelerate.write_to(writer)?;
        self.brakes.write_to(writer)?;
        self.rotate.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let accelerate: f64 = trans::Trans::read_from(reader)?;
        let brakes: bool = trans::Trans::read_from(reader)?;
        let rotate: f64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            accelerate,
            brakes,
            rotate,
        })
    }
}