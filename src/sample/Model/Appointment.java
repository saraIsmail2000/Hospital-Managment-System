package sample.Model;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private  String description;
    private  int AppId, DocId , PatientId;
    private String PatientName,DoctorName;
    private String PatientPhone;
    private String AppDate ;
    private String AppTime;

    public Appointment(String patientName, String patientPhone, String appDate, String appTime) {
        PatientName = patientName;
        PatientPhone = patientPhone;
        AppDate = appDate;
        AppTime = appTime;
    }

    public Appointment(String patientName, String doctorName, String patientPhone, String appDate, String appTime) {
        PatientName = patientName;
        DoctorName = doctorName;
        PatientPhone = patientPhone;
        AppDate = appDate;
        AppTime = appTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAppId() {
        return AppId;
    }

    public void setAppId(int appId) {
        AppId = appId;
    }

    public int getDocId() {
        return DocId;
    }

    public void setDocId(int docId) {
        DocId = docId;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getAppDate() {
        return AppDate;
    }

    public void setAppDate(String appDate) {
        AppDate = appDate;
    }

    public String getAppTime() {
        return AppTime;
    }

    public void setAppTime(String appTime) {
        AppTime = appTime;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getPatientPhone() {
        return PatientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        PatientPhone = patientPhone;
    }


}
