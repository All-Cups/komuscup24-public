<?php

namespace Model {
    require_once 'Stream.php';

    /**
     * City cell
     */
    abstract class CityCell
    {
        /**
         * Road
         */
        const ROAD = 0;

        /**
         * Building
         */
        const BUILDING = 1;

        /**
         * Refill station
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