module Model.Vehicle where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Quest (Quest)
import Model.Vec2Double (Vec2Double)

-- | A vehicle
data Vehicle = Vehicle {
    -- | Current position (center)
    position :: Vec2Double,
    -- | Velocity vector
    velocity :: Vec2Double,
    -- | Speed of wheels
    speed :: Double,
    -- | Rotation speed (radians/second)
    rotationSpeed :: Double,
    -- | Current rotation
    rotation :: Double,
    -- | Vehicle type index
    typeIndex :: Int32,
    -- | Current quest, if any
    quest :: Maybe Quest,
    -- | Remaining fuel
    fuel :: Double }
    deriving Show

instance Trans Vehicle where
    read = do
        position <- Trans.read
        velocity <- Trans.read
        speed <- Trans.read
        rotationSpeed <- Trans.read
        rotation <- Trans.read
        typeIndex <- Trans.read
        quest <- Trans.read
        fuel <- Trans.read
        return Vehicle {
            position,
            velocity,
            speed,
            rotationSpeed,
            rotation,
            typeIndex,
            quest,
            fuel }
    
    write Vehicle {
        position,
        velocity,
        speed,
        rotationSpeed,
        rotation,
        typeIndex,
        quest,
        fuel } = do
            Trans.write position
            Trans.write velocity
            Trans.write speed
            Trans.write rotationSpeed
            Trans.write rotation
            Trans.write typeIndex
            Trans.write quest
            Trans.write fuel