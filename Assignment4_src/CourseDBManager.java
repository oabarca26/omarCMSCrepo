/**
	 * @author Omar Abarca
	 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	  CourseDBStructure CDS;
	  
	  public CourseDBManager() {
	        this.CDS = new CourseDBStructure(10);
	    }

		/**
		 * Override the add method
		 * adds element into CDE
		 */
	    @Override
	    public void add(String id, int crn, int credits, String roomNum, String instructor) {
	        CourseDBElement CDE = new CourseDBElement(id, crn, credits, roomNum, instructor);
	        CDS.add(CDE);
	    }

		/**
		 * Override the get method
		 * gets the element based on the CRN
		 * @return the element
		 */
	@Override
	public CourseDBElement get(int crn) {
		try {
            return CDS.get(crn);
    } catch (IOException e) {
            e.getMessage();
    }
    return null;
	}

	/**
	 * Override the readFile method
	 * reads and stores information from file
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner file;
        try {
            file = new Scanner(input);
        } catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }

        CDS = new CourseDBStructure(10);

        while(file.hasNextLine()){
            Scanner scanner = new Scanner(file.nextLine());
            String courseId = scanner.next();
            int CRN = scanner.nextInt();
            int numberOfCredits = scanner.nextInt();
            String roomNumber = scanner.next();
            String instructorName = "";
            while (scanner.hasNext()){
                instructorName += scanner.next()+ " ";
            }

            CourseDBElement element = new CourseDBElement(courseId, CRN, numberOfCredits, roomNumber, instructorName);
            CDS.add(element);
        }
       file.close();
		
	}

	/**
	 * Override the showAll method
	 * stores all elements from linked List to array List
	 * @return An array list that has all the information
	 */
	@Override
	public ArrayList<String> showAll() {
		  ArrayList<String> list = new ArrayList<String>();


	        for (LinkedList<?> linkedList: CDS.hashTable) {
	            if (linkedList!=null) {
	                CourseDBElement[] cdeArray = (CourseDBElement[]) linkedList.toArray(new CourseDBElement[linkedList.size()]);

	                for (CourseDBElement cde: cdeArray) {
	                    String courseInfo = "\nCourse:"+cde.getCourseID()+" CRN:"+cde.getCRN()+
	                            " Credits:"+cde.getCredits()+" Instructor:"+cde.getInstructor()+
	                            " Room:"+cde.getRoomNum();
	                    list.add(courseInfo);
	                }
	            }
	        }
	        return list;
	}
}
