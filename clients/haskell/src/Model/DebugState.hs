module Model.DebugState where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)


-- | TODO - Document
data DebugState = DebugState {
    -- | TODO - Document
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