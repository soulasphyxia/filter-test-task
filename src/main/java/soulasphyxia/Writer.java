package soulasphyxia;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;


/*
    Для записи по файлам опишем класс Writer с тремя перегруженными методами для записи разных типов данных.
*/

public class Writer {

    private BufferedWriter integerWriter = null;
    private BufferedWriter floatWriter = null;
    private BufferedWriter stringWriter = null;

    private String integers = "integers.txt";
    private String floats = "floats.txt";
    private String strings = "strings.txt";

    private final boolean appendFlag;


    public Writer(boolean appendFlag) {
        this.appendFlag = appendFlag;
    }

    public Writer(String prefix,boolean appendFlag) {
        this(appendFlag);
        this.integers = prefix + this.integers;
        this.floats = prefix + this.floats;
        this.strings = prefix + this.strings;
    }

    public void write(String input) throws IOException {
        if(stringWriter == null){
            this.stringWriter = new BufferedWriter(new FileWriter(strings,appendFlag));
        }
        stringWriter.write(input);
        stringWriter.newLine();
    }

    public void write(BigInteger input) throws IOException {
        if(integerWriter == null){
            this.integerWriter = new BufferedWriter(new FileWriter(integers,appendFlag));
        }
        integerWriter.write(String.valueOf(input));
        integerWriter.newLine();
    }

    public void write(BigDecimal input) throws IOException {
        if(floatWriter == null){
            this.floatWriter = new BufferedWriter(new FileWriter(floats,appendFlag));
        }
        floatWriter.write(String.valueOf(input));
        floatWriter.newLine();
    }

    public void close() throws IOException {
        if(integerWriter != null) this.integerWriter.close();
        if(stringWriter != null) this.stringWriter.close();
        if(floatWriter != null) this.floatWriter.close();
    }


}
