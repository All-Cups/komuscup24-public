<?php

namespace Model {
    require_once 'Model/Player.php';
    require_once 'Model/Quest.php';
    require_once 'Stream.php';

    /**
     * Current game's state
     */
    class PlayerView
    {
        /**
         * Current tick number
         */
        public int $currentTick;
        /**
         * TODO - Document
         */
        public \Model\Player $you;
        /**
         * TODO - Document
         */
        public array $other;
        /**
         * TODO - Document
         */
        public array $quests;
    
        function __construct(int $currentTick, \Model\Player $you, array $other, array $quests)
        {
            $this->currentTick = $currentTick;
            $this->you = $you;
            $this->other = $other;
            $this->quests = $quests;
        }
    
        /**
         * Read PlayerView from input stream
         */
        public static function readFrom(\InputStream $stream): PlayerView
        {
            $currentTick = $stream->readInt32();
            $you = \Model\Player::readFrom($stream);
            $other = [];
            $otherSize = $stream->readInt32();
            for ($otherIndex = 0; $otherIndex < $otherSize; $otherIndex++) {
                $otherElement = \Model\Player::readFrom($stream);
                $other[] = $otherElement;
            }
            $quests = [];
            $questsSize = $stream->readInt32();
            for ($questsIndex = 0; $questsIndex < $questsSize; $questsIndex++) {
                $questsElement = \Model\Quest::readFrom($stream);
                $quests[] = $questsElement;
            }
            return new PlayerView($currentTick, $you, $other, $quests);
        }
        
        /**
         * Write PlayerView to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32($this->currentTick);
            $this->you->writeTo($stream);
            $stream->writeInt32(count($this->other));
            foreach ($this->other as $element) {
                $element->writeTo($stream);
            }
            $stream->writeInt32(count($this->quests));
            foreach ($this->quests as $element) {
                $element->writeTo($stream);
            }
        }
    }
}