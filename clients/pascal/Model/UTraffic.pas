unit UTraffic;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // Options for traffic
    TTraffic = class
        // Number of traffic cars
        amount: Int32;
        // Time to move between adjacent keypoints
        moveTime: Double;
        // Radius of each traffic car
        radius: Double;
        // Weight of each traffic car
        weight: Double;
        // Deceleration after crash
        crashDeceleration: Double;
        // Lifetime after crash
        crashLifetime: Double;
        constructor Create(amount: Int32; moveTime: Double; radius: Double; weight: Double; crashDeceleration: Double; crashLifetime: Double);
        // Read Traffic from input stream
        class function ReadFrom(stream: TStream): TTraffic; static;
        // Write Traffic to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TTraffic.Create(amount: Int32; moveTime: Double; radius: Double; weight: Double; crashDeceleration: Double; crashLifetime: Double);
begin
    self.amount := amount;
    self.moveTime := moveTime;
    self.radius := radius;
    self.weight := weight;
    self.crashDeceleration := crashDeceleration;
    self.crashLifetime := crashLifetime;
end;

class function TTraffic.ReadFrom(stream: TStream): TTraffic;
var amount: Int32;
var crashDeceleration: Double;
var crashLifetime: Double;
var moveTime: Double;
var radius: Double;
var weight: Double;
begin
    amount := stream.ReadInt32;
    moveTime := stream.ReadDouble;
    radius := stream.ReadDouble;
    weight := stream.ReadDouble;
    crashDeceleration := stream.ReadDouble;
    crashLifetime := stream.ReadDouble;
    result := TTraffic.Create(amount, moveTime, radius, weight, crashDeceleration, crashLifetime);
end;

procedure TTraffic.WriteTo(stream: TStream);
begin
    stream.WriteInt32(amount);
    stream.WriteDouble(moveTime);
    stream.WriteDouble(radius);
    stream.WriteDouble(weight);
    stream.WriteDouble(crashDeceleration);
    stream.WriteDouble(crashLifetime);
end;

function TTraffic.ToString: ansistring;
begin
    result := 'Traffic {';
    result += 'amount=';
    result += IntToStr(amount);
    result += ', ';  
    result += 'moveTime=';
    result += FloatToStr(moveTime);
    result += ', ';  
    result += 'radius=';
    result += FloatToStr(radius);
    result += ', ';  
    result += 'weight=';
    result += FloatToStr(weight);
    result += ', ';  
    result += 'crashDeceleration=';
    result += FloatToStr(crashDeceleration);
    result += ', ';  
    result += 'crashLifetime=';
    result += FloatToStr(crashLifetime);
    result += '}';
end;

end.