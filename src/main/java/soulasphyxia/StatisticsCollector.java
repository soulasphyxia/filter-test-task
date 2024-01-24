package soulasphyxia;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StatisticsCollector {
    private BigInteger minInt = null;
    private BigInteger maxInt = null;

    private BigDecimal minFloat = null;
    private BigDecimal maxFloat = null;

    private Integer maxStringLength = null;
    private Integer minStringLength = null;

    private long integerCount = 0;
    private long floatCount = 0;
    private long stringCount = 0;

    private BigInteger integerSum = new BigInteger(String.valueOf(0));
    private BigDecimal floatSum = new BigDecimal(0);

    public void increaseIntegerSum(BigInteger bigInteger){
        integerSum = integerSum.add(bigInteger);
    }

    public void increaseFloatSum(BigDecimal bigDecimal){
        floatSum = floatSum.add(bigDecimal);
    }

    public void increaseIntegerCount(){
        integerCount++;
    }

    public void increaseFloatCount(){
        floatCount++;
    }

    public void increaseStringCount(){
        stringCount++;
    }

    public void setMaxOrMinInteger(BigInteger bigInteger){
        if(maxInt == null || minInt == null){
            minInt = bigInteger;
            maxInt = bigInteger;
        }else{
            if(bigInteger.compareTo(maxInt) > 0){
                maxInt = bigInteger;
            }
            if(bigInteger.compareTo(minInt) < 0){
                minInt = bigInteger;
            }
        }
    }

    public void setMaxOrMinFloat(BigDecimal bigDecimal){
        if(maxFloat == null || minFloat == null){
            minFloat = bigDecimal;
            maxFloat = bigDecimal;
        }else{
            if(bigDecimal.compareTo(maxFloat) > 0){
                maxFloat = bigDecimal;
            }
            if(bigDecimal.compareTo(minFloat) < 0){
                minFloat = bigDecimal;
            }
        }
    }

    public void setMaxOrMinStringLength(String string){
        int length = string.length();
        if(maxStringLength == null || minStringLength == null){
            maxStringLength = length;
            minStringLength = length;
        }else{
            if(length > maxStringLength){
                maxStringLength = length;
            }
            if(length < minStringLength){
                minStringLength = length;
            }
        }
    }


}
