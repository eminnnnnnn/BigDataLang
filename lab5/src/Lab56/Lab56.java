package Lab56;

import com.company.lab31.Lab31;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Lab56 {
    /*
    В следующих заданиях требуется ввести последовательность строк из текстового потока и
    выполнить указанные действия. При этом могут рассматриваться два варианта:
    - каждая строка состоит из одного слова;
    - каждая строка состоит из нескольких слов.
    Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены
    как параметры командной строки или храниться в файле.

    Найти в строке наибольшее число цифр, идущих подряд.
     */
    public static void lab5_6() {
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
                for (String line : inputLines) {
                    int currentSequenceLength = 0;
                    int maxDigitSequenceLength = 0;
                    String[] words = line.split("");
                    for (int i = 0; i < words.length; i++) {
                        if ((words[i].charAt(0) >= '0') && (words[i].charAt(0) <= '9')) {
                            currentSequenceLength++;
                        } else {
                            if (currentSequenceLength > maxDigitSequenceLength) {
                                maxDigitSequenceLength = currentSequenceLength;
                                currentSequenceLength = 0;
                            }
                        }
                    }
                    if (currentSequenceLength > maxDigitSequenceLength) {
                        maxDigitSequenceLength = currentSequenceLength;
                    }
                    Files.writeString(outputFile.toPath(), maxDigitSequenceLength + "\n", options);
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
