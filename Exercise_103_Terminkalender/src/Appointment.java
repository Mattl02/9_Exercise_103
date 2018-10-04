
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 *
 * @author Matthias
 */
public class Appointment{
    private LocalDateTime date;
    private String text;

    public Appointment(LocalDateTime date, String text) {
        this.date = date;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s --> %s", date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm")), text);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
    
    
}
