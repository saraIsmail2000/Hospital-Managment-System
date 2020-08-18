package sample.Model;

public class Nurse {

    private  String fullName , WardName , gender ,startDate,floor;
    private  int NurseId;

    public Nurse(String fullName, String wardName, String gender,String startDate,String floor) {
        this.fullName = fullName;
        WardName = wardName;
        this.gender = gender;
        this.startDate = startDate;
        this.floor= floor;

    }

    public Nurse(String fullName, String wardName, String gender, String startDate) {
        this.fullName = fullName;
        WardName = wardName;
        this.gender = gender;
        this.startDate = startDate;
    }

    public int getNurseId() {
        return NurseId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setNurseId(int nurseId) {
        NurseId = nurseId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWardName() {
        return WardName;
    }

    public void setWardName(String wardName) {
        WardName = wardName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
