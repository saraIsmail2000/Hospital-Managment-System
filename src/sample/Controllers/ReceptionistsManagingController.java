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
import sample.Model.Nurse;
import sample.Model.Receptionist;

import java.io.IOException;
import java.util.ArrayList;

public class ReceptionistsManagingController {


    public TextField fullname;
    public ToggleGroup gender;
    public TextField phoneNum;
    public TextField username;
    public DatePicker birthDay;
    public DatePicker startDate;
    public Button apply;
    public PasswordField password;
    public TextField address;
    public TableView<Receptionist> RecTable;
    public TableColumn Fullname;
    public TableColumn Gender;
    public TableColumn Phone;
    public TableColumn Address;
    public TableColumn Startdate;
    public TableColumn Birthday;
    public TableColumn key;

    DBconnect db= DBconnect.getInstance();


    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }

    public void AddReceptionist(ActionEvent event) throws  NullPointerException{
        try {
            String name = fullname.getText().toString();
            String phone = phoneNum.getText().toString();
            String bd = birthDay.getValue().toString();
            String start = startDate.getValue().toString();
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String add = address.getText().toString();
            String g = ((RadioButton) gender.getSelectedToggle()).getText().toString();

            if (name.equals("") || g.equals("") || phone.equals("") || add.equals("") || bd.equals("") || start.equals("") ||
                    user.equals("") || pass.equals("")) {

                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Addition Failed");
                dialog.setContentText("You have to fill the fields!!");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();

            } else {
                Receptionist rec = new Receptionist(name, g, phone, user, pass, add, bd, start);
                db.insertReceptionist(rec);
                RecTable.getItems().clear();
                initialize();
            }
        }
        catch (NullPointerException e){ e.printStackTrace(); }
    }


    public  void initialize(){

        ArrayList<Receptionist> receptionists =  db.getReceptionists();

        Fullname.setCellValueFactory(new PropertyValueFactory<Receptionist, String>("FullName"));
        Gender.setCellValueFactory(new PropertyValueFactory<Receptionist, String>("gender"));
        Startdate.setCellValueFactory(new PropertyValueFactory<Receptionist, String>("JoiningDate"));
        Phone.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("phoneNumber"));
        Address.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("address"));
        Birthday.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("Birthday"));
        //key.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("RecKey"));
        for(int i = 0 ; i < receptionists.size();i++){
            RecTable.getItems().add(receptionists.get(i));
        }
        RecTable.setEditable(false);

    }
}
