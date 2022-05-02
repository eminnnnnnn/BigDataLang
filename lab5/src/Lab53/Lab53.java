package Lab53;

import com.company.lab33.Abiturient;

public class Lab53 {
    /*
    Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные
    обработчики исключений и исключения ввода/вывода.

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив
    объектов. Задать критерий выбора данных и вывести эти данные на консоль.

    Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки. Создать массив объектов.
    Вывести: a) список абитуриентов, имеющих неудовлетворительные оценки; b) список
    абитуриентов, средний балл у которых выше заданного; c) выбрать заданное число n
    абитуриентов, имеющих самый высокий средний балл (вывести также полный список
    абитуриентов, имеющих полупроходной балл).
     */
    public static void lab5_3() {
        AbiturientList abiturients = new AbiturientList();
        try {
            abiturients.append(new Abiturient(
                    0, "Петрова", "Елена", "Алексеевна", "ул. Центральная, д.3",
                    "+7932843433", new int[]{3, 3, 4, 4, 5, 4, 4}
            ));
            abiturients.append(new Abiturient(
                    1, "Васильева", "Оксана", "Геннадьевна", "ул. Советская, д.9",
                    "+7935473223", new int[]{3, 3, 4, 4, 5, 4, 4}
            ));
            abiturients.append(new Abiturient(
                    2, "Магомедов", "Шамиль", "Рамазанович", "ул. Ладожская, д.13",
                    "+798967754", new int[]{4, 3, 2, 4, 5, 2, 4}
            ));
            abiturients.append(new Abiturient(
                    3, "Пушкин", "Александр", "Сергеевич", "ул. Путина, д.34",
                    "+793785654", new int[]{2, 3, 2, 4, 5, 2, 4}
            ));
            abiturients.append(new Abiturient(
                    4, "Цветков", "ИлонМаск", "Григорьевич", "ул. Школьная, д.6",
                    "+793940393", new int[]{5, 5, 4, 4, 5, 5, 4}
            ));
            abiturients.append(null);
        } catch (AbiturientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Список абитуриентов:\n");
        System.out.println(abiturients);

        System.out.println("Абитуриенты с неудовлетворительными оценками:\n");
        System.out.println(abiturients.getAbiturientsWithBadMarks());

        System.out.println("Абитуриенты, имеющие самый высокий средний балл:\n");
        System.out.println(abiturients.getBestAbiturients(3));

        System.out.println("Абитуриенты со средним баллом выше 4.3:\n");
        System.out.println(abiturients.getWithMeanGreaterThan(4.3));

    }
}
