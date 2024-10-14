use super::*;

/// Player's orders
#[derive(Clone, Debug)]
pub struct Order {
    /// TODO - Document
    pub vehicles: Vec<model::VehicleOrder>,
}

impl trans::Trans for Order {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.vehicles.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let vehicles: Vec<model::VehicleOrder> = trans::Trans::read_from(reader)?;
        Ok(Self {
            vehicles,
        })
    }
}