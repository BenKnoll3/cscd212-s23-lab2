package cscd212comparators.lab2;
import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionScreenSizeComparator implements Comparator<Television>{
    public int compare(Television t1, Television t2){
        return Integer.compare(t1.getScreenSize(),t2.getScreenSize());
    }
}