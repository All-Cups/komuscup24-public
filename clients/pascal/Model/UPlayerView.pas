unit UPlayerView;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils,
    UPlayer in 'Model/UPlayer.pas',
    UQuest in 'Model/UQuest.pas';

type
    // Current game's state
    TPlayerView = class
        // Current tick number
        currentTick: Int32;
        // TODO - Document
        you: TPlayer;
        // TODO - Document
        other: TArray<TPlayer>;
        // TODO - Document
        quests: TArray<TQuest>;
        constructor Create(currentTick: Int32; you: TPlayer; other: TArray<TPlayer>; quests: TArray<TQuest>);
        // Read PlayerView from input stream
        class function ReadFrom(stream: TStream): TPlayerView; static;
        // Write PlayerView to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TPlayerView.Create(currentTick: Int32; you: TPlayer; other: TArray<TPlayer>; quests: TArray<TQuest>);
begin
    self.currentTick := currentTick;
    self.you := you;
    self.other := other;
    self.quests := quests;
end;

class function TPlayerView.ReadFrom(stream: TStream): TPlayerView;
var currentTick: Int32;
var other: TArray<TPlayer>;
var otherElement: TPlayer;
var otherIndex: Int32;
var quests: TArray<TQuest>;
var questsElement: TQuest;
var questsIndex: Int32;
var you: TPlayer;
begin
    currentTick := stream.ReadInt32;
    you := TPlayer.ReadFrom(stream);
    other := TArray<TPlayer>.Create;
    SetLength(other, stream.ReadInt32);
    for otherIndex := 0 to Length(other) - 1 do begin
        otherElement := TPlayer.ReadFrom(stream);
        other[otherIndex] := otherElement;
    end;
    quests := TArray<TQuest>.Create;
    SetLength(quests, stream.ReadInt32);
    for questsIndex := 0 to Length(quests) - 1 do begin
        questsElement := TQuest.ReadFrom(stream);
        quests[questsIndex] := questsElement;
    end;
    result := TPlayerView.Create(currentTick, you, other, quests);
end;

procedure TPlayerView.WriteTo(stream: TStream);
var otherElement: TPlayer;
var questsElement: TQuest;
begin
    stream.WriteInt32(currentTick);
    you.WriteTo(stream);
    stream.WriteInt32(Length(other));
    for otherElement in other do begin
        otherElement.WriteTo(stream);
    end;
    stream.WriteInt32(Length(quests));
    for questsElement in quests do begin
        questsElement.WriteTo(stream);
    end;
end;

function TPlayerView.ToString: ansistring;
var otherElement: TPlayer;
var otherIndex: Int32;
var questsElement: TQuest;
var questsIndex: Int32;
begin
    result := 'PlayerView {';
    result += 'currentTick=';
    result += IntToStr(currentTick);
    result += ', ';  
    result += 'you=';
    result += you.ToString;
    result += ', ';  
    result += 'other=';
    result += '[';
    for otherIndex := 0 to Length(other) - 1 do begin
        if otherIndex <> 0 then
            result += ', ';
        otherElement := other[otherIndex];
        result += otherElement.ToString;;
    end;
    result += ']';
    result += ', ';  
    result += 'quests=';
    result += '[';
    for questsIndex := 0 to Length(quests) - 1 do begin
        if questsIndex <> 0 then
            result += ', ';
        questsElement := quests[questsIndex];
        result += questsElement.ToString;;
    end;
    result += ']';
    result += '}';
end;

end.