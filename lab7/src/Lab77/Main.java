package Lab77;

// В тексте исключить подстроку максимальной длины, начинающуюся и заканчивающуюся
// заданными символами.

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

        System.out.print("Подстрока начинается с символа: ");
        String firstChar = scanner.nextLine();

        System.out.print("Подстроки заканчивается символом: ");
        String lastChar = scanner.nextLine();

        Pattern substringPattern = Pattern.compile("[" + firstChar + "].*[" + lastChar + "]");
        Matcher matcher = substringPattern.matcher(text.toString());

        int maxLength = 0;
        int maxStart = -1;
        int maxEnd = -1;
        while (matcher.find()) {
//            System.out.println(matcher.group());
            int length = matcher.end() - matcher.start();
            if (length > maxLength) {
                maxLength = length;
                maxStart = matcher.start();
                maxEnd = matcher.end();
            }
        }

        text.delete(maxStart, maxEnd);
        System.out.println(text);

    }
}
