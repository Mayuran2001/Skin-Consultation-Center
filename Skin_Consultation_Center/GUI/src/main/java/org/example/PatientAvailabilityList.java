package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class PatientAvailabilityList  {
    private final ArrayList<Patient> patientAvailabilityArraylist = new ArrayList<>();
    private static PatientAvailabilityList patientAvailabilityList;

    //Singleton method
    PatientAvailabilityList() {}

    public static PatientAvailabilityList getInstance() {
        if (Objects.isNull(patientAvailabilityList)) {
            patientAvailabilityList = new PatientAvailabilityList();
        }
        return patientAvailabilityList;
    }

    public ArrayList<Patient> getPatientAvailabilityArraylist() {
        return this.patientAvailabilityArraylist;
    }

    public void addPatient(Patient patient) {
        this.patientAvailabilityArraylist.add(patient);}

    public Patient getAvailabilityPatient(int index) {
        return this.patientAvailabilityArraylist.get(index);
    }

    public int generateRandomNumber(int size) {
        Random random = new Random();
        return random.nextInt(0, size);
    }

    public boolean isConsultationExists(Doctor doctor, LocalDate startDate, LocalTime startTime, long duration) {
        if (patientAvailabilityArraylist.size() > 0) {
            for (Patient patient : patientAvailabilityArraylist) {
                if (Objects.equals(doctor.getMedicalLicenceNumber(), patient.getDoctorId()) &&
                        startDate.equals(patient.getDate())) {
                    LocalTime endTime = startTime.plusMinutes(duration);
                    LocalTime consultationEndTime = patient.getStartTime().plusMinutes(patient.getDuration());
                    if ((patient.getStartTime().equals(startTime) || consultationEndTime.equals(endTime)) ||
                            consultationEndTime.isBefore(startTime) && patient.getStartTime().isAfter(endTime)){
                        return true;
                    }
                }
            }
        } return false;
    }

    public Doctor getDoctorByIndex(int i) {

        Set<Integer> keys = DoctorList.getInstance().getDoctorHashMap().keySet();

        int sCount = 0;
        for (Integer key : keys) {
            if (Objects.equals(sCount, i)) {return DoctorList.getInstance().getDoctorHashMap().get(key);
            } else {sCount++;}
        } return null;
    }
}