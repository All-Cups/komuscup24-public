module Model.Player where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vehicle (Vehicle)

-- | TODO - Document
data Player = Player {
    -- | TODO - Document
    index :: Int32,
    -- | TODO - Document
    score :: Int64,
    -- | TODO - Document
    vehicles :: [Vehicle] }
    deriving Show

instance Trans Player where
    read = do
        index <- Trans.read
        score <- Trans.read
        vehicles <- Trans.read
        return Player {
            index,
            score,
            vehicles }
    
    write Player {
        index,
        score,
        vehicles } = do
            Trans.write index
            Trans.write score
            Trans.write vehicles