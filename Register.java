import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    LibraryExceptions exceptions;
    Information info;
    public Register() throws Exception {
         exceptions = new LibraryExceptions();
         info = new Information();
    }
    File bookList = new File("Registered Book List.txt");
    ObjectOutputStream obrl = null;
    File borrowedBookList = new File("Borrowed Book List.txt");

    ObjectOutputStream obbl = null;
    File returnedBookList = new File("Returned Book List.txt");

    ObjectOutputStream orbb = null;

    public void setBorrowedBookList(Scanner sc, ArrayList<BorrowAndReturn> borrowed) throws Exception{
        ArrayList<BorrowAndReturn> borrowedList = new ArrayList<>();
        System.out.println("Enter how many student will Borrow a book");
        int Num = sc.nextInt();
        sc.nextLine();
        if(borrowed != null){
            for(BorrowAndReturn x: borrowed)
                borrowedList.add(x);
        }
        System.out.println("array of the previous borrowed from array");
        System.out.println(borrowedList);
        for (int i = 1; i <= Num; i++) {
            System.out.println("Enter the Full Name of the " + i + " of the Student");
            String fName = sc.nextLine();
            System.out.println("Enter the ISBN of the " + i + " Book");
            String isbn = exceptions.setIsbn(sc, i);
            System.out.println("Enter the ID of the " + i + " Student");
            String id = sc.nextLine();
            borrowedList.add(new BorrowAndReturn(fName, isbn, id));
        }
        System.out.println("array of borrowed after register");
        System.out.println(borrowedList);
        obbl = new ObjectOutputStream(new FileOutputStream(borrowedBookList));
        obbl.writeObject(borrowedList);
        obbl.close();
        System.out.println("borrowed registered successfully");

    }
    public void setReturnedList(Scanner sc) throws Exception{
        ArrayList<BorrowAndReturn> returnedList = info.showAllReturned();
        System.out.println("array of the previous returned from array");
        System.out.println(returnedList);
        System.out.println("Enter how many student will return a book");
        int Num = sc.nextInt();
        sc.nextLine();
        if (returnedList == null) {
            returnedList = new ArrayList<>();
        }
        for (int i = 1; i <= Num; i++) {
            BorrowAndReturn borrowed = info.searchBorrow(sc);
            //delete borrowed class from borrowes
            deleteBorrowed(borrowed);
            Book book = new Information().SearchBook(borrowed.isbn);
            updateQuantity(book, 2);
            returnedList.add(borrowed);
        }
//        System.out.println("array of returned after register");
//        System.out.println(returnedList);
        orbb = new ObjectOutputStream(new FileOutputStream(returnedBookList));
        orbb.writeObject(returnedList);
        orbb.close();
        System.out.println("returned registered successfully");

    }

    public void deleteBorrowed(BorrowAndReturn borrowed) throws Exception {
        ArrayList<BorrowAndReturn> borrowedList = info.showAllBorrowed();
        int index = -1;
        for(BorrowAndReturn x: borrowedList)
            if ( x.isbn.equals(borrowed.isbn)) {
                index = borrowedList.indexOf(x);
            }
        if (index != -1) {
            borrowedList.remove(index);
        }
        updateBorrowedList(borrowedList);
    }

    public void updateBorrowedList(ArrayList<BorrowAndReturn> update) throws Exception {
        obbl = new ObjectOutputStream(new FileOutputStream(borrowedBookList));
        obbl.writeObject(update);
        obbl.close();
        System.out.println("borrowed updated successfully");
    }
    public void updateQuantity(Book book,int choice) throws Exception {
        ArrayList<Book> bookArrayList = info.showAllBooks();
        int index = 0;
        switch (choice) {
            case 1:
                for (Book x : bookArrayList) {
                    if (x.ISBN.equals(book.ISBN)){
                        index = bookArrayList.indexOf(x);
                        if(x.quantity != 0)
                            x.quantity--;
                        bookArrayList.set(index, x);
                        updateBookList(bookArrayList);
                    }
                }
                break;
            case 2:
                for (Book x : bookArrayList) {
                    if (x.ISBN.equals(book.ISBN)){
                        index = bookArrayList.indexOf(x);
                            x.quantity++;
                        bookArrayList.set(index, x);
                        updateBookList(bookArrayList);
                    }
                }

        }
    }

    public void updateBookList(ArrayList<Book> books) throws Exception {
        obrl = new ObjectOutputStream(new FileOutputStream(bookList));
        obrl.writeObject(books);
        obrl.close();
        new Information().showAllBooks();
        System.out.println("Books updated Successfully");

    }
    public void RegisterBook(Scanner sc) throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<Book> books = info.showAllBooks();
        System.out.println("Enter how many book will Register");
        int Num = sc.nextInt();
        sc.nextLine();
        if(books != null){
            for(Book x: books)
                bookArrayList.add(x);
        }
        System.out.println(bookArrayList);
        for (int i = 1; i <= Num; i++) {
            System.out.print("Enter Title of the " + i + " Book: ");
            String title = sc.nextLine();
            System.out.println(title);
            System.out.print("Enter Edition of the " + i + " Book: ");
            String edition = sc.nextLine();
            System.out.print("Enter Author of the " + i + " Book: ");
            String author = sc.nextLine();
            System.out.print("Enter Year Of the Publication of the " + i + " Book: ");
            int yearOfPublication = sc.nextInt();
            sc.nextLine();
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
            sc.nextLine();
            System.out.print("Enter Subject of the " + i + " Book: ");
            String subject = sc.nextLine();
            bookArrayList.add(new Book(title, author, edition,
                    yearOfPublication, publisher, ISBN, quantity,
                    shellNumber, rowNumber, subject));
        }
        System.out.println(bookArrayList);
        obrl = new ObjectOutputStream(new FileOutputStream(bookList));
        obrl.writeObject(bookArrayList);
        obrl.close();
        System.out.println("Books Registered Successfully");
    }
}
