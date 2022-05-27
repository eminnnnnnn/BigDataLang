package Lab71;

import java.util.Scanner;

/*
    В тексте слова заданной длины заменить указанной подстрокой, длина которой может не
    совпадать с длиной слова.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходный текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите длину заменяемых слов: ");
        int length = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите подстроку, которой нужно заменить слова: ");
        String substr = scanner.nextLine();

        String replacedText = text.replaceAll("\\b[а-яА-Яa-zA-Z]{"+length+"}\\b", substr);

        System.out.println(replacedText);
    }
}