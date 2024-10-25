unit UPlayer;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UVehicle in 'Model/UVehicle.pas';

type
    // Player (game participant)
    TPlayer = class
        // Index
        index: Int32;
        // Current score
        score: Int64;
        // List of player's vehicles
        vehicles: TArray<TVehicle>;
        constructor Create(index: Int32; score: Int64; vehicles: TArray<TVehicle>);
        // Read Player from input stream
        class function ReadFrom(stream: TStream): TPlayer; static;
        // Write Player to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TPlayer.Create(index: Int32; score: Int64; vehicles: TArray<TVehicle>);
begin
    self.index := index;
    self.score := score;
    self.vehicles := vehicles;
end;

class function TPlayer.ReadFrom(stream: TStream): TPlayer;
var index: Int32;
var score: Int64;
var vehicles: TArray<TVehicle>;
var vehiclesElement: TVehicle;
var vehiclesIndex: Int32;
begin
    index := stream.ReadInt32;
    score := stream.ReadInt64;
    vehicles := TArray<TVehicle>.Create;
    SetLength(vehicles, stream.ReadInt32);
    for vehiclesIndex := 0 to Length(vehicles) - 1 do begin
        vehiclesElement := TVehicle.ReadFrom(stream);
        vehicles[vehiclesIndex] := vehiclesElement;
    end;
    result := TPlayer.Create(index, score, vehicles);
end;

procedure TPlayer.WriteTo(stream: TStream);
var vehiclesElement: TVehicle;
begin
    stream.WriteInt32(index);
    stream.WriteInt64(score);
    stream.WriteInt32(Length(vehicles));
    for vehiclesElement in vehicles do begin
        vehiclesElement.WriteTo(stream);
    end;
end;

function TPlayer.ToString: ansistring;
var vehiclesElement: TVehicle;
var vehiclesIndex: Int32;
begin
    result := 'Player {';
    result += 'index=';
    result += IntToStr(index);
    result += ', ';  
    result += 'score=';
    result += IntToStr(score);
    result += ', ';  
    result += 'vehicles=';
    result += '[';
    for vehiclesIndex := 0 to Length(vehicles) - 1 do begin
        if vehiclesIndex <> 0 then
            result += ', ';
        vehiclesElement := vehicles[vehiclesIndex];
        result += vehiclesElement.ToString;;
    end;
    result += ']';
    result += '}';
end;

end.