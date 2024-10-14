module Model.MinMaxRangeInt64 where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | TODO - Document
data MinMaxRangeInt64 = MinMaxRangeInt64 {
    -- | TODO - Document
    min :: Int64,
    -- | TODO - Document
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