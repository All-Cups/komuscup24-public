class DebugInterface
    def initialize(stream)
        @stream = stream
    end

    def add_circle(pos, radius)
        add(Model::DebugData::Circle.new(pos, radius))
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
        return Model::DebugState.read_from(@stream)
    end
end