<?php

namespace Model {
    require_once 'Model/Vec2Double.php';
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    abstract class DebugData
    {
        /**
         * Write DebugData to output stream
         */
        abstract function writeTo(\OutputStream $stream): void;

        /**
         * Read DebugData from input stream
         */
        static function readFrom(\InputStream $stream): DebugData
        {
            $tag = $stream->readInt32();
            if ($tag == \Model\DebugData\Circle::TAG) {
                return \Model\DebugData\Circle::readFrom($stream);
            }
            throw new Exception('Unexpected tag value');
        }
    }
}

namespace Model\DebugData {
    /**
     * TODO - Document
     */
    class Circle extends \Model\DebugData
    {
        const TAG = 0;
    
        /**
         * TODO - Document
         */
        public \Model\Vec2Double $pos;
        /**
         * TODO - Document
         */
        public float $radius;
    
        function __construct(\Model\Vec2Double $pos, float $radius)
        {
            $this->pos = $pos;
            $this->radius = $radius;
        }
    
        /**
         * Read Circle from input stream
         */
        public static function readFrom(\InputStream $stream): Circle
        {
            $pos = \Model\Vec2Double::readFrom($stream);
            $radius = $stream->readDouble();
            return new Circle($pos, $radius);
        }
        
        /**
         * Write Circle to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Circle::TAG);
            $this->pos->writeTo($stream);
            $stream->writeDouble($this->radius);
        }
    }
}