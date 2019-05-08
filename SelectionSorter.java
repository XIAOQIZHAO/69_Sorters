/**
  Implement a selection sort, in the Sorters structure
 */

/**
   pre-condition(s): a list of Comparable elements
   a synopsis of what the method does, at a higher level of abstraction than the steps in the code:
   for elements 0 to n-2 in the list
   find the smallest value in the unsorted region
   swap that value with the first value in the unsorted region
   expand the size of the sorted region by 1
   post-condition(s): the list is sorted
 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter {
    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter( ArrayList<String> usersData) {
	super(usersData);
    }

    private int dweebIndex( int startAt) {
        // use the starting element as a first guess
        int dweebAt = startAt;
        String dweeb = elements.get( dweebAt);
        
        for( int testAt = startAt +1
           ; testAt < elements.size()
           ; testAt++)
            if( elements.get( testAt).compareTo( dweeb) < 0) {
                // Found a smaller value. Remember it.
                dweebAt = testAt;
                dweeb = elements.get( dweebAt);
            }
        return dweebAt;
     }

    
    

    /**
      sort the user's data, implementing insertion sort
     */
    public void mySort() {
	for( int next = 0
           ; next < elements.size() -1  // last needs no sort
           ; next++) {
	    elements.set( next
                        , elements.set( dweebIndex( next)
                                      , elements.get( next))
                        );
	    // for debugging
	    System.out.println(next);
	    System.out.println( "    dbg: "
	    			+ "after swapping element " + next
	    			+ ", elements: " + elements
	    			);
            }
    }
}
