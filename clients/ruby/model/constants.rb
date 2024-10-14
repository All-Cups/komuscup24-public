require './model/city_cell'
require './model/city_type'
require './model/min_max_range_long'
require './model/traffic'
require './model/vehicle_type'

module Model

# TODO - Document
class Constants
    # TODO - Document
    attr_accessor :max_tick_count
    # TODO - Document
    attr_accessor :max_game_time_seconds
    # TODO - Document
    attr_accessor :ticks_per_second
    # TODO - Document
    attr_accessor :microticks
    # TODO - Document
    attr_accessor :cell_size
    # TODO - Document
    attr_accessor :collision_bounciness
    # TODO - Document
    attr_accessor :city_type
    # TODO - Document
    attr_accessor :vehicle_types
    # TODO - Document
    attr_accessor :refill_speed
    # TODO - Document
    attr_accessor :quest_count
    # TODO - Document
    attr_accessor :quest_score
    # TODO - Document
    attr_accessor :traffic
    # TODO - Document
    attr_accessor :city

    def initialize(max_tick_count, max_game_time_seconds, ticks_per_second, microticks, cell_size, collision_bounciness, city_type, vehicle_types, refill_speed, quest_count, quest_score, traffic, city)
        @max_tick_count = max_tick_count
        @max_game_time_seconds = max_game_time_seconds
        @ticks_per_second = ticks_per_second
        @microticks = microticks
        @cell_size = cell_size
        @collision_bounciness = collision_bounciness
        @city_type = city_type
        @vehicle_types = vehicle_types
        @refill_speed = refill_speed
        @quest_count = quest_count
        @quest_score = quest_score
        @traffic = traffic
        @city = city
    end

    # Read Constants from input stream
    def self.read_from(stream)
        max_tick_count = stream.read_int()
        max_game_time_seconds = stream.read_double()
        ticks_per_second = stream.read_double()
        microticks = stream.read_int()
        cell_size = stream.read_double()
        collision_bounciness = stream.read_double()
        city_type = Model::CityType.read_from(stream)
        vehicle_types = []
        stream.read_int().times do |_|
            vehicle_types_element = Model::VehicleType.read_from(stream)
            vehicle_types.push(vehicle_types_element)
        end
        refill_speed = stream.read_double()
        quest_count = stream.read_int()
        quest_score = Model::MinMaxRangeLong.read_from(stream)
        traffic = Model::Traffic.read_from(stream)
        city = []
        stream.read_int().times do |_|
            city_element = []
            stream.read_int().times do |_|
                city_element_element = Model::CityCell.read_from(stream)
                city_element.push(city_element_element)
            end
            city.push(city_element)
        end
        Constants.new(max_tick_count, max_game_time_seconds, ticks_per_second, microticks, cell_size, collision_bounciness, city_type, vehicle_types, refill_speed, quest_count, quest_score, traffic, city)
    end

    # Write Constants to output stream
    def write_to(stream)
        stream.write_int(@max_tick_count)
        stream.write_double(@max_game_time_seconds)
        stream.write_double(@ticks_per_second)
        stream.write_int(@microticks)
        stream.write_double(@cell_size)
        stream.write_double(@collision_bounciness)
        @city_type.write_to(stream)
        stream.write_int(@vehicle_types.length())
        @vehicle_types.each do |vehicle_types_element|
            vehicle_types_element.write_to(stream)
        end
        stream.write_double(@refill_speed)
        stream.write_int(@quest_count)
        @quest_score.write_to(stream)
        @traffic.write_to(stream)
        stream.write_int(@city.length())
        @city.each do |city_element|
            stream.write_int(city_element.length())
            city_element.each do |city_element_element|
                stream.write_int(city_element_element)
            end
        end
    end

    def to_s
        string_result = "Constants { "
        string_result += "max_tick_count: "
        string_result += @max_tick_count.to_s
        string_result += ", "
        string_result += "max_game_time_seconds: "
        string_result += @max_game_time_seconds.to_s
        string_result += ", "
        string_result += "ticks_per_second: "
        string_result += @ticks_per_second.to_s
        string_result += ", "
        string_result += "microticks: "
        string_result += @microticks.to_s
        string_result += ", "
        string_result += "cell_size: "
        string_result += @cell_size.to_s
        string_result += ", "
        string_result += "collision_bounciness: "
        string_result += @collision_bounciness.to_s
        string_result += ", "
        string_result += "city_type: "
        string_result += @city_type.to_s
        string_result += ", "
        string_result += "vehicle_types: "
        string_result += "[ "
        vehicle_types_index = 0
        @vehicle_types.each do |vehicle_types_element|
            if vehicle_types_index != 0
                string_result += ", "
            end
            string_result += vehicle_types_element.to_s
            vehicle_types_index += 1
        end
        string_result += " ]"
        string_result += ", "
        string_result += "refill_speed: "
        string_result += @refill_speed.to_s
        string_result += ", "
        string_result += "quest_count: "
        string_result += @quest_count.to_s
        string_result += ", "
        string_result += "quest_score: "
        string_result += @quest_score.to_s
        string_result += ", "
        string_result += "traffic: "
        string_result += @traffic.to_s
        string_result += ", "
        string_result += "city: "
        string_result += "[ "
        city_index = 0
        @city.each do |city_element|
            if city_index != 0
                string_result += ", "
            end
            string_result += "[ "
            city_element_index = 0
            city_element.each do |city_element_element|
                if city_element_index != 0
                    string_result += ", "
                end
                string_result += CityCell.to_s(city_element_element)
                city_element_index += 1
            end
            string_result += " ]"
            city_index += 1
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