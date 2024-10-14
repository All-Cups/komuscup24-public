unit UVehicle;

{$mode delphi}{$H+}

interface

uses
    Nullable,
    Stream,
    SysUtils,
    UQuest in 'Model/UQuest.pas',
    UVec2Double in 'Model/UVec2Double.pas';

type
    // TODO - Document
    TVehicle = class
        // TODO - Document
        position: TVec2Double;
        // TODO - Document
        velocity: TVec2Double;
        // TODO - Document
        speed: Double;
        // TODO - Document
        rotationSpeed: Double;
        // TODO - Document
        rotation: Double;
        // TODO - Document
        typeIndex: Int32;
        // TODO maybe multiple quests at the same time?
        quest: TNullable<TQuest>;
        // TODO - Document
        fuel: Double;
        constructor Create(position: TVec2Double; velocity: TVec2Double; speed: Double; rotationSpeed: Double; rotation: Double; typeIndex: Int32; quest: TNullable<TQuest>; fuel: Double);
        // Read Vehicle from input stream
        class function ReadFrom(stream: TStream): TVehicle; static;
        // Write Vehicle to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TVehicle.Create(position: TVec2Double; velocity: TVec2Double; speed: Double; rotationSpeed: Double; rotation: Double; typeIndex: Int32; quest: TNullable<TQuest>; fuel: Double);
begin
    self.position := position;
    self.velocity := velocity;
    self.speed := speed;
    self.rotationSpeed := rotationSpeed;
    self.rotation := rotation;
    self.typeIndex := typeIndex;
    self.quest := quest;
    self.fuel := fuel;
end;

class function TVehicle.ReadFrom(stream: TStream): TVehicle;
var fuel: Double;
var position: TVec2Double;
var quest: TNullable<TQuest>;
var questValue: TQuest;
var rotation: Double;
var rotationSpeed: Double;
var speed: Double;
var typeIndex: Int32;
var velocity: TVec2Double;
begin
    position := TVec2Double.ReadFrom(stream);
    velocity := TVec2Double.ReadFrom(stream);
    speed := stream.ReadDouble;
    rotationSpeed := stream.ReadDouble;
    rotation := stream.ReadDouble;
    typeIndex := stream.ReadInt32;
    if stream.ReadBoolean then begin
        questValue := TQuest.ReadFrom(stream);
        quest := questValue;
    end else
        quest := nil;
    fuel := stream.ReadDouble;
    result := TVehicle.Create(position, velocity, speed, rotationSpeed, rotation, typeIndex, quest, fuel);
end;

procedure TVehicle.WriteTo(stream: TStream);
var questValue: TQuest;
begin
    position.WriteTo(stream);
    velocity.WriteTo(stream);
    stream.WriteDouble(speed);
    stream.WriteDouble(rotationSpeed);
    stream.WriteDouble(rotation);
    stream.WriteInt32(typeIndex);
    if quest.HasValue then begin
        stream.WriteBoolean(true);
        questValue := quest.Value;
        questValue.WriteTo(stream);
    end else
        stream.WriteBoolean(false);
    stream.WriteDouble(fuel);
end;

function TVehicle.ToString: ansistring;
var questValue: TQuest;
begin
    result := 'Vehicle {';
    result += 'position=';
    result += position.ToString;
    result += ', ';  
    result += 'velocity=';
    result += velocity.ToString;
    result += ', ';  
    result += 'speed=';
    result += FloatToStr(speed);
    result += ', ';  
    result += 'rotationSpeed=';
    result += FloatToStr(rotationSpeed);
    result += ', ';  
    result += 'rotation=';
    result += FloatToStr(rotation);
    result += ', ';  
    result += 'typeIndex=';
    result += IntToStr(typeIndex);
    result += ', ';  
    result += 'quest=';
    if quest.HasValue then begin
        questValue := quest.Value;
        result += questValue.ToString;
    end else
        result += 'nil';
    result += ', ';  
    result += 'fuel=';
    result += FloatToStr(fuel);
    result += '}';
end;

end.