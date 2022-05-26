//********************************************************************************************************
// CLASS: OnlineStudent (OnlineStudent.java)
//
// DESCRIPTION
// Creates an OnlineStudent object which extends Student
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
public class OnlineStudent extends Student {
    
    private boolean mTechFee;   // Certain OnlineStudent's pay an additional technology fee. This instance variable will be true if the technology fee applies and false if it does not.
    
    public OnlineStudent(String pId, String pFirstName, String pLastName) {
        super(pId, pFirstName, pLastName);
    }
    
    @Override
    public void calcTuition() {
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee()) {
            t = t + TuitionConstants.ONLINE_TECH_FEE;
        } // end if
        setTuition(t);
    } // end calcTuition
    
    public boolean getTechFee() {
        return mTechFee;
    }
    
    public void setTechFee(boolean pTechFee) {
        mTechFee = pTechFee;
    }

} // end OnlineStudent
