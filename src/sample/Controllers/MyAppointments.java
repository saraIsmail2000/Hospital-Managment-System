package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Model.Appointment;
import sample.Model.DBconnect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyAppointments {

    public TableView table;
    public TableColumn date;
    public TableColumn time;
    public TableColumn Pname;
    public TableColumn phone;

    DBconnect db = DBconnect.getInstance();


    public void goBack(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/DoctorPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }



    public void initialize() throws SQLException {
        ArrayList<Appointment> appointments= db.getMyappointment();
        Pname.setCellValueFactory(new PropertyValueFactory<Appointment,String>("PatientName"));
        phone.setCellValueFactory(new PropertyValueFactory<Appointment,String>("PatientPhone"));
        date.setCellValueFactory(new PropertyValueFactory<Appointment,String>("AppDate"));
        time.setCellValueFactory(new PropertyValueFactory<Appointment,String>("AppTime"));
        System.out.print(appointments.size());
        for(int i=0;i<appointments.size();i++){
            table.getItems().add(appointments.get(i));
        }
        table.setEditable(false);
    }


}
