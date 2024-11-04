# Комус Cup 2024

В данной игре вам предстоить реализовать алгоритм доставки грузов в виртуальном городе.

Вы будете управлять набором машин, стараться объезжать здания и траффик, выполняя заказы.

Чем больше и быстрее заказов вы выполните, тем больше очков вы получите.

Соревнуйтесь с другими участниками за звание лучшего сервиса доставки в нашем виртуальном мире.

# Прямые ссылки на скачивание последних версий приложения
- [Windows](https://github.com/All-Cups/komuscup24-public/releases/download/0.1.3/komus24-windows.zip)
- [MacOS](https://github.com/All-Cups/komuscup24-public/releases/download/0.1.3/komus24-macos.zip)
- [Linux](https://github.com/All-Cups/komuscup24-public/releases/download/0.1.3/komus24-linux.zip)


## Время

Время в игре считается в секундах, при этом симуляция разделена на "тики".
За один тик игровое время продвигается на `delta_time = 1 / ticks_per_second` секунд.

Каждый тик коду вашей стратегии приходит текущее состояние игрового мира,
и от вас ожидается отдача команд управления вашим машинам.

## Город

Действие игры происходит в городе, который разделен на клетки.

Каждая клетка может быть:

- дорогой - по ним можно ездить
- зданием - их нужно объезжать
- заправкой - находясь в этой клетка ваша машина будет пополнять запас топлива (бесплатно)

## Машины

Под вашим контролем будут находиться машины доставки (минимум одна),
которыми вам предстоит управлять напрямую -
отдавая приказы из вашей стратегии, нужно будет указывать,
жать газ или тормоз, и насколько должен быть повернут руль машины.

Машины подчиняются законам физики, при этом для простоты в данной игре будут иметь форму круга (а форма всех зданий - квадрат).

Машины не могут выйти из строя, однако врезаясь в здания или другие машины вы будете замедляться.

Также не забывайте, что у ваших машин ограниченный бак с топливом, и иногда придется заезжать на заправки.

## Траффик

Помимо машин доставки участников, в игре также присутствуют машины мирных жителей,
случайным образом движущихся по городу, создающие дополнительные препятствия для вас.

При столкновении с мирной машиной, она выходит из строя (но не ваша машина),
после чего сломанная мирная машина изчезает из игрового мира через некоторое время.

## Задания доставки

В течение игры на карте будут появляться заказы клиентов - доставить груз из клетки А в клетку Б.

В рамках данной игры одна машина может перевозить лишь один груз.

Для того чтобы взять груз достаточно приехать в клетку города, указанную в заказе.
Аналогичным образов заказ выполняется -
по прибытии в целевую клетку груз из машины изчезает и вам приходят очки за выполненную работу.

## Дальнейшие шаги

- [Подробное описание объектов игровой модели](api/model.md)
- [Работа с приложением локального тестирования](app.md)
- [Разработка стратегии](client.md)
