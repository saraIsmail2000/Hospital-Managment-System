package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.Model.DBconnect;
import sample.Model.Doctor;
import sample.Model.User;

import javax.jws.soap.SOAPBinding;
import javax.print.Doc;
import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DoctorController  {


    @FXML
    public PasswordField DocPass;
    @FXML
    public TextField DocUser;
    @FXML
    public Button back;
    @FXML
    public Button DoctorLogin;
    @FXML
    public TextField fullname;
    @FXML
    public TextField phoneNum;
    @FXML
    public TextField address;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public Button update;
    @FXML
    public TextField DocKey;
    @FXML
    public TextField startDate;
    @FXML
    public TextField charges;
    @FXML
    public Label name;
    public Button buttonMyyApp;
    public Button DbuttonProfile;
    public Button Dlogout;

    Doctor d=null;
    DBconnect db = DBconnect.getInstance();
    String u,p;




    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/FirstPage.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }


    public void updateMyProfile(ActionEvent event) throws IOException {
        //////////////

    }

    @FXML
    public void ViewDoctorsProfile(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/DoctorProfile.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }



    public void MyAppointments(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/MyAppointments.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void Logout(javafx.event.ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/FirstPage.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }
}
