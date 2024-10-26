<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * Vehicle type options
     */
    class VehicleType
    {
        /**
         * Name
         */
        public string $name;
        /**
         * Radius
         */
        public float $radius;
        /**
         * Weight
         */
        public float $weight;
        /**
         * Maximal backwads movement speed
         */
        public float $maxBackwardsSpeed;
        /**
         * Maximal forward movement speed
         */
        public float $maxSpeed;
        /**
         * Acceleration
         */
        public float $acceleration;
        /**
         * Friction coefficient
         */
        public float $friction;
        /**
         * Maximal rotation speed
         */
        public float $maxRotateSpeed;
        /**
         * Rotational acceleration
         */
        public float $rotateAcceleration;
        /**
         * Maximal amount of fuel
         */
        public float $maxFuel;
        /**
         * Fuel usage speed
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