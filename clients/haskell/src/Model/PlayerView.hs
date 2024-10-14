module Model.PlayerView where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Player (Player)
import Model.Quest (Quest)

-- | Current game's state
data PlayerView = PlayerView {
    -- | Current tick number
    currentTick :: Int32,
    -- | TODO - Document
    you :: Player,
    -- | TODO - Document
    other :: [Player],
    -- | TODO - Document
    quests :: [Quest] }
    deriving Show

instance Trans PlayerView where
    read = do
        currentTick <- Trans.read
        you <- Trans.read
        other <- Trans.read
        quests <- Trans.read
        return PlayerView {
            currentTick,
            you,
            other,
            quests }
    
    write PlayerView {
        currentTick,
        you,
        other,
        quests } = do
            Trans.write currentTick
            Trans.write you
            Trans.write other
            Trans.write quests