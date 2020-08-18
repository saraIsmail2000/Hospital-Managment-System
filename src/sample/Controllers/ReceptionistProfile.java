package sample.Controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.Model.DBconnect;
import sample.Model.Receptionist;
import sample.Model.User;

import java.sql.SQLException;
import java.time.LocalDate;

public class ReceptionistProfile {

    public TextField fullname;

    public TextField phoneNum;
    public TextField address;

    public TextField username;
    public TextField password;

    public DatePicker startDate;

    public Button update;



    DBconnect db = DBconnect.getInstance();

    public void update() throws SQLException {
        if(username.getText().equals("") || password.getText().equals("") ){
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setHeaderText("We Don't do it like that.");
            dialog.setContentText("You should fill username and password.");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
            return;
        }
        Receptionist recep = new Receptionist();
        recep.setFullName(fullname.getText());
        recep.setPhoneNumber(phoneNum.getText());
        recep.setAddress(address.getText());
        recep.setUsername(username.getText());
        recep.setPassword(password.getText());
        recep.setJoiningDate(startDate.getValue().toString());
        int r = db.updateRecInfo(recep);
        if(r>0){
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setHeaderText("Done");
            dialog.setContentText("Your login info are updated successfully. ");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
        }
    }

    //
    public void initialize(){
        fullname.setText(User.name);
        username.setText(User.username);
        password.setText(User.password);
        address.setText(User.address);
        phoneNum.setText(User.phonenumber);
        startDate.setValue(LocalDate.parse(User.joiningdate));
    }

}
