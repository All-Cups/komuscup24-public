<?php

namespace Model {
    require_once 'Model/Vehicle.php';
    require_once 'Stream.php';

    /**
     * Player (game participant)
     */
    class Player
    {
        /**
         * Index
         */
        public int $index;
        /**
         * Current score
         */
        public int $score;
        /**
         * List of player's vehicles
         */
        public array $vehicles;
    
        function __construct(int $index, int $score, array $vehicles)
        {
            $this->index = $index;
            $this->score = $score;
            $this->vehicles = $vehicles;
        }
    
        /**
         * Read Player from input stream
         */
        public static function readFrom(\InputStream $stream): Player
        {
            $index = $stream->readInt32();
            $score = $stream->readInt64();
            $vehicles = [];
            $vehiclesSize = $stream->readInt32();
            for ($vehiclesIndex = 0; $vehiclesIndex < $vehiclesSize; $vehiclesIndex++) {
                $vehiclesElement = \Model\Vehicle::readFrom($stream);
                $vehicles[] = $vehiclesElement;
            }
            return new Player($index, $score, $vehicles);
        }
        
        /**
         * Write Player to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32($this->index);
            $stream->writeInt64($this->score);
            $stream->writeInt32(count($this->vehicles));
            foreach ($this->vehicles as $element) {
                $element->writeTo($stream);
            }
        }
    }
}