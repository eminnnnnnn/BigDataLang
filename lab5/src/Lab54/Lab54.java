package Lab54;

import com.company.lab34.Book;

public class Lab54 {

    public static void lab5_4() {
        BookList books = new BookList();
        try {
            books.append(new Book(
                    0, "Идиот", "Достоевский Ф.М.", "АСТ", "Мягкий", 2014, 456, 230
            ));
            books.append(new Book(
                    1, "Линейная алгебра", "Кремер Н. Ш., Фридман М. Н., Тришин И. М.", "Юрайт", "Твердый", 2019, 354, 340
            ));
            books.append(new Book(
                    2, "Белый Клык", "Лондон Джек", "Махаон", "Твердый", 2021, 224, 130
            ));
            books.append(new Book(
                    3, "Мертвые души", "Гоголь Н.В.", "Питер", "Мягкий", 2012, 280, 150
            ));
            books.append(new Book(
                    4, "Призрак оперы", "Леру Гастон", "Питер", "Мягкий", 2013, 379, 180
            ));
            books.append(null);
        } catch (BookListException e) {
            System.out.println(e.getMessage());
        }

        try {
            books.getByIndex(100);
        } catch (BookListException e) {
            System.out.println(e.getMessage());
        }

        String author = new String("Достоевский Ф.М.");
        System.out.println("Список книг автора " + author + ":\n");
        System.out.println(books.getByAuthors(author));

        String publication = new String("Питер");
        System.out.println("Список книг издательства " + publication + ":\n");
        System.out.println(books.getByPublication(publication));

        int year = 2015;
        System.out.println("Список книг, изданных после " + year + " года:\n");
        System.out.println(books.getWithYearGreaterThan(year));

    }
}
