package Lab63;

/*
    Во входном файле хранятся наименования некоторых объектов. Построить список C1,
    элементы которого содержат наименования и шифры данных объектов, причем элементы
    списка должны быть упорядочены по возрастанию шифров. Затем “сжать” список C1,
    удаляя дублирующие наименования объектов.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/Lab63/input.txt");
        List<String> inputLines = null;
        try {
            inputLines = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            System.out.println("Ошибка чтения входного файла. " + e.getMessage());
            System.exit(1);
        }

        ArrayList<SomeObject> objects = new ArrayList<>();

        for (String line : inputLines) {
            String[] objInfo = line.split(" ");
            if (objInfo.length > 2) {
                System.out.println("Некорректный формат данных во входном файле.");
                System.exit(1);
            }
            objects.add(new SomeObject(objInfo[0], objInfo[1]));
        }

        objects.sort(Comparator.comparing(t -> t.code));
        System.out.println("Исходный список объектов: " + objects);

//        ListIterator<SomeObject> it = objects.listIterator();
//        while (it != objects.listIterator(objects.size()-1)) {
        int it = 0;
        while (it < objects.size() - 1) {
            if (objects.get(it + 1).equals(objects.get(it)))
                objects.remove(it);
            else
                it++;
        }
        System.out.println("Сжатый список объектов: " + objects);
    }
}