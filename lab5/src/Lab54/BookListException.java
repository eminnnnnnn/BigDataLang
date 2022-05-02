package Lab54;

public class BookListException extends Exception {
    public BookListException() {
        super("BookListException");
    }

    public BookListException(String msg) {
        super(msg);
    }
}
