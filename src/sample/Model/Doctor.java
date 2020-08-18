package sample.Model;

import java.util.Date;

public class Doctor {
    private int DocId;
    private String Name;
    private String phoneNumber;
    private String gender;
    private String address;
    private String specification;
    private String birthday,startDate;
    private  String salary;
    private String username,password,key;
    private  String appCharge ;

    public Doctor(){

    }

    public Doctor(String name, String phoneNumber, String gender, String address, String specification, String birthday, String startDate, String salary, String username, String password, String appCharge) {
        Name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.specification = specification;
        this.birthday = birthday;
        this.startDate = startDate;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.appCharge = appCharge;
    }

    public Doctor(String name, String phoneNumber, String gender, String address, String specification, String birthday,
                  String startDate, String salary, String username, String password, String key, String charge) {
        Name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.specification = specification;
        this.birthday = birthday;
        this.startDate = startDate;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.key =key;
        this.appCharge = charge;
    }

    public Doctor(String name, String phoneNumber, String gender, String address, String specification, String birthday, String startDate, String key) {
        Name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.specification = specification;
        this.birthday = birthday;
        this.startDate = startDate;
        this.key = key;
    }

    public String getAppCharge() {
        return appCharge;
    }

    public void setAppCharge(String appCharge) {
        this.appCharge = appCharge;
    }

    public int getDocId() {
        return DocId;
    }

    public void setDocId(int docId) {
        DocId = docId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public int getDid() {
        return DocId;
    }

    public void setDid(int did) {
        DocId = did;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
