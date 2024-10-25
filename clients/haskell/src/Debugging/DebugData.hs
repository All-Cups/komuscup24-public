module Debugging.DebugData where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Debugging.Color (Color)
import Model.Vec2Double (Vec2Double)

-- | Circle
data DebugDataCircle = DebugDataCircle {
    -- | Center
    pos :: Vec2Double,
    -- | Radius
    radius :: Double,
    -- | Color
    color :: Color }
    deriving Show

instance Trans DebugDataCircle where
    read = do
        pos <- Trans.read
        radius <- Trans.read
        color <- Trans.read
        return DebugDataCircle {
            pos,
            radius,
            color }
    
    write DebugDataCircle {
        pos,
        radius,
        color } = do
            Trans.write pos
            Trans.write radius
            Trans.write color

-- | Line (segment)
data DebugDataLine = DebugDataLine {
    -- | First end
    point1 :: Vec2Double,
    -- | Other end
    point2 :: Vec2Double,
    -- | Thickness
    width :: Double,
    -- | Color
    color :: Color }
    deriving Show

instance Trans DebugDataLine where
    read = do
        point1 <- Trans.read
        point2 <- Trans.read
        width <- Trans.read
        color <- Trans.read
        return DebugDataLine {
            point1,
            point2,
            width,
            color }
    
    write DebugDataLine {
        point1,
        point2,
        width,
        color } = do
            Trans.write point1
            Trans.write point2
            Trans.write width
            Trans.write color

-- | Rectangle
data DebugDataRect = DebugDataRect {
    -- | One of the corners
    corner1 :: Vec2Double,
    -- | Opposite corner
    corner2 :: Vec2Double,
    -- | Color
    color :: Color }
    deriving Show

instance Trans DebugDataRect where
    read = do
        corner1 <- Trans.read
        corner2 <- Trans.read
        color <- Trans.read
        return DebugDataRect {
            corner1,
            corner2,
            color }
    
    write DebugDataRect {
        corner1,
        corner2,
        color } = do
            Trans.write corner1
            Trans.write corner2
            Trans.write color

-- | Text
data DebugDataText = DebugDataText {
    -- | Text to draw
    text :: String,
    -- | Position
    pos :: Vec2Double,
    -- | Font size
    size :: Double,
    -- | Alignment (0 - left, 0.5 - center, 1 - right)
    align :: Double,
    -- | Color
    color :: Color }
    deriving Show

instance Trans DebugDataText where
    read = do
        text <- Trans.read
        pos <- Trans.read
        size <- Trans.read
        align <- Trans.read
        color <- Trans.read
        return DebugDataText {
            text,
            pos,
            size,
            align,
            color }
    
    write DebugDataText {
        text,
        pos,
        size,
        align,
        color } = do
            Trans.write text
            Trans.write pos
            Trans.write size
            Trans.write align
            Trans.write color

-- | Data for debug rendering
data DebugData
    -- | Circle
    = Circle DebugDataCircle
    -- | Line (segment)
    | Line DebugDataLine
    -- | Rectangle
    | Rect DebugDataRect
    -- | Text
    | Text DebugDataText
    deriving Show

instance Trans DebugData where
    read = do
        tag :: Int32 <- Trans.read
        case tag of
            0 -> Circle <$> Trans.read
            1 -> Line <$> Trans.read
            2 -> Rect <$> Trans.read
            3 -> Text <$> Trans.read
    
    write (Circle value) = do
        Trans.write (0 :: Int32)
        Trans.write value
    write (Line value) = do
        Trans.write (1 :: Int32)
        Trans.write value
    write (Rect value) = do
        Trans.write (2 :: Int32)
        Trans.write value
    write (Text value) = do
        Trans.write (3 :: Int32)
        Trans.write value