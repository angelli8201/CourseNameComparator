//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #6
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The CourseNameComparator class allows us to compare course names with the
 * following priority: department and then number.
 *
 *
 * @author Angel Li
 *      Angel.Li@stonybrook.edu
 *      112784616
 */

import java.util.Comparator;

public class CourseNameComparator implements Comparator<Course> {

    /**
     * The method compares two courses depending on department and number.
     *
     * @param left
     *      Course object
     * @param right
     *      Course object
     * @return
     *      Return -1 if left course is "less" than right course, 0 if they
     *      are equal, and 1 if left course is "greater" than right course
     */
    public int compare(Course left, Course right) {
        String courseleft = "" + left.getDepartment() + "";
        String courseright = "" + right.getDepartment() + "";
        if (courseleft.compareTo(courseright) < 0)
            return -1;
        else if (courseleft.compareTo(courseright) > 0)
            return 1;

        else if ((left.getNumber() == right.getNumber()) &&
        left.getDepartment().equalsIgnoreCase(right.getDepartment())) {
            return 0;
        }
        else if (left.getNumber() < right.getNumber()) {
            return -1;
        }
        return 1;
    }
}
