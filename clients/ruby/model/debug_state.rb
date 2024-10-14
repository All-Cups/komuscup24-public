module Model

# TODO - Document
class DebugState
    # TODO - Document
    attr_accessor :pressed_keys

    def initialize(pressed_keys)
        @pressed_keys = pressed_keys
    end

    # Read DebugState from input stream
    def self.read_from(stream)
        pressed_keys = []
        stream.read_int().times do |_|
            pressed_keys_element = stream.read_string()
            pressed_keys.push(pressed_keys_element)
        end
        DebugState.new(pressed_keys)
    end

    # Write DebugState to output stream
    def write_to(stream)
        stream.write_int(@pressed_keys.length())
        @pressed_keys.each do |pressed_keys_element|
            stream.write_string(pressed_keys_element)
        end
    end

    def to_s
        string_result = "DebugState { "
        string_result += "pressed_keys: "
        string_result += "[ "
        pressed_keys_index = 0
        @pressed_keys.each do |pressed_keys_element|
            if pressed_keys_index != 0
                string_result += ", "
            end
            string_result += pressed_keys_element.dump
            pressed_keys_index += 1
        end
        string_result += " ]"
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end