use super::*;

/// Game constants
#[derive(Clone, Debug)]
pub struct Constants {
    /// Max duration of the game in ticks
    pub max_tick_count: i32,
    /// Max game time in seconds
    pub max_game_time_seconds: f64,
    /// Ticks per second
    pub ticks_per_second: f64,
    /// Subticks for physics simulation
    pub microticks: i32,
    /// Size of a single city cell
    pub cell_size: f64,
    /// Collision bounciness
    pub collision_bounciness: f64,
    /// City type
    pub city_type: model::CityType,
    /// List of vehicle types
    pub vehicle_types: Vec<model::VehicleType>,
    /// Speed of refueling at a station
    pub refill_speed: f64,
    /// Number of available quests
    pub quest_count: i32,
    /// Score range for quests
    pub quest_score: model::MinMaxRangeI64,
    /// Traffic options
    pub traffic: model::Traffic,
    /// Collision penalty modifier
    pub collision_penalty_modifier: f64,
    /// Map of the city
    pub city: Vec<Vec<model::CityCell>>,
}

impl trans::Trans for Constants {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.max_tick_count.write_to(writer)?;
        self.max_game_time_seconds.write_to(writer)?;
        self.ticks_per_second.write_to(writer)?;
        self.microticks.write_to(writer)?;
        self.cell_size.write_to(writer)?;
        self.collision_bounciness.write_to(writer)?;
        self.city_type.write_to(writer)?;
        self.vehicle_types.write_to(writer)?;
        self.refill_speed.write_to(writer)?;
        self.quest_count.write_to(writer)?;
        self.quest_score.write_to(writer)?;
        self.traffic.write_to(writer)?;
        self.collision_penalty_modifier.write_to(writer)?;
        self.city.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let max_tick_count: i32 = trans::Trans::read_from(reader)?;
        let max_game_time_seconds: f64 = trans::Trans::read_from(reader)?;
        let ticks_per_second: f64 = trans::Trans::read_from(reader)?;
        let microticks: i32 = trans::Trans::read_from(reader)?;
        let cell_size: f64 = trans::Trans::read_from(reader)?;
        let collision_bounciness: f64 = trans::Trans::read_from(reader)?;
        let city_type: model::CityType = trans::Trans::read_from(reader)?;
        let vehicle_types: Vec<model::VehicleType> = trans::Trans::read_from(reader)?;
        let refill_speed: f64 = trans::Trans::read_from(reader)?;
        let quest_count: i32 = trans::Trans::read_from(reader)?;
        let quest_score: model::MinMaxRangeI64 = trans::Trans::read_from(reader)?;
        let traffic: model::Traffic = trans::Trans::read_from(reader)?;
        let collision_penalty_modifier: f64 = trans::Trans::read_from(reader)?;
        let city: Vec<Vec<model::CityCell>> = trans::Trans::read_from(reader)?;
        Ok(Self {
            max_tick_count,
            max_game_time_seconds,
            ticks_per_second,
            microticks,
            cell_size,
            collision_bounciness,
            city_type,
            vehicle_types,
            refill_speed,
            quest_count,
            quest_score,
            traffic,
            collision_penalty_modifier,
            city,
        })
    }
}