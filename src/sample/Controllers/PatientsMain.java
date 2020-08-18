package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.User;

import java.io.IOException;

//done by hajar
public class PatientsMain {


    public void back(ActionEvent event) throws IOException {
        if(User.role == 1){
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
            Scene scene = new Scene(root,900,600);
            window.setScene(scene);
            window.show();
        }
        if(User.role==2) {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../Views/ReceptionistPortal.fxml"));
            Scene scene = new Scene(root, 900, 600);
            window.setScene(scene);
            window.show();
        }
    }


    public void AddPatient(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddPatient.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void Entrance(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Enterance_main_page.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void ViewIndoor(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Enterance_main_page.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void SearchIndoor(ActionEvent event) {

    }
}
