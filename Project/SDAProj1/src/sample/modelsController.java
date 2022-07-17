package sample;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.File;

import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

import javax.swing.*;


public class modelsController implements Initializable{

    @FXML
    private VBox carList;


    @FXML
    private Button button;



    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)
    {
        carList.setAlignment(Pos.CENTER);

         /*
        The Code To fetch car names into cars






         */
        ArrayList<String> arrayList=new ArrayList<>();

        Vehicles vehicles= new Vehicles();

        arrayList = vehicles.VehicleStatus("","");
        String[] cars = new String[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {

            String temp = arrayList.get(i);
            String[] temp1 = temp.split(":");
            cars[i]=temp1[0];
            System.out.println(cars[i]);

        }






        String source=new String();
        for(int i = 0 ; i < arrayList.size(); i++ ){
            source="";
            source+="\\Vehicles\\";
            source+=cars[i];
            source+=".png";

            Image image = new Image(source);
            ImageView imageView = new ImageView(image);
            imageView.setOpacity(0.5);
            //imageView.preserveRatioProperty(0);
            imageView.setPreserveRatio(false);
            imageView.setFitHeight(400);
            imageView.setFitWidth(800);


            Button b = new Button();

            //b.setFont(button.getFont());
            b.setGraphic(imageView);
            b.setText(cars[i]);
            b.setStyle("-fx-font-size:52; -fx-background-color:  #ffcf66;");
            b.setContentDisplay(ContentDisplay.CENTER);
            b.setUnderline(true);
            b.setCursor(Cursor.HAND);
           // System.out.println(button.getFont());
           //System.out.println(b.getText());

            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event)
                {
                    System.out.println("Hello World!");
                    System.out.println(b.getText());


                    Stage primaryStage= new Stage();



                    try{
                        Parent root = FXMLLoader.load(getClass().getResource("CarDetails.fxml"));
                        primaryStage.initStyle(StageStyle.UNIFIED);
                        primaryStage.setTitle(b.getText().toString());
                        //primaryStage.setOpacity(0.5);

                        primaryStage.setScene(new Scene(root));
                        primaryStage.setResizable(false);
                        primaryStage.show();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
            });

            carList.getChildren().add(b);
            Separator sep = new Separator();
            sep.setOpacity(0f);
            carList.getChildren().add(sep);
        }
    }


    void openCarButton(String s) throws Exception
    {

    }

    @FXML
    void detailsButton(ActionEvent event)
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
    public void feedBackButtonOnAction(ActionEvent event) throws Exception
    {

        Parent newParent = FXMLLoader.load(getClass().getResource("FeedBack.fxml"));
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
    public void closeButtonOnAction(ActionEvent event)
    {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
