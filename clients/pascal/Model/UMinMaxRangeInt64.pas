unit UMinMaxRangeInt64;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // TODO - Document
    TMinMaxRangeInt64 = class
        // TODO - Document
        min: Int64;
        // TODO - Document
        max: Int64;
        constructor Create(min: Int64; max: Int64);
        // Read MinMaxRangeInt64 from input stream
        class function ReadFrom(stream: TStream): TMinMaxRangeInt64; static;
        // Write MinMaxRangeInt64 to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TMinMaxRangeInt64.Create(min: Int64; max: Int64);
begin
    self.min := min;
    self.max := max;
end;

class function TMinMaxRangeInt64.ReadFrom(stream: TStream): TMinMaxRangeInt64;
var max: Int64;
var min: Int64;
begin
    min := stream.ReadInt64;
    max := stream.ReadInt64;
    result := TMinMaxRangeInt64.Create(min, max);
end;

procedure TMinMaxRangeInt64.WriteTo(stream: TStream);
begin
    stream.WriteInt64(min);
    stream.WriteInt64(max);
end;

function TMinMaxRangeInt64.ToString: ansistring;
begin
    result := 'MinMaxRangeInt64 {';
    result += 'min=';
    result += IntToStr(min);
    result += ', ';  
    result += 'max=';
    result += IntToStr(max);
    result += '}';
end;

end.