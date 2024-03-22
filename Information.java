import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Information {
    public Information() throws IOException {
    }
    File bookList = new File("Registered Book List.txt");
    File borrowedList = new File("Borrowed Book List.txt");

    public ArrayList<Book> showAllBooks()  throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        if(bookList.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bookList));
            books = (ArrayList<Book>) ois.readObject();
            ois.close();
            return books;
        }
        return null;
    }
    public ArrayList<Borrow> showAllBorrowed()  throws Exception {
        ArrayList<Borrow> borrowed = new ArrayList<>();
        if(borrowedList.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(borrowedList));
            borrowed = (ArrayList<Borrow>) ois.readObject();
            ois.close();
            System.out.println("from file");
            return borrowed;
        }
        return null;
    }

}
