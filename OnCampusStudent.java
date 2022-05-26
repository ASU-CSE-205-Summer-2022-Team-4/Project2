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
    public final static int RESIDENT = 1;
    public final static int NON_RESIDENT = 2;
    private int mResident;  // RESIDENT if the OnCampusStudent is a resident, NON_RESIDENT for non-resident.
    private double mProgramFee; // Certain OnCampusStudents pay an additional program fee; may be 0.
    
    public OnCampusStudent(String pId, String pFirstName, String pLastName) {
        //TODO, CTOR, Must call the superclass constructor passing pId, pFirstName, and pLastName as parameters.
        super(pId, pFirstName, pLastName);
    }
    
    
    /*
     * Must implement the rules described in §3 Background to calculate the tuition for either a resident or non-resident student. 
     * Note that we cannot directly access the mTuition instance variable of an OnCampusStudent because it is intentionally declared as private in Student. 
     * So how do we write to mTuition? By calling the protected setTuition() mutator method that is inherited from Student. 
     * Any why is setTuition() protected? Because it is only intended to be called from subclasses of Student and not from classes that are not part of the Student class hierarchy.
     * 
     * Override Method calcTuititon() Returns Nothing
    */
    public void calcTuition() {
        double t;
        if (getResidency()==RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        } // end if else
        t = t + getProgramFee();
        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t = t + (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS)*TuitionConstants.ONCAMP_ADD_CREDITS;
        } // end if
        setTuition(t);
    } // end calcTuition
    
    public double getProgramFee() {
        return mProgramFee;
    }
    
    public int getResidency() { 
        return mResident;
    }
    
    public void setProgramFee(double pProgramFee) {
        mProgramFee = pProgramFee;
    }
    
    public void setResidency(int pResident) {
        mResident = pResident;
    }

} // end OnCampusStudent
