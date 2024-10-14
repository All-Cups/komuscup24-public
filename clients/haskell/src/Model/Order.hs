module Model.Order where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Model.VehicleOrder (VehicleOrder)

-- | Player's orders
data Order = Order {
    -- | TODO - Document
    vehicles :: [VehicleOrder] }
    deriving Show

instance Trans Order where
    read = do
        vehicles <- Trans.read
        return Order {
            vehicles }
    
    write Order {
        vehicles } = do
            Trans.write vehicles