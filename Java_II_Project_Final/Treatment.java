import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Treatment {
    private String treatmentName;
    private Date treatmentDate;
    private String dateFormat = "MM/dd/yyyy";
    private String doctor;
    private String patient;

    public Treatment() {
        this.treatmentName = "Treatment";
        this.dateFormat = "MM/dd/yyyy";
    }

    public Treatment(String aTreatment, String aDate, String aPatient, String aDoctor) throws ParseException {
        this.treatmentName = aTreatment;
        Locale locale = Locale.CANADA;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, locale);
        this.treatmentDate = simpleDateFormat.parse(aDate);
        this.patient = aPatient;
        this.doctor = aDoctor;
    }

    public void setTreatment(String thatTreatment) {
        this.treatmentName = thatTreatment;
    }

    public void setDate(String thatDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        this.treatmentDate = simpleDateFormat.parse(thatDate);
    }

    public String getTreatment() {
        return treatmentName;
    }

    public String getTreatmentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        return simpleDateFormat.format(treatmentDate);
    }

    public String toString() {
        return "Treatment: " + treatmentName + "\nDate: " + getTreatmentDate() + "\nPatient: " + patient + "\nDoctor: " + doctor + "\n";
    }

    public void print() {
        System.out.printf("Treatment: %s%nDate: %s%nPatient: %s%nDoctor: %s%n", treatmentName, getTreatmentDate(), patient, doctor);
    }
}
