require './model/player'
require './model/quest'

module Model

# Current game's state
class PlayerView
    # Current tick number
    attr_accessor :current_tick
    # Your player
    attr_accessor :you
    # Other players
    attr_accessor :other
    # Available quests
    attr_accessor :quests

    def initialize(current_tick, you, other, quests)
        @current_tick = current_tick
        @you = you
        @other = other
        @quests = quests
    end

    # Read PlayerView from input stream
    def self.read_from(stream)
        current_tick = stream.read_int()
        you = Model::Player.read_from(stream)
        other = []
        stream.read_int().times do |_|
            other_element = Model::Player.read_from(stream)
            other.push(other_element)
        end
        quests = []
        stream.read_int().times do |_|
            quests_element = Model::Quest.read_from(stream)
            quests.push(quests_element)
        end
        PlayerView.new(current_tick, you, other, quests)
    end

    # Write PlayerView to output stream
    def write_to(stream)
        stream.write_int(@current_tick)
        @you.write_to(stream)
        stream.write_int(@other.length())
        @other.each do |other_element|
            other_element.write_to(stream)
        end
        stream.write_int(@quests.length())
        @quests.each do |quests_element|
            quests_element.write_to(stream)
        end
    end

    def to_s
        string_result = "PlayerView { "
        string_result += "current_tick: "
        string_result += @current_tick.to_s
        string_result += ", "
        string_result += "you: "
        string_result += @you.to_s
        string_result += ", "
        string_result += "other: "
        string_result += "[ "
        other_index = 0
        @other.each do |other_element|
            if other_index != 0
                string_result += ", "
            end
            string_result += other_element.to_s
            other_index += 1
        end
        string_result += " ]"
        string_result += ", "
        string_result += "quests: "
        string_result += "[ "
        quests_index = 0
        @quests.each do |quests_element|
            if quests_index != 0
                string_result += ", "
            end
            string_result += quests_element.to_s
            quests_index += 1
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