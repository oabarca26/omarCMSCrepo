/**
	 * @author Omar Abarca
	 */
import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	public LinkedList<CourseDBElement>[] hashTable;


    public CourseDBStructure(int numberOfCourses) {
        hashTable = new LinkedList[numberOfCourses];
    }

    public CourseDBStructure(String string, int hashTableSize){
        hashTable = new LinkedList[hashTableSize];
    }
	
	/**
	 * Override the add method
	 * adds element to the linked list
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = element.hashCode() % hashTable.length;
		
        if(hashTable[index] == null) {
                hashTable[index] = new LinkedList<CourseDBElement>();
        }
        
        hashTable[index].add(element);
	}

	/**
	 * Override the get method
	 * gets the element based on the CRN
	 * @return the element
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
    	String stringCRN = Integer.toString(crn);
        int hashCode = stringCRN.hashCode();
        int index = hashCode%hashTable.length;

        for ( int x = 0 ; x < hashTable[index].size(); x++) {
        	if (hashTable[index].get(x).getCRN() == crn)
        		return hashTable[index].get(x);
        }
        throw new IOException();
	}

	/**
	 * Override the getTableSize method
	 * gets the size of the table
	 * @return the size of table
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
