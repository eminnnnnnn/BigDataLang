package Lab74;

// В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите стихотворение:");
        StringBuilder text = new StringBuilder("");
        String line;
        while (!(line = scanner.nextLine()).equals("")) {
            text.append(line).append("\n");
        }

        String vowels = "уеыаоэяиюУЕЫАОЭЯИЮ";
        Pattern vowelsAtBeginAndEndOfWord = Pattern.compile("\\b[" + vowels + "][а-яА-Я]*[" + vowels + "]\\b");
        Matcher matcher = vowelsAtBeginAndEndOfWord.matcher(text.toString());
        int count = 0;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            count++;
        }
        System.out.print("\n" + count);

    }
}
