package sample;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class testDriveMenuController implements Initializable{
    ObservableList<String> searchByList = FXCollections
            .observableArrayList("Islamabad","Peshawar","Lahore","Karachi");
    @FXML
    private ComboBox<String> searchByType;

    ObservableList<String> carsList = FXCollections
            .observableArrayList("EQC 400","W218","W470");
    @FXML
    private ComboBox<String> carDropDown;


    ObservableList<String> TimmingsList = FXCollections
            .observableArrayList("9:00","3:00","6:00");

    @FXML
    private ComboBox<String> TimmingDropDown;


    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField eMail;
    @FXML
    private TextField CNIC;
    @FXML
    private TextField date;
    @FXML
    private TextField phoneNum;

    @FXML
    private Label prompt;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)
    {
        searchByType.setItems(searchByList);
        carDropDown.setItems(carsList);
        TimmingDropDown.setItems(TimmingsList);
    }

    @FXML
    public void Submit(ActionEvent event) throws Exception
    {

        if (!fName.getText().equals("") && !lName.getText().equals("") &&
            !eMail.getText().equals("") && !CNIC.getText().equals("") &&
            !date.getText().equals("") && searchByType.getValue() != null)
        {
            prompt.setText("Request Sent, Please Wait for Request Approval");

            TestDriveForm t = new TestDriveForm();
            t.RegTestDrive(carDropDown.getValue(),searchByType.getValue(), fName.getText(),lName.getText(),eMail.getText(),phoneNum.getText(),CNIC.getText(),date.getText(),TimmingDropDown.getValue());


            //t.RegTestDrive("BMW","ISL","Toli","Luser","toai1234@gmil.com","090078601","9418712355","12/02/2020", "2:10");


        }
        else
        {
            prompt.setText("Please Fill All the Fields.");
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
