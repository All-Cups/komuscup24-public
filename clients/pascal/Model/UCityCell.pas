unit UCityCell;

{$mode delphi}{$H+}

interface

uses
    Stream,
    SysUtils;

type
    // City cell
    {$scopedEnums on}
    TCityCell = (
        // Road
        Road = 0,
        // Building
        Building = 1,
        // Refill station
        RefillStation = 2);

implementation

end.