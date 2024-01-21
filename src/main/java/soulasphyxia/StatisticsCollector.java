package soulasphyxia;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StatisticsCollector {
    private BigInteger minInt = BigInteger.valueOf(99999999999999L);
    private BigInteger maxInt = BigInteger.valueOf(0L);

    private BigDecimal minDouble = BigDecimal.valueOf(999999999999L);
    private BigDecimal maxDouble = BigDecimal.ZERO;

    private int maxStringLength = 0;
    private int minStringLength = Integer.MAX_VALUE;

    private long integersCount = 0;
    private long floatsCount = 0;
    private long stringsCount = 0;

    private BigInteger integersSum = new BigInteger(String.valueOf(0));
    private BigDecimal floatsSum = new BigDecimal(0);
}
