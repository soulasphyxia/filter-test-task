# Фильтр для файлов
Приложение разработано для фильтрации входящих файлов и распределения данных по отдельным файлам в зависимости от типа. Разработано в рамках тестового задания для ШИФТ ЦФТ

## Инструкция по запуску:
### Требования
* Java 19
* Maven 4.0.0
### Библиотеки
1.Picocli - необходима для создания интерфейса взаимодействия через консоль. \ 
`<dependency>  
<groupId>info.picocli</groupId>  
<artifactId>picocli</artifactId>  
<version>4.7.5</version>  
</dependency>`

2 Lombok \
`<dependency>  
<groupId>org.projectlombok</groupId>  
<artifactId>lombok</artifactId>  
<version>1.18.26</version>  
<scope>compile</scope>  
</dependency>`
### Запуск
1. Склонировать репозиторий `git clone https://github.com/soulasphyxia/filter-test-task.git`
2. Перейти в папку проекта
3. Собрать проект с помощью Maven: `mvn package`
4. JAR-архив будет находиться в папке target рабочей директории проекта. 
Пример запуска: 
`java -jar filter-test-task-1.0-SNAPSHOT.jar -s -a -p sample- in1.txt in2.txt`
