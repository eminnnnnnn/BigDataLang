package Lab57;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Lab57 {
    /*
    При выполнении следующих заданий для вывода результатов создавать новую директорию и
    файл средствами класса File
    В файле, содержащем фамилии студентов и их оценки, записать прописными буквами
    фамилии тех студентов, которые имеют средний балл более “7”.
     */
    public static void lab5_7() {
        File inputFile = new File("test_files/students_journal.txt");
        File outputDir = new File("test_files/students");
        File outputFile = new File(outputDir.toString() + File.separator + "students_journal.txt");

        List<String> inputLines;
        try {
            inputLines = Files.readAllLines(inputFile.toPath());
            outputDir.mkdir();
            Files.write(outputFile.toPath(), new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            if (!inputLines.isEmpty()) {
                OpenOption[] options = { StandardOpenOption.WRITE, StandardOpenOption.APPEND };
                for (String line : inputLines) {
                    double studentAvgMark = 0.0;
                    double minAvgMark = 7.0;
                    String[] words = line.split(" ");
                    // it's assumed that first word is the student's last name
                    for (int i = 1; i < words.length; i++) {
                        studentAvgMark += Integer.parseInt(words[i]);
                    }
                    studentAvgMark /= words.length - 1;
                    if (studentAvgMark > minAvgMark) {
                        Files.writeString(outputFile.toPath(), words[0].toUpperCase() + "\n", options);
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
}
