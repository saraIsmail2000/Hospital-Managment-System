package sample.Model;
import javafx.scene.control.Alert;
import javax.management.openmbean.ArrayType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import static java.sql.Types.NULL;

public class DBconnect {

    private String host = "jdbc:mysql://localhost:3306/mydb";
    private String uname = "root";
    private String upass = "1234";

    public static Connection con = null;
    private static DBconnect instance  ;

    private DBconnect(){
        try {
            con = DriverManager.getConnection(host, uname, upass);
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static DBconnect getInstance() {
        if(instance == null){
            instance= new DBconnect();
        }
        return instance;
    }


    //half done
    public Doctor checkDoc(String username , String password) throws SQLException {
        Statement stat = con.createStatement();
        String sql = "select * from Doctor where username = '" + username +"' and password = '" + password + "'" ;
        ResultSet r = stat.executeQuery(sql);
        Doctor doc = null;
        if(r.next()){
            doc = new Doctor(r.getString("nameDoctor"),r.getString("phoneNumber"),r.getString("gender"),
                    r.getString("address"),r.getString("specification"),r.getString("DOB"),r.getString("Admitdate"),
                    r.getString("salary"),r.getString("username"),r.getString("password"),
                    r.getString("charges"));
            User.id = Integer.parseInt(r.getString("idDoctor"));
            User.name = doc.getName();
            User.username = doc.getUsername();
            User.password = doc.getPassword();
            User.address = doc.getAddress();
            User.phonenumber= doc.getPhoneNumber();
            User.specification = doc.getSpecification();
            User.joiningdate = doc.getStartDate();
            User.Appcharges = doc.getAppCharge();
        }
        return doc;
    }

    //done
    public Admin checkAdmin(String username , String password) throws SQLException {
        Statement stat = con.createStatement();
        String sql = "select * from Admin where userName = '" + username +"' and pass = '" + password + "'" ;
        ResultSet r = stat.executeQuery(sql);
        Admin admin = null;
        if(r.next()){
            admin = new Admin(r.getString("userName"),r.getString("pass"));
            User.name = admin.getUsername();
            User.password = admin.getPassword();
            User.role=1;
        }
        return admin;
    }

    //not tried yet
    public Receptionist checkRec(String username , String password) throws SQLException {
        Statement stat = con.createStatement();
        String sql = "select * from Receptionist where userName = '" + username +"' and pass = '" + password + "'" ;
        ResultSet r = stat.executeQuery(sql);
        Receptionist rec = null;
        if(r.next()){
            rec = new Receptionist(r.getString("nameReceptionist"),r.getString("gender"),r.getString("phoneNumber"),
                    r.getString("userName"),r.getString("pass"),r.getString("address"),
                    r.getString("DOB"),r.getString("JoiningDate"));
            User.role = 2;
            User.name = rec.getFullName();
            User.username = rec.getUsername();
            User.password = rec.getPassword();
            User.address = rec.getAddress();
            User.phonenumber = rec.getPhoneNumber();
            User.joiningdate = rec.getJoiningDate();
            User.id = Integer.parseInt(r.getString("idReceptionist"));
        }
        return rec;
    }

    //done
    public ArrayList<Nurse> getNurses(){
        ArrayList<Nurse> nurses = null;
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select nameNurse,gender,JoiningDate,nameWard,floorNb from nurse,Ward where Nurse.Ward_idWard = Ward.idWard and Nurse.LeavingDate is NULL " ;
            ResultSet r = stat.executeQuery(sql);
            nurses = new ArrayList<Nurse>();
            int i = 0;
            while(r.next()){
                i++;
                nurses.add(new Nurse(r.getString("nameNurse"),r.getString("nameWard"),r.getString("gender"),r.getString("JoiningDate"),r.getString("floorNb")));
            }
            if(i==0) return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  nurses;
    }


    //done
    public  ArrayList<String> getWardNames(){
        ArrayList<String> ward = new ArrayList<>();
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select nameWard from ward ";
            ResultSet r = stat.executeQuery(sql);
            while (r.next()){
                ward.add(r.getString("nameWard"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ward;
    }


    //done
    public int getWardId(String wardName){
        try {
            Statement stat = con.createStatement();
            String sql =  "select idWard from ward where nameWard = '" + wardName + "'";
            ResultSet r = stat.executeQuery(sql);
            r.next();
            return Integer.parseInt(r.getString("idWard"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //done
    public String getWardName(int wardId){
        try {
            Statement stat = con.createStatement();
            String sql =  "select nameWard from ward where idWard = '" + wardId + "'";
            ResultSet r = stat.executeQuery(sql);
            r.next();
            return r.getString("nameWard");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    //done
    public void insertNurse(Nurse nurse){
        Statement stat = null;
        try {
            stat = con.createStatement();
            int wid  = getWardId(nurse.getWardName());
            String sql = "insert  into nurse (nameNurse,gender,Ward_idWard,JoiningDate) values ( '" + nurse.getFullName() + "','"
                    + nurse.getGender() + " ','" + wid + "','" + nurse.getStartDate()+ "')" ;
            int r = stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //done
    public void insertReceptionist(Receptionist p){
        try {
            Statement stat = con.createStatement();
            String sql = " insert  into Receptionist (nameReceptionist,gender,phoneNumber,address,userName,pass,JoiningDate,DOB) values  (' " +
                    p.getFullName()+ "','" + p.getGender() + "','" + p.getPhoneNumber() +"','" + p.getAddress() + "','" +
                    p.getUsername() + "','" + p.getPassword() + "','" + p.getJoiningDate() + "','" + p.getBirthday() + "')";
            int r = stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //done
    public ArrayList<Receptionist> getReceptionists(){
        ArrayList<Receptionist> receptionists = new ArrayList<Receptionist>() ;
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select nameReceptionist,gender,JoiningDate,DOB,address,phoneNumber,userName,pass from receptionist where receptionist.leavingDate is NULL " ;
            ResultSet r = stat.executeQuery(sql);
            while(r.next()){
                receptionists.add(new Receptionist(r.getString("nameReceptionist"),r.getString("gender"),r.getString("phoneNumber"),
                        r.getString("userName"),r.getString("pass"),r.getString("address"),r.getString("DOB"),r.getString("JoiningDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  receptionists;
    }

    //done
    public ArrayList<Doctor> getDoctors(){
        ArrayList<Doctor> doctors = new ArrayList<Doctor>() ;
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select * from doctor where doctor.LeaveDate is NULL " ;
            ResultSet r = stat.executeQuery(sql);
            while(r.next()){
                doctors.add(new Doctor(r.getString("nameDoctor"),r.getString("phoneNumber"),r.getString("gender"),
                        r.getString("address"), r.getString("specification"),r.getString("DOB"),r.getString("AdmitDate"),r.getString("DoctorKey")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  doctors;
    }

    //done
    public void insertDoctor(Doctor d){
        try {
            Statement stat = con.createStatement();
            String sql = " insert  into Doctor (nameDoctor,gender,phoneNumber,address,username,password,AdmitDate,DOB,specification,salary,charges) values  (' " +
                    d.getName()+ "','" + d.getGender() + "','" + d.getPhoneNumber() +"','" + d.getAddress() + "','" +
                    d.getUsername() + "','" + d.getPassword() + "','" + d.getStartDate() + "','" + d.getBirthday() + "','" + d.getSpecification()
                    + "'," + Integer.parseInt(d.getSalary()) + "," + Integer.parseInt(d.getAppCharge())+ ")";
            int r = stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //done
    public ArrayList<Patient> getIndoorPatients(){
        ArrayList<Patient> patients = new ArrayList<Patient>() ;
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select patient.FullName,patient.phoneNumber,room.Ward_idWard,patient.gender,room.idRoom,room.admitDate from patient ,Entrance,room  where patient.idPatient = Entrance.Patient_idPatient and Entrance.Room_id is not null and Entrance.flag is true and room.releaseDate is null ";
            ResultSet r = stat.executeQuery(sql);
            while(r.next()){
                patients.add(new Patient(r.getString("FullName"),r.getString("phoneNumber"),r.getString("gender"),r.getString("admitDate"),getWardName(r.getInt("Ward_idWard")),r.getInt("idRoom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  patients;
    }

    //done
    public void updateAdminInfo(String username,String password){
        try {
            Statement stat = con.createStatement();
            String sql = "update Admin set userName='" + username +"' , pass ='" + password + "' where userName ='" + User.username + "' and pass = '" + User.password + "'";
            int r = stat.executeUpdate(sql);
            User.username= username;
            User.password= password;
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    //done
    public int updateDoctorInfo(Doctor d){
        int r=0;
        try {
            Statement stat = con.createStatement();
            String sql = "update Doctor set username='" + d.getUsername() +"' , password ='" + d.getPassword() + "',nameDoctor='" +d.getName()+ "',phoneNumber='" +d.getPhoneNumber() +"',address='" +d.getAddress() +"',charges=" + d.getAppCharge()+ ",AdmitDate='" + d.getStartDate()  + "' where idDoctor = "+ User.id ;
             r = stat.executeUpdate(sql);
            if(r>0){
                User.username= d.getUsername();
                User.password= d.getPassword();
                User.name = d.getName();
                User.Appcharges = d.getAppCharge();
                User.joiningdate = d.getStartDate();
                User.address = d.getAddress();
                User.phonenumber = d.getPhoneNumber();
            }
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return r;
    }

    /////hajar
    public int updateRecInfo(Receptionist recep) throws SQLException {
        int r=0;
        try {
            Statement stat = con.createStatement();
            String sql = "update receptionist set phoneNumber='" + recep.getPhoneNumber() + "',nameReceptionist='" + recep.getFullName() + "', userName='" + recep.getUsername() + "',pass='" + recep.getPassword() + "', JoiningDate='" + recep.getJoiningDate() + "', address='" + recep.getAddress() + "' where idReceptionist= " + User.id;
            r = stat.executeUpdate(sql);
            if(r>0){
                User.username= recep.getUsername();
                User.password= recep.getPassword();
                User.name = recep.getFullName();
                User.joiningdate = recep.getJoiningDate();
                User.address = recep.getAddress();
                User.phonenumber = recep.getPhoneNumber();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    //done
    public ArrayList<Appointment> getMyappointment() throws SQLException{
        int i= User.id;
        ArrayList<Appointment> myapps =new ArrayList<Appointment>();
        Statement stat=null;
        try{
            stat=con.createStatement();
            String sql="select distinct P.FullName ,P.phoneNumber, A.date, A.time from patient as P,appointment as A,entrance as E,Doctor as D where A.Entrance_idEntrance=E.idEntrance  and E.Patient_idPatient=P.idPatient and A.Doctor_idDoctor= "+ i ;
            ResultSet r=stat.executeQuery(sql);
            while(r.next()){
                myapps.add(new Appointment(r.getString("FullName"), r.getString("phoneNumber"),r.getString("date"), r.getString("time")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return myapps;
    }

    //yet
    public ArrayList<Integer> getAvailableRooms(int ward) throws SQLException {
        ArrayList<Integer> rooms = new ArrayList<Integer>();
        Statement stat = con.createStatement();
        String sql = "select idRoom from room where Ward_idWard=" + ward + " and quantity < capacity ";
        ResultSet r = stat.executeQuery(sql);
        while(r.next()){
            rooms.add(Integer.parseInt(r.getString("idRoom")));
        }
        return rooms;
    }

    //done
    public ArrayList<Appointment> getAppointments() throws SQLException {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        Statement stat = null;
        try {
            stat = con.createStatement();
            String sql = "select p.FullName,p.phoneNumber,D.nameDoctor,A.date,A.time from appointment as A , Entrance as E,Patient as p,doctor as D where A.Entrance_idEntrance=E.idEntrance and A.Doctor_idDoctor=D.idDoctor and  E.Patient_idPatient=P.idPatient";
            ResultSet r = stat.executeQuery(sql);
            while (r.next()) {
                appointments.add(new Appointment(r.getString("FullName"), r.getString("nameDoctor"), r.getString("phoneNumber"), r.getString("date"),r.getString("time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }



    public static void main(String[] args) throws SQLException {
        try {
            getInstance();
            String username = "cancer", password = "133";
            Statement stat = con.createStatement();
            String sql = "select * from room ";
            ResultSet r = stat.executeQuery(sql);
            if(r.next()) System.out.print("fee");
            else System.out.print("ma fee");
            if(r.getString("idRoom").equals(NULL)){
                System.out.print("done");
            }
            else  System.out.print("not null");
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }

    }





}
