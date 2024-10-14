module Model.Traffic where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | TODO - Document
data Traffic = Traffic {
    -- | TODO - Document
    amount :: Int32,
    -- | TODO - Document
    moveTime :: Double,
    -- | TODO - Document
    radius :: Double,
    -- | TODO - Document
    weight :: Double,
    -- | TODO - Document
    crashDeceleration :: Double,
    -- | TODO - Document
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