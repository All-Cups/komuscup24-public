module Model

# City cell
module CityCell
    # Road
    ROAD = 0
    # Building
    BUILDING = 1
    # Refill station
    REFILL_STATION = 2

    # Read CityCell from input stream
    def self.read_from(stream)
        result = stream.read_int()
        if result < 0 || result >= 3
            raise "Unexpected tag value"
        end
        result
    end

    def self.to_s(value)
        if value == ROAD
            return "ROAD"
        end
        if value == BUILDING
            return "BUILDING"
        end
        if value == REFILL_STATION
            return "REFILL_STATION"
        end
        raise "Impossible happened"
    end

    def self.to_str(value)
        self.to_s(value)
    end
end

end