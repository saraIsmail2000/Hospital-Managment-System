package sample.Model;

import java.util.Date;

public class Receptionist {
    private String FullName,RecKey;
    private String gender;
    private String phoneNumber;
    private String username;
    private String password;
    private String address;
    private int RecId;
    private String Birthday, JoiningDate , LeavingDate;

    public Receptionist(){

    }

    public Receptionist(String fullName, String gender, String phoneNumber, String username, String password, String address, String birthday, String joiningDate) {
        FullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.address = address;
        Birthday = birthday;
        JoiningDate = joiningDate;
    }


    public int getRecId() {
        return RecId;
    }

    public void setRecId(int recId) {
        RecId = recId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        JoiningDate = joiningDate;
    }

    public String getLeavingDate() {
        return LeavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        LeavingDate = leavingDate;
    }

    public void AddToDB(){
        System.out.print(this.FullName + " " + this.gender + " " + this.phoneNumber + " " + this.address + " "
        + this.Birthday + " " + this.JoiningDate);

    }


}
