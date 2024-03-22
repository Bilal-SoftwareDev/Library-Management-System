import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Register reg = new Register();
        Information info = new Information();
        ArrayList<Borrow> borrowed;
        ArrayList<Book> books;
//        reg.RegisterBook(sc);
        books = info.showAllBooks();
        System.out.println(books);
        reg.setBorrowedBookList(sc,info.showAllBorrowed());
        borrowed = info.showAllBorrowed();
        System.out.println(borrowed);
        System.out.println(info.showAllBooks());
    }
}