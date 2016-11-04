import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;


/**
 * The Deque20<E> class creates an instance of a circular array.
 * It is only possible to remove or add elements from the front or the back of the array.
 * 
 * @author Stanley Lee | 4-Digit Code: 2734 | email: stanleylee@csus.edu
 * @author Peter Le	   | 4-Digit Code: 2104 | email: peterle3@csus.edu
 * @version 13.3.7 15 April 2016
 *
 * @param <E> is a generic variable that allows the Deque to contain elements of any variable type.
 */
public class Deque20<E> implements Iterable<E> {
	
	/**
	 * The array's default size is always initialized to 16.
	 */
    public static final int INITIAL_SIZE = 16;
    
    /**
     * E[] items is an array containing Deque20.
     * int start is the starting index of Deque20.
     * int end is the ending index of Deque20.
     */
    private E[] items;
    private int start;
    private int end;
    private int numElems;
    @SuppressWarnings("unchecked")  // Casting Object[] to E[]
    
    /**
     * Deque20 constructor creates an array of a generic data type.
     */
    public Deque20() {
        items = (E[]) new Object[INITIAL_SIZE];
        numElems = size();
    }
    
    /**
     * This iterator constructor allows one to iterate over a generic type.
     */
    public Iterator<E> iterator() {
        return new Deque20Iterator<E>(items,start,end);
    }
   
    public int numElem(){
    	return numElems;
    }
    /**
     * addFirst method adds an element to the front of the circular Deque20 despite its
     * location within the array.
     * 
     * @param x is a generic variable that will be added to the front of the list.
     */
    public void addFirst(E x) {
    	if(x == null) {
   	 		throw new NullPointerException("You cannot add a null element");
        }
    	//numElems+=1;
    	 if(numElems == items.length) {
         	bigArray();
         }
    	 //Starting with EMPTY arra
    	 if(numElems == 0){
    		 start = 0;
    		 items[start] = x;
    		 numElems++;
    	 }
    	 else{
    	 start--;
    	 if(start < 0) 
    		 start = items.length - 1;
    	 items[start] = x;
    	 numElems++;
    
    	 }
    	 //If (start + numElems) %items.length < 0, we know end is at end of array
    	 if((start + numElems) %items.length < 0) { 
    		 end = items.length - 1;
    	 }
    	 // Otherwise, (start + numElems) %items.length - 1 will get us value of end
    	 end = (start + numElems) %items.length - 1;
    	 
    }
    
    /**
     * addFirst method adds an element to the end of the circular Deque20 despite its
     * location within the array. 
     * 
     * @param x is a generic variable that will be added to the end of the list.
     */
    public void addLast(E x) {
   	 	if(x == null) {
   	 		throw new NullPointerException("You cannot add a null element.");
        }
   	 	
        if(numElems == items.length) {
        	bigArray();
        }
        items[(start + numElems) %items.length] = x;
        numElems++;
        if(end == items.length - 1) { 
        	end = 0;
        }
        else { 
        	end++;
        }
        
    }
    
    /**
	 * removeFirst method removes the first element from the circular Deque20 despite 
	 * its location within the array.
	 */
	public void removeFirst() {
		if(isEmpty()) { 
			throw new NoSuchElementException();
		}	
		else {
			items[start] = null;
			numElems--;
			if(start == items.length - 1 )
				start = 0;
			else { 
				start++;
			}
		}		
	 }
		
	


	/**
     * removeLast method removes the last element from the circular Deque20 despite 
     * its location within the array.
     */
    public E removeLast() {
    	if(isEmpty()) { 
    		throw new NullPointerException();
    	}
		//items[end] = null;
    	E a = items[end];
    	
    	items[end] = null;
    	numElems--;
    	if(end == 0 ) 
    		end = items.length - 1;
    	else { 
    		end--;
    	}
    	return a;
    }
  
		
    
    /**
	 * peekLast method is used to "look" at the first element in the circular Deque20
	 * despite its location within the array.
	 * 
	 * @returns the first element in the circular Deque20.
	 */
	public E peekFirst() {
		//if(isEmpty()) { 
		//	throw new NullPointerException("You cannot peek at empty deck.");
		//}
		//else { 
			return items[start];
		//}
		
	}


	/**
     * peekLast method is used to "look" at the last element in the circular Deque20
     * despite its location within the array.
     * 
     * @returns the last element in the circular Deque20.
     */
    public E peekLast() { 
    	//if(isEmpty()) { 
    		//throw new NullPointerException("You cannot peek at empty deck.");
    //	}
    //	else { 
    		return items[end];
    	//}
	}
    
    // maybe fix x
    // I want to input values from items in order
    /**
     * bigArray doubles the size of the array once the size of the circular Deque20 
     * is equal to the size of the array.
     */
    public void bigArray() {
	    @SuppressWarnings("unchecked")
	    int x = 0;
	    E[] bigItem = (E[]) new Object[items.length * 2];
	    if(end < start) { 
	    	
	    	for(int i = start; i < items.length; i++) { 
	    		bigItem[x] = items[i];
	    		x++;
	    	}
	    	start = 0;
	    	  for(int i = 0; i <= end; i++) {
	  	    	bigItem[x] = items[i]; 
	  	    	x++;
	  	    }
	    
	    }
	    else { 
	    	for(int i = start; i <= end; i++) {
	    		bigItem[x] = items[i];
	    		x++;
	    	}
	    }
	    
	    this.items = bigItem;
    }
    
    //Need to somehow make array bigger if size = items.legnth   
    // for loops for temp solution, use iterator after it works
    /**
     * size method finds the size of the circular Deque20.
     * 
     * @param items is the array of the circular Deque20.
     * @returns the size of the circular Deque20.
     */
    public int size() {
        int size = 0;
        if(end < start) {
        	for(int i = start; i < items.length; i++) {
        		if(items[i] != null)
        			size++;   
	        }
        	for(int i = 0; i <= end; i++) { 
        		if(items[i] != null)
        			size++;
        		
        	}
        }
        else { 
        	for(int i = start; i <= end; i++) { 
        		if(items[i] != null)
        			size++;
        	}
        }
        numElems = size;
        return size;
    }
    
    /**
     * isEmpty is a boolean check to determine whether or not the circular
     * array, Deque20, is empty or not.
     * 
     * @param items is the array of the circular Deque20.
     * @returns whether or not the circular array, Deque20, is empty or not.
     */
    public boolean isEmpty() {
	    boolean check = true;
        for(int i = 0; i < items.length; i++) {
	        if(items[i] != null) {
	           check = false;
	        } 
        }  
        return check;
    }
	 
    /**
     * toString method prints out the circular array, Deque20.
     * 
     * @returns the array as a string.
     */
	public String toString() {
	    return Arrays.toString(items);
	}
}
//===========================================================================


//A java file may only have one public class. The following class is not
//declared public, so Java won't complain. No class except Deque20 creates
//a Deque20Iterator object, so it's okay to tuck its definition here.




class Deque20Iterator<E> implements Iterator<E> {


	int iterate = -1; //used as a counter to increment iterator.
	//increments before doing stuff, so -1 actually starts at 0.
	
	int start;
	int end;
	E[] items;
	
    public Deque20Iterator(E[] items, int start, int end) {
    	this.items = items;
    	this.start = start;
    	this.end = end;
    }


    public E next() {
  
    		iterate +=1;
    		//if statement checks that iterate +start so it won't be bigger then items.length
    		if(iterate + start >items.length-1){
            	iterate -= items.length;
            }
    		return items[start + iterate];
    	}
    


    public boolean hasNext() {
		//if statement checks that iterate + start won't be bigger than item.length
    	int temp = iterate;
    	if(temp + start >items.length-1){
    		temp -= items.length;
        }
    	if(isEmpty()|| start + temp ==end){
        	return false;
        }else{
        	return true;
        }
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    // If there's an element in item, return false. Otherwise, return true.
    public boolean isEmpty() {
    	boolean result = true;
        for(int i = 0; i < items.length; i++) {
           if(items[i] != null) {
              result = false;
           }
        }
        return result;
     }
}








