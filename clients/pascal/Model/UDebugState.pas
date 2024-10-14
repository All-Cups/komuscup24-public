unit UDebugState;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // TODO - Document
    TDebugState = class
        // TODO - Document
        pressedKeys: TArray<String>;
        constructor Create(pressedKeys: TArray<String>);
        // Read DebugState from input stream
        class function ReadFrom(stream: TStream): TDebugState; static;
        // Write DebugState to output stream
        procedure WriteTo(stream: TStream);
        function ToString: ansistring; override;
    end;

implementation

constructor TDebugState.Create(pressedKeys: TArray<String>);
begin
    self.pressedKeys := pressedKeys;
end;

class function TDebugState.ReadFrom(stream: TStream): TDebugState;
var pressedKeys: TArray<String>;
var pressedKeysElement: String;
var pressedKeysIndex: Int32;
begin
    pressedKeys := TArray<String>.Create;
    SetLength(pressedKeys, stream.ReadInt32);
    for pressedKeysIndex := 0 to Length(pressedKeys) - 1 do begin
        pressedKeysElement := stream.ReadString;
        pressedKeys[pressedKeysIndex] := pressedKeysElement;
    end;
    result := TDebugState.Create(pressedKeys);
end;

procedure TDebugState.WriteTo(stream: TStream);
var pressedKeysElement: String;
begin
    stream.WriteInt32(Length(pressedKeys));
    for pressedKeysElement in pressedKeys do begin
        stream.WriteString(pressedKeysElement);
    end;
end;

function TDebugState.ToString: ansistring;
var pressedKeysElement: String;
var pressedKeysIndex: Int32;
begin
    result := 'DebugState {';
    result += 'pressedKeys=';
    result += '[';
    for pressedKeysIndex := 0 to Length(pressedKeys) - 1 do begin
        if pressedKeysIndex <> 0 then
            result += ', ';
        pressedKeysElement := pressedKeys[pressedKeysIndex];
        result += '''';
        result += pressedKeysElement;
        result += '''';;
    end;
    result += ']';
    result += '}';
end;

end.