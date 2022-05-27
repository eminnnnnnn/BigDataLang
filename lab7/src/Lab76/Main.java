package Lab76;

// В каждом предложении текста поменять местами первое слово с последним, не изменяя
// длины предложения.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        StringBuilder text = new StringBuilder("");
        String line;
        while (!(line = scanner.nextLine()).equals("")) {
            text.append(line).append("\n");
        }
        // regex for words matching - \b[а-яА-Я]+\b
        Pattern sentencePattern = Pattern.compile("\\b[а-яА-Я,\\s-;:0-9()]+[^?.!]+");
        Matcher matcher = sentencePattern.matcher(text.toString());
        while (matcher.find()) {
            System.out.println("Предложение \"" + matcher.group() + "\":");
            System.out.println(matcher.group().replaceAll("^(\\b[а-яА-Я]+\\b)(.*)(\\b[а-яА-Я]+\\b$)", "$3$2$1"));
        }
    }
}
