import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class Person {
    private String name;
    private String address;
    private Date birthDate;
    private String dateFormat = "MM/dd/yyyy";
    private String phone;

    public Person() {
        this.name = "Patient X";
        this.address = "123 St, City, Province";
        this.dateFormat = "MM/dd/yyyy";
        this.phone = "514-222-3333";
    }

    public Person(String thatName, String thatAddress, String thatBirthDate, String thatPhone) throws ParseException {
        this.name = thatName;
        this.address = thatAddress;
        Locale locale = Locale.CANADA;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, locale);
        this.birthDate = simpleDateFormat.parse(thatBirthDate);
        this.phone = thatPhone;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public void setAddress(String anAddress) {
        this.address = anAddress;
    }

    public void setBirthDate (String aBirthDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        this.birthDate = simpleDateFormat.parse(aBirthDate);
    }

    public void setPhone(String aPhone) {
        this.phone = aPhone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "CA"));
        return simpleDateFormat.format(birthDate);
    }

    public String getPhone() {
        return phone;
    }

    public abstract String toString();

    public abstract void print();
}