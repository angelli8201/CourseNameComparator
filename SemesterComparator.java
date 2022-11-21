//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #6
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The SemesterComparator allows us to compare two courses based on the semester
 * they are offered.
 *
 *
 * @author Angel Li
 *      Angel.Li@stonybrook.edu
 *      112784616
 */

import java.util.Comparator;

public class SemesterComparator implements Comparator<Course> {


    /**
     * The method compares two courses based on semester offered
     *
     * @param left
     *      Course object
     * @param right
     *      Course object
     * @return
     *      Return -1 if left course's semester is less than right, 0 if they
     *      are equal, 1 if left course's semester is greater than right
     *      course's semester
     */
    public int compare(Course left, Course right) {
        if (left.getSemester().equalsIgnoreCase(right.getSemester())) {
            return 0;
        }
        //YEAR
        String temp = left.getSemester().substring(1, 5);
        String temp2 = right.getSemester().substring(1, 5);
        int x = Integer.parseInt(temp);
        int y = Integer.parseInt(temp2);

        //SEMESTER(SPRING OR FALL) SPRING COMES FIRST
        Character semesterTemp = left.getSemester().charAt(0);
        Character semesterTemp2 = right.getSemester().charAt(0);

        if (semesterTemp.compareTo(semesterTemp2) == 0 && x < y) {
            return -1;
        }
        if (semesterTemp.compareTo(semesterTemp2) == 0 && x > y) {
            return 1;
        }

        if(semesterTemp.compareTo(semesterTemp2)>0 && x==y){
            return -1;
        }
        if(semesterTemp.compareTo(semesterTemp2)>0 && x<y){
            return -1;
        }
        if(semesterTemp.compareTo(semesterTemp2)>0 && x>y){
            return 1;
        }
        if(semesterTemp.compareTo(semesterTemp2)<0 && x==y){
            return 1;
        }
        if(semesterTemp.compareTo(semesterTemp2)<0 && x<y){
            return -1;
        }
        return 1;
    }
}
