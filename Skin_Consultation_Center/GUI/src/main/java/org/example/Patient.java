package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Patient extends Person{
    private String patientNIC;
    private LocalDate date;
    private LocalTime startTime;
    private long duration;

    private String doctorName;
    private String specialisation;

    private int doctorLicenseNumber;
    private  int cost ;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Patient(String name1, String surname1, String dateOfBirth1, String mobileNumber1,
                   String patientNIC1, String doctorName1, int medicalLicense1, String specialisation1, LocalDate date1,
                   LocalTime startTime1, long duration1, int cost1){
        super(name1, surname1, dateOfBirth1, mobileNumber1);
        setPatientId(patientNIC1);
        setDoctorId(medicalLicense1);
        setSpecialisation(specialisation1);
        setDoctorName(doctorName1);
        setDate(date1);
        setStartTime(startTime1);
        setDuration(duration1);
        setCost(cost1);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }



    public LocalTime getStartTime() {
        return startTime;
    }

    public long getDuration() {
        return duration;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public String getPatientId() {
        return this.patientNIC;
    }

    public int getDoctorId() {
        return doctorLicenseNumber;
    }

    public void setDoctorId(int doctorId) {
        this.doctorLicenseNumber = doctorId;
    }

    public void setPatientId(String patientNIC1) {
        this.patientNIC = patientNIC1;

    }

}
