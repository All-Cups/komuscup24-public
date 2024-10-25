module Model.CityCell where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int

-- | City cell
data CityCell
    -- | Road
    = Road
    -- | Building
    | Building
    -- | Refill station
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