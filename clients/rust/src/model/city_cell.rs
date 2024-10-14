use super::*;

/// TODO - Document
#[derive(Clone, Debug, PartialEq, Eq, Hash)]
pub enum CityCell {
    /// TODO - Document
    Road,
    /// TODO - Document
    Building,
    /// TODO - Document
    RefillStation,
}

impl trans::Trans for CityCell {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        let tag: i32 = match self {
            Self::Road => 0,
            Self::Building => 1,
            Self::RefillStation => 2,
        };
        trans::Trans::write_to(&tag, writer)
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let tag = <i32 as trans::Trans>::read_from(reader)?;
        match tag {
            0 => Ok(Self::Road),
            1 => Ok(Self::Building),
            2 => Ok(Self::RefillStation),
            _ => Err(std::io::Error::new(
                std::io::ErrorKind::Other,
                format!("Unexpected tag {:?}", tag))),
        }
    }
}