package org.example;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends Doctor{
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private long duration;
    static int cost;

    //Constructor

    public Consultation(String name1, String specialisation1, int licenseNumber1, LocalDate date1, LocalTime startTime1,long duration1){
        super(name1,licenseNumber1,specialisation1);
        this.date = date1;
        this.startTime = startTime1;
        this.duration = duration1;
    }

    public static long getCost(LocalTime startTime,long duration,String patientID){
        long differenceBetweenTime = startTime.getMinute()+ duration/60 ;
        for (int i = 0; i < PatientAvailabilityList.getInstance().getPatientAvailabilityArraylist().size();) {
            Patient patient = PatientAvailabilityList.getInstance().getAvailabilityPatient(i);
            if(patient.getPatientId().equals(patientID)){
                cost = (int) (differenceBetweenTime*25);
            }

            return cost;
        }
        cost = (int) (differenceBetweenTime *15);
       return cost;

    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "cost=" + cost +
                '}';
    }
}
