module Model.Player where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vehicle (Vehicle)

-- | Player (game participant)
data Player = Player {
    -- | Index
    index :: Int32,
    -- | Current score
    score :: Int64,
    -- | List of player's vehicles
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