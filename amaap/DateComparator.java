package amaap;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Date;


public class DateComparator implements Comparator<Task> {
    private ArrayList<Task> listToSort;

    public DateComparator(ArrayList<Task> listToSort) {
        this.listToSort = listToSort;
    }

    @Override
    public int compare(Task obj1, Task obj2) {
        Date date1 = obj1.getDueDate();
        Date date2 = obj2.getDueDate();

        return date1.compareTo(date2);
    }
}