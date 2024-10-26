unit UDebugData;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UColor in 'Debugging/UColor.pas',
    UVec2Double in 'Model/UVec2Double.pas';

type
    // Data for debug rendering
    TDebugData = class
        // Write DebugData to output stream
        procedure WriteTo(stream: TStream); virtual; abstract;
        // Read DebugData from input stream
        class function ReadFrom(stream: TStream): TDebugData; static;
    end;

type
    // Circle
    TDebugDataCircle = class (TDebugData)
        // Center
        pos: TVec2Double;
        // Radius
        radius: Double;
        // Color
        color: TColor;
        constructor Create(pos: TVec2Double; radius: Double; color: TColor);
        // Read DebugDataCircle from input stream
        class function ReadFrom(stream: TStream): TDebugDataCircle; static;
        // Write DebugDataCircle to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

type
    // Line (segment)
    TDebugDataLine = class (TDebugData)
        // First end
        point1: TVec2Double;
        // Other end
        point2: TVec2Double;
        // Thickness
        width: Double;
        // Color
        color: TColor;
        constructor Create(point1: TVec2Double; point2: TVec2Double; width: Double; color: TColor);
        // Read DebugDataLine from input stream
        class function ReadFrom(stream: TStream): TDebugDataLine; static;
        // Write DebugDataLine to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

type
    // Rectangle
    TDebugDataRect = class (TDebugData)
        // One of the corners
        corner1: TVec2Double;
        // Opposite corner
        corner2: TVec2Double;
        // Color
        color: TColor;
        constructor Create(corner1: TVec2Double; corner2: TVec2Double; color: TColor);
        // Read DebugDataRect from input stream
        class function ReadFrom(stream: TStream): TDebugDataRect; static;
        // Write DebugDataRect to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

type
    // Text
    TDebugDataText = class (TDebugData)
        // Text to draw
        text: String;
        // Position
        pos: TVec2Double;
        // Font size
        size: Double;
        // Alignment (0 - left, 0.5 - center, 1 - right)
        align: Double;
        // Color
        color: TColor;
        constructor Create(text: String; pos: TVec2Double; size: Double; align: Double; color: TColor);
        // Read DebugDataText from input stream
        class function ReadFrom(stream: TStream): TDebugDataText; static;
        // Write DebugDataText to output stream
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
        1: result := TDebugDataLine.ReadFrom(stream);
        2: result := TDebugDataRect.ReadFrom(stream);
        3: result := TDebugDataText.ReadFrom(stream);
        else raise Exception.Create('Unexpected tag value');
    end;
end;

constructor TDebugDataCircle.Create(pos: TVec2Double; radius: Double; color: TColor);
begin
    self.pos := pos;
    self.radius := radius;
    self.color := color;
end;

class function TDebugDataCircle.ReadFrom(stream: TStream): TDebugDataCircle;
var color: TColor;
var pos: TVec2Double;
var radius: Double;
begin
    pos := TVec2Double.ReadFrom(stream);
    radius := stream.ReadDouble;
    color := TColor.ReadFrom(stream);
    result := TDebugDataCircle.Create(pos, radius, color);
end;

procedure TDebugDataCircle.WriteTo(stream: TStream);
begin
    stream.WriteInt32(0);
    pos.WriteTo(stream);
    stream.WriteDouble(radius);
    color.WriteTo(stream);
end;

function TDebugDataCircle.ToString: ansistring;
begin
    result := 'Circle {';
    result += 'pos=';
    result += pos.ToString;
    result += ', ';  
    result += 'radius=';
    result += FloatToStr(radius);
    result += ', ';  
    result += 'color=';
    result += color.ToString;
    result += '}';
end;

constructor TDebugDataLine.Create(point1: TVec2Double; point2: TVec2Double; width: Double; color: TColor);
begin
    self.point1 := point1;
    self.point2 := point2;
    self.width := width;
    self.color := color;
end;

class function TDebugDataLine.ReadFrom(stream: TStream): TDebugDataLine;
var color: TColor;
var point1: TVec2Double;
var point2: TVec2Double;
var width: Double;
begin
    point1 := TVec2Double.ReadFrom(stream);
    point2 := TVec2Double.ReadFrom(stream);
    width := stream.ReadDouble;
    color := TColor.ReadFrom(stream);
    result := TDebugDataLine.Create(point1, point2, width, color);
end;

procedure TDebugDataLine.WriteTo(stream: TStream);
begin
    stream.WriteInt32(1);
    point1.WriteTo(stream);
    point2.WriteTo(stream);
    stream.WriteDouble(width);
    color.WriteTo(stream);
end;

function TDebugDataLine.ToString: ansistring;
begin
    result := 'Line {';
    result += 'point1=';
    result += point1.ToString;
    result += ', ';  
    result += 'point2=';
    result += point2.ToString;
    result += ', ';  
    result += 'width=';
    result += FloatToStr(width);
    result += ', ';  
    result += 'color=';
    result += color.ToString;
    result += '}';
end;

constructor TDebugDataRect.Create(corner1: TVec2Double; corner2: TVec2Double; color: TColor);
begin
    self.corner1 := corner1;
    self.corner2 := corner2;
    self.color := color;
end;

class function TDebugDataRect.ReadFrom(stream: TStream): TDebugDataRect;
var color: TColor;
var corner1: TVec2Double;
var corner2: TVec2Double;
begin
    corner1 := TVec2Double.ReadFrom(stream);
    corner2 := TVec2Double.ReadFrom(stream);
    color := TColor.ReadFrom(stream);
    result := TDebugDataRect.Create(corner1, corner2, color);
end;

procedure TDebugDataRect.WriteTo(stream: TStream);
begin
    stream.WriteInt32(2);
    corner1.WriteTo(stream);
    corner2.WriteTo(stream);
    color.WriteTo(stream);
end;

function TDebugDataRect.ToString: ansistring;
begin
    result := 'Rect {';
    result += 'corner1=';
    result += corner1.ToString;
    result += ', ';  
    result += 'corner2=';
    result += corner2.ToString;
    result += ', ';  
    result += 'color=';
    result += color.ToString;
    result += '}';
end;

constructor TDebugDataText.Create(text: String; pos: TVec2Double; size: Double; align: Double; color: TColor);
begin
    self.text := text;
    self.pos := pos;
    self.size := size;
    self.align := align;
    self.color := color;
end;

class function TDebugDataText.ReadFrom(stream: TStream): TDebugDataText;
var align: Double;
var color: TColor;
var pos: TVec2Double;
var size: Double;
var text: String;
begin
    text := stream.ReadString;
    pos := TVec2Double.ReadFrom(stream);
    size := stream.ReadDouble;
    align := stream.ReadDouble;
    color := TColor.ReadFrom(stream);
    result := TDebugDataText.Create(text, pos, size, align, color);
end;

procedure TDebugDataText.WriteTo(stream: TStream);
begin
    stream.WriteInt32(3);
    stream.WriteString(text);
    pos.WriteTo(stream);
    stream.WriteDouble(size);
    stream.WriteDouble(align);
    color.WriteTo(stream);
end;

function TDebugDataText.ToString: ansistring;
begin
    result := 'Text {';
    result += 'text=';
    result += '''';
    result += text;
    result += '''';
    result += ', ';  
    result += 'pos=';
    result += pos.ToString;
    result += ', ';  
    result += 'size=';
    result += FloatToStr(size);
    result += ', ';  
    result += 'align=';
    result += FloatToStr(align);
    result += ', ';  
    result += 'color=';
    result += color.ToString;
    result += '}';
end;

end.