package model

import "fmt"
import "io"
import . "komus24/stream"

// Current game's state
type PlayerView struct {
    // Current tick number
    CurrentTick int32
    // TODO - Document
    You Player
    // TODO - Document
    Other []Player
    // TODO - Document
    Quests []Quest
}

func NewPlayerView(currentTick int32, you Player, other []Player, quests []Quest) PlayerView {
    return PlayerView {
        CurrentTick: currentTick,
        You: you,
        Other: other,
        Quests: quests,
    }
}

// Read PlayerView from reader
func ReadPlayerView(reader io.Reader) PlayerView {
    var currentTick int32
    currentTick = ReadInt32(reader)
    var you Player
    you = ReadPlayer(reader)
    var other []Player
    other = make([]Player, ReadInt32(reader))
    for otherIndex := range other {
        var otherElement Player
        otherElement = ReadPlayer(reader)
        other[otherIndex] = otherElement
    }
    var quests []Quest
    quests = make([]Quest, ReadInt32(reader))
    for questsIndex := range quests {
        var questsElement Quest
        questsElement = ReadQuest(reader)
        quests[questsIndex] = questsElement
    }
    return PlayerView {
        CurrentTick: currentTick,
        You: you,
        Other: other,
        Quests: quests,
    }
}

// Write PlayerView to writer
func (playerView PlayerView) Write(writer io.Writer) {
    currentTick := playerView.CurrentTick
    WriteInt32(writer, currentTick)
    you := playerView.You
    you.Write(writer)
    other := playerView.Other
    WriteInt32(writer, int32(len(other)))
    for _, otherElement := range other {
        otherElement.Write(writer)
    }
    quests := playerView.Quests
    WriteInt32(writer, int32(len(quests)))
    for _, questsElement := range quests {
        questsElement.Write(writer)
    }
}

// Get string representation of PlayerView
func (playerView PlayerView) String() string {
    stringResult := "{ "
    stringResult += "CurrentTick: "
    currentTick := playerView.CurrentTick
    stringResult += fmt.Sprint(currentTick)
    stringResult += ", "
    stringResult += "You: "
    you := playerView.You
    stringResult += you.String()
    stringResult += ", "
    stringResult += "Other: "
    other := playerView.Other
    stringResult += "[ "
    for otherIndex, otherElement := range other {
        if otherIndex != 0 {
            stringResult += ", "
        }
        stringResult += otherElement.String()
    }
    stringResult += " ]"
    stringResult += ", "
    stringResult += "Quests: "
    quests := playerView.Quests
    stringResult += "[ "
    for questsIndex, questsElement := range quests {
        if questsIndex != 0 {
            stringResult += ", "
        }
        stringResult += questsElement.String()
    }
    stringResult += " ]"
    stringResult += " }"
    return stringResult
}