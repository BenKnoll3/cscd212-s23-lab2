package cscd212comparators.lab2;
import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator implements Comparator<Television>{
    public int compare(Television t1, Television t2){
        if (t1.getModel().compareTo(t2.getModel()) != 0)
            return t1.getModel().compareTo(t2.getModel());
        else
            return Integer.compare(t1.getScreenSize(),t2.getScreenSize());
    }
}