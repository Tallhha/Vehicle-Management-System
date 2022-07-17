package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.print.Book;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class M_DashboardController implements Initializable {
    ObservableList<String> searchByList = FXCollections
            .observableArrayList("SUV","Sports","Luxury","Executive","Truck");
    @FXML
    private ComboBox<String> searchByType;

    @FXML
    private TextField ADPrompt;



    @FXML
    private TextField custEmail;

    @FXML
    private TextField DealerEmail;


    @FXML
    private TextField AD_Fname;
    @FXML
    private TextField AD_Lname;
    @FXML
    private TextField AD_Phone;
    @FXML
    private TextField AD_CNIC;
    @FXML
    private TextField AD_Address;
    @FXML
    private TextField AD_email;
    @FXML
    private TextField AD_password;
    @FXML
    private TextField AD_salary;





    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, String> name;
    @FXML
    private TableColumn<Customer, String> lname;
    @FXML
    private TableColumn<Customer, String> gmail;
    @FXML
    private TableColumn<Customer, String> CNIC;
    @FXML
    private TableColumn<Customer, String> phone;
    @FXML
    private TableColumn<Customer, String> address;


    @FXML
    private TableView<TestDriveForm> tableView2;
    @FXML
    private TableColumn<TestDriveForm, String> vehicle;
    @FXML
    private TableColumn<TestDriveForm, String> outlet;
    @FXML
    private TableColumn<TestDriveForm, String> firstName2;
    @FXML
    private TableColumn<TestDriveForm, String> lastName2;
    @FXML
    private TableColumn<TestDriveForm, String> email2;
    @FXML
    private TableColumn<TestDriveForm, String> phone2;
    @FXML
    private TableColumn<TestDriveForm, String> CNIC2;
    @FXML
    private TableColumn<TestDriveForm, String> date;
    @FXML
    private TableColumn<TestDriveForm, String> time;

    @FXML
    private TableView<BookingForm> tableView3;
    @FXML
    private TableColumn<BookingForm, String> fname3;
    @FXML
    private TableColumn<BookingForm,String>lname3;
    @FXML
    private TableColumn<BookingForm,String>email3;
    @FXML
    private TableColumn<BookingForm,String>phone3;
    @FXML
    private TableColumn<BookingForm,String>buyingOption;


    @FXML
    private TableView<Vehicles> tableView4;
    @FXML
    private TableColumn<Vehicles,String>vName;
    @FXML
    private TableColumn<Vehicles,String>vtype;
    @FXML
    private TableColumn<Vehicles,String>vmodel;
    @FXML
    private TableColumn<Vehicles,String>vcost;
    @FXML
    private TableColumn<Vehicles,String>vcolor;

    @FXML
    private TableView<Dealer> tableView5;
    @FXML
    private TableColumn<Dealer,String>dfName;
    @FXML
    private TableColumn<Dealer,String>dlName;
    @FXML
    private TableColumn<Dealer,String>demail;
    @FXML
    private TableColumn<Dealer,String>dtype;
    @FXML
    private TableColumn<Dealer,String>dsalary;
    @FXML
    private TableColumn<Dealer,String>dsales;



    @FXML
    private TableView<Vehicles> tableView6;
    @FXML
    private TableColumn<Vehicles,String>vName2;
    @FXML
    private TableColumn<Vehicles,String>vtype2;
    @FXML
    private TableColumn<Vehicles,String>vmodel2;
    @FXML
    private TableColumn<Vehicles,String>vcost2;
    @FXML
    private TableColumn<Vehicles,String>vcolor2;
    @FXML
    private TableColumn<Vehicles,String>avail;




    @FXML
    private TextField emailTextField;
    @FXML
    private TextField emailTextField1;
    @FXML
    private TextField Del_Veh;

    //FOR TEST DRIVE
    @FXML
    public void addDealer(ActionEvent event)
    {
        ADPrompt.setText("Dealer Successfully Added!");
        Dealer d = new Dealer();
        d.RegisterDealer(AD_Fname.getText(),AD_Lname.getText(),AD_email.getText(),AD_Phone.getText(),searchByType.getValue(),AD_CNIC.getText(),AD_Address.getText(),AD_salary.getText(),AD_password.getText());

    }

    //FOR TEST DRIVE
    @FXML
    public void DeleteCustomer(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        //System.out.println(emailTextField.getText());
        //Dealer d = new Dealer();
        Customer customer = new Customer();
        customer.DeleteCustomer("Email",custEmail.getText());
        reFreshTable();

    }

    //FOR TEST DRIVE
    @FXML
    public void DeleteDealer(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        //System.out.println(emailTextField.getText());
        //Dealer d = new Dealer();
        //Customer customer = new Customer();
        //customer.DeleteCustomer("Email",custEmail.getText());

        Manager manager= new Manager();
        manager.DeleteDealer("Email",DealerEmail.getText());
        reFreshTable();

    }


    //FOR TEST DRIVE
    @FXML
    public void ConfirmOnAction(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        System.out.println(emailTextField.getText());
        Dealer d = new Dealer();

        d.CheckTestDrive("Email",emailTextField.getText(),title,true);

        reFreshTable();
    }
    @FXML
    public void DenyOnAction(ActionEvent event)
    {

        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        System.out.println(emailTextField.getText());
        Dealer d = new Dealer();

        d.CheckTestDrive("Email",emailTextField.getText(),title,false);
        reFreshTable();
    }


    //FOR BOOKING
    @FXML
    public void ConfirmOnAction1(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        System.out.println(emailTextField1.getText());
        Dealer d = new Dealer();

        d.CheckBookings("Email",emailTextField1.getText(),title,true);
        //d.CheckTestDrive("Email",emailTextField.getText(),title,false);
        reFreshTable();
    }

    @FXML
    public void DenyOnAction1(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        System.out.println(emailTextField1.getText());
        Dealer d = new Dealer();

        d.CheckBookings("Email",emailTextField1.getText(),title,false);
        //d.CheckTestDrive("Email",emailTextField.getText(),title,false);
        reFreshTable();
    }

    @FXML
    public void DelVehicle(ActionEvent event)
    {
        String title =  ((Stage)(((Button)event.getSource()).getScene().getWindow())).getTitle();
        System.out.println(Del_Veh.getText());
        Manager M = new Manager();

        M.DeleteVehicle("Name",Del_Veh.getText());
        reFreshTable();
    }


    ObservableList<Customer> list = FXCollections.observableArrayList(
    );

    ObservableList<TestDriveForm> list2 = FXCollections.observableArrayList(
            //new TestDriveForm("a","b","c","d","e","f","g","h","i")

    );


    ObservableList<BookingForm> list3 = FXCollections.observableArrayList(
            //new TestDriveForm("a","b","c","d","e","f","g","h","i")
            //new BookingForm("a","b","c","d","a","a",new Vehicles("a","b","c","d","a","a","a"))
    );

    ObservableList<Vehicles> list4 = FXCollections.observableArrayList(
            //new TestDriveForm("a","b","c","d","e","f","g","h","i")
            //   new Vehicles("a","b","c","d","a","a","a")
    );

    ObservableList<Dealer> list5 = FXCollections.observableArrayList(
            //new TestDriveForm("a","b","c","d","e","f","g","h","i")

    );
    ObservableList<Vehicles> list6 = FXCollections.observableArrayList(
            //new TestDriveForm("a","b","c","d","e","f","g","h","i")

    );


    public void reFreshTable()
    {
//Initialize List
        for ( int i = 0; i<tableView3.getItems().size(); i++) {
            tableView3.getItems().clear();
        }
        for ( int i = 0; i<tableView5.getItems().size(); i++) {
            tableView5.getItems().clear();
        }
        for ( int i = 0; i<tableView2.getItems().size(); i++) {
            tableView2.getItems().clear();
        }
        for ( int i = 0; i<tableView6.getItems().size(); i++) {
            tableView6.getItems().clear();
        }
        for ( int i = 0; i<tableView4.getItems().size(); i++) {
            tableView4.getItems().clear();
        }
        for ( int i = 0; i<tableView.getItems().size(); i++) {
            tableView.getItems().clear();
        }


        //Initialize List
        ArrayList<String> sList = new ArrayList<>();
        Dealer dealer= new Dealer();
        sList = dealer.SearchTestDrive("","");

        ArrayList<String> VList2 = new ArrayList<>();
        Vehicles vehicles2=new Vehicles();
        VList2 = vehicles2.VehicleStatus("","");



        for (int i = 0; i < sList.size(); i++) {

            String temp = sList.get(i);
            String[] temp1 = temp.split(":");
            list2.add(new TestDriveForm(temp1[5],temp1[6],temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[7]+":00",""));
            System.out.println(temp1[7]);
        }

        //Initialize List
        ArrayList<String> CList = new ArrayList<>();
        Dealer dealerC= new Dealer();
        CList = dealerC.SearchCustomer("","");

        for (int i = 0; i <CList.size(); i++) {

            String temp = CList.get(i);
            String[] temp1 = temp.split(":");
            list.add(new Customer(temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[5]));

        }

        ArrayList<String> sList2 = new ArrayList<>();
        Dealer dealer2= new Dealer();
        sList2 = dealer.SearchBookings("","");


        for (int i = 0; i < sList2.size(); i++) {

            String temp = sList2.get(i);
            String[] temp1 = temp.split(":");

            list4.add(new Vehicles(temp1[5],"",temp1[6],temp1[7],temp1[9],temp1[8],""));
            list3.add(new BookingForm(temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[10],new Vehicles()));
            System.out.println( temp1[5]);


        }

        ArrayList<String> DList = new ArrayList<>();
        Manager manager=new Manager();
        DList = manager.SearchDealer("","");
        for (int i = 0; i <DList.size(); i++) {

            String temp = DList.get(i);
            String[] temp1 = temp.split(":");
            list5.add(new Dealer(temp1[2],temp1[3],temp1[0],temp1[4],temp1[7],temp1[1],temp1[5],temp1[6],temp1[8]));

        }

        ArrayList<String> ZZList2 = new ArrayList<>();
        Vehicles vehicles=new Vehicles();
        ZZList2 = vehicles.VehicleStatus("","");


        for (int i = 0; i <ZZList2.size(); i++) {

            String temp = ZZList2.get(i);
            String[] temp1 = temp.split(":");

            list6.add(new Vehicles(temp1[0],"",temp1[2],temp1[3],temp1[5],temp1[4],temp1[6]));
        }

        //CUSTOMER TABLE/////////////////////////////////////////////////////////////////////
        name.setCellValueFactory(new PropertyValueFactory<Customer,String>("FirstName"));
        lname.setCellValueFactory(new PropertyValueFactory<Customer,String>("LastName"));
        gmail.setCellValueFactory(new PropertyValueFactory<Customer,String>("Email"));
        CNIC.setCellValueFactory(new PropertyValueFactory<Customer,String>("PhoneNo"));
        phone.setCellValueFactory(new PropertyValueFactory<Customer,String>("CNIC"));
        address.setCellValueFactory(new PropertyValueFactory<Customer,String>("Address"));

        //////////////////////////////////////////////////////////////////////////////////////

        //TESTING TABLE/////////////////////////////////////////////////////////////////////
        vehicle.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Vehicle"));
        firstName2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("FirstName"));
        lastName2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("LastName"));
        email2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Email"));
        phone2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("PhoneNo"));
        CNIC2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Cnic"));
        date.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("date"));
        time.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("time"));
        outlet.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("outlet"));

        ////////////////////////////////////////////////////////////////////////////////////

        //Dealer TABLE/////////////////////////////////////////////////////////////////////
        dfName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("FirstName"));
        dlName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("LastName"));
        demail.setCellValueFactory(new PropertyValueFactory<Dealer,String>("Email"));
        dtype.setCellValueFactory(new PropertyValueFactory<Dealer,String>("type"));
        dsalary.setCellValueFactory(new PropertyValueFactory<Dealer,String>("salary"));
        dsales.setCellValueFactory(new PropertyValueFactory<Dealer,String>("sales"));



        //TESTING TABLE/////////////////////////////////////////////////////////////////////
        //vehicle.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Vehicle"));
        fname3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("FirstName"));
        lname3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("LastName"));
        email3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("Email"));
        phone3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("PhoneNo"));
        buyingOption.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("BuyingOption"));

        vName.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Name"));
        vcolor.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Color"));
        vmodel.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Model"));
        vtype.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Type"));
        vcost.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Cost"));

        vName2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Name"));
        vcolor2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Color"));
        vmodel2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Model"));
        vtype2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Type"));
        vcost2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Cost"));
        avail.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Total"));



        tableView.setItems(list);
        tableView2.setItems(list2);
        tableView3.setItems(list3);
        tableView4.setItems(list4);
        tableView5.setItems(list5);
        tableView6.setItems(list6);
        ////////////////////////////////////////////////////////////////////////////////////
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        searchByType.setItems(searchByList);

        //Initialize List
        ArrayList<String> sList = new ArrayList<>();
        Dealer dealer= new Dealer();
        sList = dealer.SearchTestDrive("","");

        ArrayList<String> VList2 = new ArrayList<>();
        Vehicles vehicles2=new Vehicles();
        VList2 = vehicles2.VehicleStatus("","");



        for (int i = 0; i < sList.size(); i++) {

            String temp = sList.get(i);
            String[] temp1 = temp.split(":");
            list2.add(new TestDriveForm(temp1[5],temp1[6],temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[7]+":00",""));
            System.out.println(temp1[7]);
        }

        //Initialize List
        ArrayList<String> CList = new ArrayList<>();
        Dealer dealerC= new Dealer();
        CList = dealerC.SearchCustomer("","");

        for (int i = 0; i <CList.size(); i++) {

            String temp = CList.get(i);
            String[] temp1 = temp.split(":");
            list.add(new Customer(temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[5]));

        }

        ArrayList<String> sList2 = new ArrayList<>();
        Dealer dealer2= new Dealer();
        sList2 = dealer.SearchBookings("","");


        for (int i = 0; i < sList2.size(); i++) {

            String temp = sList2.get(i);
            String[] temp1 = temp.split(":");

            list4.add(new Vehicles(temp1[5],"",temp1[6],temp1[7],temp1[9],temp1[8],""));
            list3.add(new BookingForm(temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[10],new Vehicles()));
            System.out.println( temp1[5]);
        }



        ArrayList<String> DList = new ArrayList<>();
        Manager manager=new Manager();
        DList = manager.SearchDealer("","");
        for (int i = 0; i <DList.size(); i++) {

            String temp = DList.get(i);
            String[] temp1 = temp.split(":");
            list5.add(new Dealer(temp1[2],temp1[3],temp1[0],temp1[4],temp1[7],temp1[1],temp1[5],temp1[6],temp1[8]));

        }



        ArrayList<String> ZZList2 = new ArrayList<>();
        Vehicles vehicles=new Vehicles();
        ZZList2 = vehicles.VehicleStatus("","");


        for (int i = 0; i <ZZList2.size(); i++) {

            String temp = ZZList2.get(i);
            String[] temp1 = temp.split(":");

            list6.add(new Vehicles(temp1[0],"",temp1[2],temp1[3],temp1[5],temp1[4],temp1[6]));
        }


        //CUSTOMER TABLE/////////////////////////////////////////////////////////////////////
        name.setCellValueFactory(new PropertyValueFactory<Customer,String>("FirstName"));
        lname.setCellValueFactory(new PropertyValueFactory<Customer,String>("LastName"));
        gmail.setCellValueFactory(new PropertyValueFactory<Customer,String>("Email"));
        CNIC.setCellValueFactory(new PropertyValueFactory<Customer,String>("PhoneNo"));
        phone.setCellValueFactory(new PropertyValueFactory<Customer,String>("CNIC"));
        address.setCellValueFactory(new PropertyValueFactory<Customer,String>("Address"));

        //////////////////////////////////////////////////////////////////////////////////////

        //TESTING TABLE/////////////////////////////////////////////////////////////////////
        vehicle.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Vehicle"));
        firstName2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("FirstName"));
        lastName2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("LastName"));
        email2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Email"));
        phone2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("PhoneNo"));
        CNIC2.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Cnic"));
        date.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("date"));
        time.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("time"));
        outlet.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("outlet"));

        ////////////////////////////////////////////////////////////////////////////////////

        //Dealer TABLE/////////////////////////////////////////////////////////////////////
        dfName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("FirstName"));
        dlName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("LastName"));
        demail.setCellValueFactory(new PropertyValueFactory<Dealer,String>("Email"));
        dtype.setCellValueFactory(new PropertyValueFactory<Dealer,String>("type"));
        dsalary.setCellValueFactory(new PropertyValueFactory<Dealer,String>("salary"));
        dsales.setCellValueFactory(new PropertyValueFactory<Dealer,String>("sales"));



        //TESTING TABLE/////////////////////////////////////////////////////////////////////
        //vehicle.setCellValueFactory(new PropertyValueFactory<TestDriveForm,String>("Vehicle"));
        fname3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("FirstName"));
        lname3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("LastName"));
        email3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("Email"));
        phone3.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("PhoneNo"));
        buyingOption.setCellValueFactory(new PropertyValueFactory<BookingForm,String>("BuyingOption"));

        vName.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Name"));
        vcolor.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Color"));
        vmodel.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Model"));
        vtype.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Type"));
        vcost.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Cost"));

        vName2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Name"));
        vcolor2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Color"));
        vmodel2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Model"));
        vtype2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Type"));
        vcost2.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Cost"));
        avail.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("Total"));



        tableView.setItems(list);
        tableView2.setItems(list2);
        tableView3.setItems(list3);
        tableView4.setItems(list4);
        tableView5.setItems(list5);
        tableView6.setItems(list6);

        ////////////////////////////////////////////////////////////////////////////////////

    }

    @FXML
    public void closeButtonOnAction(ActionEvent event)
    {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}

