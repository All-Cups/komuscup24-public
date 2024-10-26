module Model.VehicleOrder where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | Order for controlling a single vehicle
data VehicleOrder = VehicleOrder {
    -- | Acceleration (-1 - fully backwards, +1 - fully forward)
    accelerate :: Double,
    -- | Hand brakes
    brakes :: Bool,
    -- | Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
    rotate :: Double }
    deriving Show

instance Trans VehicleOrder where
    read = do
        accelerate <- Trans.read
        brakes <- Trans.read
        rotate <- Trans.read
        return VehicleOrder {
            accelerate,
            brakes,
            rotate }
    
    write VehicleOrder {
        accelerate,
        brakes,
        rotate } = do
            Trans.write accelerate
            Trans.write brakes
            Trans.write rotate