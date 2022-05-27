package Lab73;

// Найти, каких букв, гласных или согласных, больше в каждом предложении текста.

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        String[] splittedText = text.split("[.]\\s*");
        System.out.println(Arrays.toString(splittedText));

        Pattern glPattern = Pattern.compile("[уеоэюияаы]");
        Pattern soglPattern = Pattern.compile("[а-яА-Я&&[^уеоэюияаыУЕОЭЮИЯАЫ]]");

        for (String str : splittedText) {
            Matcher matcher = glPattern.matcher(str);

            int glCount = 0;
            int soglCount = 0;

            while (matcher.find())
                glCount++;

            matcher = soglPattern.matcher(str);
            while (matcher.find())
                soglCount++;

            System.out.println("В предложении \"" + str + "\"");
            System.out.println("    гласных: " + glCount + "\n    согласных: " + soglCount);
        }
    }
}
