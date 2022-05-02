package Lab55;

import com.company.lab31.Lab31;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Lab55 {
    /*
    В следующих заданиях требуется ввести последовательность строк из текстового потока и
    выполнить указанные действия. При этом могут рассматриваться два варианта:
    - каждая строка состоит из одного слова;
    - каждая строка состоит из нескольких слов.
    Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены
    как параметры командной строки или храниться в файле.

     Найти и вывести слова текста, для которых последняя буква одного слова совпадает с
    первой буквой следующего слова.
     */
    public static void lab5_5() {
        File filesInfo = new File("test_files/files_info.txt");
        File inputFile = new File("");
        File outputFile = new File("");
        try {
            List<String> infoLines = Files.readAllLines(filesInfo.toPath()); // Path.of("files_info.txt")
            inputFile = new File(infoLines.get(0));
            outputFile = new File(infoLines.get(1));
        } catch (IOException e) {
            System.out.println("IO error (Reading of the info file)");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Security error");
            System.exit(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There are no paths of input and output files in files_info.txt");
            System.exit(1);
        }

        List<String> inputLines;
        try {
            inputLines = Files.readAllLines(inputFile.toPath());
            Files.write(outputFile.toPath(), new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            if (!inputLines.isEmpty()) {
                OpenOption[] options = { StandardOpenOption.WRITE, StandardOpenOption.APPEND };
                String lastWord = ""; // the last word in previous line
                for (String line : inputLines) {
                    String[] words = line.split(" ");
                    for (int i = 0; i < words.length - 1; i++) {
                        if ((i == 0) && (!lastWord.isEmpty()) && (words[i].charAt(0) == lastWord.charAt(lastWord.length()-1))) {
                            Files.writeString(outputFile.toPath(), lastWord + " ", options);
                        }
                        if (words[i].charAt(words[i].length() - 1) == words[i+1].charAt(0)) {
                            Files.writeString(outputFile.toPath(), words[i] + " ", options);
                        }
                    }
                    lastWord = words[words.length-1];
                }
            }
        } catch (IOException e) {
            System.out.println("IO error");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Security error");
        }
    }
}
