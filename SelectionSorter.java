/**
  Implement a selection sort, in the Sorters structure
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

   private int indexOf( String findMe) {
        int low = 0;
        int hi  = elements.size() -1;  // inclusive

        while( low <= hi){
            int pageToCheck = (low + hi) / 2;
            int comparison =
              findMe.compareTo( elements.get( pageToCheck));
            if( comparison == 0) return pageToCheck;
            else
                if( comparison < 0)
                    // findMe's spot precedes pageToCheck
                    hi = pageToCheck -1;
                // findMe's spot follows pageToCheck
                else low = pageToCheck +1;
        }
        return -3; // value differs from skeleton, just FYI
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
