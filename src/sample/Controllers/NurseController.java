package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.Nurse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class NurseController {


    public ComboBox combobox;
    public TextField nurseName;
    public Button addbutton;
    public DatePicker sDate;
    public ToggleGroup gender;
    public TableView<Nurse> NursesTable;
    public TableColumn FullName;
    public TableColumn Gender;
    public TableColumn JoiningDate;
    public TableColumn ward;
    public TableColumn floor;

    DBconnect db = DBconnect.getInstance();
    ArrayList<String> wards = null;

    public void addNurse(ActionEvent event) throws NullPointerException {
        try {
            if (nurseName.getText().toString().equals("") || sDate.getValue().toString().equals("") ||
                    ((RadioButton) gender.getSelectedToggle()).getText().toString().equals("")) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Addition Failed");
                dialog.setContentText("You have to fill the fields of a nurse to add !!");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(300, 100);
                dialog.showAndWait();

            } else {
                if(wards.size() == 0){
                    Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                    dialog.setHeaderText("Addition Failed");
                    dialog.setContentText("No Wards Yet !!");
                    dialog.setResizable(true);
                    dialog.getDialogPane().setPrefSize(300, 100);
                    dialog.showAndWait();
                }
                else {
                    Nurse nurse = new Nurse(nurseName.getText().toString(), combobox.getValue().toString(), ((RadioButton) gender.getSelectedToggle()).getText().toString(), sDate.getValue().toString());
                    db.insertNurse(nurse);
                    NursesTable.getItems().clear();
                    initialize();
                }
            }
        } catch (NullPointerException e) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Addition Failed");
            dialog.setContentText("You have to fill the fields of a nurse to add !!");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
        }


    }

    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
        Scene scene = new Scene(root, 900, 600);
        window.setScene(scene);
        window.show();

    }


    public void initialize() {

        wards = db.getWardNames();
        for(int i=0; i < wards.size(); i++){
            combobox.getItems().add(wards.get(i));
        }
        ArrayList<Nurse> nurses =  db.getNurses();
        //set up the columns in the table
        FullName.setCellValueFactory(new PropertyValueFactory<Nurse, String>("fullName"));
        Gender.setCellValueFactory(new PropertyValueFactory<Nurse, String>("gender"));
        JoiningDate.setCellValueFactory(new PropertyValueFactory<Nurse, String>("startDate"));
        ward.setCellValueFactory(new PropertyValueFactory<Nurse,String>("wardName"));
        floor.setCellValueFactory(new PropertyValueFactory<Nurse,String>("floor"));
        for(int i = 0 ; i < nurses.size();i++){
            NursesTable.getItems().add(nurses.get(i));
        }
        NursesTable.setEditable(false);
    }



}
