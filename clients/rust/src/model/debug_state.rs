use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub struct DebugState {
    /// TODO - Document
    pub pressed_keys: Vec<String>,
}

impl trans::Trans for DebugState {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        self.pressed_keys.write_to(writer)?;
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let pressed_keys: Vec<String> = trans::Trans::read_from(reader)?;
        Ok(Self {
            pressed_keys,
        })
    }
}