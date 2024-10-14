module Model.DebugData where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vec2Double (Vec2Double)

-- | TODO - Document
data DebugDataCircle = DebugDataCircle {
    -- | TODO - Document
    pos :: Vec2Double,
    -- | TODO - Document
    radius :: Double }
    deriving Show

instance Trans DebugDataCircle where
    read = do
        pos <- Trans.read
        radius <- Trans.read
        return DebugDataCircle {
            pos,
            radius }
    
    write DebugDataCircle {
        pos,
        radius } = do
            Trans.write pos
            Trans.write radius

-- | TODO - Document
data DebugData
    -- | TODO - Document
    = Circle DebugDataCircle
    deriving Show

instance Trans DebugData where
    read = do
        tag :: Int32 <- Trans.read
        case tag of
            0 -> Circle <$> Trans.read
    
    write (Circle value) = do
        Trans.write (0 :: Int32)
        Trans.write value