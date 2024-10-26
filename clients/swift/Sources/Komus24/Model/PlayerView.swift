/// Current game's state
public struct PlayerView {
    /// Current tick number
    let currentTick: Int32

    /// Your player
    let you: Player

    /// Other players
    let other: [Player]

    /// Available quests
    let quests: [Quest]

    /// Read PlayerView from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> PlayerView {
        var currentTick: Int32
        currentTick = stream.readInt32()
        var you: Player
        you = Player.readFrom(stream)
        var other: [Player]
        let otherSize = stream.readInt32()
        other = (0..<otherSize).map{ _ in
            var otherSize: Player
            otherSize = Player.readFrom(stream)
            return otherSize
        }
        var quests: [Quest]
        let questsSize = stream.readInt32()
        quests = (0..<questsSize).map{ _ in
            var questsSize: Quest
            questsSize = Quest.readFrom(stream)
            return questsSize
        }
        return PlayerView(currentTick: currentTick, you: you, other: other, quests: quests)
    }

    /// Write PlayerView to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(currentTick)
        you.writeTo(stream)
        stream.writeInt32(Int32(other.count))
        for otherElement in other {
            otherElement.writeTo(stream)
        }
        stream.writeInt32(Int32(quests.count))
        for questsElement in quests {
            questsElement.writeTo(stream)
        }
    }
}