# Debugging

## `DebugCommand`

Команды, которые могут быть отправлены приложению для помощи в отладке

Варианты:

- `Add` &mdash; Добавить отладочные данные в текущий тик

  Поля:

  - `debug_data`: `Model::DebugData` &mdash; Данные для добавления

- `Clear` &mdash; Очистить отладочные данные текущего тика

  Нет полей

- `SetAutoFlush` &mdash; Включить/выключить автоматическое выполнение команд

  Поля:

  - `enable`: `boolean` &mdash; Включить/выключить автоматическое выполнение

- `Flush` &mdash; Выполнить все присланные ранее команды

  Нет полей