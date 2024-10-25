module Model

# Range of values
class MinMaxRangeLong
    # Minimal value
    attr_accessor :min
    # Maximal  value
    attr_accessor :max

    def initialize(min, max)
        @min = min
        @max = max
    end

    # Read MinMaxRangeLong from input stream
    def self.read_from(stream)
        min = stream.read_long()
        max = stream.read_long()
        MinMaxRangeLong.new(min, max)
    end

    # Write MinMaxRangeLong to output stream
    def write_to(stream)
        stream.write_long(@min)
        stream.write_long(@max)
    end

    def to_s
        string_result = "MinMaxRangeLong { "
        string_result += "min: "
        string_result += @min.to_s
        string_result += ", "
        string_result += "max: "
        string_result += @max.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end