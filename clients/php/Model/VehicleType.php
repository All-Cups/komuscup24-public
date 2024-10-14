<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    class VehicleType
    {
        /**
         * TODO - Document
         */
        public string $name;
        /**
         * TODO - Document
         */
        public float $radius;
        /**
         * TODO - Document
         */
        public float $weight;
        /**
         * TODO - Document
         */
        public float $maxBackwardsSpeed;
        /**
         * TODO - Document
         */
        public float $maxSpeed;
        /**
         * TODO - Document
         */
        public float $acceleration;
        /**
         * TODO - Document
         */
        public float $friction;
        /**
         * TODO - Document
         */
        public float $maxRotateSpeed;
        /**
         * TODO - Document
         */
        public float $rotateAcceleration;
        /**
         * TODO - Document
         */
        public float $maxFuel;
        /**
         * TODO - Document
         */
        public float $fuelUseSpeed;
    
        function __construct(string $name, float $radius, float $weight, float $maxBackwardsSpeed, float $maxSpeed, float $acceleration, float $friction, float $maxRotateSpeed, float $rotateAcceleration, float $maxFuel, float $fuelUseSpeed)
        {
            $this->name = $name;
            $this->radius = $radius;
            $this->weight = $weight;
            $this->maxBackwardsSpeed = $maxBackwardsSpeed;
            $this->maxSpeed = $maxSpeed;
            $this->acceleration = $acceleration;
            $this->friction = $friction;
            $this->maxRotateSpeed = $maxRotateSpeed;
            $this->rotateAcceleration = $rotateAcceleration;
            $this->maxFuel = $maxFuel;
            $this->fuelUseSpeed = $fuelUseSpeed;
        }
    
        /**
         * Read VehicleType from input stream
         */
        public static function readFrom(\InputStream $stream): VehicleType
        {
            $name = $stream->readString();
            $radius = $stream->readDouble();
            $weight = $stream->readDouble();
            $maxBackwardsSpeed = $stream->readDouble();
            $maxSpeed = $stream->readDouble();
            $acceleration = $stream->readDouble();
            $friction = $stream->readDouble();
            $maxRotateSpeed = $stream->readDouble();
            $rotateAcceleration = $stream->readDouble();
            $maxFuel = $stream->readDouble();
            $fuelUseSpeed = $stream->readDouble();
            return new VehicleType($name, $radius, $weight, $maxBackwardsSpeed, $maxSpeed, $acceleration, $friction, $maxRotateSpeed, $rotateAcceleration, $maxFuel, $fuelUseSpeed);
        }
        
        /**
         * Write VehicleType to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeString($this->name);
            $stream->writeDouble($this->radius);
            $stream->writeDouble($this->weight);
            $stream->writeDouble($this->maxBackwardsSpeed);
            $stream->writeDouble($this->maxSpeed);
            $stream->writeDouble($this->acceleration);
            $stream->writeDouble($this->friction);
            $stream->writeDouble($this->maxRotateSpeed);
            $stream->writeDouble($this->rotateAcceleration);
            $stream->writeDouble($this->maxFuel);
            $stream->writeDouble($this->fuelUseSpeed);
        }
    }
}