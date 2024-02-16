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
    private final StatisticsFormatter formatter = new StatisticsFormatter();

    public StatisticsPrinter(Statistics statistics, Map<String,String> filenames){
        tokens = new ArrayList<>();
        this.statistics = statistics;
        this.filenames = filenames;
    }

    /*
        Методы для печати статистики в кон
    */
    public void printShortStatistics(){
        generateShortStatistics();
        System.out.println(formatter.format(tokens));
    }

    public void printFullStatistics(){
        generateFullStatistics();
        System.out.println(formatter.format(tokens));
    }

    /*
        Генерация краткой статистики
    */
    private void generateShortStatistics(){
        tokens.add("Короткая статистика:");
        tokens.add("\n");
        if(statistics.getIntegerCount() > 0){
            tokens.add(generateShortToken(filenames.get("integer"), statistics.getIntegerCount()));
            tokens.add("\n");
        }

        if(statistics.getFloatCount() > 0){
            tokens.add(generateShortToken(filenames.get("float"), statistics.getFloatCount()));
            tokens.add("\n");
        }

        if(statistics.getStringCount() > 0){
            tokens.add(generateShortToken(filenames.get("string"), statistics.getStringCount()));
        }
    }

    /*
        Генерация полной статистики
    */
    private void generateFullStatistics(){
        tokens.add("Полная статистика:");
        tokens.add("\n");
        if(statistics.getIntegerCount() > 0){
            tokens.add("Целые числа:");
            tokens.add(generateShortToken(filenames.get("integer"), statistics.getIntegerCount()));
            generateIntegerToken();
            tokens.add("\n");
        }

        if(statistics.getFloatCount() > 0){
            tokens.add("Вещественные числа:");
            tokens.add(generateShortToken(filenames.get("float"), statistics.getFloatCount()));
            generateFloatToken();
            tokens.add("\n");
        }

        if(statistics.getStringCount() > 0){
            tokens.add("Строки:");
            tokens.add(generateShortToken(filenames.get("string"), statistics.getStringCount()));
            generateStringToken();
        }
    }

    /*
        Генерация токенов для статистики
    */

    private String generateShortToken(String filename, long elementsCount){
        return String.format("В файл %s записано элементов: %d", filename, elementsCount);
    }

    private void generateIntegerToken(){
        tokens.add(generateMaxToken(statistics.getMaxInt()));
        tokens.add(generateMinToken(statistics.getMinInt()));
        tokens.add(generateSumToken(statistics.getIntegerSum()));
        tokens.add(generateMeanToken(statistics.getIntegerSum().floatValue() / statistics.getIntegerCount()));
    }

    private void generateFloatToken(){
        tokens.add(generateMaxToken(statistics.getMaxFloat()));
        tokens.add(generateMinToken(statistics.getMinFloat()));
        tokens.add(generateSumToken(statistics.getFloatSum()));
        tokens.add(generateMeanToken(
                statistics.getFloatSum().divide(BigDecimal.valueOf(statistics.getFloatCount()),5)));
    }

    private void generateStringToken(){
        tokens.add(generateMaxLengthToken(statistics.getMaxStringLength()));
        tokens.add(generateMinLengthToken(statistics.getMinStringLength()));
    }

    private String generateMaxLengthToken(Number maxLength){
        return "Длина самой длинной строки: " + maxLength;
    }

    private String generateMinLengthToken(Number minLength){
        return "Длина самой короткой строки: " + minLength;
    }

    private String generateMinToken(Number num){
        return "Минимальное число: " + num;
    }
    private String generateMaxToken(Number num){
        return "Максимальное число: " + num;
    }

    private String generateSumToken(Number num){
        return "Сумма: " + num;
    }

    private String generateMeanToken(Number num){
        return "Среднее: " + num;
    }


}
