import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Register reg = new Register();
        Information info = new Information();
        reg.RegisterBook(sc,info.showAllBooks());
        ArrayList<Book> books = info.showAllBooks();
        System.out.println(books);
    }
}