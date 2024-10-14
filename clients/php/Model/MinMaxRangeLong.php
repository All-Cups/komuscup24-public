<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    class MinMaxRangeLong
    {
        /**
         * TODO - Document
         */
        public int $min;
        /**
         * TODO - Document
         */
        public int $max;
    
        function __construct(int $min, int $max)
        {
            $this->min = $min;
            $this->max = $max;
        }
    
        /**
         * Read MinMaxRangeLong from input stream
         */
        public static function readFrom(\InputStream $stream): MinMaxRangeLong
        {
            $min = $stream->readInt64();
            $max = $stream->readInt64();
            return new MinMaxRangeLong($min, $max);
        }
        
        /**
         * Write MinMaxRangeLong to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt64($this->min);
            $stream->writeInt64($this->max);
        }
    }
}