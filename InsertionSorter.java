/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {


    private String insert1( ArrayList<String> list, int alreadyInserted){
	String valueToInsert = list.get(alreadyInserted);
	for (int indexToCompare = alreadyInserted - 1;
	     indexToCompare >= 0;
	     indexToCompare--){
	    if (valueToInsert.compareTo( list.get(indexToCompare)) >= 0){
		drop(list, indexToCompare + 1, valueToInsert);
		indexToCompare = -1;
		//get out of loop after dropping current value
	    }
	    else
		shift(list, indexToCompare);
	}
	return valueToInsert;
    }

    private String drop( ArrayList<String> list, int index, String value){
	list.set(index, value);
	return value;
    }
    
    private String shift(ArrayList<String> list, int index){
	String oldValue = list.get(index);
	list.set(index, list.set(index + 1, oldValue));
	return oldValue;
    }
    
    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
	
    }
    

    /**
      sort the user's data, implementing insertion sort
     */
    public void mySort() {
	
	for (int numSorted = 1; numSorted < list.size(); numSorted++){
	    insert1(list, numSorted);
	}
    }
}
