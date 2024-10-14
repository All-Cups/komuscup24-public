<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    class VehicleOrder
    {
        /**
         * -1..+1
         */
        public float $accelerate;
        /**
         * TODO - Document
         */
        public bool $brakes;
        /**
         * -1..+1
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