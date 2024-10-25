module Model.MinMaxRangeInt64 where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | Range of values
data MinMaxRangeInt64 = MinMaxRangeInt64 {
    -- | Minimal value
    min :: Int64,
    -- | Maximal  value
    max :: Int64 }
    deriving Show

instance Trans MinMaxRangeInt64 where
    read = do
        min <- Trans.read
        max <- Trans.read
        return MinMaxRangeInt64 {
            min,
            max }
    
    write MinMaxRangeInt64 {
        min,
        max } = do
            Trans.write min
            Trans.write max