package soulasphyxia;

import picocli.CommandLine;
import soulasphyxia.filter.Filter;
import soulasphyxia.filter.FilterArgumentsCLI;
import soulasphyxia.writer.FilterWriter;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        args = new String[]{"-o","-p","in2.txt","sample.txt"};
        FilterArgumentsCLI arguments = new FilterArgumentsCLI();

        new CommandLine(arguments).parseArgs(args);
        System.out.println(arguments);
        long start = System.currentTimeMillis();
        String prefixWithPath = generatePrefixWithPath(arguments.getPath(), arguments.getPrefix());
        Map<String,String> filenames = generateFilenamesMap(prefixWithPath);
        File[] files = arguments.getFiles();

        FilterWriter filterWriter = new FilterWriter(filenames, arguments.isAppendFlag());

        Filter filter = new Filter(filterWriter);

        filter.filter(files);

        long end = System.currentTimeMillis();

        System.out.println("ВРЕМЯ ВЫПОЛНЕНИЯ: " + (end - start) / 1000.0 + "с");

//        List<String> filenames = new ArrayList<>(List.of("sample.txt"));

//
//
//
//        Writer writer = new Writer(false);
//
//        System.out.println("НАЧАЛОСЬ");
//        long start = System.currentTimeMillis();
//
//        for(String filename : filenames){
//            File file = new File(filename);
//            Scanner sc = new Scanner(file);
//            while(sc.hasNext()){
//                if(sc.hasNextBigInteger()){
//                    BigInteger result = sc.nextBigInteger();
//                    if(result.compareTo(maxInt) > 0){
//                        maxInt = result;
//                    }
//                    if(result.compareTo(minInt) < 0){
//                        minInt = result;
//                    }
//                    integersSum = integersSum.add(result);
//                    integersCount++;
//                    writer.write(result);
//                }else if(sc.hasNextBigDecimal()){
//                    BigDecimal result = sc.nextBigDecimal();
//                    if(result.compareTo(maxDouble) > 0){
//                        maxDouble = result;
//                    }
//                    if(result.compareTo(minDouble) < 0){
//                        minDouble = result;
//                    }
//                    floatsSum = floatsSum.add(result);
//                    floatsCount++;
//                    writer.write(result);
//                }else {
//                    String result = sc.nextLine();
//                    int resultLength = result.length();
//                    if(resultLength > maxStringLength){
//                        maxStringLength = resultLength;
//                    }
//                    if(resultLength < minStringLength){
//                        minStringLength = resultLength;
//                    }
//                    if(result.isEmpty()){
//                        continue;
//                    }
//                    stringsCount++;
//                    writer.write(result);
//                }
//            }
//            sc.close();
//        }
//
//        writer.close();
//
//        long end = System.currentTimeMillis();
//        if(integersCount > 0){
//            System.out.println("Max and Min Integers: " + maxInt + " " + minInt);
//            System.out.println("Integers count: " + integersCount);
//            System.out.println("Integer's mean: " + integersSum.divide(BigInteger.valueOf(integersCount)));
//        }
//        if(floatsCount > 0){
//            System.out.println("Max and Min Doubles: " + maxDouble + " " + minDouble);
//            System.out.println("Floats count " + floatsCount);
//            System.out.println("Floats's mean: " + floatsSum.divide(BigDecimal.valueOf(floatsCount),new MathContext(5)));
//        }
//        if(stringsCount > 0){
//            System.out.println("Max and Min String's Lengths: " + maxStringLength + " " + minStringLength);
//            System.out.println("Strings count: " + stringsCount);
//        }
//
//        System.out.println("ВРЕМЯ ВЫПОЛНЕНИЯ: " + (end - start) / 1000.0 + "с");
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
                "integer", prefixWithPath + "integers",
                "float", prefixWithPath + "floats",
                "string", prefixWithPath + "strings"
        );
    }
}