<?php

namespace Model {
    require_once 'Model/VehicleOrder.php';
    require_once 'Stream.php';

    /**
     * Player's orders
     */
    class Order
    {
        /**
         * TODO - Document
         */
        public array $vehicles;
    
        function __construct(array $vehicles)
        {
            $this->vehicles = $vehicles;
        }
    
        /**
         * Read Order from input stream
         */
        public static function readFrom(\InputStream $stream): Order
        {
            $vehicles = [];
            $vehiclesSize = $stream->readInt32();
            for ($vehiclesIndex = 0; $vehiclesIndex < $vehiclesSize; $vehiclesIndex++) {
                $vehiclesElement = \Model\VehicleOrder::readFrom($stream);
                $vehicles[] = $vehiclesElement;
            }
            return new Order($vehicles);
        }
        
        /**
         * Write Order to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(count($this->vehicles));
            foreach ($this->vehicles as $element) {
                $element->writeTo($stream);
            }
        }
    }
}