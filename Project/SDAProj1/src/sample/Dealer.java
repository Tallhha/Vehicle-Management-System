package sample;

import java.util.ArrayList;

public class Dealer extends Person{

    //Class Attributes
    private String type, salary,sales;
    DBMS DB = new DBMS();
    LogInfo L = new LogInfo();

    //Public Functions =================================================================================================

    //Constructor
    public Dealer(){
        type = salary = "";
    }

    public Dealer(String fn, String ln, String e, String num, String t,String cnic, String addr, String s,String sales){

        super(fn,ln,e,num,cnic,addr);
        type = t;
        salary = s;
        this.sales=sales;
    }
    //Setters
    public void setType(String type) { this.type = type; }

    public void setSalary(String salary) { this.salary = salary; }
    public void setSales(String sales) { this.sales = sales; }

    //Getters
    public String getSalary() { return salary; }
    public String getSales() { return sales; }

    public String getType() { return type; }

    //Initializer Function.
    public void SetDealer(String fn, String ln, String e, String num, String t,String cnic, String addr, String s, String p){

        AddPerson(fn,ln,e,num,cnic,addr);
        type = t;
        salary = s;
    }

    //This function add and store dealer in DBMS.
    public boolean RegisterDealer(String fn, String ln, String e, String num, String t,String cnic, String addr, String s, String p){

        AddPerson(fn,ln,e,num,cnic,addr);          //Function initialize values for inherited class.
        type = t;
        salary = s;

        boolean ret = DB.InsertDealer(this);    //Insert Dealer in DBMS.

        if(ret)
            L.StoreInfo(e, p, 0, 1);

        return ret;

    }

    //This function return list of searched costumers.
    public ArrayList<String> SearchCustomer(String opt, String v){

        ArrayList<String> lists = new ArrayList<String>();
        lists = DB.SEARCH("CUSTOMER",opt,v);

        return lists;

    }

    //This function returns list of Test Drive Forms.
    public ArrayList<String> SearchTestDrive(String opt, String v){

        ArrayList<String> forms = new ArrayList<String>();
        forms = DB.SEARCH("TESTDRIVEREG",opt,v);        //Get List from DBMS.

        return forms;

    }

    //This function return list of vehicle bookings made by customers.
    public ArrayList<String> SearchBookings(String opt, String v){

        ArrayList<String> forms = new ArrayList<String>();
        forms = DB.SEARCH("BOOKING",opt,v);             //Get list from DBMS.

        return forms;

    }

    public boolean CheckBookings(String opt, String v, String dlr_em,boolean confirm){


        ArrayList<String> forms = new ArrayList<String>();
        forms = SearchBookings(opt,v);          //Returned list of Vehicle Bookings.

        boolean ret = DB.DELETE("BOOKING",opt, v);      //Delete selected booking from DBMS.

        System.out.println(forms.size());

        String temp = forms.get(0);
        String[] temp1 = temp.split(":");       //This function split and store different strings in string array on basis of ":".

        Vehicles V = new Vehicles();
        BookingForm B = new BookingForm();

        V.SetVehicle(temp1[5], "BMW", temp1[6], temp1[7], temp1[9], temp1[8], "");          //This function store values for vehicle.
        B.SetBooking(temp1[2], temp1[3], temp1[0], temp1[4], temp1[1], temp1[10], V);                //This function store values for booking.


        ArrayList<String> dlr = new ArrayList<String>();
        dlr = DB.SEARCH("EMPLOYEE", opt, dlr_em);       //Searching dealer in DBMS.

        String tempdlr = dlr.get(0);
        String[] tempdlr1 = tempdlr.split(":");         //This function split and store different strings in string array on basis of ":".

        Dealer D = new Dealer();
        D.SetDealer(tempdlr1[2], tempdlr1[3], tempdlr1[0], tempdlr1[4], tempdlr1[7], tempdlr1[1], tempdlr1[5], tempdlr1[6], "");        //Setting Dealer

        Sale S = new Sale(B,D);         //Creating Sale instance.

        if(confirm) {           //If sale is approved.

            S.Add_Sale();               //Store sale info in DBMS.
            S.Generate_SaleForm();      //This function generate sale form and send approval to costumer.

        }
        else
            S.Generate_DenyForm();      //This function send denial of booking to costumer.

        return ret;

    }

    public boolean CheckTestDrive(String opt, String v, String dlr_em, boolean confirm){

        ArrayList<String> forms = new ArrayList<String>();
        forms = DB.SEARCH("TESTDRIVEREG", opt, v);              //Return list of Test Drive Registration.


        boolean ret = DB.DELETE("TESTDRIVEREG",opt, v);         //Delete Selected Test Drive from DBMS.

        String temp = forms.get(0);
        String[] temp1 = temp.split(":");       //This function spilt string using ":" and store different strings in array.

        TestDriveForm T = new TestDriveForm();
        T.SetTestDrive(temp1[5],temp1[6],temp1[2],temp1[3],temp1[0],temp1[4],temp1[1],temp1[7],"");         //Storing values for Test Drive.

        ArrayList<String> dlr = new ArrayList<String>();
        dlr = DB.SEARCH("EMPLOYEE", opt, dlr_em);           //Search required dealer in DBMS.

        String tempdlr = dlr.get(0);
        String[] tempdlr1 = tempdlr.split(":");

        Dealer D = new Dealer();                      //This function spilt string using ":" and store different strings in array.
        D.SetDealer(tempdlr1[2], tempdlr1[3], tempdlr1[0], tempdlr1[4], tempdlr1[7], tempdlr1[1], tempdlr1[5], tempdlr1[6], "");        //Stores dealer info.


        if(confirm)
            T.Generate_TestDriveForm(D);            //Send approval to costumer.
        else
            T.Deny_TestDriveForm(D);                //Send denial to costumer.

        return ret;

    }

    public void DisplayForms(ArrayList<String> forms){


        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t:\t" + temp1[6] + "\t:\t" + temp1[7] + "\t:\n");

        }

    }


    public void DisplayBookings(ArrayList<String> forms){

        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t:\t" + temp1[6] + "\t:\t" + temp1[7] + "\t:\t"+ temp1[8] + "\t:\t"+ temp1[9] + "\t:\t"+ temp1[10] + "\t:\n");

        }

    }

    //Display List of Costumers.
    public void DisplayCustomers(ArrayList<String> forms){

        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t:\n");

        }

    }
}
