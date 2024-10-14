unit MyStrategy;

{$mode delphi}{$H+}

interface

uses
    UConstants in 'Model/UConstants.pas',
    UPlayerView in 'Model/UPlayerView.pas',
    UOrder in 'Model/UOrder.pas',
    Stream,
        SysUtils,
        UVehicleOrder in 'Model/UVehicleOrder.pas';

type
    TMyStrategy = class
        constructor Create(constants: TConstants);
        function GetOrder(playerView: TPlayerView): TOrder;
        procedure Finish();
    end;

implementation

constructor TMyStrategy.Create(constants: TConstants);
begin
end;

function TMyStrategy.GetOrder(playerView: TPlayerView): TOrder;
begin
    result := TOrder.Create(nil);
end;

procedure TMyStrategy.Finish();
begin
end;

end.