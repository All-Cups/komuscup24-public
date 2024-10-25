require './model/quest'
require './model/vec2_double'

module Model

# A vehicle
class Vehicle
    # Current position (center)
    attr_accessor :position
    # Velocity vector
    attr_accessor :velocity
    # Speed of wheels
    attr_accessor :speed
    # Rotation speed (radians/second)
    attr_accessor :rotation_speed
    # Current rotation
    attr_accessor :rotation
    # Vehicle type index
    attr_accessor :type_index
    # Current quest, if any
    attr_accessor :quest
    # Remaining fuel
    attr_accessor :fuel

    def initialize(position, velocity, speed, rotation_speed, rotation, type_index, quest, fuel)
        @position = position
        @velocity = velocity
        @speed = speed
        @rotation_speed = rotation_speed
        @rotation = rotation
        @type_index = type_index
        @quest = quest
        @fuel = fuel
    end

    # Read Vehicle from input stream
    def self.read_from(stream)
        position = Model::Vec2Double.read_from(stream)
        velocity = Model::Vec2Double.read_from(stream)
        speed = stream.read_double()
        rotation_speed = stream.read_double()
        rotation = stream.read_double()
        type_index = stream.read_int()
        if stream.read_bool()
            quest = Model::Quest.read_from(stream)
        else
            quest = nil
        end
        fuel = stream.read_double()
        Vehicle.new(position, velocity, speed, rotation_speed, rotation, type_index, quest, fuel)
    end

    # Write Vehicle to output stream
    def write_to(stream)
        @position.write_to(stream)
        @velocity.write_to(stream)
        stream.write_double(@speed)
        stream.write_double(@rotation_speed)
        stream.write_double(@rotation)
        stream.write_int(@type_index)
        if @quest.nil?
            stream.write_bool(false)
        else
            stream.write_bool(true)
            @quest.write_to(stream)
        end
        stream.write_double(@fuel)
    end

    def to_s
        string_result = "Vehicle { "
        string_result += "position: "
        string_result += @position.to_s
        string_result += ", "
        string_result += "velocity: "
        string_result += @velocity.to_s
        string_result += ", "
        string_result += "speed: "
        string_result += @speed.to_s
        string_result += ", "
        string_result += "rotation_speed: "
        string_result += @rotation_speed.to_s
        string_result += ", "
        string_result += "rotation: "
        string_result += @rotation.to_s
        string_result += ", "
        string_result += "type_index: "
        string_result += @type_index.to_s
        string_result += ", "
        string_result += "quest: "
        if @quest.nil?
            string_result += "nil"
        else
            string_result += @quest.to_s
        end
        string_result += ", "
        string_result += "fuel: "
        string_result += @fuel.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end