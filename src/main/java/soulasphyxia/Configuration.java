package soulasphyxia;


import picocli.CommandLine;

import java.io.File;
import java.util.Arrays;


public class Configuration {

    @CommandLine.Option(names = {"-o"},description = "Префикс для имени файла")
    private String prefix;
    @CommandLine.Option(names = {"-p"},description = "Путь")
    private String path;
    @CommandLine.Option(names={"-a"}, description = "Добавление в существующие файлы", defaultValue = "false")
    private boolean appendFlag;

    @CommandLine.Option(names={"-f"}, description = "Полная статистика", defaultValue = "false")
    private boolean fullStat;

    @CommandLine.Option(names="-s", description = "Короткая статистика", defaultValue = "true")
    private boolean shortStat;

    @CommandLine.Parameters(paramLabel = "FILE", description = "Укажите 1 или более файлов")
    private File[] files;


    public String getPrefix() {
        return prefix;
    }

    public String getPath() {
        return path;
    }

    public boolean isAppendFlag() {
        return appendFlag;
    }

    public boolean isFullStat() {
        return fullStat;
    }


    public boolean isShortStat() {
        return shortStat;
    }

    public File[] getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "prefix='" + prefix + '\'' +
                ", path='" + path + '\'' +
                ", appendFlag=" + appendFlag +
                ", fullStat=" + fullStat +
                ", shortStat=" + shortStat +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
