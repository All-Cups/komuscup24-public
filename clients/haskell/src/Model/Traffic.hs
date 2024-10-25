module Model.Traffic where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | Options for traffic
data Traffic = Traffic {
    -- | Number of traffic cars
    amount :: Int32,
    -- | Time to move between adjacent keypoints
    moveTime :: Double,
    -- | Radius of each traffic car
    radius :: Double,
    -- | Weight of each traffic car
    weight :: Double,
    -- | Deceleration after crash
    crashDeceleration :: Double,
    -- | Lifetime after crash
    crashLifetime :: Double }
    deriving Show

instance Trans Traffic where
    read = do
        amount <- Trans.read
        moveTime <- Trans.read
        radius <- Trans.read
        weight <- Trans.read
        crashDeceleration <- Trans.read
        crashLifetime <- Trans.read
        return Traffic {
            amount,
            moveTime,
            radius,
            weight,
            crashDeceleration,
            crashLifetime }
    
    write Traffic {
        amount,
        moveTime,
        radius,
        weight,
        crashDeceleration,
        crashLifetime } = do
            Trans.write amount
            Trans.write moveTime
            Trans.write radius
            Trans.write weight
            Trans.write crashDeceleration
            Trans.write crashLifetime