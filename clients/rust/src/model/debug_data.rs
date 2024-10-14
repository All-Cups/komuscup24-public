use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub enum DebugData {
    /// TODO - Document
    Circle {
        /// TODO - Document
        pos: model::Vec2F64,
        /// TODO - Document
        radius: f64,
    },
}

impl trans::Trans for DebugData {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        match self {
            Self::Circle {
                pos,
                radius,
            } => {
                <i32 as trans::Trans>::write_to(&0, writer)?;
                pos.write_to(writer)?;
                radius.write_to(writer)?;
            }
        }
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let tag = <i32 as trans::Trans>::read_from(reader)?;
        match tag {
            0 => {
                let pos: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let radius: f64 = trans::Trans::read_from(reader)?;
                Ok(Self::Circle {
                    pos,
                    radius,
                })
            }
            _ => Err(std::io::Error::new(
                std::io::ErrorKind::Other,
                format!("Unexpected tag {:?}", tag))),
        }
    }
}