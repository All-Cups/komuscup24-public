use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub struct VehicleType {
    /// TODO - Document
    pub name: String,
    /// TODO - Document
    pub radius: f64,
    /// TODO - Document
    pub weight: f64,
    /// TODO - Document
    pub max_backwards_speed: f64,
    /// TODO - Document
    pub max_speed: f64,
    /// TODO - Document
    pub acceleration: f64,
    /// TODO - Document
    pub friction: f64,
    /// TODO - Document
    pub max_rotate_speed: f64,
    /// TODO - Document
    pub rotate_acceleration: f64,
    /// TODO - Document
    pub max_fuel: f64,
    /// TODO - Document
    pub fuel_use_speed: f64,
}

impl trans::Trans for VehicleType {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.name.write_to(writer)?;
        self.radius.write_to(writer)?;
        self.weight.write_to(writer)?;
        self.max_backwards_speed.write_to(writer)?;
        self.max_speed.write_to(writer)?;
        self.acceleration.write_to(writer)?;
        self.friction.write_to(writer)?;
        self.max_rotate_speed.write_to(writer)?;
        self.rotate_acceleration.write_to(writer)?;
        self.max_fuel.write_to(writer)?;
        self.fuel_use_speed.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let name: String = trans::Trans::read_from(reader)?;
        let radius: f64 = trans::Trans::read_from(reader)?;
        let weight: f64 = trans::Trans::read_from(reader)?;
        let max_backwards_speed: f64 = trans::Trans::read_from(reader)?;
        let max_speed: f64 = trans::Trans::read_from(reader)?;
        let acceleration: f64 = trans::Trans::read_from(reader)?;
        let friction: f64 = trans::Trans::read_from(reader)?;
        let max_rotate_speed: f64 = trans::Trans::read_from(reader)?;
        let rotate_acceleration: f64 = trans::Trans::read_from(reader)?;
        let max_fuel: f64 = trans::Trans::read_from(reader)?;
        let fuel_use_speed: f64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            name,
            radius,
            weight,
            max_backwards_speed,
            max_speed,
            acceleration,
            friction,
            max_rotate_speed,
            rotate_acceleration,
            max_fuel,
            fuel_use_speed,
        })
    }
}