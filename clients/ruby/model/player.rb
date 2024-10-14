require './model/vehicle'

module Model

# TODO - Document
class Player
    # TODO - Document
    attr_accessor :index
    # TODO - Document
    attr_accessor :score
    # TODO - Document
    attr_accessor :vehicles

    def initialize(index, score, vehicles)
        @index = index
        @score = score
        @vehicles = vehicles
    end

    # Read Player from input stream
    def self.read_from(stream)
        index = stream.read_int()
        score = stream.read_long()
        vehicles = []
        stream.read_int().times do |_|
            vehicles_element = Model::Vehicle.read_from(stream)
            vehicles.push(vehicles_element)
        end
        Player.new(index, score, vehicles)
    end

    # Write Player to output stream
    def write_to(stream)
        stream.write_int(@index)
        stream.write_long(@score)
        stream.write_int(@vehicles.length())
        @vehicles.each do |vehicles_element|
            vehicles_element.write_to(stream)
        end
    end

    def to_s
        string_result = "Player { "
        string_result += "index: "
        string_result += @index.to_s
        string_result += ", "
        string_result += "score: "
        string_result += @score.to_s
        string_result += ", "
        string_result += "vehicles: "
        string_result += "[ "
        vehicles_index = 0
        @vehicles.each do |vehicles_element|
            if vehicles_index != 0
                string_result += ", "
            end
            string_result += vehicles_element.to_s
            vehicles_index += 1
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