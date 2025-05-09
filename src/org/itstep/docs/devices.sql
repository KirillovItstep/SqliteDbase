Postgres

Перечень приборов (list_device)
id_list_device
Название (модель) (ЩП8155, ЩП8156, ПП8180)

Проверяемый прибор (device)
id_device
Инвентарный номер (уникальный - 123456)
Версия прошивки (1234в03)
Перечень (внешний ключ)

Оператор (operator)
id_operator
ФИО (Иванов И.И.)
Инвентарный номер (1234б)

Неисправность (bug)
id_bug
Название исправностей (строка)

Проверка (check)
id_check
Прибор (внешний ключ)
Оператор (внешний ключ)
Неисправность (внешний ключ)
Дата и время

select * from device; Выбрать все приборы
Дан Id_device. По нему найти все неисправности за какой-то диапазон времени.
Дан инвентарный номер. По нему найти проверку (дату проверки, названия неисправностей, оператора)
