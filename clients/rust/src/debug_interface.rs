use komus24::*;

pub struct DebugInterface<'a> {
    reader: &'a mut dyn std::io::Read,
    writer: &'a mut dyn std::io::Write,
}

impl<'a> DebugInterface<'a> {
    pub fn new(reader: &'a mut dyn std::io::Read, writer: &'a mut dyn std::io::Write) -> Self {
        Self { reader, writer }
    }

    pub fn add_circle(&mut self, pos: model::Vec2F64, radius: f64) {
        self.add(model::DebugData::Circle { pos, radius });
    }

    pub fn add(&mut self, debug_data: model::DebugData) {
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

    pub fn get_state(&mut self) -> model::DebugState {
        use trans::Trans;
        codegame::ClientMessage::RequestDebugState {}
            .write_to(self.writer)
            .expect("Failed to write request debug state message");
        self.writer.flush().expect("Failed to flush");
        model::DebugState::read_from(self.reader).expect("Failed to read debug state")
    }
}