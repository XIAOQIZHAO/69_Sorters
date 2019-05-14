import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter{

    public SubSortThenMerge_Sorter(ArrayList<String> list){
	super(list);
    }

    public void mySort() {
	sortRange(0, elements.size());
    }

    
    private void sortRange( int startAt, int stopBefore) {
        int splitBefore = (stopBefore + startAt +1) / 2;
        /* "splitBefore" seemed like a clear name. So "+1"
           was included to match the processing to the name */

        // temp for debugging
        // System.out.println( "startAt= " + startAt
        //                   + ", stopBefore= " + stopBefore
        //                   + ", splitBefore= " + splitBefore
        //                   );

        // decision: Is the requested a base or recursive case?
        if( splitBefore < stopBefore) {
            /* solution to base case of 0 or 1 elements:
                  already sorted, trivially */
            // solution to recursive cases
            sortRange( startAt, splitBefore);
            sortRange(          splitBefore, stopBefore);
	    // elements already changed into combination of two sorted lists
            new Merger( elements).merge( startAt
                                       , splitBefore
                                       , stopBefore);
        }
    }
}
