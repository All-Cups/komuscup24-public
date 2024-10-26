class DebugInterface
    def initialize(stream)
        @stream = stream
    end

    def add_circle(pos, radius, color)
        add(Debugging::DebugData::Circle.new(pos, radius, color))
    end
    
    def add_line(point1, point2, width, color)
        add(Debugging::DebugData::Line.new(point1, point2, width, color))
    end
    
    def add_rect(corner1, corner2, color)
        add(Debugging::DebugData::Rect.new(corner1, corner2, color))
    end
    
    def add_text(text, pos, size, align, color)
        add(Debugging::DebugData::Text.new(text, pos, size, align, color))
    end

    def add(debug_data)
        send(Debugging::DebugCommand::Add.new(debug_data))
    end
    
    def clear()
        send(Debugging::DebugCommand::Clear.new())
    end
    
    def set_auto_flush(enable)
        send(Debugging::DebugCommand::SetAutoFlush.new(enable))
    end
    
    def flush()
        send(Debugging::DebugCommand::Flush.new())
    end

    def send(command)
        Codegame::ClientMessage::DebugMessage.new(command).write_to(@stream)
        @stream.flush()
    end

    def get_state()
        Codegame::ClientMessage::RequestDebugState.new().write_to(@stream)
        @stream.flush()
        return Debugging::DebugState.read_from(@stream)
    end
end