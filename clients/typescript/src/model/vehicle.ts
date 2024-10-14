import { Quest } from "./quest";
import { Vec2Double } from "./vec2-double";
import { Stream } from "../stream";

/**
 * TODO - Document
 */
export class Vehicle {
    /**
     * TODO - Document
     */
    position: Vec2Double
    /**
     * TODO - Document
     */
    velocity: Vec2Double
    /**
     * TODO - Document
     */
    speed: number
    /**
     * TODO - Document
     */
    rotationSpeed: number
    /**
     * TODO - Document
     */
    rotation: number
    /**
     * TODO - Document
     */
    typeIndex: number
    /**
     * TODO maybe multiple quests at the same time?
     */
    quest: Quest | null
    /**
     * TODO - Document
     */
    fuel: number

    constructor(position: Vec2Double, velocity: Vec2Double, speed: number, rotationSpeed: number, rotation: number, typeIndex: number, quest: Quest | null, fuel: number) {
        this.position = position;
        this.velocity = velocity;
        this.speed = speed;
        this.rotationSpeed = rotationSpeed;
        this.rotation = rotation;
        this.typeIndex = typeIndex;
        this.quest = quest;
        this.fuel = fuel;
    }

    /**
     * Read Vehicle from input stream
     */
    static async readFrom(stream: Stream): Promise<Vehicle> {
        let position;
        position = await Vec2Double.readFrom(stream);
        let velocity;
        velocity = await Vec2Double.readFrom(stream);
        let speed;
        speed = await stream.readDouble();
        let rotationSpeed;
        rotationSpeed = await stream.readDouble();
        let rotation;
        rotation = await stream.readDouble();
        let typeIndex;
        typeIndex = await stream.readInt();
        let quest;
        if (await stream.readBool()) {
            quest = await Quest.readFrom(stream);
        } else {
            quest = null;
        }
        let fuel;
        fuel = await stream.readDouble();
        return new Vehicle(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel)
    }

    /**
     * Write Vehicle to output stream
     */
    async writeTo(stream: Stream) {
        let position = this.position;
        await position.writeTo(stream);
        let velocity = this.velocity;
        await velocity.writeTo(stream);
        let speed = this.speed;
        await stream.writeDouble(speed);
        let rotationSpeed = this.rotationSpeed;
        await stream.writeDouble(rotationSpeed);
        let rotation = this.rotation;
        await stream.writeDouble(rotation);
        let typeIndex = this.typeIndex;
        await stream.writeInt(typeIndex);
        let quest = this.quest;
        if (quest === null) {
            await stream.writeBool(false);
        } else {
            await stream.writeBool(true);
            await quest.writeTo(stream);
        }
        let fuel = this.fuel;
        await stream.writeDouble(fuel);
    }
}