package codegame

import "io"
import . "komus24/debugging"
import . "komus24/model"
import . "komus24/stream"

// Message sent from client
type ClientMessage interface {
    // Write ClientMessage to writer
    Write(writer io.Writer)

    // Get string representation of ClientMessage
    String() string
}

// Read ClientMessage from reader
func ReadClientMessage(reader io.Reader) ClientMessage {
    switch ReadInt32(reader) {
    case 0:
        return ReadClientMessageDebugMessage(reader)
    case 1:
        return ReadClientMessageOrderMessage(reader)
    case 2:
        return ReadClientMessageDebugUpdateDone(reader)
    case 3:
        return ReadClientMessageRequestDebugState(reader)
    }
    panic("Unexpected tag value")
}

// Ask app to perform new debug command
type ClientMessageDebugMessage struct {
    // Command to perform
    Command DebugCommand
}

func NewClientMessageDebugMessage(command DebugCommand) ClientMessageDebugMessage {
    return ClientMessageDebugMessage {
        Command: command,
    }
}

// Read DebugMessage from reader
func ReadClientMessageDebugMessage(reader io.Reader) ClientMessageDebugMessage {
    var command DebugCommand
    command = ReadDebugCommand(reader)
    return ClientMessageDebugMessage {
        Command: command,
    }
}

// Write DebugMessage to writer
func (clientMessageDebugMessage ClientMessageDebugMessage) Write(writer io.Writer) {
    WriteInt32(writer, 0)
    command := clientMessageDebugMessage.Command
    command.Write(writer)
}

// Get string representation of DebugMessage
func (clientMessageDebugMessage ClientMessageDebugMessage) String() string {
    stringResult := "{ "
    stringResult += "Command: "
    command := clientMessageDebugMessage.Command
    stringResult += command.String()
    stringResult += " }"
    return stringResult
}

// Reply for ServerMessage::GetOrder
type ClientMessageOrderMessage struct {
    // Player's order
    Order Order
}

func NewClientMessageOrderMessage(order Order) ClientMessageOrderMessage {
    return ClientMessageOrderMessage {
        Order: order,
    }
}

// Read OrderMessage from reader
func ReadClientMessageOrderMessage(reader io.Reader) ClientMessageOrderMessage {
    var order Order
    order = ReadOrder(reader)
    return ClientMessageOrderMessage {
        Order: order,
    }
}

// Write OrderMessage to writer
func (clientMessageOrderMessage ClientMessageOrderMessage) Write(writer io.Writer) {
    WriteInt32(writer, 1)
    order := clientMessageOrderMessage.Order
    order.Write(writer)
}

// Get string representation of OrderMessage
func (clientMessageOrderMessage ClientMessageOrderMessage) String() string {
    stringResult := "{ "
    stringResult += "Order: "
    order := clientMessageOrderMessage.Order
    stringResult += order.String()
    stringResult += " }"
    return stringResult
}

// Signifies finish of the debug update
type ClientMessageDebugUpdateDone struct {
}

func NewClientMessageDebugUpdateDone() ClientMessageDebugUpdateDone {
    return ClientMessageDebugUpdateDone {
    }
}

// Read DebugUpdateDone from reader
func ReadClientMessageDebugUpdateDone(reader io.Reader) ClientMessageDebugUpdateDone {
    return ClientMessageDebugUpdateDone {
    }
}

// Write DebugUpdateDone to writer
func (clientMessageDebugUpdateDone ClientMessageDebugUpdateDone) Write(writer io.Writer) {
    WriteInt32(writer, 2)
}

// Get string representation of DebugUpdateDone
func (clientMessageDebugUpdateDone ClientMessageDebugUpdateDone) String() string {
    stringResult := "{ "
    stringResult += " }"
    return stringResult
}

// Request debug state from the app
type ClientMessageRequestDebugState struct {
}

func NewClientMessageRequestDebugState() ClientMessageRequestDebugState {
    return ClientMessageRequestDebugState {
    }
}

// Read RequestDebugState from reader
func ReadClientMessageRequestDebugState(reader io.Reader) ClientMessageRequestDebugState {
    return ClientMessageRequestDebugState {
    }
}

// Write RequestDebugState to writer
func (clientMessageRequestDebugState ClientMessageRequestDebugState) Write(writer io.Writer) {
    WriteInt32(writer, 3)
}

// Get string representation of RequestDebugState
func (clientMessageRequestDebugState ClientMessageRequestDebugState) String() string {
    stringResult := "{ "
    stringResult += " }"
    return stringResult
}