require './model/vec2_int'

module Model

# TODO - Document
class CityType
    # Read CityType from input stream
    def self.read_from(stream)
        tag = stream.read_int()
        if tag == CityType::Manhattan::TAG
            return CityType::Manhattan.read_from(stream)
        end
        if tag == CityType::Inline::TAG
            return CityType::Inline.read_from(stream)
        end
        raise "Unexpected tag value"
    end

    # TODO - Document
    class Manhattan
        TAG = 0
    
        # TODO - Document
        attr_accessor :size
        # TODO - Document
        attr_accessor :block_size
        # TODO - Document
        attr_accessor :refills
    
        def initialize(size, block_size, refills)
            @size = size
            @block_size = block_size
            @refills = refills
        end
    
        # Read Manhattan from input stream
        def self.read_from(stream)
            size = Model::Vec2Int.read_from(stream)
            block_size = Model::Vec2Int.read_from(stream)
            refills = stream.read_int()
            Manhattan.new(size, block_size, refills)
        end
    
        # Write Manhattan to output stream
        def write_to(stream)
            stream.write_int(TAG)
            @size.write_to(stream)
            @block_size.write_to(stream)
            stream.write_int(@refills)
        end
    
        def to_s
            string_result = "Manhattan { "
            string_result += "size: "
            string_result += @size.to_s
            string_result += ", "
            string_result += "block_size: "
            string_result += @block_size.to_s
            string_result += ", "
            string_result += "refills: "
            string_result += @refills.to_s
            string_result += " }"
            string_result
        end
    
        def to_str
            to_s
        end
    end
    # TODO - Document
    class Inline
        TAG = 1
    
        # TODO - Document
        attr_accessor :cells
    
        def initialize(cells)
            @cells = cells
        end
    
        # Read Inline from input stream
        def self.read_from(stream)
            cells = []
            stream.read_int().times do |_|
                cells_element = stream.read_string()
                cells.push(cells_element)
            end
            Inline.new(cells)
        end
    
        # Write Inline to output stream
        def write_to(stream)
            stream.write_int(TAG)
            stream.write_int(@cells.length())
            @cells.each do |cells_element|
                stream.write_string(cells_element)
            end
        end
    
        def to_s
            string_result = "Inline { "
            string_result += "cells: "
            string_result += "[ "
            cells_index = 0
            @cells.each do |cells_element|
                if cells_index != 0
                    string_result += ", "
                end
                string_result += cells_element.dump
                cells_index += 1
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

end