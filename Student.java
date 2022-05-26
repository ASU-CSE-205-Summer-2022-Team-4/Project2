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
//********************************************************************************************************
public class Student {
    private int mCredits;
    private String mFirstName;
    private String mId;
    private String mLastName;
    private double mTuition;
    
    public Student(String pId, String pFirstName, String pLastName) {
        // ctor
        mId = pId;
        mFirstName = pFirstName;
        mLastName = pLastName;
    } // end constructor
    
    public void calcTution() {
        //TODO
    }
    
    public int compareTo(Student pStudent) {
        //TODO, OVERRIDE
        return 0;
    }
    
    public int getCredits() {
        //TODO
        return 0;
    }
    
    public String getFirstName() {
        //TODO
        return null;
    }
    
    public String getID() {
        //TODO
        return null;
    }
    
    public double getTuition() {
        //TODO
        return 0.0;
    }
    
    public void setCredits(int pCredits) {
        //TODO
    }
    
    public void setFirstName(String pFirstName) {
        //TODO
    }
    
    public void setId(String pId) {
        //TODO
    }
    
    public void setLastName(String pLastName) {
        //TODO
    }
    
    protected void setTuition(double pTuition) {
        //TODO
    }

} // end Student
