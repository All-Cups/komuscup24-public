module Model.CityCell where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | TODO - Document
data CityCell
    -- | TODO - Document
    = Road
    -- | TODO - Document
    | Building
    -- | TODO - Document
    | RefillStation
    deriving (Eq, Ord, Show)

instance Trans CityCell where
    read = do
        tag :: Int32 <- Trans.read
        return $ case tag of
            0 -> Road
            1 -> Building
            2 -> RefillStation
            
    write Road =
        Trans.write (0 :: Int32)
    write Building =
        Trans.write (1 :: Int32)
    write RefillStation =
        Trans.write (2 :: Int32)