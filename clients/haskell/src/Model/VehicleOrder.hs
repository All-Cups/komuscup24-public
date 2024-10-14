module Model.VehicleOrder where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | TODO - Document
data VehicleOrder = VehicleOrder {
    -- | -1..+1
    accelerate :: Double,
    -- | TODO - Document
    brakes :: Bool,
    -- | -1..+1
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