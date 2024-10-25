<?php

require_once 'Codegame/ClientMessage.php';
require_once 'Debugging/DebugCommand.php';
require_once 'Debugging/DebugState.php';

class DebugInterface
{
    private TcpStream $tcpStream;

    function __construct(TcpStream $tcpStream)
    {
        $this->tcpStream = $tcpStream;
    }

    public function send(\Debugging\DebugCommand $command): void
    {
        (new \Codegame\ClientMessage\DebugMessage($command))->writeTo($this->tcpStream->outputStream);
        $this->tcpStream->outputStream->flush();
    }

    public function getState(): \Debugging\DebugState
    {
        (new \Codegame\ClientMessage\RequestDebugState())->writeTo($this->tcpStream->outputStream);
        $this->tcpStream->outputStream->flush();
        return \Debugging\DebugState\readFrom($this->tcpStream->inputStream);
    }

    function addCircle(\Model\Vec2Double $pos, float $radius, \Debugging\Color $color): void
    {
        $this->add(new \Debugging\DebugData\Circle($pos, $radius, $color));
    }
    function addLine(\Model\Vec2Double $point1, \Model\Vec2Double $point2, float $width, \Debugging\Color $color): void
    {
        $this->add(new \Debugging\DebugData\Line($point1, $point2, $width, $color));
    }
    function addRect(\Model\Vec2Double $corner1, \Model\Vec2Double $corner2, \Debugging\Color $color): void
    {
        $this->add(new \Debugging\DebugData\Rect($corner1, $corner2, $color));
    }
    function addText(string $text, \Model\Vec2Double $pos, float $size, float $align, \Debugging\Color $color): void
    {
        $this->add(new \Debugging\DebugData\Text($text, $pos, $size, $align, $color));
    }

    function add(\Debugging\DebugData $debugData): void
    {
        $this->send(new \Debugging\DebugCommand\Add($debugData));
    }
    function clear(): void
    {
        $this->send(new \Debugging\DebugCommand\Clear());
    }
    function setAutoFlush(bool $enable): void
    {
        $this->send(new \Debugging\DebugCommand\SetAutoFlush($enable));
    }
    function flush(): void
    {
        $this->send(new \Debugging\DebugCommand\Flush());
    }
}