package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.Doctor;
import sample.Model.Patient;

import java.io.IOException;


public class PatientsForRecController {
    @FXML
    public TableView patientTable;
    @FXML
    public TextField phoneNb;
    @FXML
    public ToggleGroup gender;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastname;
    @FXML
    public TextField patientkey;
    @FXML
    public DatePicker birthday;
    @FXML
    public DatePicker AdmitDay;
    @FXML
    public Button Add;
    @FXML
    public Button Enter;
    @FXML
    public Button search;
    @FXML
    public Button operation;
    @FXML
    public Button Addoperation;
    @FXML
    public Button Discharge;
    @FXML
    public TextField Ward;
    @FXML
    public TextField roomnb;



    public void addpatient(ActionEvent event)  throws NullPointerException{
        try {

            String fName = firstName.getText().toString();
            String Lname = lastname.getText().toString();
            String phone = phoneNb.getText().toString();
            String bd = birthday.getValue().toString();
            String admit = AdmitDay.getValue().toString();
            String key = patientkey.getText().toString();
            String ward = Ward.getText().toString();

            if (fName.equals("") || Lname.equals("") || ((RadioButton) gender.getSelectedToggle()).getText().toString().equals("")
                    || phone.equals("") || bd.equals("") || admit.equals("") ||
                    key.equals("") || ward.equals("")) {

                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Addition Failed");
                dialog.setContentText("You have to fill the fields!!");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();
            } else {

                //Patient p = new Patient(fName, Lname, phone, ((RadioButton) gender.getSelectedToggle()).getText().toString(), admit, bd);
                DBconnect db = DBconnect.getInstance();

            }
        }
        catch (NullPointerException e){
        }
    }


    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/ReceptionistPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void search(ActionEvent event) {

    }

    public void add(ActionEvent event) {
    }

    public void enter(ActionEvent event) {
    }

    public void addoperation(ActionEvent event) {
    }

    public void operation(ActionEvent event) {
    }

    public void Discharge(ActionEvent event) {
    }
}
