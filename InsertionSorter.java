/**
  Implement an insertion sort, in the Sorters structure
 */

/**
   pre-condition(s): a list of Comparable elements

   a synopsis of what the method does, at a higher level of abstraction than the steps in the code:
   for elements 1 to n-1 in the list
   compare the first value in the unsorted region with values before it, starting from the closest in position to the left
   shift all the larger values
   insert the unsorted value into the empty space
   expand the size of the sorted region by 1

   post-condition(s): the list is sorted
 */

import java.util.ArrayList;

public class InsertionSorter extends Sorter {
    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter( ArrayList<String> usersData) {
	super(usersData); // have to call super class constructor since
	// super class doesn't have a default constructor
    }

    private String insert1(int alreadyInserted){
	String valueToInsert = elements.get(alreadyInserted);
	for (int indexToCompare = alreadyInserted - 1;
	     indexToCompare >= 0;
	     indexToCompare--){
	    if (valueToInsert.compareTo( elements.get(indexToCompare)) >= 0){
		drop(indexToCompare + 1, valueToInsert);
		indexToCompare = -1;
		//get out of loop after dropping current value
	    }
	    else
		shift(indexToCompare);
	}
	return valueToInsert;
    }

    private String drop( int index, String value){
	elements.set(index, value);
	return value;
    }
    
    private String shift( int index){
	String oldValue = elements.get(index);
	elements.set(index, elements.set(index + 1, oldValue));
	return oldValue;
    }
    
    

    /**
      sort the user's data, implementing insertion sort
     */
    public void mySort() {
	
	for (int numSorted = 1; numSorted < elements.size(); numSorted++){
	    insert1(numSorted);
	    
	    // for debugging
	    System.out.println(numSorted);
	    System.out.println( "    dbg: "
	    			+ "after inserting element " + numSorted
	    			+ ", elements: " + elements
	    			);
	}
    }
}
