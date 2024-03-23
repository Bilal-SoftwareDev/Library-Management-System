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
//        reg.RegisterBook(sc);
        books = info.showAllBooks();
        System.out.println(books);
//        reg.setBorrowedBookList(sc,info.showAllBorrowed());
        reg.setReturnedList(sc);
        returned = info.showAllReturned();
        System.out.println(returned);
        System.out.println("borrwed");
        borrowed = info.showAllBorrowed();
        System.out.println(borrowed);
        System.out.println("books");
        System.out.println(books);

    }
}