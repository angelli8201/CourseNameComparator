//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #6
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The LunarSystem class allows the user to interact with a database of Students.
 * The class provides the user with a menu-based interface that allows them to
 * add,remove, and edit Students, as well as their courses.
 *
 *
 * @author Angel Li
 *      Angel.Li@stonybrook.edu
 *      112784616
 */

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class LunarSystem {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Lunar System, a second place " +
                "course registration system for second rate courses at a second " +
                "class school.\n");
       HashMap<String, Student> database = new HashMap<String,Student>();
       try{
           FileInputStream file = new FileInputStream("Lunar.ser");
           ObjectInputStream inStream = new ObjectInputStream(file);
           database = (HashMap<String, Student>) inStream.readObject();
            inStream.close();

       } catch (IOException | ClassNotFoundException e) {
           System.out.println("No previous data found\n");
       }
        boolean b = true;

        Scanner input = new Scanner(System.in);
        String selection;
        String selectionName;
        String registrarSelection;
        String webidSelection;
        do {
            System.out.println("Menu:\n" +
                    "    L)Login\n" +
                    "    X)Save state and quit\n" +
                    "    Q)Quit without saving state.\n");
            System.out.println("Please select an option: ");
            selection = input.next().toUpperCase();

            switch (selection) {
                case "L":
                case "l":
                    System.out.println("Please enter webid: ");
                    selectionName = input.next().toUpperCase();

                    switch (selectionName) {
                        case "REGISTRAR":
                            System.out.println("Welcome REGISTRAR");
                            do {
                                System.out.println("Options:\n" +
                                        "     R) Register a student\n" +
                                        "     D) De-register a student\n" +
                                        "     E) View course enrollment\n" +
                                        "     L) Logout\n");
                                System.out.println("Please select an option: ");
                                registrarSelection = input.next();
                                switch (registrarSelection) {
                                    case "R":
                                    case "r":
                                        System.out.println("Please enter a webid for the new student:");
                                        String webidTemp = input.next().toUpperCase();
                                        if (!database.containsKey(webidTemp)) {
                                            Student newStudent = new Student();
                                            newStudent.setWebID(webidTemp);
                                            database.put(webidTemp, newStudent);
                                            System.out.println(webidTemp + " registered.");
                                        } else {
                                            System.out.println(webidTemp + " is already registered.");
                                        }
                                        break;

                                    case "D":
                                    case "d":
                                        System.out.println("Please enter the webid of the student you want to deregister: ");
                                        String removeWebid = input.next().toUpperCase();
                                        database.remove(removeWebid);
                                        System.out.println(removeWebid + " deregistered.");

                                        break;

                                    case "E":
                                    case "e":
                                        System.out.println("Please select a course: ");
                                        String courseOption = input.next().toUpperCase();
                                        int i2 = input.nextInt();
                                        Course tempc = new Course();
                                        tempc.setDepartment(courseOption);
                                        tempc.setNumber(i2);
                                        System.out.println("Student    Semester\n" +
                                                "-------------------");
                                        for (Map.Entry<String, Student> x : database.entrySet()) {
                                            for (Course c : x.getValue().getCourses()) {
                                                if (tempc.getDepartment().equalsIgnoreCase(c.getDepartment()) &&
                                                        tempc.getNumber() == c.getNumber()) {
                                                    System.out.println(x.getValue().getWebID() + "\t\t" + c.getSemester());
                                                }
                                            }
                                        }

                                        break;

                                    case "L":
                                    case "l":
                                        System.out.println("Registrar logged out");
                                        break;

                                    default:
                                        System.out.println("Not an option. Please try again");

                                }
                            } while (!registrarSelection.equalsIgnoreCase("L"));
                            break;

                        default:
                            try {
                                System.out.println("Welcome " + selectionName);
                                do {
                                    System.out.println("Options:\n" +
                                            "    A)Add a class\n" +
                                            "    D)Drop a class\n" +
                                            "    C)View your classes sorted by course name/department\n" +
                                            "    S)View your courses sorted by semester\n" +
                                            "    L}Logout  ");
                                    System.out.println("Please select an option: ");
                                    webidSelection = input.next();
                                    switch (webidSelection) {
                                        case "A":
                                        case "a":
                                            System.out.println("Please enter course name: ");
                                            String courseAdd = input.next().toUpperCase() + " " + input.next();
                                            String[] temp1 = courseAdd.split(" ");
                                            System.out.println("Please select a semester: ");
                                            String semesterAdd = input.next().toUpperCase();
                                            Course newCourse = new Course();
                                            newCourse.setDepartment(temp1[0]);
                                            int x = Integer.valueOf(temp1[1]);
                                            newCourse.setNumber(x);
                                            newCourse.setSemester(semesterAdd);
                                            database.get(selectionName).getCourses().add(newCourse);
                                            System.out.println(courseAdd + " added into " + semesterAdd);
                                            System.out.println();
                                            break;

                                        case "D":
                                        case "d":
                                            System.out.println("Please enter course name: ");
                                            String semester;
                                            String courseName = input.next().toUpperCase();
                                            int i = input.nextInt();
                                            for (Iterator<Course> it = database.get(selectionName).getCourses().iterator(); it.hasNext(); ) {
                                                Course c = it.next();
                                                if (c.getDepartment().equalsIgnoreCase(courseName) && c.getNumber() == i) {
                                                    System.out.println(courseName + i + " dropped for " + c.getSemester());
                                                    it.remove();
                                                }
                                            }

                                            break;

                                        case "C":
                                        case "c":
                                            System.out.println("Dept. Course Semester\n" +
                                                    "-------------------------------");
                                            database.get(selectionName).getCourses().sort(new CourseNameComparator());
                                            for (Course c : database.get(selectionName).getCourses()) {
                                                System.out.println(c.getDepartment() + "\t\t" + c.getNumber() + "\t\t" + c.getSemester());
                                            }

                                            break;

                                        case "S":
                                        case "s":
                                            System.out.println("Dept. Course Semester\n" +
                                                    "-------------------------------");
                                            database.get(selectionName).getCourses().sort(new CourseNameComparator());
                                            database.get(selectionName).getCourses().sort(new SemesterComparator());
                                            for (Course c : database.get(selectionName).getCourses()) {
                                                System.out.println(c.getDepartment() + "\t\t" + c.getNumber() + "\t\t" + c.getSemester());
                                            }
                                            break;

                                        case "L":
                                        case "l":
                                            System.out.println(selectionName + " logged out.");
                                            break;

                                        default:
                                            System.out.println("Not an option. Please try again.");
                                    }
                                } while (!webidSelection.equalsIgnoreCase("L"));
                            } catch (Exception e) {
                                System.out.println("Student not registered. Please try again.\n");
                            }
                    }
                            break;
                        case "X":
                        case "x":
                            System.out.println("System state saved, system shut down for maintenance.");
                            FileOutputStream file = new FileOutputStream("Lunar.ser");
                            ObjectOutputStream outStream = new ObjectOutputStream(file);
                            outStream.writeObject(database);
                            outStream.close();
                            b = false;
                            break;

                        case "Q":
                        case "q":
                            System.out.println("Good bye, please pick the right SUNY next time!");
                            b = false;
                            break;

                        default:
                            System.out.println("Not an option. Please try again.");
                    }
            }
            while (b == true) ;
        }
}
