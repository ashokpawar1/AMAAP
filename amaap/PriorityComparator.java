package amaap;
import java.util.ArrayList;
import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {
    private ArrayList<Task> listToSort;

    public PriorityComparator(ArrayList<Task> listToSort) {
        this.listToSort = listToSort;
    }

    @Override
    public int compare(Task obj1, Task obj2) {
        int priority1 = obj1.getPriority();
        int priority2 = obj2.getPriority();
        return Integer.compare(priority2, priority1);
    }
}
