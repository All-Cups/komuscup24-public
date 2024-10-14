class MyStrategy
    def initialize(constants)
    end
    def get_order(player_view, debug_interface)
        return Model::Order.new([])
    end
    def debug_update(displayed_tick, debug_interface)
    end
    def finish()
    end
end