<?php

require_once 'Model/PlayerView.php';
require_once 'Model/Order.php';
require_once 'Model/Constants.php';

class MyStrategy
{
    function __construct(\Model\Constants $constants) {}
    function getOrder(\Model\PlayerView $playerView, ?DebugInterface $debugInterface): \Model\Order
    {
        return new \Model\Order([]);
    }
    function debugUpdate(int $displayedTick, DebugInterface $debugInterface) {}
    function finish() {}
}