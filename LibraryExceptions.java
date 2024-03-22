import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class LibraryExceptions extends Exception {
    Information info;
    ArrayList<Book> books;

    public LibraryExceptions() throws Exception{
       info =  new Information();
        books = info.showAllBooks();
    }



    public void checkQuantity(Book book) throws Exception {
        if (book.quantity == 0) {
            System.out.println("quantity is zero");
            System.exit(0);
        }
        new Register().updateQuantity(book);
    }

    public String setIsbn(Scanner sc,int Num) throws Exception{
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
