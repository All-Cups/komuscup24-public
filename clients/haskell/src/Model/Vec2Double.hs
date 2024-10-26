module Model.Vec2Double where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | 2 dimensional vector.
data Vec2Double = Vec2Double {
    -- | `x` coordinate of the vector
    x :: Double,
    -- | `y` coordinate of the vector
    y :: Double }
    deriving Show

instance Trans Vec2Double where
    read = do
        x <- Trans.read
        y <- Trans.read
        return Vec2Double {
            x,
            y }
    
    write Vec2Double {
        x,
        y } = do
            Trans.write x
            Trans.write y