package Lab75;

// Во всех вопросительных предложениях текста найти и напечатать без повторений слова
// заданной длины.

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

        System.out.println("Длина слов, которые нужно вывести: ");
        int wordLength = Integer.parseInt(scanner.nextLine());

//        Pattern interrogativePattern = Pattern.compile("\\b[а-яА-Я0-9,:\\-()\\s&&[^.?!]]*\\?\\b");
        Pattern interrogativePattern = Pattern.compile("\\b[а-яА-Я,\\s-;:0-9()]+[?]+");
        Matcher matcher = interrogativePattern.matcher(text.toString());
        while (matcher.find()) {
            System.out.println("В предложении \"" + matcher.group() + "\":");
            Set<String> words = new HashSet<>();
            String sentence = matcher.group();
            Pattern wordPattern = Pattern.compile("\\b[а-яА-Я]{" + wordLength + "}\\b");
            Matcher wordMatcher = wordPattern.matcher(sentence);
            while (wordMatcher.find()) {
                words.add(wordMatcher.group());
            }
            for (String w : words)
                System.out.println("    " + w);
        }
    }
}
