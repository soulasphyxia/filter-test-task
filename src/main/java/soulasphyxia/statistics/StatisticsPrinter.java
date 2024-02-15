package soulasphyxia.statistics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
/*Данный класс используется для вывода статистики.*/
public class StatisticsPrinter {
    private final Map<String,String> filenames;

    private final Statistics statistics;
    private final ArrayList<String> tokens;

    public StatisticsPrinter(Statistics statistics, Map<String,String> filenames){
        tokens = new ArrayList<>();
        this.statistics = statistics;
        this.filenames = filenames;
    }

    /*
        Методы для печати статистики в консоль
    */
    public void printShortStatistics(){
        generateShortStatistics();
        if(tokens.size() > 1){
            tokens.forEach(System.out::println);
        }
    }

    public void printFullStatistics(){
        generateFullStatistics();
        if(tokens.size() > 1){
            tokens.forEach(System.out::println);
        }
    }

    /*
        Генерация краткой статистики
    */
    private void generateShortStatistics(){
        tokens.add("Короткая статистика:");
        if(statistics.getIntegerCount() > 0){
            tokens.add(generateShortToken(filenames.get("integer"), statistics.getIntegerCount()));
        }
        if(statistics.getFloatCount() > 0){
            tokens.add(generateShortToken(filenames.get("float"), statistics.getFloatCount()));
        }
        if(statistics.getStringCount() > 0){
            tokens.add(generateShortToken(filenames.get("string"), statistics.getStringCount()));
        }
    }

    /*
        Генерация полной статистики
    */
    private void generateFullStatistics(){
        tokens.add("Полная статистика:\n");
        if(statistics.getIntegerCount() > 0){
            tokens.add("Целые числа:");
            tokens.add(generateShortToken(filenames.get("integer"), statistics.getIntegerCount()));
            tokens.add(generateIntegerToken());
        }
        if(statistics.getFloatCount() > 0){
            tokens.add("Вещественные числа:");
            tokens.add(generateShortToken(filenames.get("float"), statistics.getFloatCount()));
            tokens.add(generateFloatToken());
        }
        if(statistics.getStringCount() > 0){
            tokens.add("Строки:");
            tokens.add(generateShortToken(filenames.get("string"), statistics.getStringCount()));
            tokens.add(generateStringToken());
        }
    }


    /*
        Генерация токенов для статистики
    */

    private String generateShortToken(String filename, long elementsCount){
        return String.format("В файл %s записано элементов: %d", filename, elementsCount);
    }


    private String generateIntegerToken(){
        return String.format("""
                        Максимальное число: %d
                        Минимальное число: %d
                        Сумма: %d
                        Среднее: %f
                        """,
                statistics.getMaxInt(), statistics.getMinInt(), statistics.getIntegerSum(),
                statistics.getIntegerSum().floatValue() / statistics.getIntegerCount()
                );
    }

    private String generateFloatToken(){
        return String.format("""
                        Максимальное число: %f
                        Минимальное число: %f
                        Сумма: %f
                        Среднее: %f
                        """,
                statistics.getMaxFloat(), statistics.getMinFloat(), statistics.getFloatSum(),
                statistics.getFloatSum().divide(BigDecimal.valueOf(statistics.getFloatCount()),5)
        );
    }

    private String generateStringToken(){
        return String.format("""
                        Длина самой длинной строки: %d
                        Длина самой короткой строки: %d
                        """,
                statistics.getMaxStringLength(),statistics.getMinStringLength());
    }


}
