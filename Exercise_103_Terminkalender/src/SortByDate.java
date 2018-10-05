
import java.util.Comparator;


/**
 *
 * @author Matthias
 */
public class SortByDate implements Comparator<Appointment>{

    @Override
    public int compare(Appointment a, Appointment a1) {
        return a.getDate().compareTo(a1.getDate());
    }

}
