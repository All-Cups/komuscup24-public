# Model

## `Vec2Int32`

Вектор в 2-х мерном пространстве

Поля:

- `x`: `int32` &mdash; Координата x
- `y`: `int32` &mdash; Координата y

## `CityType`

Тип карты города

Варианты:

- `Manhattan` &mdash; Автоматически сгенерированная карта манхэттенского типа

  Поля:

  - `size`: `Vec2Int32` &mdash; Размер карты
  - `block_size`: `Vec2Int32` &mdash; Размер блока зданий
  - `refills`: `int32` &mdash; Количество заправок

- `Inline` &mdash; Фиксированная карта

  Поля:

  - `cells`: `[string]` &mdash; Список строк представляющий карту

## `VehicleType`

Тип машины

Поля:

- `name`: `string` &mdash; Название
- `radius`: `float64` &mdash; Радиус
- `weight`: `float64` &mdash; Вес
- `max_backwards_speed`: `float64` &mdash; Максимальная скорость движения задом
- `max_speed`: `float64` &mdash; Максимальная скорость при движении вперед
- `acceleration`: `float64` &mdash; Ускорение
- `friction`: `float64` &mdash; Коэффициент трения шин с дорогой
- `max_rotate_speed`: `float64` &mdash; Максимальная скорость поворота
- `rotate_acceleration`: `float64` &mdash; Ускорение при изменении скорости поворота
- `max_fuel`: `float64` &mdash; Размер бака с топливом
- `fuel_use_speed`: `float64` &mdash; Скорость расхода топлива

## `MinMaxRangeInt64`

Диапазон значений

Поля:

- `min`: `int64` &mdash; Минимальное значение
- `max`: `int64` &mdash; Максимальное значение

## `Traffic`

Настройки машин траффика

Поля:

- `amount`: `int32` &mdash; Количество машин траффика
- `move_time`: `float64` &mdash; Время перехода между соседними ключевыми точками перемещения траффика
- `radius`: `float64` &mdash; Радиус всех машин траффика
- `weight`: `float64` &mdash; Вес всех машин траффика
- `crash_deceleration`: `float64` &mdash; Ускорение замедления сломанной машины
- `crash_lifetime`: `float64` &mdash; Время жизни сломанной машины

## `CityCell`

Ячейча карты города

Варианты:

* `Road` &mdash; Дорога
* `Building` &mdash; Здание
* `RefillStation` &mdash; Заправка

## `Constants`

Константы игры

Поля:

- `max_tick_count`: `int32` &mdash; Максимальная длительность игры в тиках
- `max_game_time_seconds`: `float64` &mdash; Максимальная длительность игры в секундах
- `ticks_per_second`: `float64` &mdash; Количество тиков симуляции в игровую секунду
- `microticks`: `int32` &mdash; Количество микротиков при симуляции физики
- `cell_size`: `float64` &mdash; Размер ячейчи города
- `collision_bounciness`: `float64` &mdash; Эластичность столкновений
- `city_type`: `CityType` &mdash; Тип карты города
- `vehicle_types`: `[VehicleType]` &mdash; Список типов машин
- `refill_speed`: `float64` &mdash; Скорость заправки топлива
- `quest_count`: `int32` &mdash; Количество постоянно доступных заданий
- `quest_score`: `MinMaxRangeInt64` &mdash; Диапазон очков за выполнение заданий
- `traffic`: `Traffic` &mdash; Настройки траффика
- `city`: `[[CityCell]]` &mdash; Карта города

## `Vec2Float64`

Вектор в 2-х мерном пространстве

Поля:

- `x`: `float64` &mdash; Координата x
- `y`: `float64` &mdash; Координата y

## `Quest`

Задание по перевозке груза

Поля:

- `pickup_cell`: `Vec2Int32` &mdash; Ячейка города, откуда нужно забрать груз
- `drop_cell`: `Vec2Int32` &mdash; Ячейка города, куда нужно привезти груз
- `score`: `int64` &mdash; Количество очков за выполнение задания

## `Vehicle`

Машина

Поля:

- `position`: `Vec2Float64` &mdash; Позиция центра машины
- `velocity`: `Vec2Float64` &mdash; Вектор скорости движения
- `speed`: `float64` &mdash; Скорость вращения колес
- `rotation_speed`: `float64` &mdash; Скорость поворота в радианах/секунду
- `rotation`: `float64` &mdash; Текущий поворот в радианах
- `type_index`: `int32` &mdash; Индекс типа машины
- `quest`: `Option<Quest>` &mdash; Задание, выполняемое машиной, если есть
- `fuel`: `float64` &mdash; Оставшееся количество топлива

## `Player`

Информация об игроке (участнике игры)

Поля:

- `index`: `int32` &mdash; Индекс игрока
- `score`: `int64` &mdash; Текущее количество очков
- `vehicles`: `[Vehicle]` &mdash; Список машин игрока

## `PlayerView`

Текущее состояние игры

Поля:

- `current_tick`: `int32` &mdash; Номер текущего тика
- `you`: `Player` &mdash; Ваш игрок
- `other`: `[Player]` &mdash; Остальные игроки
- `quests`: `[Quest]` &mdash; Доступные задания

## `DebugData`

В данный момент не используется

Варианты:

- `Circle` &mdash; Круг

  Поля:

  - `pos`: `Vec2Float64` &mdash; Центр круга
  - `radius`: `float64` &mdash; Радиус

## `VehicleOrder`

Управление машиной

Поля:

- `accelerate`: `float64` &mdash; Ускорение. -1 - полный назад, 1 - полный вперед
- `brakes`: `boolean` &mdash; Ручной тормоз
- `rotate`: `float64` &mdash; Поворот. -1 - максимально по часовой стрелке, 1 - максимально против часовой стрелке

## `Order`

Действия игрока

Поля:

- `vehicles`: `[VehicleOrder]` &mdash; Команды управления для каждой машины

## `DebugState`

В данный момент не используется

Поля:

- `pressed_keys`: `[string]` &mdash; В данный момент не используется