package sample.Model;

public class PatientOperation {

    private String patientName , DoctorName , OperationName , Date;

    public PatientOperation(String patientName, String doctorName, String operationName, String date) {
        this.patientName = patientName;
        DoctorName = doctorName;
        OperationName = operationName;
        Date = date;

    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getOperationName() {
        return OperationName;
    }

    public void setOperationName(String operationName) {
        OperationName = operationName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

     public  void AddToDB(){
        /////////////
     }
}
