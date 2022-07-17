package sample;

import java.awt.print.Book;

public class BookingForm extends Forms{

    //Class Attributes.
    private String BuyingOption;
    Vehicles V = new Vehicles();
    DBMS DB = new DBMS();

    //Public Functions ============================================================================================

    //Constructor
    public BookingForm(){
        BuyingOption = "";
    }

    public BookingForm(String fn, String ln, String e, String Num, String cnic, String opt, Vehicles Veh) {

        super(Veh.getName(),fn,ln,e,Num,cnic);
        V = Veh;
        BuyingOption = opt;           //This function store information required for form

    }
    //Setter
    public void setBuyingOption(String buyingOption) { BuyingOption = buyingOption; }

    //Getter
    public String getBuyingOption() { return BuyingOption; }

    //Initializer
    public void SetBooking(String fn, String ln, String e, String Num, String cnic, String opt, Vehicles Veh) {

        V = Veh;
        BuyingOption = opt;
        Addform(V.getName(),fn,ln,e,Num,cnic);              //This function store information required for form

    }

    //This function is used for booking vehicle which customer wants to buy.
    public boolean BookVehicle(String fn, String ln, String e, String Num, String cnic, String opt, Vehicles Veh) {

        V = Veh;
        BuyingOption = opt;

        Addform(V.getName(),fn,ln,e,Num,cnic);              //This function store information required for form
        boolean ret = DB.InsertBookingForm(this);        //This function add booking details in DBMS for track record and further processing.

        return ret;

    }

}
