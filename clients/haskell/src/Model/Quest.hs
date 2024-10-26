module Model.Quest where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vec2Int32 (Vec2Int32)

-- | A delivery quest
data Quest = Quest {
    -- | Cell where to pick delivery from
    pickupCell :: Vec2Int32,
    -- | Cell to drop the delivery at
    dropCell :: Vec2Int32,
    -- | Score for completing the quest
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