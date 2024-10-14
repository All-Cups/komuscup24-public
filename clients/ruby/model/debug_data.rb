require './model/vec2_double'

module Model

# TODO - Document
class DebugData
    # Read DebugData from input stream
    def self.read_from(stream)
        tag = stream.read_int()
        if tag == DebugData::Circle::TAG
            return DebugData::Circle.read_from(stream)
        end
        raise "Unexpected tag value"
    end

    # TODO - Document
    class Circle
        TAG = 0
    
        # TODO - Document
        attr_accessor :pos
        # TODO - Document
        attr_accessor :radius
    
        def initialize(pos, radius)
            @pos = pos
            @radius = radius
        end
    
        # Read Circle from input stream
        def self.read_from(stream)
            pos = Model::Vec2Double.read_from(stream)
            radius = stream.read_double()
            Circle.new(pos, radius)
        end
    
        # Write Circle to output stream
        def write_to(stream)
            stream.write_int(TAG)
            @pos.write_to(stream)
            stream.write_double(@radius)
        end
    
        def to_s
            string_result = "Circle { "
            string_result += "pos: "
            string_result += @pos.to_s
            string_result += ", "
            string_result += "radius: "
            string_result += @radius.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
end

end