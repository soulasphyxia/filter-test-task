package soulasphyxia.filter;


import lombok.Getter;
import picocli.CommandLine;

import java.io.File;
import java.util.Arrays;

/*Данный класс конфигурации характеризует параметры, использующиеся при фильтрации */
@Getter
public class FilterConfiguration {
    @CommandLine.Option(names = {"-p"},description = "Префикс для имени файла")
    private String prefix;
    @CommandLine.Option(names = {"-o"},description = "Путь")
    private String path;
    @CommandLine.Option(names={"-a"}, description = "Добавление в существующие файлы", defaultValue = "false")
    private boolean appendFlag;

    @CommandLine.Option(names={"-f"}, description = "Полная статистика", defaultValue = "false")
    private boolean fullStat;

    @CommandLine.Option(names="-s", description = "Короткая статистика", defaultValue = "false")
    private boolean shortStat;

    @CommandLine.Parameters(arity ="1..*" ,paramLabel = "FILE", description = "Укажите 1 или более файлов")
    private File[] files;

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
