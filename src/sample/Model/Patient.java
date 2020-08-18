package sample.Model;

public class Patient {

    public String fullName;
    public String phoneNumber;
    public String gender;
    public String ward;
    public String AdmitDate,releaseDate,birthday;
    public int PatientId;
    public int room;

    public Patient(String fullName, String phoneNumber, String gender, String admitDate, String birthday) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        AdmitDate = admitDate;
        this.birthday = birthday;
    }

    public Patient(String fullName, String phoneNumber, String gender,String admitDate, String ward,  int room) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.ward = ward;
        AdmitDate = admitDate;
        this.room = room;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setAdmitDate(String admitDate) {
        AdmitDate = admitDate;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getWard() {
        return ward;
    }

    public String getAdmitDate() {
        return AdmitDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPatientId() {
        return PatientId;
    }

    public int getRoom() {
        return room;
    }
}
