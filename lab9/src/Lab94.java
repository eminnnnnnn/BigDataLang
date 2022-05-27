// Задана коллекция строк. Преобразовать в MAP, сгруппировав по первому символу строки.

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab94 {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("test", "string", "number", "qwerty", "aboba", "fusrodah", "amogus");
        System.out.println("Исходная коллекция строк: " + Arrays.toString(strings.toArray()));

        Map<Character, List<String>> stringAsMap = strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Коллекция строк в виде MAP: " + stringAsMap);
    }
}
