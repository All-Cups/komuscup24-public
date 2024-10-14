module Model.CityType where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.Vec2Int32 (Vec2Int32)

-- | TODO - Document
data CityTypeManhattan = CityTypeManhattan {
    -- | TODO - Document
    size :: Vec2Int32,
    -- | TODO - Document
    blockSize :: Vec2Int32,
    -- | TODO - Document
    refills :: Int32 }
    deriving Show

instance Trans CityTypeManhattan where
    read = do
        size <- Trans.read
        blockSize <- Trans.read
        refills <- Trans.read
        return CityTypeManhattan {
            size,
            blockSize,
            refills }
    
    write CityTypeManhattan {
        size,
        blockSize,
        refills } = do
            Trans.write size
            Trans.write blockSize
            Trans.write refills

-- | TODO - Document
data CityTypeInline = CityTypeInline {
    -- | TODO - Document
    cells :: [String] }
    deriving Show

instance Trans CityTypeInline where
    read = do
        cells <- Trans.read
        return CityTypeInline {
            cells }
    
    write CityTypeInline {
        cells } = do
            Trans.write cells

-- | TODO - Document
data CityType
    -- | TODO - Document
    = Manhattan CityTypeManhattan
    -- | TODO - Document
    | Inline CityTypeInline
    deriving Show

instance Trans CityType where
    read = do
        tag :: Int32 <- Trans.read
        case tag of
            0 -> Manhattan <$> Trans.read
            1 -> Inline <$> Trans.read
    
    write (Manhattan value) = do
        Trans.write (0 :: Int32)
        Trans.write value
    write (Inline value) = do
        Trans.write (1 :: Int32)
        Trans.write value