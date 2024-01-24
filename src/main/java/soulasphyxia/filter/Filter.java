package soulasphyxia.filter;
import soulasphyxia.statistics.Statistics;
import soulasphyxia.writer.FilterWriter;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Filter {

    private final Statistics statistics;
    private final FilterWriter filterWriter;

    public Filter(FilterWriter filterWriter){
        this.statistics = new Statistics();
        this.filterWriter = filterWriter;
    }

    public void filter(File[] files) throws IOException {
        for(File file : files){
            Scanner sc = new Scanner(file);
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
            sc.close();
        }
        filterWriter.close();
    }

}
