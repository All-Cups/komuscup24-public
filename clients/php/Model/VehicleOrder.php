<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * Order for controlling a single vehicle
     */
    class VehicleOrder
    {
        /**
         * Acceleration (-1 - fully backwards, +1 - fully forward)
         */
        public float $accelerate;
        /**
         * Hand brakes
         */
        public bool $brakes;
        /**
         * Rotate the steering wheel (-1 - full clockwise, +1 - full counterclockwise)
         */
        public float $rotate;
    
        function __construct(float $accelerate, bool $brakes, float $rotate)
        {
            $this->accelerate = $accelerate;
            $this->brakes = $brakes;
            $this->rotate = $rotate;
        }
    
        /**
         * Read VehicleOrder from input stream
         */
        public static function readFrom(\InputStream $stream): VehicleOrder
        {
            $accelerate = $stream->readDouble();
            $brakes = $stream->readBool();
            $rotate = $stream->readDouble();
            return new VehicleOrder($accelerate, $brakes, $rotate);
        }
        
        /**
         * Write VehicleOrder to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeDouble($this->accelerate);
            $stream->writeBool($this->brakes);
            $stream->writeDouble($this->rotate);
        }
    }
}