module Model.Quest where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vec2Int32 (Vec2Int32)

-- | TODO - Document
data Quest = Quest {
    -- | TODO - Document
    pickupCell :: Vec2Int32,
    -- | TODO - Document
    dropCell :: Vec2Int32,
    -- | TODO - Document
    score :: Int64 }
    deriving Show

instance Trans Quest where
    read = do
        pickupCell <- Trans.read
        dropCell <- Trans.read
        score <- Trans.read
        return Quest {
            pickupCell,
            dropCell,
            score }
    
    write Quest {
        pickupCell,
        dropCell,
        score } = do
            Trans.write pickupCell
            Trans.write dropCell
            Trans.write score