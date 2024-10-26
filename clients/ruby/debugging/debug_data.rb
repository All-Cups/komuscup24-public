require './debugging/color'
require './model/vec2_double'

module Debugging

# Data for debug rendering
class DebugData
    # Read DebugData from input stream
    def self.read_from(stream)
        tag = stream.read_int()
        if tag == DebugData::Circle::TAG
            return DebugData::Circle.read_from(stream)
        end
        if tag == DebugData::Line::TAG
            return DebugData::Line.read_from(stream)
        end
        if tag == DebugData::Rect::TAG
            return DebugData::Rect.read_from(stream)
        end
        if tag == DebugData::Text::TAG
            return DebugData::Text.read_from(stream)
        end
        raise "Unexpected tag value"
    end

    # Circle
    class Circle
        TAG = 0
    
        # Center
        attr_accessor :pos
        # Radius
        attr_accessor :radius
        # Color
        attr_accessor :color
    
        def initialize(pos, radius, color)
            @pos = pos
            @radius = radius
            @color = color
        end
    
        # Read Circle from input stream
        def self.read_from(stream)
            pos = Model::Vec2Double.read_from(stream)
            radius = stream.read_double()
            color = Debugging::Color.read_from(stream)
            Circle.new(pos, radius, color)
        end
    
        # Write Circle to output stream
        def write_to(stream)
            stream.write_int(TAG)
            @pos.write_to(stream)
            stream.write_double(@radius)
            @color.write_to(stream)
        end
    
        def to_s
            string_result = "Circle { "
            string_result += "pos: "
            string_result += @pos.to_s
            string_result += ", "
            string_result += "radius: "
            string_result += @radius.to_s
            string_result += ", "
            string_result += "color: "
            string_result += @color.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
    # Line (segment)
    class Line
        TAG = 1
    
        # First end
        attr_accessor :point1
        # Other end
        attr_accessor :point2
        # Thickness
        attr_accessor :width
        # Color
        attr_accessor :color
    
        def initialize(point1, point2, width, color)
            @point1 = point1
            @point2 = point2
            @width = width
            @color = color
        end
    
        # Read Line from input stream
        def self.read_from(stream)
            point1 = Model::Vec2Double.read_from(stream)
            point2 = Model::Vec2Double.read_from(stream)
            width = stream.read_double()
            color = Debugging::Color.read_from(stream)
            Line.new(point1, point2, width, color)
        end
    
        # Write Line to output stream
        def write_to(stream)
            stream.write_int(TAG)
            @point1.write_to(stream)
            @point2.write_to(stream)
            stream.write_double(@width)
            @color.write_to(stream)
        end
    
        def to_s
            string_result = "Line { "
            string_result += "point1: "
            string_result += @point1.to_s
            string_result += ", "
            string_result += "point2: "
            string_result += @point2.to_s
            string_result += ", "
            string_result += "width: "
            string_result += @width.to_s
            string_result += ", "
            string_result += "color: "
            string_result += @color.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
    # Rectangle
    class Rect
        TAG = 2
    
        # One of the corners
        attr_accessor :corner1
        # Opposite corner
        attr_accessor :corner2
        # Color
        attr_accessor :color
    
        def initialize(corner1, corner2, color)
            @corner1 = corner1
            @corner2 = corner2
            @color = color
        end
    
        # Read Rect from input stream
        def self.read_from(stream)
            corner1 = Model::Vec2Double.read_from(stream)
            corner2 = Model::Vec2Double.read_from(stream)
            color = Debugging::Color.read_from(stream)
            Rect.new(corner1, corner2, color)
        end
    
        # Write Rect to output stream
        def write_to(stream)
            stream.write_int(TAG)
            @corner1.write_to(stream)
            @corner2.write_to(stream)
            @color.write_to(stream)
        end
    
        def to_s
            string_result = "Rect { "
            string_result += "corner1: "
            string_result += @corner1.to_s
            string_result += ", "
            string_result += "corner2: "
            string_result += @corner2.to_s
            string_result += ", "
            string_result += "color: "
            string_result += @color.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
    # Text
    class Text
        TAG = 3
    
        # Text to draw
        attr_accessor :text
        # Position
        attr_accessor :pos
        # Font size
        attr_accessor :size
        # Alignment (0 - left, 0.5 - center, 1 - right)
        attr_accessor :align
        # Color
        attr_accessor :color
    
        def initialize(text, pos, size, align, color)
            @text = text
            @pos = pos
            @size = size
            @align = align
            @color = color
        end
    
        # Read Text from input stream
        def self.read_from(stream)
            text = stream.read_string()
            pos = Model::Vec2Double.read_from(stream)
            size = stream.read_double()
            align = stream.read_double()
            color = Debugging::Color.read_from(stream)
            Text.new(text, pos, size, align, color)
        end
    
        # Write Text to output stream
        def write_to(stream)
            stream.write_int(TAG)
            stream.write_string(@text)
            @pos.write_to(stream)
            stream.write_double(@size)
            stream.write_double(@align)
            @color.write_to(stream)
        end
    
        def to_s
            string_result = "Text { "
            string_result += "text: "
            string_result += @text.dump
            string_result += ", "
            string_result += "pos: "
            string_result += @pos.to_s
            string_result += ", "
            string_result += "size: "
            string_result += @size.to_s
            string_result += ", "
            string_result += "align: "
            string_result += @align.to_s
            string_result += ", "
            string_result += "color: "
            string_result += @color.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
end

end