import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class test {
    public static void main(String[] args) {
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Define a custom format to include only year, month, day, hour, minute, and timezone offset
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm ", Locale.US);

        // Format the ZonedDateTime object using the custom format
        String formattedDateTime = currentDateTime.format(customFormat);

        System.out.println("Current date and time with custom format: " + formattedDateTime);
    }
}
