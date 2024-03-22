import java.util.ArrayList;
import java.util.Scanner;

public class LibraryExceptions extends Exception {
    public LibraryExceptions() {
    }

    ArrayList<Book> books;

    public LibraryExceptions(Information info) throws Exception {
        books = info.showAllBooks();
    }

    public void checkQuantity(Book book) {
        if (book.quantity == 0) {
            System.out.println("quantity is zero");
            System.exit(0);
        }
    }

    public String setIsbn(Scanner sc,int Num) {
        System.out.println("System.out.println(\"Enter the ISBN of the " + Num + " Book");
        String isbn = sc.nextLine();
        for (Book x : books) {
            if(isbn.equals(x.ISBN)) {
                checkQuantity(x);
                    return isbn;
            }
        }
        System.out.println("Invalid ISBN PLEASE TRY AGAIN");
        return setIsbn(sc,Num);
    }

}
