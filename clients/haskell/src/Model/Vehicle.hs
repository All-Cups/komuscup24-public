module Model.Vehicle where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Quest (Quest)
import Model.Vec2Double (Vec2Double)

-- | TODO - Document
data Vehicle = Vehicle {
    -- | TODO - Document
    position :: Vec2Double,
    -- | TODO - Document
    velocity :: Vec2Double,
    -- | TODO - Document
    speed :: Double,
    -- | TODO - Document
    rotationSpeed :: Double,
    -- | TODO - Document
    rotation :: Double,
    -- | TODO - Document
    typeIndex :: Int32,
    -- | TODO maybe multiple quests at the same time?
    quest :: Maybe Quest,
    -- | TODO - Document
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