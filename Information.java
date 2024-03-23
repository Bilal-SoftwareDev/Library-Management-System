import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Information {
    public Information() throws IOException {
    }
    File bookList = new File("Registered Book List.txt");
    File returnedList = new File("Returned Book List.txt");
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

    public Book SearchBook(String isbn) throws Exception{
        ArrayList<Book> books = showAllBooks();
        for (Book x : books) {
            if(x.ISBN.equals(isbn))
                return x;
        }
        return null;
    }
    public ArrayList<BorrowAndReturn> showAllBorrowed()  throws Exception {
        ArrayList<BorrowAndReturn> borrowed = new ArrayList<>();
        if(borrowedList.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(borrowedList));
            borrowed = (ArrayList<BorrowAndReturn>) ois.readObject();
            ois.close();
            System.out.println("from file");
            return borrowed;
        }
        return null;
    }
    public ArrayList<BorrowAndReturn> showAllReturned() throws Exception{

        ArrayList<BorrowAndReturn> returnedBooList;
        if(this.returnedList.isFile()){//if file is available
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(returnedList));
            returnedBooList = (ArrayList<BorrowAndReturn>) ois.readObject();
            return returnedBooList;
        } else {
            return null;
        }
    }

    public  BorrowAndReturn searchBorrow(Scanner sc) throws Exception{
        ArrayList<BorrowAndReturn> list = showAllBorrowed();
        ArrayList<Book> books = showAllBooks();
        System.out.println("Enter isbn ok the book");
        String isbn = sc.nextLine();
        for (BorrowAndReturn x : list) {
            if(x.isbn.equals(isbn))
                return x;
        }
        for (Book x : books) {
            if(x.ISBN.equals(isbn))
                System.out.println("this book didn't borrowed yet try again");
            return searchBorrow(sc);
        }
        System.out.println("incorrect isbn try again");
        return searchBorrow(sc);
    }

}
