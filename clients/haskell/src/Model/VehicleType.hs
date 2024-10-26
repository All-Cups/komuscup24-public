module Model.VehicleType where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | Vehicle type options
data VehicleType = VehicleType {
    -- | Name
    name :: String,
    -- | Radius
    radius :: Double,
    -- | Weight
    weight :: Double,
    -- | Maximal backwads movement speed
    maxBackwardsSpeed :: Double,
    -- | Maximal forward movement speed
    maxSpeed :: Double,
    -- | Acceleration
    acceleration :: Double,
    -- | Friction coefficient
    friction :: Double,
    -- | Maximal rotation speed
    maxRotateSpeed :: Double,
    -- | Rotational acceleration
    rotateAcceleration :: Double,
    -- | Maximal amount of fuel
    maxFuel :: Double,
    -- | Fuel usage speed
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