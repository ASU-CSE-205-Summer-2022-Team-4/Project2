//********************************************************************************************************
// CLASS: Main (Main.java)
//
// DESCRIPTION
// Contains main logic for program
// This program reads an input file "p02-students.txt", processes tuition fees including
// tech. fees, residence information, etc. The program creates a formatted output file "p02-tuition.txt"
// containing student tuition information.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Summer 2022
// Project Number: P02
//
// AUTHOR: David McConnell  ASURITE ID: dmcconn7  EMAIL: dmcconn7@asu.edu
// AUTHOR: Lia Moua         ASURITE ID: amoua     EMAIL: amoua@asu.edu
// AUTHOR: Arsal Akhtar     ASURITE ID: akakhta2  EMAIL: akakhta2@asu.edu
// AUTHOR: Kari McBride     ASURITE ID: kemcbri2  EMAIL: kemcbri2@asu.edu
//********************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Instantiate a Main object and call run() on the object. Note that essentially
     * now, run() becomes the starting point of execution for the program.
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Get student information from p02-students.txt
     *      if not found:       Output "Sorry, could not open 'p02-students.txt' for reading. Stopping." 
     * Calculate tuition for each student
     * Sort students ascending order by ID
     * Print tuition for each student to p02-tuition.txt, sorted
     *      If not found:       Output "Sorry, could not open 'p02-tuition.txt' for writing. Stopping."
     */
    private void run() {
        
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            studentList = readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, could not open \'p02-students.txt\' for reading. Stopping.");
            System.exit(-1);
        }
        calcTuition(studentList);
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
        try {
            writeFile(studentList);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, could not open \'p02-tuition.txt\' for writing. Stopping.");
            System.exit(-1);
        }
    } // end run

    /**
     * Calculates the tuition for each Student in pStudentList. 
     * Write an enhanced for loop that iterates over each Student in pStudentList. For each Student,
     * call calcTuition() on that Student object. 
     * Note: this is a polymorphic method call. What does that mean?
     * Students may be OnCampusStudents or OnlineStudents. Regardless which type of student they are,
     * the appropriate method will be called. Since different student types have different fee schedules,
     * a polymorphic method call ensures each student will be processed accordingly.
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    } // end calcTuition

    /**
     * Reads the student information from "p02-students.txt" and returns the list of
     * students as an ArrayList<Student> object. Note that this method throws
     * FileNotFoundException if the input file could not be opened. The exception is
     * caught and handled in run()
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner in = new Scanner(new File("p02-students.txt"));
        while (in.hasNext()) {
            String studentType = in.next();
            if (studentType.equals("C")) {
                studentList.add(readOnCampusStudent(in));
            } else {
                studentList.add(readOnlineStudent(in));
            }
        }
        in.close();
        return studentList;
    } // end readFile

    /**
     * Reads the information for an on-campus student from the input file.
     *
     * PSEUDOCODE Declare String object id and assign pIn.next() to id Declare
     * String object named lname and assign pIn.next() to lname Declare String
     * object named fname and assign pIn.next() to fname Declare and create an
     * OnCampusStudent object. Pass id, fname, and lname as params to ctor. Declare
     * String object named res and assign pIn.next() to res Declare double variable
     * named fee and assign pIn.nextDouble() to fee Declare int variable named
     * credits and assign pIn.nextInt() to credits If res.equals("R") Then Call
     * setResidency(OnCampusStudent.RESIDENT) on student Else Call
     * setResidency(OnCampusStudent.NON_RESIDENT) on student End If Call
     * setProgramFee(fee) on student Call setCredits(credits) on student Return
     * student
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) { 
        String id = pIn.next();
        String lastName = pIn.next();
        String firstName = pIn.next();
        OnCampusStudent student = new OnCampusStudent(id, firstName, lastName);
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();
        if (res.equals("R")) {
            student.setResidency(OnCampusStudent.RESIDENT);
        } else {
            student.setResidency(OnCampusStudent.NON_RESIDENT);
        }
        student.setProgramFee(fee);
        student.setCredits(credits);
        return student;
    } // end readOnCampusStudent

    /**
     * Reads the information for an online student from the input file.
     *
     * PSEUDOCODE Declare String object id and assign pIn.next() to id Declare
     * String object named lname and assign pIn.next() to lname Declare String
     * object named fname and assign pIn.next() to fname Declare and create an
     * OnlineStudent student. Pass id, fname, lname as params to the ctor., Declare
     * String object named fee and assign pIn.next() to fee Declare int variable
     * named credits and assign pIn.nextInt() to credits If fee.equals("T")) Then
     * Call setTechFee(true) on student Else Call setTechFee(false) on student End
     * If Call setCredits(credits) on student Return student
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lastName = pIn.next();
        String firstName = pIn.next();
        OnlineStudent student = new OnlineStudent(id, firstName, lastName);
        String fee = pIn.next();
        int credits = pIn.nextInt();
        if (fee.equals("T")) {
            student.setTechFee(true);
        } else {
            student.setTechFee(false);
        }
        student.setCredits(credits);
        return student;
    } // end readOnlineStudent

    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note
     * that this method throws FileNotFoundException if the output file could not be
     * opened. The exception is caught and handled in run().
     *
     * PSEUDOCODE Declare and create a PrintWriter object named out, opening
     * "p02-tuition.txt" for writing Enhanced ForEach student in pStudentList Do
     * Using out.printf() output the student information per SW Requirement 3 End
     * Enhanced ForEach Close the output file
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter outWriter = new PrintWriter("p02-tuition.txt");
        for(Student student : pStudentList){
            outWriter.printf("%-16s%-20s%-15s%8.2f\n", student.getId(), student.getLastName(), student.getFirstName(), student.getTuition());
        }
        outWriter.close();
    } // end writeFile
} // end Main
