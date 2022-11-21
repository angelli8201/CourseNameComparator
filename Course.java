//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #6
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The Course class is used to make and represent a Course object with a
 * specific department, number, and semester offered.
 *
 *
 * @author Angel Li
 *      Angel.Li@stonybrook.edu
 *      112784616
 */

import java.io.Serializable;

public class Course implements Serializable {
    private String department;
    private int number;
    private String semester;


    /**
     * This is a constructor used to create a Course object
     */
    public Course(){
    }

    /**
     * The method gets the department of the Course object
     *
     * @return
     *      String describing the department of the Course object
     */
    public String getDepartment() {
        return department;
    }

    /**
     * The method changes the department of the Course object
     *
     * @param department
     *      String describing the department of the Course object
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * The method gets the number of the Course object
     *
     * @return
     *      Integer describing the number of the Course object
     */
    public int getNumber() {
        return number;
    }

    /**
     * The method changes the number of the Course object
     *
     * @param number
     *      Integer describing the number of the Course object
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * The method gets the semester of the Course object
     *
     * @return
     *      String describing the semester of the Course object
     */
    public String getSemester() {
        return semester;
    }

    /**
     * The method changes the semester of the Course object
     *
     * @param semester
     *      String describing the semester of the Course object
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
}
