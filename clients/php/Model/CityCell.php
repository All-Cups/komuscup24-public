<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * TODO - Document
     */
    abstract class CityCell
    {
        /**
         * TODO - Document
         */
        const ROAD = 0;

        /**
         * TODO - Document
         */
        const BUILDING = 1;

        /**
         * TODO - Document
         */
        const REFILL_STATION = 2;

        /**
         * Read CityCell from input stream
         */
        public static function readFrom(\InputStream $stream): int
        {
            $result = $stream->readInt32();
            if (0 <= $result && $result < 3) {
                return $result;
            }
            throw new Exception('Unexpected tag value');
        }
    }
}