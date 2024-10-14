unit UVehicleOrder;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // TODO - Document
    TVehicleOrder = class
        // -1..+1
        accelerate: Double;
        // TODO - Document
        brakes: Boolean;
        // -1..+1
        rotate: Double;
        constructor Create(accelerate: Double; brakes: Boolean; rotate: Double);
        // Read VehicleOrder from input stream
        class function ReadFrom(stream: TStream): TVehicleOrder; static;
        // Write VehicleOrder to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TVehicleOrder.Create(accelerate: Double; brakes: Boolean; rotate: Double);
begin
    self.accelerate := accelerate;
    self.brakes := brakes;
    self.rotate := rotate;
end;

class function TVehicleOrder.ReadFrom(stream: TStream): TVehicleOrder;
var accelerate: Double;
var brakes: Boolean;
var rotate: Double;
begin
    accelerate := stream.ReadDouble;
    brakes := stream.ReadBoolean;
    rotate := stream.ReadDouble;
    result := TVehicleOrder.Create(accelerate, brakes, rotate);
end;

procedure TVehicleOrder.WriteTo(stream: TStream);
begin
    stream.WriteDouble(accelerate);
    stream.WriteBoolean(brakes);
    stream.WriteDouble(rotate);
end;

function TVehicleOrder.ToString: ansistring;
begin
    result := 'VehicleOrder {';
    result += 'accelerate=';
    result += FloatToStr(accelerate);
    result += ', ';  
    result += 'brakes=';
    result += BoolToStr(brakes);
    result += ', ';  
    result += 'rotate=';
    result += FloatToStr(rotate);
    result += '}';
end;

end.