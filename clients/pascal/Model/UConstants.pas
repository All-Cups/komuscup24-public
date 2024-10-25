unit UConstants;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UCityCell in 'Model/UCityCell.pas',
    UCityType in 'Model/UCityType.pas',
    UMinMaxRangeInt64 in 'Model/UMinMaxRangeInt64.pas',
    UTraffic in 'Model/UTraffic.pas',
    UVehicleType in 'Model/UVehicleType.pas';

type
    // Game constants
    TConstants = class
        // Max duration of the game in ticks
        maxTickCount: Int32;
        // Max game time in seconds
        maxGameTimeSeconds: Double;
        // Ticks per second
        ticksPerSecond: Double;
        // Subticks for physics simulation
        microticks: Int32;
        // Size of a single city cell
        cellSize: Double;
        // Collision bounciness
        collisionBounciness: Double;
        // City type
        cityType: TCityType;
        // List of vehicle types
        vehicleTypes: TArray<TVehicleType>;
        // Speed of refueling at a station
        refillSpeed: Double;
        // Number of available quests
        questCount: Int32;
        // Score range for quests
        questScore: TMinMaxRangeInt64;
        // Traffic options
        traffic: TTraffic;
        // Collision penalty modifier
        collisionPenaltyModifier: Double;
        // Map of the city
        city: TArray<TArray<TCityCell>>;
        constructor Create(maxTickCount: Int32; maxGameTimeSeconds: Double; ticksPerSecond: Double; microticks: Int32; cellSize: Double; collisionBounciness: Double; cityType: TCityType; vehicleTypes: TArray<TVehicleType>; refillSpeed: Double; questCount: Int32; questScore: TMinMaxRangeInt64; traffic: TTraffic; collisionPenaltyModifier: Double; city: TArray<TArray<TCityCell>>);
        // Read Constants from input stream
        class function ReadFrom(stream: TStream): TConstants; static;
        // Write Constants to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TConstants.Create(maxTickCount: Int32; maxGameTimeSeconds: Double; ticksPerSecond: Double; microticks: Int32; cellSize: Double; collisionBounciness: Double; cityType: TCityType; vehicleTypes: TArray<TVehicleType>; refillSpeed: Double; questCount: Int32; questScore: TMinMaxRangeInt64; traffic: TTraffic; collisionPenaltyModifier: Double; city: TArray<TArray<TCityCell>>);
begin
    self.maxTickCount := maxTickCount;
    self.maxGameTimeSeconds := maxGameTimeSeconds;
    self.ticksPerSecond := ticksPerSecond;
    self.microticks := microticks;
    self.cellSize := cellSize;
    self.collisionBounciness := collisionBounciness;
    self.cityType := cityType;
    self.vehicleTypes := vehicleTypes;
    self.refillSpeed := refillSpeed;
    self.questCount := questCount;
    self.questScore := questScore;
    self.traffic := traffic;
    self.collisionPenaltyModifier := collisionPenaltyModifier;
    self.city := city;
end;

class function TConstants.ReadFrom(stream: TStream): TConstants;
var cellSize: Double;
var city: TArray<TArray<TCityCell>>;
var cityElement: TArray<TCityCell>;
var cityElementElement: TCityCell;
var cityElementIndex: Int32;
var cityIndex: Int32;
var cityType: TCityType;
var collisionBounciness: Double;
var collisionPenaltyModifier: Double;
var maxGameTimeSeconds: Double;
var maxTickCount: Int32;
var microticks: Int32;
var questCount: Int32;
var questScore: TMinMaxRangeInt64;
var refillSpeed: Double;
var ticksPerSecond: Double;
var traffic: TTraffic;
var vehicleTypes: TArray<TVehicleType>;
var vehicleTypesElement: TVehicleType;
var vehicleTypesIndex: Int32;
begin
    maxTickCount := stream.ReadInt32;
    maxGameTimeSeconds := stream.ReadDouble;
    ticksPerSecond := stream.ReadDouble;
    microticks := stream.ReadInt32;
    cellSize := stream.ReadDouble;
    collisionBounciness := stream.ReadDouble;
    cityType := TCityType.ReadFrom(stream);
    vehicleTypes := TArray<TVehicleType>.Create;
    SetLength(vehicleTypes, stream.ReadInt32);
    for vehicleTypesIndex := 0 to Length(vehicleTypes) - 1 do begin
        vehicleTypesElement := TVehicleType.ReadFrom(stream);
        vehicleTypes[vehicleTypesIndex] := vehicleTypesElement;
    end;
    refillSpeed := stream.ReadDouble;
    questCount := stream.ReadInt32;
    questScore := TMinMaxRangeInt64.ReadFrom(stream);
    traffic := TTraffic.ReadFrom(stream);
    collisionPenaltyModifier := stream.ReadDouble;
    city := TArray<TArray<TCityCell>>.Create;
    SetLength(city, stream.ReadInt32);
    for cityIndex := 0 to Length(city) - 1 do begin
        cityElement := TArray<TCityCell>.Create;
        SetLength(cityElement, stream.ReadInt32);
        for cityElementIndex := 0 to Length(cityElement) - 1 do begin
            cityElementElement := TCityCell(stream.ReadInt32);
            cityElement[cityElementIndex] := cityElementElement;
        end;
        city[cityIndex] := cityElement;
    end;
    result := TConstants.Create(maxTickCount, maxGameTimeSeconds, ticksPerSecond, microticks, cellSize, collisionBounciness, cityType, vehicleTypes, refillSpeed, questCount, questScore, traffic, collisionPenaltyModifier, city);
end;

procedure TConstants.WriteTo(stream: TStream);
var cityElement: TArray<TCityCell>;
var cityElementElement: TCityCell;
var vehicleTypesElement: TVehicleType;
begin
    stream.WriteInt32(maxTickCount);
    stream.WriteDouble(maxGameTimeSeconds);
    stream.WriteDouble(ticksPerSecond);
    stream.WriteInt32(microticks);
    stream.WriteDouble(cellSize);
    stream.WriteDouble(collisionBounciness);
    cityType.WriteTo(stream);
    stream.WriteInt32(Length(vehicleTypes));
    for vehicleTypesElement in vehicleTypes do begin
        vehicleTypesElement.WriteTo(stream);
    end;
    stream.WriteDouble(refillSpeed);
    stream.WriteInt32(questCount);
    questScore.WriteTo(stream);
    traffic.WriteTo(stream);
    stream.WriteDouble(collisionPenaltyModifier);
    stream.WriteInt32(Length(city));
    for cityElement in city do begin
        stream.WriteInt32(Length(cityElement));
        for cityElementElement in cityElement do begin
            stream.WriteInt32(ord(cityElementElement));
        end;
    end;
end;

function TConstants.ToString: ansistring;
var cityElement: TArray<TCityCell>;
var cityElementElement: TCityCell;
var cityElementElementName: String;
var cityElementIndex: Int32;
var cityIndex: Int32;
var vehicleTypesElement: TVehicleType;
var vehicleTypesIndex: Int32;
begin
    result := 'Constants {';
    result += 'maxTickCount=';
    result += IntToStr(maxTickCount);
    result += ', ';  
    result += 'maxGameTimeSeconds=';
    result += FloatToStr(maxGameTimeSeconds);
    result += ', ';  
    result += 'ticksPerSecond=';
    result += FloatToStr(ticksPerSecond);
    result += ', ';  
    result += 'microticks=';
    result += IntToStr(microticks);
    result += ', ';  
    result += 'cellSize=';
    result += FloatToStr(cellSize);
    result += ', ';  
    result += 'collisionBounciness=';
    result += FloatToStr(collisionBounciness);
    result += ', ';  
    result += 'cityType=';
    result += cityType.ToString;
    result += ', ';  
    result += 'vehicleTypes=';
    result += '[';
    for vehicleTypesIndex := 0 to Length(vehicleTypes) - 1 do begin
        if vehicleTypesIndex <> 0 then
            result += ', ';
        vehicleTypesElement := vehicleTypes[vehicleTypesIndex];
        result += vehicleTypesElement.ToString;;
    end;
    result += ']';
    result += ', ';  
    result += 'refillSpeed=';
    result += FloatToStr(refillSpeed);
    result += ', ';  
    result += 'questCount=';
    result += IntToStr(questCount);
    result += ', ';  
    result += 'questScore=';
    result += questScore.ToString;
    result += ', ';  
    result += 'traffic=';
    result += traffic.ToString;
    result += ', ';  
    result += 'collisionPenaltyModifier=';
    result += FloatToStr(collisionPenaltyModifier);
    result += ', ';  
    result += 'city=';
    result += '[';
    for cityIndex := 0 to Length(city) - 1 do begin
        if cityIndex <> 0 then
            result += ', ';
        cityElement := city[cityIndex];
        result += '[';
        for cityElementIndex := 0 to Length(cityElement) - 1 do begin
            if cityElementIndex <> 0 then
                result += ', ';
            cityElementElement := cityElement[cityElementIndex];
            WriteStr(cityElementElementName, cityElementElement);
            result += cityElementElementName;;
        end;
        result += ']';;
    end;
    result += ']';
    result += '}';
end;

end.