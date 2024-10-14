package komus24.model;

import komus24.util.StreamUtil;

/**
 * Current game's state
 */
public class PlayerView {
    /**
     * Current tick number
     */
    private int currentTick;

    /**
     * Current tick number
     */
    public int getCurrentTick() {
        return currentTick;
    }

    /**
     * Current tick number
     */
    public void setCurrentTick(int value) {
        this.currentTick = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Player you;

    /**
     * TODO - Document
     */
    public komus24.model.Player getYou() {
        return you;
    }

    /**
     * TODO - Document
     */
    public void setYou(komus24.model.Player value) {
        this.you = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Player[] other;

    /**
     * TODO - Document
     */
    public komus24.model.Player[] getOther() {
        return other;
    }

    /**
     * TODO - Document
     */
    public void setOther(komus24.model.Player[] value) {
        this.other = value;
    }
    /**
     * TODO - Document
     */
    private komus24.model.Quest[] quests;

    /**
     * TODO - Document
     */
    public komus24.model.Quest[] getQuests() {
        return quests;
    }

    /**
     * TODO - Document
     */
    public void setQuests(komus24.model.Quest[] value) {
        this.quests = value;
    }

    public PlayerView(int currentTick, komus24.model.Player you, komus24.model.Player[] other, komus24.model.Quest[] quests) {
        this.currentTick = currentTick;
        this.you = you;
        this.other = other;
        this.quests = quests;
    }

    /**
     * Read PlayerView from input stream
     */
    public static PlayerView readFrom(java.io.InputStream stream) throws java.io.IOException {
        int currentTick;
        currentTick = StreamUtil.readInt(stream);
        komus24.model.Player you;
        you = komus24.model.Player.readFrom(stream);
        komus24.model.Player[] other;
        other = new komus24.model.Player[StreamUtil.readInt(stream)];
        for (int otherIndex = 0; otherIndex < other.length; otherIndex++) {
            komus24.model.Player otherElement;
            otherElement = komus24.model.Player.readFrom(stream);
            other[otherIndex] = otherElement;
        }
        komus24.model.Quest[] quests;
        quests = new komus24.model.Quest[StreamUtil.readInt(stream)];
        for (int questsIndex = 0; questsIndex < quests.length; questsIndex++) {
            komus24.model.Quest questsElement;
            questsElement = komus24.model.Quest.readFrom(stream);
            quests[questsIndex] = questsElement;
        }
        return new PlayerView(currentTick, you, other, quests);
    }

    /**
     * Write PlayerView to output stream
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        StreamUtil.writeInt(stream, currentTick);
        you.writeTo(stream);
        StreamUtil.writeInt(stream, other.length);
        for (komus24.model.Player otherElement : other) {
            otherElement.writeTo(stream);
        }
        StreamUtil.writeInt(stream, quests.length);
        for (komus24.model.Quest questsElement : quests) {
            questsElement.writeTo(stream);
        }
    }

    /**
     * Get string representation of PlayerView
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlayerView { ");
        stringBuilder.append("currentTick: ");
        stringBuilder.append(String.valueOf(currentTick));
        stringBuilder.append(", ");
        stringBuilder.append("you: ");
        stringBuilder.append(String.valueOf(you));
        stringBuilder.append(", ");
        stringBuilder.append("other: ");
        stringBuilder.append("[ ");
        for (int otherIndex = 0; otherIndex < other.length; otherIndex++) {
            if (otherIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.Player otherElement = other[otherIndex];
            stringBuilder.append(String.valueOf(otherElement));
        }
        stringBuilder.append(" ]");
        stringBuilder.append(", ");
        stringBuilder.append("quests: ");
        stringBuilder.append("[ ");
        for (int questsIndex = 0; questsIndex < quests.length; questsIndex++) {
            if (questsIndex != 0) {
                stringBuilder.append(", ");
            }
            komus24.model.Quest questsElement = quests[questsIndex];
            stringBuilder.append(String.valueOf(questsElement));
        }
        stringBuilder.append(" ]");
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}