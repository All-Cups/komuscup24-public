require './model/vehicle_order'

module Model

# Player's orders
class Order
    # Orders for each of the vehicles
    attr_accessor :vehicles

    def initialize(vehicles)
        @vehicles = vehicles
    end

    # Read Order from input stream
    def self.read_from(stream)
        vehicles = []
        stream.read_int().times do |_|
            vehicles_element = Model::VehicleOrder.read_from(stream)
            vehicles.push(vehicles_element)
        end
        Order.new(vehicles)
    end

    # Write Order to output stream
    def write_to(stream)
        stream.write_int(@vehicles.length())
        @vehicles.each do |vehicles_element|
            vehicles_element.write_to(stream)
        end
    end

    def to_s
        string_result = "Order { "
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