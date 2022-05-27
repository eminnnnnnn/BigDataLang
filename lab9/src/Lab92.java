// Задана коллекция строк. Вернуть список из коллекции без повторов.

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab92 {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("aaa", "bb", "aaa", "bbb", "aaa", "bb");
        System.out.println("Исходная коллекция строк: " + Arrays.toString(strings.toArray()));

        List<String> stringsNotRepeated = strings.stream().distinct().collect(Collectors.toList());
        System.out.println("Коллекция строк без повторов: " + stringsNotRepeated);
    }
}
