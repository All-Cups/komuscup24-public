module Debugging.DebugState where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | App state for debugging
data DebugState = DebugState {
    -- | Currently pressed keys
    pressedKeys :: [String] }
    deriving Show

instance Trans DebugState where
    read = do
        pressedKeys <- Trans.read
        return DebugState {
            pressedKeys }
    
    write DebugState {
        pressedKeys } = do
            Trans.write pressedKeys