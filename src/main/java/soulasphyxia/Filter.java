package soulasphyxia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Filter {

    private StatisticsCollector collector;

    private final Configuration config;

    private final Writer writer;

    public Filter(Configuration config){
        this.config = config;
        this.writer = new Writer(config.isAppendFlag());
    }

    public void filter(File file) throws IOException {
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
    }


    public void close() throws IOException {
        writer.close();
    }
}
