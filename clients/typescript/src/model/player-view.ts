import { Player } from "./player";
import { Quest } from "./quest";
import { Stream } from "../stream";

/**
 * Current game's state
 */
export class PlayerView {
    /**
     * Current tick number
     */
    currentTick: number
    /**
     * Your player
     */
    you: Player
    /**
     * Other players
     */
    other: Array<Player>
    /**
     * Available quests
     */
    quests: Array<Quest>

    constructor(currentTick: number, you: Player, other: Array<Player>, quests: Array<Quest>) {
        this.currentTick = currentTick;
        this.you = you;
        this.other = other;
        this.quests = quests;
    }

    /**
     * Read PlayerView from input stream
     */
    static async readFrom(stream: Stream): Promise<PlayerView> {
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
        return new PlayerView(currentTick, you, other, quests)
    }

    /**
     * Write PlayerView to output stream
     */
    async writeTo(stream: Stream) {
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