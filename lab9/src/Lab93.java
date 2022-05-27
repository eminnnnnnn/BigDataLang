
// Задана коллекция строк. Преобразовать в MAP, где первый символ ключ, второй –
// значение.

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab93 {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("test", "string", "number", "qwerty", "aboba", "fusrodah");
        System.out.println("Исходная коллекция строк: " + Arrays.toString(strings.toArray()));
        // ошибка при дублировании ключей - можно использовать toMap с binaryOperator
        Map<Character, Character> stringAsMap = strings.stream().collect(Collectors.toMap(s -> s.charAt(0), s -> s.charAt(1)));
        System.out.println("Коллекция строк в виде MAP: " + stringAsMap);
    }
}
