package soulasphyxia;

import picocli.CommandLine;
import soulasphyxia.filter.Filter;
import soulasphyxia.filter.FilterConfiguration;
import soulasphyxia.statistics.StatisticsPrinter;
import soulasphyxia.writer.FilterWriter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        FilterConfiguration configuration = new FilterConfiguration();
        CommandLine commandLine = new CommandLine(configuration);
        try {
            commandLine.parseArgs(args);
        }catch (CommandLine.MissingParameterException e){
            System.out.println("Укажите 1 или более файлов");
        }
        String prefixWithPath = generatePrefixWithPath(configuration.getPath(), configuration.getPrefix());
        Map<String,String> filenames = generateFilenamesMap(prefixWithPath);
        if(configuration.getFiles() != null){
            File[] files = configuration.getFiles();
            FilterWriter filterWriter = new FilterWriter(filenames, configuration.isAppendFlag());
            Filter filter = new Filter(filterWriter);
            filter.filter(files);
            StatisticsPrinter printer = new StatisticsPrinter(filter.getStatistics(), filenames);
            if(configuration.isFullStat()){
                printer.printFullStatistics();
            }else if(configuration.isShortStat()){
                printer.printShortStatistics();
            }
        }
    }


    private static String generatePrefixWithPath(String path, String filePrefix){
        if(path == null){
            path = "";
        }
        if(filePrefix == null){
            filePrefix = "";
        }
        return path + filePrefix;
    }

    private static Map<String,String> generateFilenamesMap(String prefixWithPath){
        return Map.of(
                "integer", prefixWithPath + "integers.txt",
                "float", prefixWithPath + "floats.txt",
                "string", prefixWithPath + "strings.txt"
        );
    }
}