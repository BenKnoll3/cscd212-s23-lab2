package cscd212comparators.lab2;
import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television>{
    public int compare(Television t1, Television t2){
        if (t1.getScreenSize() - t2.getScreenSize() != 0)
            return Integer.compare(t1.getScreenSize(),t2.getScreenSize());
        return t1.getMake().compareTo(t2.getMake());
    }
}