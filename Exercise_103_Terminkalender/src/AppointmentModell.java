
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public void save() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("./appointments.bin")));
        
        for (Appointment a : appointments) {
            oos.writeObject(a);
        }
        
        oos.flush();
        oos.close();
    }
    
    public void load() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("./appointments.bin")));
        
        try{
            Object o;
            while((o = ois.readObject()) != null){
                appointments.add((Appointment) o);
            }
        }
        catch(EOFException eof){
            
        }
        
        ois.close();
        this.fireIntervalAdded(this, 0, appointments.size());
    }
    
    public void sort(){
        
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
