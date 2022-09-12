import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee, Sharon; Zhong, Zeshi; Trinidad, Jeorge
 * @version 1.2
 * @since December 20, 2021
 * @updated December 23, 2021
 */


public class MedicalCenter {

    enum choice {
        a, A, b, B, x, X, y, Y, z, Z, q, Q, p, P, d, D, t, T
    }
    
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<Patient>();
        List<Doctor> doctors = new ArrayList<Doctor>();
        List<Treatment> treatments = new ArrayList<Treatment>();
        String patientName, patientAddress, patientBirthDate, patientPhone, insuranceCompany;
        int patientID;
        String doctorName, doctorAddress, doctorBirthDate, doctorPhone, employmentDate, specialty;
        String treatmentName, treatmentDate, treatmentPatient, treatmentDoctor;
        choice thisChoice = null, aChoice = null, bChoice = null;

        Scanner input = new Scanner(System.in);

        try {
            Patient patient1 = new Patient("Alice N. Wonderland", 1, "London, Ontario", "02/14/2014", "514-014-1414", "Queen of Hearts Insurance Co.");
            Doctor doctor1 = new Doctor("Math D. Hatter", "London,UK", "05/15/1989", "514-876-0987", "11/02/2014", "Psychiatry");
            Treatment treatment1 = new Treatment("Psychotherapy", "12/01/2021", patient1.getName(), doctor1.getName());
            Patient patient2 = new Patient("Bob D. Builder", 2, "Montreal, Quebec", "06/24/1980", "514-444-5555", "ACME Insurance LLC");
            Doctor doctor2 = new Doctor("Frank E. Stein", "Montreal, Quebec", "10/08/1975", "514-098-7654", "05/14/2014", "Surgery");
            Treatment treatment2 = new Treatment("Appendectomy", "12/12/2021", patient2.getName(), doctor2.getName());
            Doctor doctor3 = new Doctor("Vlad Dracul III", "Montreal, Quebec", "11/14/1980", "514-524-0956", "08/17/2016", "Internal Medicine");
            Treatment treatment3 = new Treatment("Blood Transfusion", "12/12/2021", patient2.getName(), doctor3.getName());

            patients.add(patient1);
            patients.add(patient2);
            doctors.add(doctor1);
            doctors.add(doctor2);
            doctors.add(doctor3);
            treatments.add(treatment1);
            treatments.add(treatment2);
            treatments.add(treatment3);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            System.out.println(e1);
            e1.printStackTrace();
        }
        

        System.out.println("Health is Wealth Medical Center");
        do {
            boolean valid = true;
            int count = 0;
            do {
                try {
                    System.out.println();
                    System.out.println("Enter A to manage or B to input new treatment or Q to quit.");
                    thisChoice = choice.valueOf(input.nextLine());
                    valid = true;
                } catch(Exception e) {
                    if(count == 0) System.out.println("Error: wrong input.");
                    else if(count == 1) System.out.println("This is your last chance.");
                    else return;

                    valid = false;
                }
                count++;
            } while (!valid);
            
            switch(thisChoice) {
                case a, A: 
                boolean aValid = true;
                int aCount = 0;
                do {
                try {
                    System.out.println("Enter X to add a new patient, Y to add a new doctor, Q to quit.");
                    System.out.println("To display, enter P to display all patients, D to display all doctors, T to display all treatments done.");
                    aChoice = choice.valueOf(input.nextLine());
                    System.out.println();
                    aValid = true;
                    aCount = 2;
                } catch (Exception e) {
                    System.out.println("Error!");
                    aValid = false;
                }
                aCount++;
                } while(aCount < 2); // do try while aCount is less than 2.

                    if(aValid) {
                        switch(aChoice) {
                            case x, X:
                                System.out.print("Enter patient's name: ");
                                patientName = input.nextLine();
                                System.out.print("Enter patient's ID: ");
                                patientID = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter patient's address: ");
                                patientAddress = input.nextLine();
                                System.out.print("Enter patient's birthdate (mm/dd/yyyy): ");
                                patientBirthDate = input.nextLine();
                                System.out.print("Enter patient's contact number: ");
                                patientPhone = input.nextLine();
                                System.out.print("Enter patient's insurance company: ");
                                insuranceCompany = input.nextLine();
                                try {
                                    patients.add(new Patient(patientName, patientID, patientAddress, patientBirthDate, patientPhone, insuranceCompany));
                                } catch (ParseException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                            break;
                            case y, Y:
                                System.out.print("Enter doctor's name: ");
                                doctorName = input.nextLine();
                                System.out.print("Enter doctor's address: ");
                                doctorAddress = input.nextLine();
                                System.out.print("Enter doctor's birthdate (mm/dd/yyyy): ");
                                doctorBirthDate = input.nextLine();
                                System.out.print("Enter doctor's contact number: ");
                                doctorPhone = input.nextLine();
                                System.out.print("Enter doctor's employment date (mm/dd/yyyy): ");
                                employmentDate = input.nextLine();
                                System.out.print("Enter doctor's specialty: ");
                                specialty = input.nextLine();
                                try {
                                    doctors.add(new Doctor(doctorName, doctorAddress, doctorBirthDate, doctorPhone, employmentDate, specialty));
                                } catch (ParseException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            break;
                            case q, Q:
                            return;

                            case p, P:
                                for(int i = 0; i < patients.size(); i++) {
                                    Patient current = patients.get(i);
                                    System.out.println(current);
                                }
                                break;

                            case d, D:
                                for(int i = 0; i < doctors.size(); i++) {
                                    Doctor current = doctors.get(i);
                                    System.out.println(current);
                                }
                                break;
                            
                            case t, T:
                                for(int i = 0; i < treatments.size(); i++) {
                                    Treatment current = treatments.get(i);
                                    System.out.println(current);
                                }
                                break;   
                        } // End switch aChoice!
                    } // End if aValid!
                    break;

                case b, B: 
                boolean bValid = true;
                int bCount = 0;
                do {
                    try {
                        System.out.println("Enter Z to add new treatment record or T to display all treatment record.");
                        bChoice = choice.valueOf(input.nextLine());
                        System.out.println();
                        bValid = true;
                        bCount = 2;
                    } catch (Exception e) {
                        System.out.println("Error!");
                        bValid = false;
                    }
                    bCount++;
                } while(bCount < 2);

                    if(bValid) {
                        switch(bChoice) {
                            case z, Z:
                                System.out.print("Enter treatment name: ");
                                treatmentName = input.nextLine();
                                System.out.print("Enter treatment date (mm/dd/yyyy): ");
                                treatmentDate = input.nextLine();
                                System.out.print("Enter treatment patient name: ");
                                treatmentPatient = input.nextLine();
                                System.out.print("Enter treatment doctor name: ");
                                treatmentDoctor = input.nextLine();
                                try {
                                    treatments.add(new Treatment(treatmentName, treatmentDate, treatmentPatient, treatmentDoctor));
                                } catch (ParseException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                                break;

                            case t, T:
                                for(int i = 0; i < treatments.size(); i++) {
                                    Treatment current = treatments.get(i);
                                    System.out.println(current);
                                }
                                break;
                    
                        } // End switch bChoice!
                    } // End of if(bValid)!
                    break;
                case q, Q:
                    return;
            } // End switch thisChoice!
        } // End do-while loop!
        while(true);
    } // End method main!
} // End class!