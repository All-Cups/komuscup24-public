unit UQuest;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UVec2Int32 in 'Model/UVec2Int32.pas';

type
    // TODO - Document
    TQuest = class
        // TODO - Document
        pickupCell: TVec2Int32;
        // TODO - Document
        dropCell: TVec2Int32;
        // TODO - Document
        score: Int64;
        constructor Create(pickupCell: TVec2Int32; dropCell: TVec2Int32; score: Int64);
        // Read Quest from input stream
        class function ReadFrom(stream: TStream): TQuest; static;
        // Write Quest to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TQuest.Create(pickupCell: TVec2Int32; dropCell: TVec2Int32; score: Int64);
begin
    self.pickupCell := pickupCell;
    self.dropCell := dropCell;
    self.score := score;
end;

class function TQuest.ReadFrom(stream: TStream): TQuest;
var dropCell: TVec2Int32;
var pickupCell: TVec2Int32;
var score: Int64;
begin
    pickupCell := TVec2Int32.ReadFrom(stream);
    dropCell := TVec2Int32.ReadFrom(stream);
    score := stream.ReadInt64;
    result := TQuest.Create(pickupCell, dropCell, score);
end;

procedure TQuest.WriteTo(stream: TStream);
begin
    pickupCell.WriteTo(stream);
    dropCell.WriteTo(stream);
    stream.WriteInt64(score);
end;

function TQuest.ToString: ansistring;
begin
    result := 'Quest {';
    result += 'pickupCell=';
    result += pickupCell.ToString;
    result += ', ';  
    result += 'dropCell=';
    result += dropCell.ToString;
    result += ', ';  
    result += 'score=';
    result += IntToStr(score);
    result += '}';
end;

end.