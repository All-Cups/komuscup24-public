unit UCityType;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UVec2Int32 in 'Model/UVec2Int32.pas';

type
    // City type
    TCityType = class
        // Write CityType to output stream
        procedure WriteTo(stream: TStream); virtual; abstract;
        // Read CityType from input stream
        class function ReadFrom(stream: TStream): TCityType; static;
    end;

type
    // Auto generated manhattan map
    TCityTypeManhattan = class (TCityType)
        // Map size
        size: TVec2Int32;
        // Size of a single block
        blockSize: TVec2Int32;
        // Number of refill stations
        refills: Int32;
        constructor Create(size: TVec2Int32; blockSize: TVec2Int32; refills: Int32);
        // Read CityTypeManhattan from input stream
        class function ReadFrom(stream: TStream): TCityTypeManhattan; static;
        // Write CityTypeManhattan to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

type
    // Fixed map
    TCityTypeInline = class (TCityType)
        // Each string represents a row in the city
        cells: TArray<String>;
        constructor Create(cells: TArray<String>);
        // Read CityTypeInline from input stream
        class function ReadFrom(stream: TStream): TCityTypeInline; static;
        // Write CityTypeInline to output stream
        procedure WriteTo(stream: TStream); override;
        function ToString: ansistring; override;
    end;

implementation

class function TCityType.ReadFrom(stream: TStream): TCityType;
var tag: Int32;
begin
    tag := stream.ReadInt32;
    case tag of
        0: result := TCityTypeManhattan.ReadFrom(stream);
        1: result := TCityTypeInline.ReadFrom(stream);
        else raise Exception.Create('Unexpected tag value');
    end;
end;

constructor TCityTypeManhattan.Create(size: TVec2Int32; blockSize: TVec2Int32; refills: Int32);
begin
    self.size := size;
    self.blockSize := blockSize;
    self.refills := refills;
end;

class function TCityTypeManhattan.ReadFrom(stream: TStream): TCityTypeManhattan;
var blockSize: TVec2Int32;
var refills: Int32;
var size: TVec2Int32;
begin
    size := TVec2Int32.ReadFrom(stream);
    blockSize := TVec2Int32.ReadFrom(stream);
    refills := stream.ReadInt32;
    result := TCityTypeManhattan.Create(size, blockSize, refills);
end;

procedure TCityTypeManhattan.WriteTo(stream: TStream);
begin
    stream.WriteInt32(0);
    size.WriteTo(stream);
    blockSize.WriteTo(stream);
    stream.WriteInt32(refills);
end;

function TCityTypeManhattan.ToString: ansistring;
begin
    result := 'Manhattan {';
    result += 'size=';
    result += size.ToString;
    result += ', ';  
    result += 'blockSize=';
    result += blockSize.ToString;
    result += ', ';  
    result += 'refills=';
    result += IntToStr(refills);
    result += '}';
end;

constructor TCityTypeInline.Create(cells: TArray<String>);
begin
    self.cells := cells;
end;

class function TCityTypeInline.ReadFrom(stream: TStream): TCityTypeInline;
var cells: TArray<String>;
var cellsElement: String;
var cellsIndex: Int32;
begin
    cells := TArray<String>.Create;
    SetLength(cells, stream.ReadInt32);
    for cellsIndex := 0 to Length(cells) - 1 do begin
        cellsElement := stream.ReadString;
        cells[cellsIndex] := cellsElement;
    end;
    result := TCityTypeInline.Create(cells);
end;

procedure TCityTypeInline.WriteTo(stream: TStream);
var cellsElement: String;
begin
    stream.WriteInt32(1);
    stream.WriteInt32(Length(cells));
    for cellsElement in cells do begin
        stream.WriteString(cellsElement);
    end;
end;

function TCityTypeInline.ToString: ansistring;
var cellsElement: String;
var cellsIndex: Int32;
begin
    result := 'Inline {';
    result += 'cells=';
    result += '[';
    for cellsIndex := 0 to Length(cells) - 1 do begin
        if cellsIndex <> 0 then
            result += ', ';
        cellsElement := cells[cellsIndex];
        result += '''';
        result += cellsElement;
        result += '''';;
    end;
    result += ']';
    result += '}';
end;

end.