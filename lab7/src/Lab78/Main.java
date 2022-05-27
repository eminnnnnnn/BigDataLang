package Lab78;

// Заменить все одинаковые рядом стоящие символы в тексте одним символом.

import java.util.Scanner;
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

        text = new StringBuilder(text.toString().replaceAll("([а-яА-Яa-zA-Z])\\1+", "$1"));
        System.out.println(text);
    }
}
