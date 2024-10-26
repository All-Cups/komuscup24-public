require './model/vec2_int'

module Model

# A delivery quest
class Quest
    # Cell where to pick delivery from
    attr_accessor :pickup_cell
    # Cell to drop the delivery at
    attr_accessor :drop_cell
    # Score for completing the quest
    attr_accessor :score

    def initialize(pickup_cell, drop_cell, score)
        @pickup_cell = pickup_cell
        @drop_cell = drop_cell
        @score = score
    end

    # Read Quest from input stream
    def self.read_from(stream)
        pickup_cell = Model::Vec2Int.read_from(stream)
        drop_cell = Model::Vec2Int.read_from(stream)
        score = stream.read_long()
        Quest.new(pickup_cell, drop_cell, score)
    end

    # Write Quest to output stream
    def write_to(stream)
        @pickup_cell.write_to(stream)
        @drop_cell.write_to(stream)
        stream.write_long(@score)
    end

    def to_s
        string_result = "Quest { "
        string_result += "pickup_cell: "
        string_result += @pickup_cell.to_s
        string_result += ", "
        string_result += "drop_cell: "
        string_result += @drop_cell.to_s
        string_result += ", "
        string_result += "score: "
        string_result += @score.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end