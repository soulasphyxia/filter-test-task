package soulasphyxia.writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/*Данный класс записывает в нужный файл результат фильтрации, используя заранее определенные методы*/
public class FilterWriter {
    private BufferedWriter integerWriter = null;
    private BufferedWriter floatWriter = null;
    private BufferedWriter stringWriter = null;

    private final Map<String,String> filenames;

    private final boolean appendFlag;

    public FilterWriter(Map<String,String> filenames, boolean appendFlag) {
        this.filenames = filenames;
        this.appendFlag = appendFlag;
    }

    public void write(String input) throws IOException {
        if(stringWriter == null){
            this.stringWriter = new BufferedWriter(new FileWriter(filenames.get("string"),appendFlag));
        }

        stringWriter.write(input);
        stringWriter.newLine();
    }

    public void write(BigInteger input) throws IOException {
        if(integerWriter == null){
            this.integerWriter = new BufferedWriter(new FileWriter(filenames.get("integer"),appendFlag));
        }

        integerWriter.write(String.valueOf(input));
        integerWriter.newLine();
    }

    public void write(BigDecimal input) throws IOException {
        if(floatWriter == null){
            this.floatWriter = new BufferedWriter(new FileWriter(filenames.get("float"),appendFlag));
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
