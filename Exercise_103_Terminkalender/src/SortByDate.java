
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
