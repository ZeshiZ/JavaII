import java.text.ParseException;

public class Patient extends Person {
    private int patientID;
    private String insuranceCompany;

    public Patient(String aName, int aPatientID, String anAddress, String aBirthDate, String aPhone, String anInsuranceCompany) throws ParseException {
        super(aName, anAddress, aBirthDate, aPhone);
        this.patientID = aPatientID;
        this.insuranceCompany = anInsuranceCompany;
    }

    public void setPatientID(int thatPatientID) {
        this.patientID = thatPatientID;
    }

    public void setInsuranceCompany(String thatInsuranceCompany) {
        this.insuranceCompany = thatInsuranceCompany;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public String toString() {
        return "Name: " + super.getName() + "\nPatient ID: " + patientID + "\nAddress: " + super.getAddress() + "\nBirthday: " + super.getBirthDate() + "\nContact No.: " + super.getPhone() + "\nInsurance Company: " + insuranceCompany + "\n";
    }

    public void print() {
        System.out.printf("Name: %s%nPatient ID: %d%nAddress: %s%nBirthday: %s%nContact No.: %s%nInsurance Company: %s%n", super.getName(), patientID, super.getAddress(), super.getBirthDate(), super.getPhone(), insuranceCompany);
    }
}
