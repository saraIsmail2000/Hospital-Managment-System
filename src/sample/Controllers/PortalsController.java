package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class PortalsController {


    public Button logout;
    public Button changeInfo;
    public AnchorPane patients;
    public Button Rlogout;
    public Button buttonPatients;
    public Button RbuttonProfile;
    public Button buttonApp;


    public void goToChange(javafx.event.ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/ChangeAdminInfo.fxml"));
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

    public void doctorsClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/Doctors.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void receptionistsClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/Receptionists.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }

    public void patientsDetails(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/ViewIndoorPatients.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void ViewRecProfile(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/ReceptionistProfile.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void appointments(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/ViewAppointments.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }



    public void nursesClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/Nurses.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    public void patientsClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/Patients.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


}
