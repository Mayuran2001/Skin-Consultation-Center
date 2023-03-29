package org.example;
public class Doctor extends Person {
    private int medicalLicenceNumber;
    private String specialisation;

    //Constructor
    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, int medicalLicenceNumber1, String specialisation1){
        super(name, surname, dateOfBirth, mobileNumber);
        setMedicalLicenceNumber(medicalLicenceNumber1);
        setSpecialisation(specialisation1);
    }

    public Doctor(String name1, int medicalLicenceNumber1, String specialisation1) {
        super(name1);
        setMedicalLicenceNumber(medicalLicenceNumber1);
        setSpecialisation(specialisation1);

    }

    public void setMedicalLicenceNumber(int medicalLicenceNumber1){
        this.medicalLicenceNumber = medicalLicenceNumber1;
    }

    public void setSpecialisation(String specialisation1){
        this.specialisation = specialisation1;
    }

    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s\s
                Surname: %s\s
                Date Of Birth: %s\s
                Mobile Number: %s\s
                Specialization: %s\s
                License number: %d""",
                this.name, this.surname, this.dateOfBirth,
                this.mobileNumber,this.specialisation,this.medicalLicenceNumber);
    }
}
