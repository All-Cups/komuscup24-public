<?php

namespace Model {
    require_once 'Model/Quest.php';
    require_once 'Model/Vec2Double.php';
    require_once 'Stream.php';

    /**
     * A vehicle
     */
    class Vehicle
    {
        /**
         * Current position (center)
         */
        public \Model\Vec2Double $position;
        /**
         * Velocity vector
         */
        public \Model\Vec2Double $velocity;
        /**
         * Speed of wheels
         */
        public float $speed;
        /**
         * Rotation speed (radians/second)
         */
        public float $rotationSpeed;
        /**
         * Current rotation
         */
        public float $rotation;
        /**
         * Vehicle type index
         */
        public int $typeIndex;
        /**
         * Current quest, if any
         */
        public ?\Model\Quest $quest;
        /**
         * Remaining fuel
         */
        public float $fuel;
    
        function __construct(\Model\Vec2Double $position, \Model\Vec2Double $velocity, float $speed, float $rotationSpeed, float $rotation, int $typeIndex, ?\Model\Quest $quest, float $fuel)
        {
            $this->position = $position;
            $this->velocity = $velocity;
            $this->speed = $speed;
            $this->rotationSpeed = $rotationSpeed;
            $this->rotation = $rotation;
            $this->typeIndex = $typeIndex;
            $this->quest = $quest;
            $this->fuel = $fuel;
        }
    
        /**
         * Read Vehicle from input stream
         */
        public static function readFrom(\InputStream $stream): Vehicle
        {
            $position = \Model\Vec2Double::readFrom($stream);
            $velocity = \Model\Vec2Double::readFrom($stream);
            $speed = $stream->readDouble();
            $rotationSpeed = $stream->readDouble();
            $rotation = $stream->readDouble();
            $typeIndex = $stream->readInt32();
            if ($stream->readBool()) {
                $quest = \Model\Quest::readFrom($stream);
            } else {
                $quest = NULL;
            }
            $fuel = $stream->readDouble();
            return new Vehicle($position, $velocity, $speed, $rotationSpeed, $rotation, $typeIndex, $quest, $fuel);
        }
        
        /**
         * Write Vehicle to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $this->position->writeTo($stream);
            $this->velocity->writeTo($stream);
            $stream->writeDouble($this->speed);
            $stream->writeDouble($this->rotationSpeed);
            $stream->writeDouble($this->rotation);
            $stream->writeInt32($this->typeIndex);
            if (is_null($this->quest)) {
                $stream->writeBool(false);
            } else {
                $stream->writeBool(true);
                $this->quest->writeTo($stream);
            }
            $stream->writeDouble($this->fuel);
        }
    }
}