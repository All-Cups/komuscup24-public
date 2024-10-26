module Model

# 2 dimensional vector.
class Vec2Double
    # `x` coordinate of the vector
    attr_accessor :x
    # `y` coordinate of the vector
    attr_accessor :y

    def initialize(x, y)
        @x = x
        @y = y
    end

    # Read Vec2Double from input stream
    def self.read_from(stream)
        x = stream.read_double()
        y = stream.read_double()
        Vec2Double.new(x, y)
    end

    # Write Vec2Double to output stream
    def write_to(stream)
        stream.write_double(@x)
        stream.write_double(@y)
    end

    def to_s
        string_result = "Vec2Double { "
        string_result += "x: "
        string_result += @x.to_s
        string_result += ", "
        string_result += "y: "
        string_result += @y.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end