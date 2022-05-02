package Lab58;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Lab58 {
    /*
    При выполнении следующих заданий для вывода результатов создавать новую директорию и
    файл средствами класса File
    Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить
    все данные, тип которых вводится из командной строки.
     */
    public static void lab5_8() {
        Scanner scanner = new Scanner(System.in);

        File dataFile = new File("test_files/data.txt");
        File outputDir = new File("test_files/datatypes");
        File outputFile = new File(outputDir.toString() + File.separator + "data.txt");

        List<String> inputLines;
        try {
            System.out.print("Input type of data: ");
            String typeQuery = scanner.nextLine().toLowerCase();

            inputLines = Files.readAllLines(dataFile.toPath());
            outputDir.mkdir();
            Files.write(outputFile.toPath(), new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            if (!inputLines.isEmpty()) {
                OpenOption[] options = { StandardOpenOption.WRITE, StandardOpenOption.APPEND };
                for (String line : inputLines) {
                    String[] tokens = line.split(" ");
                    for (String token : tokens) {
                        if (typeQuery.equals("double") && isDouble(token)) {
                            Files.writeString(outputFile.toPath(), token + " ", options);
                        } else if (typeQuery.equals("integer") && isInteger(token)) {
                            Files.writeString(outputFile.toPath(), token + " ", options);
                        } else if ((typeQuery.equals("char")) && (token.length() == 1)
                                && ((token.charAt(0) < '0') || (token.charAt(0) > '9'))) {
                            Files.writeString(outputFile.toPath(), token + " ", options);
                        } else if ((typeQuery.equals("word")) && (token.length() > 1)
                                && !isDouble(token) && !isInteger(token)) {
                            Files.writeString(outputFile.toPath(), token + " ", options);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IO error");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Security error");
        }
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return s.contains(".");
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
