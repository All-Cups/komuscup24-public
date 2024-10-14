module Model

# TODO - Document
class VehicleType
    # TODO - Document
    attr_accessor :name
    # TODO - Document
    attr_accessor :radius
    # TODO - Document
    attr_accessor :weight
    # TODO - Document
    attr_accessor :max_backwards_speed
    # TODO - Document
    attr_accessor :max_speed
    # TODO - Document
    attr_accessor :acceleration
    # TODO - Document
    attr_accessor :friction
    # TODO - Document
    attr_accessor :max_rotate_speed
    # TODO - Document
    attr_accessor :rotate_acceleration
    # TODO - Document
    attr_accessor :max_fuel
    # TODO - Document
    attr_accessor :fuel_use_speed

    def initialize(name, radius, weight, max_backwards_speed, max_speed, acceleration, friction, max_rotate_speed, rotate_acceleration, max_fuel, fuel_use_speed)
        @name = name
        @radius = radius
        @weight = weight
        @max_backwards_speed = max_backwards_speed
        @max_speed = max_speed
        @acceleration = acceleration
        @friction = friction
        @max_rotate_speed = max_rotate_speed
        @rotate_acceleration = rotate_acceleration
        @max_fuel = max_fuel
        @fuel_use_speed = fuel_use_speed
    end

    # Read VehicleType from input stream
    def self.read_from(stream)
        name = stream.read_string()
        radius = stream.read_double()
        weight = stream.read_double()
        max_backwards_speed = stream.read_double()
        max_speed = stream.read_double()
        acceleration = stream.read_double()
        friction = stream.read_double()
        max_rotate_speed = stream.read_double()
        rotate_acceleration = stream.read_double()
        max_fuel = stream.read_double()
        fuel_use_speed = stream.read_double()
        VehicleType.new(name, radius, weight, max_backwards_speed, max_speed, acceleration, friction, max_rotate_speed, rotate_acceleration, max_fuel, fuel_use_speed)
    end

    # Write VehicleType to output stream
    def write_to(stream)
        stream.write_string(@name)
        stream.write_double(@radius)
        stream.write_double(@weight)
        stream.write_double(@max_backwards_speed)
        stream.write_double(@max_speed)
        stream.write_double(@acceleration)
        stream.write_double(@friction)
        stream.write_double(@max_rotate_speed)
        stream.write_double(@rotate_acceleration)
        stream.write_double(@max_fuel)
        stream.write_double(@fuel_use_speed)
    end

    def to_s
        string_result = "VehicleType { "
        string_result += "name: "
        string_result += @name.dump
        string_result += ", "
        string_result += "radius: "
        string_result += @radius.to_s
        string_result += ", "
        string_result += "weight: "
        string_result += @weight.to_s
        string_result += ", "
        string_result += "max_backwards_speed: "
        string_result += @max_backwards_speed.to_s
        string_result += ", "
        string_result += "max_speed: "
        string_result += @max_speed.to_s
        string_result += ", "
        string_result += "acceleration: "
        string_result += @acceleration.to_s
        string_result += ", "
        string_result += "friction: "
        string_result += @friction.to_s
        string_result += ", "
        string_result += "max_rotate_speed: "
        string_result += @max_rotate_speed.to_s
        string_result += ", "
        string_result += "rotate_acceleration: "
        string_result += @rotate_acceleration.to_s
        string_result += ", "
        string_result += "max_fuel: "
        string_result += @max_fuel.to_s
        string_result += ", "
        string_result += "fuel_use_speed: "
        string_result += @fuel_use_speed.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end