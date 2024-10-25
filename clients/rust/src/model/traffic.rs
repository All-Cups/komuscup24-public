use super::*;

/// Options for traffic
#[derive(Clone, Debug)]
pub struct Traffic {
    /// Number of traffic cars
    pub amount: i32,
    /// Time to move between adjacent keypoints
    pub move_time: f64,
    /// Radius of each traffic car
    pub radius: f64,
    /// Weight of each traffic car
    pub weight: f64,
    /// Deceleration after crash
    pub crash_deceleration: f64,
    /// Lifetime after crash
    pub crash_lifetime: f64,
}

impl trans::Trans for Traffic {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.amount.write_to(writer)?;
        self.move_time.write_to(writer)?;
        self.radius.write_to(writer)?;
        self.weight.write_to(writer)?;
        self.crash_deceleration.write_to(writer)?;
        self.crash_lifetime.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let amount: i32 = trans::Trans::read_from(reader)?;
        let move_time: f64 = trans::Trans::read_from(reader)?;
        let radius: f64 = trans::Trans::read_from(reader)?;
        let weight: f64 = trans::Trans::read_from(reader)?;
        let crash_deceleration: f64 = trans::Trans::read_from(reader)?;
        let crash_lifetime: f64 = trans::Trans::read_from(reader)?;
        Ok(Self {
            amount,
            move_time,
            radius,
            weight,
            crash_deceleration,
            crash_lifetime,
        })
    }
}