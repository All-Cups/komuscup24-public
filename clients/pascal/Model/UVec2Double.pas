unit UVec2Double;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // 2 dimensional vector.
    TVec2Double = class
        // `x` coordinate of the vector
        x: Double;
        // `y` coordinate of the vector
        y: Double;
        constructor Create(x: Double; y: Double);
        // Read Vec2Double from input stream
        class function ReadFrom(stream: TStream): TVec2Double; static;
        // Write Vec2Double to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TVec2Double.Create(x: Double; y: Double);
begin
    self.x := x;
    self.y := y;
end;

class function TVec2Double.ReadFrom(stream: TStream): TVec2Double;
var x: Double;
var y: Double;
begin
    x := stream.ReadDouble;
    y := stream.ReadDouble;
    result := TVec2Double.Create(x, y);
end;

procedure TVec2Double.WriteTo(stream: TStream);
begin
    stream.WriteDouble(x);
    stream.WriteDouble(y);
end;

function TVec2Double.ToString: ansistring;
begin
    result := 'Vec2Double {';
    result += 'x=';
    result += FloatToStr(x);
    result += ', ';  
    result += 'y=';
    result += FloatToStr(y);
    result += '}';
end;

end.