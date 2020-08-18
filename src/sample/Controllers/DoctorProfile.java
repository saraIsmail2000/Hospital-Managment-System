package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.Doctor;
import sample.Model.User;

import java.io.IOException;
import java.time.LocalDate;

public class DoctorProfile {


    public TextField fullname;
    public TextField phoneNum;
    public TextField address;
    public TextField password;
    public Button update;
    public Button back;
    public TextField username;
    public TextField charges;
    public DatePicker startDate;

    DBconnect db = DBconnect.getInstance();

    public void goBack(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/DoctorPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void updateMyProfile(ActionEvent event) {
            //////////////
            if(username.getText().equals("") || password.getText().equals("") ){
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setHeaderText("We Don't do it like that.");
                dialog.setContentText("You should fill username and password.");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();
                return;
            }
            Doctor d = new Doctor();
            d.setName(fullname.getText());
            d.setAddress(address.getText());
            d.setUsername(username.getText());
            d.setPassword(password.getText());
            d.setStartDate(startDate.getValue().toString());
            d.setAppCharge(charges.getText());
            d.setPhoneNumber(phoneNum.getText());
           int r=  db.updateDoctorInfo(d);
           if(r>0){
               Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
               dialog.setHeaderText("Done");
               dialog.setContentText("Your login info are updated successfully. ");
               dialog.setResizable(true);
               dialog.getDialogPane().setPrefSize(300, 100);
               dialog.showAndWait();
           }

        }


    public void initialize(){
        fullname.setText(User.name);
        username.setText(User.username);
        password.setText(User.password);
        address.setText(User.address);
        phoneNum.setText(User.phonenumber);
        startDate.setValue(LocalDate.parse(User.joiningdate));
        charges.setText(User.Appcharges);
    }
}
