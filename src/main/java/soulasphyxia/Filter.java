package soulasphyxia;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Filter {

    private StatisticsCollector collector;

    private boolean appendFlag = false;

    private String statictics;

    public Filter(){

    }

    public void filter(File file) throws IOException {
        Writer writer = new Writer(appendFlag);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            if(sc.hasNextBigInteger()){
                BigInteger result = sc.nextBigInteger();
                writer.write(result);
            }else if(sc.hasNextBigDecimal()){
                writer.write(sc.nextBigDecimal());
            }else{
                String result = sc.nextLine();
                if(result.isEmpty()){
                    continue;
                }
                writer.write(result);
            }
        }
        sc.close();
        writer.close();
    }

    public void setAppendFlag(boolean appendFlag) {
        this.appendFlag = appendFlag;
    }
}
