use super::*;

/// TODO - Document
#[derive(Clone, Debug)]
pub enum CityType {
    /// TODO - Document
    Manhattan {
        /// TODO - Document
        size: model::Vec2I32,
        /// TODO - Document
        block_size: model::Vec2I32,
        /// TODO - Document
        refills: i32,
    },
    /// TODO - Document
    Inline {
        /// TODO - Document
        cells: Vec<String>,
    },
}

impl trans::Trans for CityType {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        match self {
            Self::Manhattan {
                size,
                block_size,
                refills,
            } => {
                <i32 as trans::Trans>::write_to(&0, writer)?;
                size.write_to(writer)?;
                block_size.write_to(writer)?;
                refills.write_to(writer)?;
            }
            Self::Inline {
                cells,
            } => {
                <i32 as trans::Trans>::write_to(&1, writer)?;
                cells.write_to(writer)?;
            }
        }
        Ok(())
    }
    fn read_from(reader: &mut dyn std::io::Read) -> std::io::Result<Self> {
        let tag = <i32 as trans::Trans>::read_from(reader)?;
        match tag {
            0 => {
                let size: model::Vec2I32 = trans::Trans::read_from(reader)?;
                let block_size: model::Vec2I32 = trans::Trans::read_from(reader)?;
                let refills: i32 = trans::Trans::read_from(reader)?;
                Ok(Self::Manhattan {
                    size,
                    block_size,
                    refills,
                })
            }
            1 => {
                let cells: Vec<String> = trans::Trans::read_from(reader)?;
                Ok(Self::Inline {
                    cells,
                })
            }
            _ => Err(std::io::Error::new(
                std::io::ErrorKind::Other,
                format!("Unexpected tag {:?}", tag))),
        }
    }
}