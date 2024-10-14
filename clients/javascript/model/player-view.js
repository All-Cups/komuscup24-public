const Player = require.main.require('./model/player');
const Quest = require.main.require('./model/quest');
/**
 * Current game's state
 */
class PlayerView {
    /**
     * Current tick number
     */
    currentTick;
    /**
     * TODO - Document
     */
    you;
    /**
     * TODO - Document
     */
    other;
    /**
     * TODO - Document
     */
    quests;

    constructor(currentTick, you, other, quests) {
        this.currentTick = currentTick;
        this.you = you;
        this.other = other;
        this.quests = quests;
    }

    /**
     * Read PlayerView from input stream
     */
    static async readFrom(stream) {
        let currentTick;
        currentTick = await stream.readInt();
        let you;
        you = await Player.readFrom(stream);
        let other;
        other = [];
        for (let otherCount = await stream.readInt(); otherCount > 0; otherCount--) {
            let otherElement;
            otherElement = await Player.readFrom(stream);
            other.push(otherElement);
        }
        let quests;
        quests = [];
        for (let questsCount = await stream.readInt(); questsCount > 0; questsCount--) {
            let questsElement;
            questsElement = await Quest.readFrom(stream);
            quests.push(questsElement);
        }
        return new PlayerView(currentTick, you, other, quests);
    }

    /**
     * Write PlayerView to output stream
     */
    async writeTo(stream) {
        let currentTick = this.currentTick;
        await stream.writeInt(currentTick);
        let you = this.you;
        await you.writeTo(stream);
        let other = this.other;
        await stream.writeInt(other.length);
        for (let otherElement of other) {
            await otherElement.writeTo(stream);
        }
        let quests = this.quests;
        await stream.writeInt(quests.length);
        for (let questsElement of quests) {
            await questsElement.writeTo(stream);
        }
    }
}
module.exports = PlayerView