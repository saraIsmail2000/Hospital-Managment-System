package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.Doctor;
import sample.Model.Patient;
import sample.Model.User;

import java.io.IOException;
import java.util.ArrayList;

public class ViewIndoor {

    public TableColumn Name;
    public TableColumn Gender;
    public TableColumn Phone;
    public TableColumn Ward;
    public TableColumn Room;
    public TableColumn Admit;

    public TableView patientsTable;



    DBconnect db = DBconnect.getInstance();

    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Patients.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }
    
    public void searchPatient(){
        String phone ="";
        // phoneNumber.getText().toString();
        if(phone.equals("")){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Search Failed");
            dialog.setContentText("Enter phone number first !");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
            return;
        }
        ////////////////////continue

    }

    public  void  initialize(){
        ArrayList<Patient> patients =  db.getIndoorPatients();

        Name.setCellValueFactory(new PropertyValueFactory<Patient, String>("fullName"));
        Gender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        Admit.setCellValueFactory(new PropertyValueFactory<Patient, String>("AdmitDate"));
        Phone.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        Ward.setCellValueFactory(new PropertyValueFactory<Patient,String>("ward"));
        Room.setCellValueFactory(new PropertyValueFactory<Patient,String>("room"));
        for(int i = 0 ; i < patients.size();i++){
            patientsTable.getItems().add(patients.get(i));
        }
        patientsTable.setEditable(false);


    }


}
