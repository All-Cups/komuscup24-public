<?php

namespace Debugging {
    require_once 'Stream.php';

    /**
     * App state for debugging
     */
    class DebugState
    {
        /**
         * Currently pressed keys
         */
        public array $pressedKeys;
    
        function __construct(array $pressedKeys)
        {
            $this->pressedKeys = $pressedKeys;
        }
    
        /**
         * Read DebugState from input stream
         */
        public static function readFrom(\InputStream $stream): DebugState
        {
            $pressedKeys = [];
            $pressedKeysSize = $stream->readInt32();
            for ($pressedKeysIndex = 0; $pressedKeysIndex < $pressedKeysSize; $pressedKeysIndex++) {
                $pressedKeysElement = $stream->readString();
                $pressedKeys[] = $pressedKeysElement;
            }
            return new DebugState($pressedKeys);
        }
        
        /**
         * Write DebugState to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(count($this->pressedKeys));
            foreach ($this->pressedKeys as $element) {
                $stream->writeString($element);
            }
        }
    }
}