package tester;

import lists.ListADT;

public class ListMethods {
	
	/**
	 * Returns the index of the first occurrence 'item' in l. If no such element, return -1.
	 * @param <E> - Type of elements in ListADT
	 * @paramH l - list to search
	 * @param item - Item to find
	 * @return index of first occurrence
	 * 
	 * THIS METHOD DO NOT CHANGE THE LIST l
	 * (so make sure currPos returns to it's position before this method was called, 
	 *  see printing methods)
	 */
	public static <E> int find(ListADT<E> l, E item) {
		int originalPos = l.currPos(); // variable to hold the current position
		
		
		for(int i = 0; i<l.length(); i++) { //for loop iterates through the entire list.
			l.moveToPos(i);
			if(l.getValue().equals(item)) { // .equals returns true if as long as they have the same characters
				l.moveToPos(originalPos); // Conditional statement checks if index i is equal to the item passed in as a parameter.
				return i; //if true return index i
			}
		}
		l.moveToPos(originalPos); //move position back to its origin.
		return -1; //return -1 if item not found.
	}
	
	/**
	 * Insert 'item' in position 'pos' of list l of type E
	 * @return True if inserted, false if not. 
	 * Position after insertion is at pos
	 */
	public static <E> boolean insertIn(ListADT<E> l, E item, int pos) {
		if(pos < 0 || pos > l.length()) { //conditional statement to check if parameter pos is out of bounds. 
			return false; 
		}
		l.moveToPos(pos); // move to position specified in the pos parameter
		l.insert(item); // insert item parameter.
		return true;
	}
	
	/**
	 * Return a list with all elements of l, in reverse order. 
	 * If l is empty, returns empty list.
	 * 
	 * THIS METHOD DO NOT CHANGE THE LIST l
	 * 
	 * This method runs in LINEAR time for BOTH implementations
	 */
	public static <E> ListADT<E> getReversedList(ListADT<E> l){
		ListADT<E> reversedList = new ArrayListADT<>();
		int originalPos = l.currPos();
		
		for(int i = l.length()-1; i >=0 ; i--) {
			l.moveToPos(i);
			reversedList.append(l.getValue());
		}
		l.moveToPos(originalPos);
		return reversedList;
	}
	
	/**
	 * Returns the first index of the first occurrence of sequence 'seq' in l. 
	 * If not there, returns -1.  
	 * 
	 * THIS METHOD DO NOT CHANGE THE LIST (including currPos)
	 */
	public static int findSequence (ListADT<Integer> l, Integer[] seq) {
		int originalPos = l.currPos();
		
		for(int i = 0 ; i <= l.length()-seq.length; i++) {
		boolean match = true;	
		
		
		for(int j = 0; j < seq.length; j++) {
			l.moveToPos(i+j);
			if(!l.getValue().equals(seq[j])) {
				match = false;
				break;
			}
		}
			if(match) {
				l.moveToPos(originalPos);
				return i;
			}
		}
		l.moveToPos(originalPos);
		return -1;
	}
	
	
	/**
	 * Returns true is the character 'first' appears before the character 'second' 
	 * (there may be other characters in between)
	 * 
	 * THIS METHOD DO NOT CHANGE THE LIST  (including currPos) 
	 */
	public static boolean isBefore(ListADT<Character> l, Character first, Character second) {
		return false; //STUB
	}

	
	/**
	 * Returns true if the list is sorted in ascending order
	 * 
	 * THIS METHOD DO NOT CHANGE THE LIST  (including currPos)
	 */
	public static <E extends Comparable<E>> boolean isSorted(ListADT<E> l){
		//Save current position to set list back to initial state at the end of method
		int initialPos = l.currPos();

		// An empty list is already sorted
		if (l.isEmpty()) {
			return true;
		}
		// Iterate the list
		E curr;
		// read first element
		l.moveToStart();
		E prev = l.getValue();
		l.next();
		
		// For every element, check if it is no smaller then the previous
		while(!l.isAtEnd()) {
			curr = l.getValue();
			if (prev.compareTo(curr) > 0) {
				return false;
			}
			prev = curr;
			l.next();	
		}
		
		// Return l to initial state
		l.moveToPos(initialPos);
		return true;
	}
}
