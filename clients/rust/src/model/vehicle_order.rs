use super::*;

/// Order for controlling a single vehicle
#[derive(Clone, Debug)]
pub struct VehicleOrder {
    /// Acceleration (-1 - fully backwards, +1 - fully forward)
    pub accelerate: f64,
    /// Hand brakes
    pub brakes: bool,
    /// Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
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