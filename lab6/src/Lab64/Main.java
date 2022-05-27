package Lab64;

/*
    Во входном файле расположены два набора положительных чисел; между наборами стоит
    отрицательное число. Построить два списка C1 и С2, элементы которых содержат
    соответственно числа 1-го и 2-го набора таким образом, чтобы внутри одного списка числа
    были упорядочены по возрастанию. Затем объединить списки C1 и С2 в один
    упорядоченный список, изменяя только значения полей ссылочного типа.
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/Lab64/input.txt");
        List<String> inputLines = null;
        try {
            inputLines = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            System.out.println("Ошибка чтения входного файла. " + e.getMessage());
            System.exit(1);
        }

        if (inputLines.size() > 1) {
            System.out.println("Некорректный формат входного файла");
            System.exit(1);
        }

        ArrayList<Integer> listC1 = new ArrayList<>();
        ArrayList<Integer> listC2 = new ArrayList<>();
        String[] inputNumbers = inputLines.get(0).split(" ");

        int i = 0;
        for (int num = Integer.parseInt(inputNumbers[i]); num >= 0; num = Integer.parseInt(inputNumbers[i])) {
            int j = 0;
            while (j < listC1.size() && num > listC1.get(j))
                j++;
            listC1.add(j, num);
            i++;
        }
        System.out.println("C1: " + listC1);
        i++;
        while (i < inputNumbers.length) {
            listC2.add(Integer.parseInt(inputNumbers[i]));
            i++;
        }
        System.out.println("C2: " + listC2);

        ArrayList<Integer> listC3 = new ArrayList<>();
        listC3.addAll(listC1);
        listC3.addAll(listC2);
        Collections.sort(listC3);
        System.out.println("C1+C2: " + listC3);
    }
}