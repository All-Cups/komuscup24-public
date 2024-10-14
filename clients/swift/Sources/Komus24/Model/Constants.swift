/// TODO - Document
public struct Constants {
    /// TODO - Document
    let maxTickCount: Int32

    /// TODO - Document
    let maxGameTimeSeconds: Double

    /// TODO - Document
    let ticksPerSecond: Double

    /// TODO - Document
    let microticks: Int32

    /// TODO - Document
    let cellSize: Double

    /// TODO - Document
    let collisionBounciness: Double

    /// TODO - Document
    let cityType: CityType

    /// TODO - Document
    let vehicleTypes: [VehicleType]

    /// TODO - Document
    let refillSpeed: Double

    /// TODO - Document
    let questCount: Int32

    /// TODO - Document
    let questScore: MinMaxRangeLong

    /// TODO - Document
    let traffic: Traffic

    /// TODO - Document
    let city: [[CityCell]]

    /// Read Constants from input stream
    static func readFrom<S: InputStream>(_ stream: S) -> Constants {
        var maxTickCount: Int32
        maxTickCount = stream.readInt32()
        var maxGameTimeSeconds: Double
        maxGameTimeSeconds = stream.readDouble()
        var ticksPerSecond: Double
        ticksPerSecond = stream.readDouble()
        var microticks: Int32
        microticks = stream.readInt32()
        var cellSize: Double
        cellSize = stream.readDouble()
        var collisionBounciness: Double
        collisionBounciness = stream.readDouble()
        var cityType: CityType
        cityType = CityType.readFrom(stream)
        var vehicleTypes: [VehicleType]
        let vehicleTypesSize = stream.readInt32()
        vehicleTypes = (0..<vehicleTypesSize).map{ _ in
            var vehicleTypesSize: VehicleType
            vehicleTypesSize = VehicleType.readFrom(stream)
            return vehicleTypesSize
        }
        var refillSpeed: Double
        refillSpeed = stream.readDouble()
        var questCount: Int32
        questCount = stream.readInt32()
        var questScore: MinMaxRangeLong
        questScore = MinMaxRangeLong.readFrom(stream)
        var traffic: Traffic
        traffic = Traffic.readFrom(stream)
        var city: [[CityCell]]
        let citySize = stream.readInt32()
        city = (0..<citySize).map{ _ in
            var citySize: [CityCell]
            let citySizeSize = stream.readInt32()
            citySize = (0..<citySizeSize).map{ _ in
                var citySizeSize: CityCell
                citySizeSize = CityCell.readFrom(stream)
                return citySizeSize
            }
            return citySize
        }
        return Constants(maxTickCount: maxTickCount, maxGameTimeSeconds: maxGameTimeSeconds, ticksPerSecond: ticksPerSecond, microticks: microticks, cellSize: cellSize, collisionBounciness: collisionBounciness, cityType: cityType, vehicleTypes: vehicleTypes, refillSpeed: refillSpeed, questCount: questCount, questScore: questScore, traffic: traffic, city: city)
    }

    /// Write Constants to output stream
    func writeTo<S: OutputStream>(_ stream: S) {
        stream.writeInt32(maxTickCount)
        stream.writeDouble(maxGameTimeSeconds)
        stream.writeDouble(ticksPerSecond)
        stream.writeInt32(microticks)
        stream.writeDouble(cellSize)
        stream.writeDouble(collisionBounciness)
        cityType.writeTo(stream)
        stream.writeInt32(Int32(vehicleTypes.count))
        for vehicleTypesElement in vehicleTypes {
            vehicleTypesElement.writeTo(stream)
        }
        stream.writeDouble(refillSpeed)
        stream.writeInt32(questCount)
        questScore.writeTo(stream)
        traffic.writeTo(stream)
        stream.writeInt32(Int32(city.count))
        for cityElement in city {
            stream.writeInt32(Int32(cityElement.count))
            for cityElementElement in cityElement {
                cityElementElement.writeTo(stream)
            }
        }
    }
}