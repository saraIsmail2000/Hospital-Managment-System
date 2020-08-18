package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.DBconnect;
import sample.Model.User;

import java.io.IOException;

public class AdminProfile {

    public TextField username;
    public TextField password;

    DBconnect db = DBconnect.getInstance();




    public void back(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AdminPortal.fxml"));
        Scene scene = new Scene(root,900,600);
        window.setScene(scene);
        window.show();
    }

    public void update(ActionEvent event) {
        //////////////
        if(username.getText().equals("") || password.getText().equals("")){
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setHeaderText("We Don't do it like that.");
            dialog.setContentText("You should fill both username and password.");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(300, 100);
            dialog.showAndWait();
            return;
        }
        db.updateAdminInfo(username.getText(),password.getText());
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setHeaderText("Done");
        dialog.setContentText("Your login info are updated successfully. ");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(300, 100);
        dialog.showAndWait();
    }

    public void initialize(){
        username.setText(User.username);
        password.setText(User.password);
    }
}
