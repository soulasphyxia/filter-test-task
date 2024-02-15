package soulasphyxia.filter;
import lombok.Getter;
import soulasphyxia.statistics.Statistics;
import soulasphyxia.writer.FilterWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;
/*
    Данный класс предназачен для фильтрации массива файлов и сбора статистики
*/
public class Filter {
    @Getter
    private final Statistics statistics;
    private final FilterWriter filterWriter;

    public Filter(FilterWriter filterWriter){
        this.statistics = new Statistics();
        this.filterWriter = filterWriter;
    }

    /*
    * Данный метод фильтрует файлы с помощью сканнера в том порядке, в котором они были переданы,а также записывает
    * результаты с помощью объекта класса FileWriter
    * */
    public void filter(File[] files) throws IOException {
        for(File file : files){
            try(Scanner sc = new Scanner(file)){
                sc.useLocale(Locale.ENGLISH);
                while(sc.hasNext()){
                    if(sc.hasNextBigInteger()){
                        BigInteger scannedInteger = sc.nextBigInteger();
                        statistics.collectInteger(scannedInteger);
                        filterWriter.write(scannedInteger);
                    }else if(sc.hasNextBigDecimal()){
                        BigDecimal scannedFloat = sc.nextBigDecimal();
                        statistics.collectFloat(scannedFloat);
                        filterWriter.write(scannedFloat);
                    }else{
                        String scannedString = sc.nextLine();
                        if(scannedString.isEmpty()){
                            continue;
                        }
                        statistics.collectString(scannedString);
                        filterWriter.write(scannedString);
                    }
                }
            }catch (FileNotFoundException e){
                System.out.println("Файл " + file.getName() + " не найден");
            }
        }
        filterWriter.close();
    }
}
