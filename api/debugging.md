# Debugging

## `Color`

Цвет в RGBA формате

Поля:

- `r`: `float64` &mdash; Компонента красного цвета
- `g`: `float64` &mdash; Компонента зеленого цвета
- `b`: `float64` &mdash; Компонента синего цвета
- `a`: `float64` &mdash; Альфа компонента (непрозрачность)

## `DebugData`

Данные для отладочной отрисовки

Варианты:

- `Circle` &mdash; Круг

  Поля:

  - `pos`: `Model::Vec2Float64` &mdash; Центр круга
  - `radius`: `float64` &mdash; Радиус
  - `color`: `Color` &mdash; Цвет

- `Line` &mdash; Линия (отрезок)

  Поля:

  - `point1`: `Model::Vec2Float64` &mdash; Первый конец
  - `point2`: `Model::Vec2Float64` &mdash; Второй конец
  - `width`: `float64` &mdash; Толщина
  - `color`: `Color` &mdash; Цвет

- `Rect` &mdash; Прямоугольник

  Поля:

  - `corner1`: `Model::Vec2Float64` &mdash; Один из углов
  - `corner2`: `Model::Vec2Float64` &mdash; Противоположный угол
  - `color`: `Color` &mdash; Цвет

- `Text` &mdash; Текст

  Поля:

  - `text`: `string` &mdash; Текст
  - `pos`: `Model::Vec2Float64` &mdash; Позиция
  - `size`: `float64` &mdash; Размер шрифта
  - `align`: `float64` &mdash; Выравнивание (0 - по левому краю, 0.5 - по центру, 1 - по правому краю)
  - `color`: `Color` &mdash; TODO - Document

## `DebugCommand`

Команды, которые могут быть отправлены приложению для помощи в отладке

Варианты:

- `Add` &mdash; Добавить отладочные данные в текущий тик

  Поля:

  - `debug_data`: `DebugData` &mdash; Данные для добавления

- `Clear` &mdash; Очистить отладочные данные текущего тика

  Нет полей

- `SetAutoFlush` &mdash; Включить/выключить автоматическое выполнение команд

  Поля:

  - `enable`: `boolean` &mdash; Включить/выключить автоматическое выполнение

- `Flush` &mdash; Выполнить все присланные ранее команды

  Нет полей

## `DebugState`

Состояние приложения при отладке

Поля:

- `pressed_keys`: `[string]` &mdash; Зажатые в данный момент кнопки