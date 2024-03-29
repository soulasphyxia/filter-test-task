# Фильтр для файлов
Приложение разработано для фильтрации входящих файлов и распределения данных по отдельным файлам в зависимости от типа. Разработано в рамках тестового задания для ШИФТ ЦФТ

## Инструкция по запуску:
### Требования
* Java 17
* Maven 4.0.0
### Библиотеки
1.Picocli - необходима для создания интерфейса взаимодействия через консоль.
```
<dependency>  
<groupId>info.picocli</groupId>  
<artifactId>picocli</artifactId>  
<version>4.7.5</version>  
</dependency>
```

2 Lombok
```
<dependency>  
<groupId>org.projectlombok</groupId>  
<artifactId>lombok</artifactId>  
<version>1.18.26</version>  
<scope>compile</scope>  
</dependency>
```
### Запуск
1. Склонировать репозиторий ```git clone https://github.com/soulasphyxia/filter-test-task.git```
2. Перейти в папку проекта
3. Собрать проект с помощью Maven: ```mvn package```
4. JAR-архив будет находиться в папке target рабочей директории проекта. 
Пример запуска: 
```java -jar filter-test-task-1.0-SNAPSHOT.jar -s -a -p sample- in1.txt in2.txt```

### Описание решения:
Фильтрация данных происходит с помощью встроенных методов класса Scanner(hasNextBigInt, hasNextBigDecimal и т.д), данное решение удовлетворяет условию задания(последовательное чтение из файла), по этой же причине не было реализовано решение, использующее многопоточное программирование. Идея собственного алгоритма фильтрации(определения типа данных) отпала, т.к самое оптимальное решение(использование регулярных выражений) уже реализована в классе Scanner.  

Программа оперирует типами BigInteger и BigDecimal: в задании не указано, являются ли числа, не входящие в long и float, числами, или это уже строки. Поэтому было принято решение фильтровать их именно с помощью данных типов. Да, мы жертвуем скоростью, но при необходимости можно переписать решение в довольно короткие сроки.

Взаимодействие с комадной строкой происходит с помощью библиотеки Picocli. Обязательным аргументом для командной строки являются только имена файлов(как минимум 1). Все остальные аргументы считаются необязательными. Если пользователь не указал, какую статистику он хочет вывести, то не выводится никакая статистика.

Решение тестировалось на данных, предоставленных в описании задачи, а также на 3-х сгенерированных файлах, в каждом из котором находилось 1_000_000 строк(каждый файл весил ~по 20Мб). Программа фильтровала данные правильно, в среднем это занимало у нее 8-10 секунд.

Итоговая статистика выводится в виде таблицы. Предусмотрена возможность смены разделителей, меняется в соответствующих final-переменных класса StatisticsFormatter.

Отлавливаются следующие ошибки: пользователь не ввел названия файлов в командную строку, файл не найден(алгоритм пропускает его и идет дальше), файл удалили во время фильтрации(если удалили до начала доступа, то пропускет, иначе фильтрует что успел)

### Результат работы программы:
Вывод с краткой статистикой
![image](https://github.com/soulasphyxia/filter-test-task/assets/98162330/61d3a6ec-ae7d-4b6a-b776-2ac804a462e9)
Вывод с полной статистикой
![image](https://github.com/soulasphyxia/filter-test-task/assets/98162330/b4b39d4d-774f-4ebf-ac70-02ad504d56fb)


