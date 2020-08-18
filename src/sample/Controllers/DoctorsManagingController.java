package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.Doctor;
import sample.Model.Receptionist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class DoctorsManagingController {


    public TableView doctorsTable;
    public TextField phoneNb;
    public ToggleGroup gender;
    public TextField fullName;
    public TextField salary;
    public TextField specification;
    public DatePicker birthday;
    public DatePicker startDay;
    public Button addDoc;
    public TextField address;
    public TextField username;
    public PasswordField password;
    public TextField charges;
    public TableColumn Name;
    public TableColumn key;
    public TableColumn phone;
    public TableColumn Address;
    public TableColumn start;
    public TableColumn Spec;
    public TableColumn BD;
    public TableColumn Gender;


    DBconnect db = DBconnect.getInstance();



    public void addDoctor(ActionEvent event)  throws NullPointerException{
        try {

            String fullname= fullName.getText().toString();
            String spec =specification.getText().toString();
            String sal = salary.getText().toString();
            String phone =phoneNb.getText().toString();
            String bd = birthday.getValue().toString();
            String start = startDay.getValue().toString();
            String user = username.getText().toString();
            String pass =password.getText().toString();
            String add = address.getText().toString();


            if (fullname.equals("") || spec.equals("") || ((RadioButton) gender.getSelectedToggle()).getText().toString().equals("")
                    || sal.equals("") ||phone.equals("") || add.equals("") ||
                    bd.equals("") || start.equals("") ||
                    user.equals("") || pass.equals("")) {

                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Addition Failed");
                dialog.setContentText("You have to fill the fields!!");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();
            }
            else{
                if(phone.length() != 8 ){
                    Alert dialog = new Alert(Alert.AlertType.WARNING);
                    dialog.setHeaderText("Check Phone Number");
                    dialog.setContentText("The phone number must be 8 digits and with no spaces.");
                    dialog.setResizable(true);
                    dialog.getDialogPane().setPrefSize(300, 100);
                    dialog.showAndWait();
                    return;
                }

                Doctor doc = new Doctor(fullname,phone,((RadioButton) gender.getSelectedToggle()).getText().toString(),add,spec,bd,start,sal,user,pass,charges.getText().toString());
                //insert to database
                db.insertDoctor(doc);
                doctorsTable.getItems().clear();
                initialize();
                Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                dialog.setHeaderText("Good Work");
                dialog.setContentText("The new Doctor is added successfully.");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();
            }

        }
        catch (NullPointerException e){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Addition Failed");
            dialog.setContentText("You have to fill the fields!!");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();

        }

    }

    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }

    public void initialize(){
        ArrayList<Doctor> doctors =  db.getDoctors();

        Name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("Name"));
        Gender.setCellValueFactory(new PropertyValueFactory<Doctor, String>("gender"));
        start.setCellValueFactory(new PropertyValueFactory<Doctor, String>("startDate"));
        phone.setCellValueFactory(new PropertyValueFactory<Doctor,String>("phoneNumber"));
        Address.setCellValueFactory(new PropertyValueFactory<Doctor,String>("address"));
        BD.setCellValueFactory(new PropertyValueFactory<Doctor,String>("birthday"));
        Spec.setCellValueFactory(new PropertyValueFactory<Doctor,String>("specification"));
        // key.setCellValueFactory(new PropertyValueFactory<Doctor,String>("key"));
        for(int i = 0 ; i < doctors.size();i++){
            doctorsTable.getItems().add(doctors.get(i));
        }
        doctorsTable.setEditable(false);
    }
}
