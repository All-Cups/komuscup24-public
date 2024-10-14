module model.player_view;

import stream;
import std.conv;
import std.typecons : Nullable;
import model.player;
import model.quest;

/// Current game's state
struct PlayerView {
    /// Current tick number
    int currentTick;
    /// TODO - Document
    model.Player you;
    /// TODO - Document
    model.Player[] other;
    /// TODO - Document
    model.Quest[] quests;

    this(int currentTick, model.Player you, model.Player[] other, model.Quest[] quests) {
        this.currentTick = currentTick;
        this.you = you;
        this.other = other;
        this.quests = quests;
    }

    /// Read PlayerView from reader
    static PlayerView readFrom(Stream reader) {
        int currentTick;
        currentTick = reader.readInt();
        model.Player you;
        you = model.Player.readFrom(reader);
        model.Player[] other;
        other = new model.Player[reader.readInt()];
        for (int otherIndex = 0; otherIndex < other.length; otherIndex++) {
            model.Player otherKey;
            otherKey = model.Player.readFrom(reader);
            other[otherIndex] = otherKey;
        }
        model.Quest[] quests;
        quests = new model.Quest[reader.readInt()];
        for (int questsIndex = 0; questsIndex < quests.length; questsIndex++) {
            model.Quest questsKey;
            questsKey = model.Quest.readFrom(reader);
            quests[questsIndex] = questsKey;
        }
        return PlayerView(currentTick, you, other, quests);
    }

    /// Write PlayerView to writer
    void writeTo(Stream writer) const {
        writer.write(currentTick);
        you.writeTo(writer);
        writer.write(cast(int)(other.length));
        foreach (otherElement; other) {
            otherElement.writeTo(writer);
        }
        writer.write(cast(int)(quests.length));
        foreach (questsElement; quests) {
            questsElement.writeTo(writer);
        }
    }
}