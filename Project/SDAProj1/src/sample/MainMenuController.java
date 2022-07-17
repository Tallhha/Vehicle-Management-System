package sample;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class MainMenuController implements Initializable{


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML
    public void modelsButtonOnAction(ActionEvent event) throws Exception
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("models.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);

    }
    @FXML
    public void searchVehicleButtonOnAction(ActionEvent event) throws Exception
    {

        Parent newParent = FXMLLoader.load(getClass().getResource("searchMenu.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);

    }
    @FXML
    public void testDriveButtonOnAction(ActionEvent event) throws Exception
    {

        Parent newParent = FXMLLoader.load(getClass().getResource("testDriveMenu.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);
    }
    @FXML
    public void homeButtonOnAction(ActionEvent event) throws Exception
    {

        Parent newParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);
    }
    @FXML
    public void loginButtonOnAction(ActionEvent event) throws Exception
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);

    }
    @FXML
    public void feedBackButtonOnAction(ActionEvent event) throws Exception
    {

        Parent newParent = FXMLLoader.load(getClass().getResource("FeedBack.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = ((Stage)(((Button)event.getSource()).getScene().getWindow()));
        window.setScene(newScene);
    }
    @FXML
    public void closeButtonOnAction(ActionEvent event)
    {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
