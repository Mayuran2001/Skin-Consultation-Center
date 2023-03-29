package org.example;
import java.util.LinkedHashMap;
import java.util.Objects;

public class DoctorList {
    private final LinkedHashMap<Integer, Doctor> doctorHashMap = new LinkedHashMap<>();
    private static DoctorList doctorList;

    private DoctorList(){}
    //Singleton method
    public static DoctorList getInstance() {
        if (Objects.isNull(doctorList)) {
            doctorList = new DoctorList();
        } return doctorList;
    }

    public LinkedHashMap<Integer, Doctor> getDoctorHashMap() {
        return this.doctorHashMap;
    }
    //Add doctor method
    public void addDoctor(Integer license, Doctor doctor) {
        if (doctorHashMap.size() != 10) {
            this.doctorHashMap.put(license, doctor);
            System.out.println("Doctor add successfully. ");
        }else{
            System.out.println("Can't add doctors. ");
        }
    }
    //Get doctor details method
    public Doctor getDoctor(int index) {
        return this.doctorHashMap.get(index);
    }
    //Remove doctor method
    public void removeDoctor(int license) {
        Doctor doctor = this.doctorHashMap.get(license);
        this.doctorHashMap.remove(license, doctor);
    }
}
