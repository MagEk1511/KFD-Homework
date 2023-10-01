## Иерархия классов
```mermaid
classDiagram
class Vehicle {
+ name: String
+ velocity: Int
+ fuelType: Fuel
+ passport(): void
+ move(): String
}
class Car {
+ move(): String
}
class Airplane {
+ move(): String
}
class Sedan {
+ move(): String
}
class SUV {
+ move(): String
}
class SportsCar {
+ move(): String
}
class CommercialAirplane {
+ move(): String
}
class PrivateJet {
+ move(): String
}
class CargoPlane {
+ move(): String
}

Vehicle <|-- Car
Vehicle <|-- Airplane
Car <|-- Sedan
Car <|-- SUV
Car <|-- SportsCar
Airplane <|-- CommercialAirplane
Airplane <|-- PrivateJet
Airplane <|-- CargoPlane
```
## Пользовательский интерфейс

1. Меню выбора действия:
* Создать автомобиль
* Создать самолет
* Выйти
2. Создание автомобиля (Car):
* Имя
* Скорость
* Тип топлива
3. Создание самолета (Airplane):
* Имя
* Скорость
* Тип топлива
4. Отображение результатов:
* Информация о созданном объекте
5. Выйти (Exit):
* Завершение программы