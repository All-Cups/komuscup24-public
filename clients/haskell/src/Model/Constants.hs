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

-- | Game constants
data Constants = Constants {
    -- | Max duration of the game in ticks
    maxTickCount :: Int32,
    -- | Max game time in seconds
    maxGameTimeSeconds :: Double,
    -- | Ticks per second
    ticksPerSecond :: Double,
    -- | Subticks for physics simulation
    microticks :: Int32,
    -- | Size of a single city cell
    cellSize :: Double,
    -- | Collision bounciness
    collisionBounciness :: Double,
    -- | City type
    cityType :: CityType,
    -- | List of vehicle types
    vehicleTypes :: [VehicleType],
    -- | Speed of refueling at a station
    refillSpeed :: Double,
    -- | Number of available quests
    questCount :: Int32,
    -- | Score range for quests
    questScore :: MinMaxRangeInt64,
    -- | Traffic options
    traffic :: Traffic,
    -- | Collision penalty modifier
    collisionPenaltyModifier :: Double,
    -- | Map of the city
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
        collisionPenaltyModifier <- Trans.read
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
            collisionPenaltyModifier,
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
        collisionPenaltyModifier,
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
            Trans.write collisionPenaltyModifier
            Trans.write city