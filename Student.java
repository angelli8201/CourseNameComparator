//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #6
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The Student class is used to make and represent a Student object
 * with a specific webID and list of courses
 *
 *
 * @author Angel Li
 *      Angel.Li@stonybrook.edu
 *      112784616
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String webID;
    private ArrayList<Course> courses ;

    /**
     * This is a constructor used to create a Student object
     */
    public Student(){
        courses = new ArrayList<Course>();
    }

    /**
     * The method gets the webID associated with the Student object
     *
     * @return
     *      String of webID of student
     */
    public String getWebID(){
        return this.webID;
    }

    /**
     * The method gets the list of courses associated with the Student object
     *
     * @return
     *      ArrayList of courses associated with the Student object
     */
    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    /**
     * The method changes the webID of the student
     *
     * @param webID
     *      String of webID
     */
    public void setWebID(String webID){
        this.webID = webID;
    }

    /**
     * The method changes the ArrayList of courses associated with the student
     *
     * @param courses
     *      ArrayList of course objects
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
