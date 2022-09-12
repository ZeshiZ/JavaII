import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Doctor extends Person {
    // private String dateOfEmployment;
    private Date dateOfEmployment;
    private String dateFormat = "MM/dd/yyyy";
    private String specialty;

    public Doctor() {
        super();
        this.dateFormat = "MM/dd/yyyy";
        this.specialty = "Specialty";
    }

    public Doctor(String aName, String anAddress, String aBirthDate, String aPhone, String aDateOfEmployment, String aSpecialty) throws ParseException {
        super(aName, anAddress, aBirthDate, aPhone);
        Locale locale = Locale.CANADA;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, locale);
        this.dateOfEmployment = simpleDateFormat.parse(aDateOfEmployment);
        this.specialty = aSpecialty;
    }

    public void setDateOfEmployment(String thatDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        this.dateOfEmployment = simpleDateFormat.parse(thatDate);
    }

    public void setSpecialty(String thatSpecialty) {
        this.specialty = thatSpecialty;
    }

    public String getDateOfEmployment() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        return simpleDateFormat.format(dateOfEmployment);
    }

    public String getSpecialty() {
        return specialty;
    }

    public String toString() {
        return "Name: " + super.getName() + "\nBirthday: " + super.getBirthDate() + "\nDate of Employment: " + getDateOfEmployment() + "\nSpecialty: " + specialty + "\n";
    }

    public void print() {
        System.out.printf("Name: %s%nAddress: %s%nBirthday: %s%nCotact No.: %s%nDate of Employment: %s%nSpecialty: %s%n", super.getName(), super.getAddress(), super.getBirthDate(), super.getPhone(), getDateOfEmployment(), specialty);
    }
}
