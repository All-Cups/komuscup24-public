module Model

# Options for traffic
class Traffic
    # Number of traffic cars
    attr_accessor :amount
    # Time to move between adjacent keypoints
    attr_accessor :move_time
    # Radius of each traffic car
    attr_accessor :radius
    # Weight of each traffic car
    attr_accessor :weight
    # Deceleration after crash
    attr_accessor :crash_deceleration
    # Lifetime after crash
    attr_accessor :crash_lifetime

    def initialize(amount, move_time, radius, weight, crash_deceleration, crash_lifetime)
        @amount = amount
        @move_time = move_time
        @radius = radius
        @weight = weight
        @crash_deceleration = crash_deceleration
        @crash_lifetime = crash_lifetime
    end

    # Read Traffic from input stream
    def self.read_from(stream)
        amount = stream.read_int()
        move_time = stream.read_double()
        radius = stream.read_double()
        weight = stream.read_double()
        crash_deceleration = stream.read_double()
        crash_lifetime = stream.read_double()
        Traffic.new(amount, move_time, radius, weight, crash_deceleration, crash_lifetime)
    end

    # Write Traffic to output stream
    def write_to(stream)
        stream.write_int(@amount)
        stream.write_double(@move_time)
        stream.write_double(@radius)
        stream.write_double(@weight)
        stream.write_double(@crash_deceleration)
        stream.write_double(@crash_lifetime)
    end

    def to_s
        string_result = "Traffic { "
        string_result += "amount: "
        string_result += @amount.to_s
        string_result += ", "
        string_result += "move_time: "
        string_result += @move_time.to_s
        string_result += ", "
        string_result += "radius: "
        string_result += @radius.to_s
        string_result += ", "
        string_result += "weight: "
        string_result += @weight.to_s
        string_result += ", "
        string_result += "crash_deceleration: "
        string_result += @crash_deceleration.to_s
        string_result += ", "
        string_result += "crash_lifetime: "
        string_result += @crash_lifetime.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end