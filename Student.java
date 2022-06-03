//********************************************************************************************************
// CLASS: Student (Student.java)
//
// DESCRIPTION
// Creates a Student object
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Summer 2022
// Project Number: P02
//
// AUTHOR: David McConnell  ASURITE ID: dmcconn7  EMAIL: dmcconn7@asu.edu
// AUTHOR: Lia Moua         ASURITE ID: amoua     EMAIL: amoua@asu.edu
// AUTHOR: Arsal Akhtar     ASURITE ID: akakhta2  EMAIL: akakhta2@asu.edu
// AUTHOR: Kari McBride     ASURITE ID: kemcbri2  EMAIL: kemcbri2@asu.edu
// AUTHOR: Kevin R. Burger (burgerk@asu.edu) (Template author)
//          Computer Science & Engineering
//          School of Computing, Informatics, and Decision Systems Engineering
//          Fulton Schools of Engineering
//          Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************
public abstract class Student implements Comparable<Student> {
    
    private int mCredits;
    private String mFirstName;
    private String mId;
    private String mLastName;
    private double mTuition;
    
    

    /**
     * Creates a Student object and initializes the mId, mFirstName, and mLastName instance
     * variables.
     */
    public Student(String pId, String pFirstName, String pLastName) {

        mId = pId;
        mFirstName = pFirstName;
        mLastName = pLastName;
    } // end constructor
    
    /**
     * calcTuition() is to be implemented by subclasses of Student. Remember that abstract methods
     * are not implemented in a superclass but must either be implemented in a subclass, or if not,
     * then the subclass also becomes an abstract class. The reason calcTuition() is abstract
     * and intended to be implemented by the subclasses of Student is because how we calculate the
     * tuition for an OnCampusStudent is different than how we calculate the tuition for an Online-
     * Student.
     */
    abstract public void calcTuition();
    
    /**
     * The java.lang.Comparable<T> interface declares one method int compareTo(T obj) that must be
     * implemented by any class which implements the interface. This method is called from Sorter.
     * keepMoving() to compare the mId fields of two Students.
     *
     * Compares the mId fields of 'this' Student and pStudent. Returns -1 if this Student's mId
     * field is less than pStudent's mId field. Returns 0 if this Student's mId field is equal to
     * pStudent's mId field. Returns 1 if this Student's mId field is greater than pStudent's mId
     * field.
     *
     * Note that the mId field of a Student is a java.lang.String and String also implements the
     * Comparable<String> interface and consequently, also implements a compareTo() method to
     * compare two strings. Hence, all we have to do here is to call the String class compareTo()
     * method on the two mId strings of 'this' Student and pStudent and return whatever that method
     * returns.
     */
    
    @Override
    public int compareTo(Student pStudent) {
        // Implements the compareTo() method of the Comparable<Student> interface. 
        //Returns a negative integer if the mId instance variable of this Student is less than the mId instance variable of pStudent. 
        //Returns 0 if they are equal (should not happen because id numbers are unique). 
        //Returns a positive integer if the mId instance variable of this Student is greater than the mId instance variable of pStudent. 
        //The code for compareTo() is simple and is shown below. 
        //Read the compareTo() method comments in Student for more information. 
        //Note you will use the @Override annotation to prevent accidental overloading.
        // check for correct implementation
        return getId().compareTo(pStudent.getId());
    }

    /**
     * Accessor method for mCredits.
     */
    public int getCredits() {
        return mCredits;
    }

    /**
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * Accessor method for mId.
     */
    public String getId() {
        return mId;
    }

    /**
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * Accessor method for mTuition.
     */
    public double getTuition() {
        return mTuition;
    }

    /**
     * Mutator method for mCredits.
     */
    public void setCredits(int pCredits) {
        mCredits = pCredits;
    }

    /**
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * Mutator method for mId.
     */
    public void setId(String pId) {
        mId = pId;
    }

    /**
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * Mutator method for mTuition.
     */
    protected void setTuition(double pTuition) {
        mTuition = pTuition;
    }
    
    
} // end Student
