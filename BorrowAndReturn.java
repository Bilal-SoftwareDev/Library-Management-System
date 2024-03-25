import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BorrowAndReturn extends Person implements Serializable {
    public BorrowAndReturn() {
    }

    public BorrowAndReturn(String fName, String isbn, String id) {
        this.fName = fName;
        this.isbn = isbn;
       setId(id);
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Define a custom format to include only year, month, day, hour, minute, and timezone offset
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm ", Locale.US);
        this.date = currentDateTime.format(customFormat);
    }
    public BorrowAndReturn(BorrowAndReturn returned) {
        this.fName = returned.fName;
        this.isbn = returned.isbn;
        setId(returned.getId());
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Define a custom format to include only year, month, day, hour, minute, and timezone offset
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm ", Locale.US);
        this.date = currentDateTime.format(customFormat);
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
