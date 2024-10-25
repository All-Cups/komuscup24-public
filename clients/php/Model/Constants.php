<?php

namespace Model {
    require_once 'Model/CityCell.php';
    require_once 'Model/CityType.php';
    require_once 'Model/MinMaxRangeLong.php';
    require_once 'Model/Traffic.php';
    require_once 'Model/VehicleType.php';
    require_once 'Stream.php';

    /**
     * Game constants
     */
    class Constants
    {
        /**
         * Max duration of the game in ticks
         */
        public int $maxTickCount;
        /**
         * Max game time in seconds
         */
        public float $maxGameTimeSeconds;
        /**
         * Ticks per second
         */
        public float $ticksPerSecond;
        /**
         * Subticks for physics simulation
         */
        public int $microticks;
        /**
         * Size of a single city cell
         */
        public float $cellSize;
        /**
         * Collision bounciness
         */
        public float $collisionBounciness;
        /**
         * City type
         */
        public \Model\CityType $cityType;
        /**
         * List of vehicle types
         */
        public array $vehicleTypes;
        /**
         * Speed of refueling at a station
         */
        public float $refillSpeed;
        /**
         * Number of available quests
         */
        public int $questCount;
        /**
         * Score range for quests
         */
        public \Model\MinMaxRangeLong $questScore;
        /**
         * Traffic options
         */
        public \Model\Traffic $traffic;
        /**
         * Collision penalty modifier
         */
        public float $collisionPenaltyModifier;
        /**
         * Map of the city
         */
        public array $city;
    
        function __construct(int $maxTickCount, float $maxGameTimeSeconds, float $ticksPerSecond, int $microticks, float $cellSize, float $collisionBounciness, \Model\CityType $cityType, array $vehicleTypes, float $refillSpeed, int $questCount, \Model\MinMaxRangeLong $questScore, \Model\Traffic $traffic, float $collisionPenaltyModifier, array $city)
        {
            $this->maxTickCount = $maxTickCount;
            $this->maxGameTimeSeconds = $maxGameTimeSeconds;
            $this->ticksPerSecond = $ticksPerSecond;
            $this->microticks = $microticks;
            $this->cellSize = $cellSize;
            $this->collisionBounciness = $collisionBounciness;
            $this->cityType = $cityType;
            $this->vehicleTypes = $vehicleTypes;
            $this->refillSpeed = $refillSpeed;
            $this->questCount = $questCount;
            $this->questScore = $questScore;
            $this->traffic = $traffic;
            $this->collisionPenaltyModifier = $collisionPenaltyModifier;
            $this->city = $city;
        }
    
        /**
         * Read Constants from input stream
         */
        public static function readFrom(\InputStream $stream): Constants
        {
            $maxTickCount = $stream->readInt32();
            $maxGameTimeSeconds = $stream->readDouble();
            $ticksPerSecond = $stream->readDouble();
            $microticks = $stream->readInt32();
            $cellSize = $stream->readDouble();
            $collisionBounciness = $stream->readDouble();
            $cityType = \Model\CityType::readFrom($stream);
            $vehicleTypes = [];
            $vehicleTypesSize = $stream->readInt32();
            for ($vehicleTypesIndex = 0; $vehicleTypesIndex < $vehicleTypesSize; $vehicleTypesIndex++) {
                $vehicleTypesElement = \Model\VehicleType::readFrom($stream);
                $vehicleTypes[] = $vehicleTypesElement;
            }
            $refillSpeed = $stream->readDouble();
            $questCount = $stream->readInt32();
            $questScore = \Model\MinMaxRangeLong::readFrom($stream);
            $traffic = \Model\Traffic::readFrom($stream);
            $collisionPenaltyModifier = $stream->readDouble();
            $city = [];
            $citySize = $stream->readInt32();
            for ($cityIndex = 0; $cityIndex < $citySize; $cityIndex++) {
                $cityElement = [];
                $cityElementSize = $stream->readInt32();
                for ($cityElementIndex = 0; $cityElementIndex < $cityElementSize; $cityElementIndex++) {
                    $cityElementElement = \Model\CityCell::readFrom($stream);
                    $cityElement[] = $cityElementElement;
                }
                $city[] = $cityElement;
            }
            return new Constants($maxTickCount, $maxGameTimeSeconds, $ticksPerSecond, $microticks, $cellSize, $collisionBounciness, $cityType, $vehicleTypes, $refillSpeed, $questCount, $questScore, $traffic, $collisionPenaltyModifier, $city);
        }
        
        /**
         * Write Constants to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32($this->maxTickCount);
            $stream->writeDouble($this->maxGameTimeSeconds);
            $stream->writeDouble($this->ticksPerSecond);
            $stream->writeInt32($this->microticks);
            $stream->writeDouble($this->cellSize);
            $stream->writeDouble($this->collisionBounciness);
            $this->cityType->writeTo($stream);
            $stream->writeInt32(count($this->vehicleTypes));
            foreach ($this->vehicleTypes as $element) {
                $element->writeTo($stream);
            }
            $stream->writeDouble($this->refillSpeed);
            $stream->writeInt32($this->questCount);
            $this->questScore->writeTo($stream);
            $this->traffic->writeTo($stream);
            $stream->writeDouble($this->collisionPenaltyModifier);
            $stream->writeInt32(count($this->city));
            foreach ($this->city as $element) {
                $stream->writeInt32(count($element));
                foreach ($element as $element) {
                    $stream->writeInt32($element);
                }
            }
        }
    }
}