<?php

require_once 'Codegame/ClientMessage.php';
require_once 'Debugging/DebugCommand.php';
require_once 'Model/DebugState.php';

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

    public function getState(): \Model\DebugState
    {
        (new \Codegame\ClientMessage\RequestDebugState())->writeTo($this->tcpStream->outputStream);
        $this->tcpStream->outputStream->flush();
        return \Model\DebugState\readFrom($this->tcpStream->inputStream);
    }

    function addCircle(\Model\Vec2Double $pos, float $radius): void
    {
        $this->add(new \Model\DebugData\Circle($pos, $radius));
    }

    function add(\Model\DebugData $debugData): void
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