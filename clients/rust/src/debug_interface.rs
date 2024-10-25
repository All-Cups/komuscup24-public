use komus24::*;

pub struct DebugInterface<'a> {
    reader: &'a mut dyn std::io::Read,
    writer: &'a mut dyn std::io::Write,
}

impl<'a> DebugInterface<'a> {
    pub fn new(reader: &'a mut dyn std::io::Read, writer: &'a mut dyn std::io::Write) -> Self {
        Self { reader, writer }
    }

    pub fn add_circle(&mut self, pos: model::Vec2F64, radius: f64, color: debugging::Color) {
        self.add(debugging::DebugData::Circle { pos, radius, color });
    }
    
    pub fn add_line(&mut self, point1: model::Vec2F64, point2: model::Vec2F64, width: f64, color: debugging::Color) {
        self.add(debugging::DebugData::Line { point1, point2, width, color });
    }
    
    pub fn add_rect(&mut self, corner1: model::Vec2F64, corner2: model::Vec2F64, color: debugging::Color) {
        self.add(debugging::DebugData::Rect { corner1, corner2, color });
    }
    
    pub fn add_text(&mut self, text: String, pos: model::Vec2F64, size: f64, align: f64, color: debugging::Color) {
        self.add(debugging::DebugData::Text { text, pos, size, align, color });
    }

    pub fn add(&mut self, debug_data: debugging::DebugData) {
        self.send(debugging::DebugCommand::Add { debug_data });
    }
    
    pub fn clear(&mut self) {
        self.send(debugging::DebugCommand::Clear {  });
    }
    
    pub fn set_auto_flush(&mut self, enable: bool) {
        self.send(debugging::DebugCommand::SetAutoFlush { enable });
    }
    
    pub fn flush(&mut self) {
        self.send(debugging::DebugCommand::Flush {  });
    }

    pub fn send(&mut self, command: debugging::DebugCommand) {
        use trans::Trans;
        codegame::ClientMessage::DebugMessage { command }
            .write_to(self.writer)
            .expect("Failed to write custom debug data");
        self.writer.flush().expect("Failed to flush");
    }

    pub fn get_state(&mut self) -> debugging::DebugState {
        use trans::Trans;
        codegame::ClientMessage::RequestDebugState {}
            .write_to(self.writer)
            .expect("Failed to write request debug state message");
        self.writer.flush().expect("Failed to flush");
        debugging::DebugState::read_from(self.reader).expect("Failed to read debug state")
    }
}