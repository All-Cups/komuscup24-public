unit UDebugData;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UVec2Double in 'Model/UVec2Double.pas';

type
    // TODO - Document
    TDebugData = class
        // Write DebugData to output stream
        procedure WriteTo(stream: TStream); virtual; abstract;
        // Read DebugData from input stream
        class function ReadFrom(stream: TStream): TDebugData; static;
    end;

type
    // TODO - Document
    TDebugDataCircle = class (TDebugData)
        // TODO - Document
        pos: TVec2Double;
        // TODO - Document
        radius: Double;
        constructor Create(pos: TVec2Double; radius: Double);
        // Read DebugDataCircle from input stream
        class function ReadFrom(stream: TStream): TDebugDataCircle; static;
        // Write DebugDataCircle to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

implementation

class function TDebugData.ReadFrom(stream: TStream): TDebugData;
var tag: Int32;
begin
    tag := stream.ReadInt32;
    case tag of
        0: result := TDebugDataCircle.ReadFrom(stream);
        else raise Exception.Create('Unexpected tag value');
    end;
end;

constructor TDebugDataCircle.Create(pos: TVec2Double; radius: Double);
begin
    self.pos := pos;
    self.radius := radius;
end;

class function TDebugDataCircle.ReadFrom(stream: TStream): TDebugDataCircle;
var pos: TVec2Double;
var radius: Double;
begin
    pos := TVec2Double.ReadFrom(stream);
    radius := stream.ReadDouble;
    result := TDebugDataCircle.Create(pos, radius);
end;

procedure TDebugDataCircle.WriteTo(stream: TStream);
begin
    stream.WriteInt32(0);
    pos.WriteTo(stream);
    stream.WriteDouble(radius);
end;

function TDebugDataCircle.ToString: ansistring;
begin
    result := 'Circle {';
    result += 'pos=';
    result += pos.ToString;
    result += ', ';  
    result += 'radius=';
    result += FloatToStr(radius);
    result += '}';
end;

end.