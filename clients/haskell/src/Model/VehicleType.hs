module Model.VehicleType where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | TODO - Document
data VehicleType = VehicleType {
    -- | TODO - Document
    name :: String,
    -- | TODO - Document
    radius :: Double,
    -- | TODO - Document
    weight :: Double,
    -- | TODO - Document
    maxBackwardsSpeed :: Double,
    -- | TODO - Document
    maxSpeed :: Double,
    -- | TODO - Document
    acceleration :: Double,
    -- | TODO - Document
    friction :: Double,
    -- | TODO - Document
    maxRotateSpeed :: Double,
    -- | TODO - Document
    rotateAcceleration :: Double,
    -- | TODO - Document
    maxFuel :: Double,
    -- | TODO - Document
    fuelUseSpeed :: Double }
    deriving Show

instance Trans VehicleType where
    read = do
        name <- Trans.read
        radius <- Trans.read
        weight <- Trans.read
        maxBackwardsSpeed <- Trans.read
        maxSpeed <- Trans.read
        acceleration <- Trans.read
        friction <- Trans.read
        maxRotateSpeed <- Trans.read
        rotateAcceleration <- Trans.read
        maxFuel <- Trans.read
        fuelUseSpeed <- Trans.read
        return VehicleType {
            name,
            radius,
            weight,
            maxBackwardsSpeed,
            maxSpeed,
            acceleration,
            friction,
            maxRotateSpeed,
            rotateAcceleration,
            maxFuel,
            fuelUseSpeed }
    
    write VehicleType {
        name,
        radius,
        weight,
        maxBackwardsSpeed,
        maxSpeed,
        acceleration,
        friction,
        maxRotateSpeed,
        rotateAcceleration,
        maxFuel,
        fuelUseSpeed } = do
            Trans.write name
            Trans.write radius
            Trans.write weight
            Trans.write maxBackwardsSpeed
            Trans.write maxSpeed
            Trans.write acceleration
            Trans.write friction
            Trans.write maxRotateSpeed
            Trans.write rotateAcceleration
            Trans.write maxFuel
            Trans.write fuelUseSpeed