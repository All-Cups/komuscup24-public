<?php

namespace Model {
    require_once 'Model/Vec2Int.php';
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    abstract class CityType
    {
        /**
         * Write CityType to output stream
         */
        abstract function writeTo(\OutputStream $stream): void;

        /**
         * Read CityType from input stream
         */
        static function readFrom(\InputStream $stream): CityType
        {
            $tag = $stream->readInt32();
            if ($tag == \Model\CityType\Manhattan::TAG) {
                return \Model\CityType\Manhattan::readFrom($stream);
            }
            if ($tag == \Model\CityType\Inline::TAG) {
                return \Model\CityType\Inline::readFrom($stream);
            }
            throw new Exception('Unexpected tag value');
        }
    }
}

namespace Model\CityType {
    /**
     * TODO - Document
     */
    class Manhattan extends \Model\CityType
    {
        const TAG = 0;
    
        /**
         * TODO - Document
         */
        public \Model\Vec2Int $size;
        /**
         * TODO - Document
         */
        public \Model\Vec2Int $blockSize;
        /**
         * TODO - Document
         */
        public int $refills;
    
        function __construct(\Model\Vec2Int $size, \Model\Vec2Int $blockSize, int $refills)
        {
            $this->size = $size;
            $this->blockSize = $blockSize;
            $this->refills = $refills;
        }
    
        /**
         * Read Manhattan from input stream
         */
        public static function readFrom(\InputStream $stream): Manhattan
        {
            $size = \Model\Vec2Int::readFrom($stream);
            $blockSize = \Model\Vec2Int::readFrom($stream);
            $refills = $stream->readInt32();
            return new Manhattan($size, $blockSize, $refills);
        }
        
        /**
         * Write Manhattan to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Manhattan::TAG);
            $this->size->writeTo($stream);
            $this->blockSize->writeTo($stream);
            $stream->writeInt32($this->refills);
        }
    }

    /**
     * TODO - Document
     */
    class Inline extends \Model\CityType
    {
        const TAG = 1;
    
        /**
         * TODO - Document
         */
        public array $cells;
    
        function __construct(array $cells)
        {
            $this->cells = $cells;
        }
    
        /**
         * Read Inline from input stream
         */
        public static function readFrom(\InputStream $stream): Inline
        {
            $cells = [];
            $cellsSize = $stream->readInt32();
            for ($cellsIndex = 0; $cellsIndex < $cellsSize; $cellsIndex++) {
                $cellsElement = $stream->readString();
                $cells[] = $cellsElement;
            }
            return new Inline($cells);
        }
        
        /**
         * Write Inline to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Inline::TAG);
            $stream->writeInt32(count($this->cells));
            foreach ($this->cells as $element) {
                $stream->writeString($element);
            }
        }
    }
}