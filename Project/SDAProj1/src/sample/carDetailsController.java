package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class carDetailsController implements Initializable {
    ObservableList<String> searchByList = FXCollections
            .observableArrayList("Full Payment", "10000/Month", "20000/Month","30000/Month" );
    @FXML
    private ComboBox<String> searchByType;

    @FXML
    private Label CarName;
    @FXML
    private Label prompt404;

    @FXML
    private Label Type;
    @FXML
    private Label Model;
    @FXML
    private Label Cost;
    @FXML
    private Label Company;


    @FXML
    private TextField email;
    @FXML
    private TextField CNIC;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField phoneNum;
    @FXML
    private ImageView img;

    String vname;
    String vcolor;

    @FXML
    private Button submissionButton;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)
    {
        searchByType.setItems(searchByList);
        prompt404.setText("[Oops... Something went wrong, Please Refresh]");
    }

    @FXML
    public void loadPage(ActionEvent event)
    {
        Stage stages = (Stage) CarName.getScene().getWindow();
        String modelString = stages.getTitle();
        System.out.println(modelString);

        //rect.setSize(1,1);
        CarName.setText(modelString);
        prompt404.setText("");

        String source=new String();
        source="";
        source+="\\Vehicles\\";
        source+=modelString;
        source+=".png";
        System.out.println("source");

        System.out.println(source);
        javafx.scene.image.Image image = new Image(source);
        img.setImage(image);
        img.setOpacity(0.7);


        ArrayList<String> arrayList1 = new ArrayList();
        Vehicles vehicles=new Vehicles();
        arrayList1= vehicles.VehicleStatus("Name",modelString);
        String temp = arrayList1.get(0);
        String[] temp1 = temp.split(":");


        Type.setText(temp1[2]);
        Model.setText((temp1[3]));
        Cost.setText(temp1[4]);
        Company.setText(temp1[1]);

        vname=temp1[0];
        vcolor=temp1[5];
    }

    @FXML
    public void submit(ActionEvent event)
    {
        BookingForm bookingForm=new BookingForm();
        Vehicles vehicles=new Vehicles();

        vehicles.SetVehicle(vname,Company.getText(),Type.getText(),Model.getText(),vcolor,Cost.getText(),"");
        bookingForm.BookVehicle(fName.getText(),lName.getText(),email.getText(),phoneNum.getText(),CNIC.getText(),searchByType.getValue(),vehicles);

        prompt404.setText("Booking Request Sent,Confirmation will be shortly sent");
        email.setText("");
        CNIC.setText("");
        fName.setText("");
        lName.setText("");
        phoneNum.setText("");


        submissionButton.setDisable(true);
    }

    @FXML
    public void closeButtonOnAction(ActionEvent event)
    {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }


}
