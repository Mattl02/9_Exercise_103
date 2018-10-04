
import java.util.ArrayList;
import javax.swing.AbstractListModel;


/**
 *
 * @author Matthias
 */
public class AppointmentModell extends AbstractListModel{
    
    private ArrayList<Appointment> appointments = new ArrayList<>();
    
    
    public void add(Appointment a){
        appointments.add(a);
        this.fireIntervalAdded(this, appointments.size() - 1, appointments.size() - 1);
    }
    
    public void add(Appointment a, int idx){
        appointments.add(idx, a);
        this.fireIntervalAdded(this, appointments.size() - 1, appointments.size() - 1);
    }
    
    public void remove(int idx){
        appointments.remove(idx);
        this.fireContentsChanged(this, idx, appointments.size()-1);
    }
    
    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int i) {
        return appointments.get(i);
    }

}
