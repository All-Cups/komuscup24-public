unit UVehicleType;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // TODO - Document
    TVehicleType = class
        // TODO - Document
        name: String;
        // TODO - Document
        radius: Double;
        // TODO - Document
        weight: Double;
        // TODO - Document
        maxBackwardsSpeed: Double;
        // TODO - Document
        maxSpeed: Double;
        // TODO - Document
        acceleration: Double;
        // TODO - Document
        friction: Double;
        // TODO - Document
        maxRotateSpeed: Double;
        // TODO - Document
        rotateAcceleration: Double;
        // TODO - Document
        maxFuel: Double;
        // TODO - Document
        fuelUseSpeed: Double;
        constructor Create(name: String; radius: Double; weight: Double; maxBackwardsSpeed: Double; maxSpeed: Double; acceleration: Double; friction: Double; maxRotateSpeed: Double; rotateAcceleration: Double; maxFuel: Double; fuelUseSpeed: Double);
        // Read VehicleType from input stream
        class function ReadFrom(stream: TStream): TVehicleType; static;
        // Write VehicleType to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TVehicleType.Create(name: String; radius: Double; weight: Double; maxBackwardsSpeed: Double; maxSpeed: Double; acceleration: Double; friction: Double; maxRotateSpeed: Double; rotateAcceleration: Double; maxFuel: Double; fuelUseSpeed: Double);
begin
    self.name := name;
    self.radius := radius;
    self.weight := weight;
    self.maxBackwardsSpeed := maxBackwardsSpeed;
    self.maxSpeed := maxSpeed;
    self.acceleration := acceleration;
    self.friction := friction;
    self.maxRotateSpeed := maxRotateSpeed;
    self.rotateAcceleration := rotateAcceleration;
    self.maxFuel := maxFuel;
    self.fuelUseSpeed := fuelUseSpeed;
end;

class function TVehicleType.ReadFrom(stream: TStream): TVehicleType;
var acceleration: Double;
var friction: Double;
var fuelUseSpeed: Double;
var maxBackwardsSpeed: Double;
var maxFuel: Double;
var maxRotateSpeed: Double;
var maxSpeed: Double;
var name: String;
var radius: Double;
var rotateAcceleration: Double;
var weight: Double;
begin
    name := stream.ReadString;
    radius := stream.ReadDouble;
    weight := stream.ReadDouble;
    maxBackwardsSpeed := stream.ReadDouble;
    maxSpeed := stream.ReadDouble;
    acceleration := stream.ReadDouble;
    friction := stream.ReadDouble;
    maxRotateSpeed := stream.ReadDouble;
    rotateAcceleration := stream.ReadDouble;
    maxFuel := stream.ReadDouble;
    fuelUseSpeed := stream.ReadDouble;
    result := TVehicleType.Create(name, radius, weight, maxBackwardsSpeed, maxSpeed, acceleration, friction, maxRotateSpeed, rotateAcceleration, maxFuel, fuelUseSpeed);
end;

procedure TVehicleType.WriteTo(stream: TStream);
begin
    stream.WriteString(name);
    stream.WriteDouble(radius);
    stream.WriteDouble(weight);
    stream.WriteDouble(maxBackwardsSpeed);
    stream.WriteDouble(maxSpeed);
    stream.WriteDouble(acceleration);
    stream.WriteDouble(friction);
    stream.WriteDouble(maxRotateSpeed);
    stream.WriteDouble(rotateAcceleration);
    stream.WriteDouble(maxFuel);
    stream.WriteDouble(fuelUseSpeed);
end;

function TVehicleType.ToString: ansistring;
begin
    result := 'VehicleType {';
    result += 'name=';
    result += '''';
    result += name;
    result += '''';
    result += ', ';  
    result += 'radius=';
    result += FloatToStr(radius);
    result += ', ';  
    result += 'weight=';
    result += FloatToStr(weight);
    result += ', ';  
    result += 'maxBackwardsSpeed=';
    result += FloatToStr(maxBackwardsSpeed);
    result += ', ';  
    result += 'maxSpeed=';
    result += FloatToStr(maxSpeed);
    result += ', ';  
    result += 'acceleration=';
    result += FloatToStr(acceleration);
    result += ', ';  
    result += 'friction=';
    result += FloatToStr(friction);
    result += ', ';  
    result += 'maxRotateSpeed=';
    result += FloatToStr(maxRotateSpeed);
    result += ', ';  
    result += 'rotateAcceleration=';
    result += FloatToStr(rotateAcceleration);
    result += ', ';  
    result += 'maxFuel=';
    result += FloatToStr(maxFuel);
    result += ', ';  
    result += 'fuelUseSpeed=';
    result += FloatToStr(fuelUseSpeed);
    result += '}';
end;

end.