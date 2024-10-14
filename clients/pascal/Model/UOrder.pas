unit UOrder;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UVehicleOrder in 'Model/UVehicleOrder.pas';

type
    // Player's orders
    TOrder = class
        // TODO - Document
        vehicles: TArray<TVehicleOrder>;
        constructor Create(vehicles: TArray<TVehicleOrder>);
        // Read Order from input stream
        class function ReadFrom(stream: TStream): TOrder; static;
        // Write Order to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TOrder.Create(vehicles: TArray<TVehicleOrder>);
begin
    self.vehicles := vehicles;
end;

class function TOrder.ReadFrom(stream: TStream): TOrder;
var vehicles: TArray<TVehicleOrder>;
var vehiclesElement: TVehicleOrder;
var vehiclesIndex: Int32;
begin
    vehicles := TArray<TVehicleOrder>.Create;
    SetLength(vehicles, stream.ReadInt32);
    for vehiclesIndex := 0 to Length(vehicles) - 1 do begin
        vehiclesElement := TVehicleOrder.ReadFrom(stream);
        vehicles[vehiclesIndex] := vehiclesElement;
    end;
    result := TOrder.Create(vehicles);
end;

procedure TOrder.WriteTo(stream: TStream);
var vehiclesElement: TVehicleOrder;
begin
    stream.WriteInt32(Length(vehicles));
    for vehiclesElement in vehicles do begin
        vehiclesElement.WriteTo(stream);
    end;
end;

function TOrder.ToString: ansistring;
var vehiclesElement: TVehicleOrder;
var vehiclesIndex: Int32;
begin
    result := 'Order {';
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