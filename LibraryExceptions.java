import java.util.ArrayList;
import java.util.Scanner;

public class LibraryExceptions extends Exception {

    public void checkQuantity(Book book) throws Exception {
        if (book.quantity == 0) {
            System.out.println("quantity is zero");
            System.exit(0);
        }
        new Register().updateQuantity(book,1);
    }

    public String setIsbn(Scanner sc,int Num) throws Exception{
        System.out.println("System.out.println(\"Enter the ISBN of the " + Num + " Book");
        String isbn = sc.nextLine();
        ArrayList<Book> books = new Information().showAllBooks();        for (Book x : books) {
            if(isbn.equals(x.ISBN)) {
                checkQuantity(x);
                    return isbn;
            }
        }
        System.out.println("Invalid ISBN PLEASE TRY AGAIN");
        return setIsbn(sc,Num);
    }

}
