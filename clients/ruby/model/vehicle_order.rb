module Model

# TODO - Document
class VehicleOrder
    # -1..+1
    attr_accessor :accelerate
    # TODO - Document
    attr_accessor :brakes
    # -1..+1
    attr_accessor :rotate

    def initialize(accelerate, brakes, rotate)
        @accelerate = accelerate
        @brakes = brakes
        @rotate = rotate
    end

    # Read VehicleOrder from input stream
    def self.read_from(stream)
        accelerate = stream.read_double()
        brakes = stream.read_bool()
        rotate = stream.read_double()
        VehicleOrder.new(accelerate, brakes, rotate)
    end

    # Write VehicleOrder to output stream
    def write_to(stream)
        stream.write_double(@accelerate)
        stream.write_bool(@brakes)
        stream.write_double(@rotate)
    end

    def to_s
        string_result = "VehicleOrder { "
        string_result += "accelerate: "
        string_result += @accelerate.to_s
        string_result += ", "
        string_result += "brakes: "
        string_result += @brakes.to_s
        string_result += ", "
        string_result += "rotate: "
        string_result += @rotate.to_s
        string_result += " }"
        string_result
    end

    def to_str
        to_s
    end
end

end