import java.io.Serializable;

public class Book implements Serializable {
    String title;
    String author;
    String edition;
    int yearOfPublication;
    String publisher;
    String ISBN;
    int quantity;
    int shellNumber;
    int rowNumber;
    String subject;

    /*
     *all above info derived from a+ system(OPAC library )
     */

    public Book(String title, String author, String edition,
                int yearOfPublication, String publisher, String ISBN,
                int quantity, int shellNumber, int rowNumber,String subject) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.quantity = quantity;
        this.shellNumber = shellNumber;
        this.rowNumber = rowNumber;
        this.subject = subject;
    }

    @Override//overriding toString method
    public String toString() {
        return "\n--------------------------"+
                "\n title = " + title +
                "\n author = " + author +
                "\n edition = " + edition +
                "\n yearOfPublication = " + yearOfPublication +
                "\n publisher = " + publisher +
                "\n ISBN = " + ISBN +
                "\n quantity = " + quantity +
                "\n shellNumber = " + shellNumber +
                "\n rowNumber = " + rowNumber +
                "\n subject = " + subject
                +"\n--------------------------";
    }
}
