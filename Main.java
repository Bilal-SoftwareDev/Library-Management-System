import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Register reg = new Register();
        Information info = new Information();
        ArrayList<BorrowAndReturn> borrowed;
        ArrayList<BorrowAndReturn> returned;
        ArrayList<Book> books;
     borrowed = info.showAllBorrowed();
     books = info.showAllBooks();
     returned = info.showAllReturned();
        System.out.println("Books");
        System.out.println(books);
//        reg.setBorrowedBookList(sc);
//        reg.setReturnedList(sc);
        System.out.println("Borrowed");
        System.out.println(borrowed);
        System.out.println("returned");
        System.out.println(returned);

    }
}