use super::*;

/// Data for debug rendering
#[derive(Clone, Debug)]
pub enum DebugData {
    /// Circle
    Circle {
        /// Center
        pos: model::Vec2F64,
        /// Radius
        radius: f64,
        /// Color
        color: debugging::Color,
    },
    /// Line (segment)
    Line {
        /// First end
        point1: model::Vec2F64,
        /// Other end
        point2: model::Vec2F64,
        /// Thickness
        width: f64,
        /// Color
        color: debugging::Color,
    },
    /// Rectangle
    Rect {
        /// One of the corners
        corner1: model::Vec2F64,
        /// Opposite corner
        corner2: model::Vec2F64,
        /// Color
        color: debugging::Color,
    },
    /// Text
    Text {
        /// Text to draw
        text: String,
        /// Position
        pos: model::Vec2F64,
        /// Font size
        size: f64,
        /// Alignment (0 - left, 0.5 - center, 1 - right)
        align: f64,
        /// Color
        color: debugging::Color,
    },
}

impl trans::Trans for DebugData {
    fn write_to(&self, writer: &mut dyn std::io::Write) -> std::io::Result<()> {
        match self {
            Self::Circle {
                pos,
                radius,
                color,
            } => {
                <i32 as trans::Trans>::write_to(&0, writer)?;
                pos.write_to(writer)?;
                radius.write_to(writer)?;
                color.write_to(writer)?;
            }
            Self::Line {
                point1,
                point2,
                width,
                color,
            } => {
                <i32 as trans::Trans>::write_to(&1, writer)?;
                point1.write_to(writer)?;
                point2.write_to(writer)?;
                width.write_to(writer)?;
                color.write_to(writer)?;
            }
            Self::Rect {
                corner1,
                corner2,
                color,
            } => {
                <i32 as trans::Trans>::write_to(&2, writer)?;
                corner1.write_to(writer)?;
                corner2.write_to(writer)?;
                color.write_to(writer)?;
            }
            Self::Text {
                text,
                pos,
                size,
                align,
                color,
            } => {
                <i32 as trans::Trans>::write_to(&3, writer)?;
                text.write_to(writer)?;
                pos.write_to(writer)?;
                size.write_to(writer)?;
                align.write_to(writer)?;
                color.write_to(writer)?;
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
                let color: debugging::Color = trans::Trans::read_from(reader)?;
                Ok(Self::Circle {
                    pos,
                    radius,
                    color,
                })
            }
            1 => {
                let point1: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let point2: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let width: f64 = trans::Trans::read_from(reader)?;
                let color: debugging::Color = trans::Trans::read_from(reader)?;
                Ok(Self::Line {
                    point1,
                    point2,
                    width,
                    color,
                })
            }
            2 => {
                let corner1: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let corner2: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let color: debugging::Color = trans::Trans::read_from(reader)?;
                Ok(Self::Rect {
                    corner1,
                    corner2,
                    color,
                })
            }
            3 => {
                let text: String = trans::Trans::read_from(reader)?;
                let pos: model::Vec2F64 = trans::Trans::read_from(reader)?;
                let size: f64 = trans::Trans::read_from(reader)?;
                let align: f64 = trans::Trans::read_from(reader)?;
                let color: debugging::Color = trans::Trans::read_from(reader)?;
                Ok(Self::Text {
                    text,
                    pos,
                    size,
                    align,
                    color,
                })
            }
            _ => Err(std::io::Error::new(
                std::io::ErrorKind::Other,
                format!("Unexpected tag {:?}", tag))),
        }
    }
}