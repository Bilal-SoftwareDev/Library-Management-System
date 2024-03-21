import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    File file = new File("Data\\Registered Book List.txt");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

    public Register() throws Exception {
    }
    public void RegisterBook(Scanner sc) throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        System.out.println("Enter how many book will Register");
        int Num = sc.nextInt();
        for (int i = 1; i <= Num; i++) {
            System.out.print("Enter Title of the " + i + " Book: ");
            String title = sc.nextLine();
            System.out.println(title);
            System.out.print("Enter Edition of the " + i + " Book: ");
            String edition = sc.nextLine();
            System.out.print("Enter Author of the " + i + "Book: ");
            String author = sc.nextLine();
            System.out.print("Enter Year Of the Publication of the " + i + " Book: ");
            int yearOfPublication = sc.nextInt();
            System.out.print("Enter Publisher of the " + i + " Book: ");
            String publisher = sc.nextLine();
            System.out.print("Enter ISBN of the " + i + " Book: ");
            String ISBN = sc.nextLine();
            System.out.print("Enter Quantity of the " + i + " Book: ");
            int quantity = sc.nextInt();
            System.out.print("Enter Shell Number of the " + i + " Book: ");
            int shellNumber = sc.nextInt();
            System.out.print("Enter Row Number of the " + i + " Book: ");
            int rowNumber = sc.nextInt();
            System.out.print("Enter Subject of the " + i + " Book: ");
            String subject = sc.nextLine();
            bookArrayList.add(new Book(title, author, edition,
                    yearOfPublication, publisher, ISBN, quantity,
                    shellNumber, rowNumber, subject));
        }
        oos  = new ObjectOutputStream(new FileOutputStream(file,true));
        oos.writeObject(bookArrayList);
        oos.close();
        System.out.println("Books Registered Successfully");
    }
}
