package sample;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.File;

import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class feedbackController implements Initializable{

    @FXML
    private TextField fName;


    @FXML
    private TextField lName;
    @FXML
    private TextArea comments;

    @FXML
    private Label prompt;
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)
    {

    }
    @FXML
    public void SubmitButtonOnAction(ActionEvent event) throws Exception
    {
        if (!fName.getText().toString().equals("") && !lName.getText().toString().equals("") && !comments.getText().toString().equals(""))
        {
           // System.out.println(fName.getText());
            prompt.setText("Thanks for your Feedback!");

            Customer customer = new Customer();
            customer.Feedback(fName.getText(),lName.getText(),comments.getText());





        }
        else
        {
            prompt.setText("Please Enter Valid Entries");
        }

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
    public void loginButtonOnAction(ActionEvent event) throws Exception
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
