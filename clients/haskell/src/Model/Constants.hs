module Model.Constants where

import Prelude hiding (id)
import qualified Trans
import Trans (Trans)
import Data.Int
import Model.CityCell (CityCell)
import Model.CityType (CityType)
import Model.MinMaxRangeInt64 (MinMaxRangeInt64)
import Model.Traffic (Traffic)
import Model.VehicleType (VehicleType)

-- | TODO - Document
data Constants = Constants {
    -- | TODO - Document
    maxTickCount :: Int32,
    -- | TODO - Document
    maxGameTimeSeconds :: Double,
    -- | TODO - Document
    ticksPerSecond :: Double,
    -- | TODO - Document
    microticks :: Int32,
    -- | TODO - Document
    cellSize :: Double,
    -- | TODO - Document
    collisionBounciness :: Double,
    -- | TODO - Document
    cityType :: CityType,
    -- | TODO - Document
    vehicleTypes :: [VehicleType],
    -- | TODO - Document
    refillSpeed :: Double,
    -- | TODO - Document
    questCount :: Int32,
    -- | TODO - Document
    questScore :: MinMaxRangeInt64,
    -- | TODO - Document
    traffic :: Traffic,
    -- | TODO - Document
    city :: [[CityCell]] }
    deriving Show

instance Trans Constants where
    read = do
        maxTickCount <- Trans.read
        maxGameTimeSeconds <- Trans.read
        ticksPerSecond <- Trans.read
        microticks <- Trans.read
        cellSize <- Trans.read
        collisionBounciness <- Trans.read
        cityType <- Trans.read
        vehicleTypes <- Trans.read
        refillSpeed <- Trans.read
        questCount <- Trans.read
        questScore <- Trans.read
        traffic <- Trans.read
        city <- Trans.read
        return Constants {
            maxTickCount,
            maxGameTimeSeconds,
            ticksPerSecond,
            microticks,
            cellSize,
            collisionBounciness,
            cityType,
            vehicleTypes,
            refillSpeed,
            questCount,
            questScore,
            traffic,
            city }
    
    write Constants {
        maxTickCount,
        maxGameTimeSeconds,
        ticksPerSecond,
        microticks,
        cellSize,
        collisionBounciness,
        cityType,
        vehicleTypes,
        refillSpeed,
        questCount,
        questScore,
        traffic,
        city } = do
            Trans.write maxTickCount
            Trans.write maxGameTimeSeconds
            Trans.write ticksPerSecond
            Trans.write microticks
            Trans.write cellSize
            Trans.write collisionBounciness
            Trans.write cityType
            Trans.write vehicleTypes
            Trans.write refillSpeed
            Trans.write questCount
            Trans.write questScore
            Trans.write traffic
            Trans.write city