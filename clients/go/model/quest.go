package model

import "fmt"
import "io"
import . "komus24/stream"

// A delivery quest
type Quest struct {
    // Cell where to pick delivery from
    PickupCell Vec2Int32
    // Cell to drop the delivery at
    DropCell Vec2Int32
    // Score for completing the quest
    Score int64
}

func NewQuest(pickupCell Vec2Int32, dropCell Vec2Int32, score int64) Quest {
    return Quest {
        PickupCell: pickupCell,
        DropCell: dropCell,
        Score: score,
    }
}

// Read Quest from reader
func ReadQuest(reader io.Reader) Quest {
    var pickupCell Vec2Int32
    pickupCell = ReadVec2Int32(reader)
    var dropCell Vec2Int32
    dropCell = ReadVec2Int32(reader)
    var score int64
    score = ReadInt64(reader)
    return Quest {
        PickupCell: pickupCell,
        DropCell: dropCell,
        Score: score,
    }
}

// Write Quest to writer
func (quest Quest) Write(writer io.Writer) {
    pickupCell := quest.PickupCell
    pickupCell.Write(writer)
    dropCell := quest.DropCell
    dropCell.Write(writer)
    score := quest.Score
    WriteInt64(writer, score)
}

// Get string representation of Quest
func (quest Quest) String() string {
    stringResult := "{ "
    stringResult += "PickupCell: "
    pickupCell := quest.PickupCell
    stringResult += pickupCell.String()
    stringResult += ", "
    stringResult += "DropCell: "
    dropCell := quest.DropCell
    stringResult += dropCell.String()
    stringResult += ", "
    stringResult += "Score: "
    score := quest.Score
    stringResult += fmt.Sprint(score)
    stringResult += " }"
    return stringResult
}