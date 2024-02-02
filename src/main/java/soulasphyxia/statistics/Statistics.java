package soulasphyxia.statistics;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
@Data
@NoArgsConstructor
/*Данный класс является моделью статистики, которая собирается во время фильтрации*/
public class Statistics {
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

    public void collectInteger(BigInteger bigInteger){
        increaseIntegerCount();
        increaseIntegerSum(bigInteger);
        setMaxOrMinInteger(bigInteger);
    }


    public void collectFloat(BigDecimal bigDecimal){
        increaseFloatCount();
        increaseFloatSum(bigDecimal);
        setMaxOrMinFloat(bigDecimal);
    }

    public void collectString(String string){
        increaseStringCount();
        setMaxOrMinStringLength(string);
    }


    private void increaseIntegerSum(BigInteger bigInteger){
        integerSum = integerSum.add(bigInteger);
    }

    private void increaseFloatSum(BigDecimal bigDecimal){
        floatSum = floatSum.add(bigDecimal);
    }

    private void increaseIntegerCount(){
        integerCount++;
    }

    private void increaseFloatCount(){
        floatCount++;
    }

    private void increaseStringCount(){
        stringCount++;
    }

    private void setMaxOrMinInteger(BigInteger bigInteger){
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

    private void setMaxOrMinFloat(BigDecimal bigDecimal){
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

    private void setMaxOrMinStringLength(String string){
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
