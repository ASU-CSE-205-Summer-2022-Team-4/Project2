//********************************************************************************************************
// CLASS: OnCampusStudent (OnCampusStudent.java)
//
// DESCRIPTION
// Creates an OnCampusStudent object which extends Student
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
public class OnCampusStudent extends Student {
    public final int RESIDENT = 1;
    public final int NON_RESIDENT = 2;
    private int mResident;
    private double mProgramFee;
    
    public OnCampusStudent(String Id, String pFirstName, String pLastName) {
        //TODO, CTOR
    }
    
    public void calcTuition() {
        //TODO, OVERRIDE
    }
    
    public double getProgramFee() {
        //TODO
        return 0.0;
    }
    
    public int getResidency() {
        //TODO
        return 0;
    }
    
    public void setProgramFee(double pProgramFee) {
        //TODO
    }
    
    public void setResidency(int pResident) {
        //TODO
    }

}
