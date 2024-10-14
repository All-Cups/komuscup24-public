<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    class Traffic
    {
        /**
         * TODO - Document
         */
        public int $amount;
        /**
         * TODO - Document
         */
        public float $moveTime;
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
        public float $crashDeceleration;
        /**
         * TODO - Document
         */
        public float $crashLifetime;
    
        function __construct(int $amount, float $moveTime, float $radius, float $weight, float $crashDeceleration, float $crashLifetime)
        {
            $this->amount = $amount;
            $this->moveTime = $moveTime;
            $this->radius = $radius;
            $this->weight = $weight;
            $this->crashDeceleration = $crashDeceleration;
            $this->crashLifetime = $crashLifetime;
        }
    
        /**
         * Read Traffic from input stream
         */
        public static function readFrom(\InputStream $stream): Traffic
        {
            $amount = $stream->readInt32();
            $moveTime = $stream->readDouble();
            $radius = $stream->readDouble();
            $weight = $stream->readDouble();
            $crashDeceleration = $stream->readDouble();
            $crashLifetime = $stream->readDouble();
            return new Traffic($amount, $moveTime, $radius, $weight, $crashDeceleration, $crashLifetime);
        }
        
        /**
         * Write Traffic to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32($this->amount);
            $stream->writeDouble($this->moveTime);
            $stream->writeDouble($this->radius);
            $stream->writeDouble($this->weight);
            $stream->writeDouble($this->crashDeceleration);
            $stream->writeDouble($this->crashLifetime);
        }
    }
}