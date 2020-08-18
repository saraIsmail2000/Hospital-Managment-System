package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//// I ADD THEM
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import sample.Model.*;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    Button admin;

    @FXML
    Button doc;

    @FXML
    Button rec;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Button Adminlogin ;

    @FXML
    Button DoctorLogin;

    @FXML
    Button RecLogin;

    @FXML
    TextField DocUser;

    @FXML
    PasswordField DocPass;

    @FXML
    TextField RecUser;

    @FXML
    PasswordField RecPass;


    DBconnect db= DBconnect.getInstance();



    @FXML
    public void goToAdminLogin(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/AdminLogin.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }


    @FXML
    public  void goToDoctorLogin(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/DoctorLogin.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    @FXML
    public  void goToRecLogin(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ReceptionistLogin.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void goToAdminPortal(ActionEvent event) throws IOException {
        if(username.getText().toString().equals("") || password.getText().toString().equals("")){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Login Failed");
            dialog.setContentText("You have to fill the login fields !!");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
        }
        else{
            //database functions
            User.username = username.getText();
            User.password = password.getText();

            //
            try {
                Admin a = db.checkAdmin(username.getText().toString(),password.getText().toString());
                if(a==null) {
                    Alert dialog = new Alert(Alert.AlertType.WARNING);
                    dialog.setHeaderText("Login Failed");
                    dialog.setContentText("Your login info are incorrect ! ");
                    dialog.setResizable(true);
                    dialog.getDialogPane().setPrefSize(300, 100);
                    dialog.showAndWait();
                }
                else{
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Parent root =  FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
                    Scene scene = new Scene(root,900,600);
                    window.setScene(scene);
                    window.show();
                }
            }catch (SQLException e){}
        }
    }

    public void goToDoctorPortal(ActionEvent event) throws IOException,NullPointerException {
        if(DocUser.getText().toString().equals("") || DocPass.getText().toString().equals("")){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Login Failed");
            dialog.setContentText("You have to fill the login fields !!");
            dialog.setResizable(false);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
        }
        else{
            // database function to check the login and returns object of type doctor

            try {
               Doctor d = db.checkDoc(DocUser.getText().toString(),DocPass.getText().toString());
                if(d==null) {
                    Alert dialog = new Alert(Alert.AlertType.WARNING);
                    dialog.setHeaderText("Login Failed");
                    dialog.setContentText("Your login info are incorrect ! ");
                    dialog.setResizable(true);
                    dialog.getDialogPane().setPrefSize(300, 100);
                    dialog.showAndWait();
                }
                else {

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Parent root =  FXMLLoader.load(getClass().getResource("../Views/DoctorPortal.fxml"));
                    Scene scene = new Scene(root,900,600);
                    window.setScene(scene);
                    window.show();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    @FXML
    public void goToRecPortal(ActionEvent event) throws IOException{
        if(RecUser.getText().toString().equals("") || RecPass.getText().toString().equals("")){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Login Failed");
            dialog.setContentText("You have to fill the login fields !!");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
        }
        else{

            //database functions
            try {
                Receptionist r = db.checkRec(RecUser.getText().toString(),RecPass.getText().toString());
                if(r==null) {
                    Alert dialog = new Alert(Alert.AlertType.WARNING);
                    dialog.setHeaderText("Login Failed");
                    dialog.setContentText("Your login info are incorrect ! ");
                    dialog.setResizable(true);
                    dialog.getDialogPane().setPrefSize(300, 100);
                    dialog.showAndWait();
                }
                else{
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Parent root =  FXMLLoader.load(getClass().getResource("../Views/ReceptionistPortal.fxml"));
                    Scene scene = new Scene(root,900,600);
                    window.setScene(scene);
                    window.show();
                }
            }catch (SQLException e){}
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("../Views/FirstPage.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();

    }

}
