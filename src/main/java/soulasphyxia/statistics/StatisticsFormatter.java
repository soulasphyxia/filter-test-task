package soulasphyxia.statistics;

import java.util.List;

/*
 Данный класс форматирует собранную статистику в виде таблицы.
 */


public class StatisticsFormatter {
    //Знак горизонтального разделителя (ex. "----------------------")
    private final String HORIZONTAL_DELIMITER = "-";

    /*
        Знак вертикального разделителя
        (ex. |
             |
             |
        )
     */
    private final String VERTICAL_DELIMITER = "|";

    /**
     * @param tokens
     * @return Отформатированная статистика в виде таблицы
     */
    public String format(List<String> tokens){
        int maxLength = getMaxTokenLength(tokens)+2;
        String delimeterLine = HORIZONTAL_DELIMITER.repeat(maxLength + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(delimeterLine).append("\n");
        for(String token: tokens){
            if(token.equals("\n")){
                sb.append(delimeterLine);
            }else{
                sb.append(VERTICAL_DELIMITER).append(token).append(" ".repeat(maxLength - token.length() - 1)).append(VERTICAL_DELIMITER);
            }
            sb.append("\n");
        }
        sb.append(delimeterLine).append("\n");
        return sb.toString();
    }


    /**
     * @param tokens
     * @return Максимальная длина токена(строки статистики), необходим для формирования строки разделения
     */
    private int getMaxTokenLength(List<String> tokens){
        int maxLength = 0;
        for(String token : tokens){
            int tokenLength = token.length();
            if(tokenLength > maxLength){
                maxLength = tokenLength;
            }
        }
        return maxLength;
    }



}
