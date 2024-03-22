import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Borrow extends Person implements Serializable {
    public Borrow() {
    }

    public Borrow( String fName,String isbn, String id) {
        this.fName = fName;
        this.isbn = isbn;
       setId(id);
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Define a custom format to include only year, month, day, hour, minute, and timezone offset
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm ", Locale.US);
        this.date = customFormat.toString();
    }


    String isbn;
  String date;


    @Override
    public String toString() {
        return "\n Full Name = " + fName +
                "\n ISBN = " + isbn +
                "\n ID = " + getId() +
                "\n Date = " + date +
                "\n --------------\n";
    }
}
