package cscd212comparators.lab2;
import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator implements Comparator<Television>{
    public int compare(final Television t1, final Television t2){
        if (t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");
        if (t1.getModel().compareTo(t2.getModel()) != 0)
            return t1.getModel().compareTo(t2.getModel());
        else
            return t1.getScreenSize() - t2.getScreenSize();
    }
}