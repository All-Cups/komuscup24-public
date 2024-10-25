<?php

namespace Model {
    require_once 'Model/Vec2Int.php';
    require_once 'Stream.php';

    /**
     * A delivery quest
     */
    class Quest
    {
        /**
         * Cell where to pick delivery from
         */
        public \Model\Vec2Int $pickupCell;
        /**
         * Cell to drop the delivery at
         */
        public \Model\Vec2Int $dropCell;
        /**
         * Score for completing the quest
         */
        public int $score;
    
        function __construct(\Model\Vec2Int $pickupCell, \Model\Vec2Int $dropCell, int $score)
        {
            $this->pickupCell = $pickupCell;
            $this->dropCell = $dropCell;
            $this->score = $score;
        }
    
        /**
         * Read Quest from input stream
         */
        public static function readFrom(\InputStream $stream): Quest
        {
            $pickupCell = \Model\Vec2Int::readFrom($stream);
            $dropCell = \Model\Vec2Int::readFrom($stream);
            $score = $stream->readInt64();
            return new Quest($pickupCell, $dropCell, $score);
        }
        
        /**
         * Write Quest to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $this->pickupCell->writeTo($stream);
            $this->dropCell->writeTo($stream);
            $stream->writeInt64($this->score);
        }
    }
}