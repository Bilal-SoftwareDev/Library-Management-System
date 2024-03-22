import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Information {
    File file = new File("Registered Book List.txt");

    public Information() throws IOException {
    }

    public ArrayList<Book> showAllBooks()  throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        if(file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            books = (ArrayList<Book>) ois.readObject();
            ois.close();
            return books;
        }
        return null;
    }
}
