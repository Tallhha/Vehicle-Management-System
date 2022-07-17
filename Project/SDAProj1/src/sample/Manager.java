package sample;

import java.util.ArrayList;

public class Manager extends Person{

    //Class Attributes
    DBMS DB = new DBMS();
    LogInfo L = new LogInfo();

    //Public Functions =================================================================================================

    //This function returns the list of dealer.
    public ArrayList<String> SearchDealer(String opt, String v){

        ArrayList<String> lists = new ArrayList<String>();
        lists = DB.SEARCH("EMPLOYEE",opt,v);        //This function search dealers in DBMS.

        return lists;

    }
    //This function remove information of required dealer from DBMS.
    public boolean DeleteBooking(String opt, String v){

        boolean ret = DB.DELETE("BOOKING",opt,v);          //Remove dealer from DBMS.

        return ret;

    }
    //This function remove information of required dealer from DBMS.
    public boolean DeleteTestDrive(String opt, String v){

        boolean ret = DB.DELETE("TESTDRIVEREG",opt,v);          //Remove dealer from DBMS.

        return ret;

    }
    //This function return list of made sales.
    public ArrayList<String> SearchSales(String opt, String v){

        ArrayList<String> lists = new ArrayList<String>();
        lists = DB.SEARCH("SALE",opt,v);            //THis function search sales in DBMS.

        return lists;

    }

    //This function return list of Feedback.
    public ArrayList<String> SearchFeedback(String opt, String v){

        ArrayList<String> lists = new ArrayList<String>();
        lists = DB.SEARCH("FEEDBACK",opt,v);            //THis function search sales in DBMS.

        return lists;

    }

    //This function remove information of required dealer from DBMS.
    public boolean DeleteDealer(String opt, String v){

        boolean ret = DB.DELETE("EMPLOYEE",opt,v);          //Remove dealer from DBMS.
        if(ret)
            L.DeleteInfo(opt, v);           //Deleting log in information of removed dealer.

        return ret;

    }

    //This function remove information of required vehicle from DBMS.
    public boolean DeleteVehicle(String opt, String v){

        boolean ret = DB.DELETE("VEHICLE",opt, v);          //Removing vehicle from DBMS.
        return ret;

    }

    //This function updates the information of selected vehicle.
    public boolean UpdateVehicle(String tot, String n, String mod){

        //"Available","Name","Model"
        System.out.println(tot);

        boolean ret = DB.UPDATEVEH(tot,n,mod);          //Updating vehicle info in DBMS.

        System.out.println(ret);

        return ret;

    }

    //This function update information of selected dealer.
    public boolean UpdateDealer(String opt, String v, String em){

        //"Type,Sal",val,"Email"
        boolean ret = DB.UPDATEEMP(opt, v,em);          //Updating dealer info in DBMS.

        return ret;

    }

    //Displays all employees.
    public void DisplayEmp(ArrayList<String> forms){

        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t:\t" + temp1[6] + "\t:\t" + temp1[7] + "\t:\t" + temp1[8] + "\t:\n");

        }

    }

    //Displays all sales.
    public void DisplaySales(ArrayList<String> forms){

        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t:\t" + temp1[6] + "\t:\t" + temp1[7] + "\t:\n");

        }

    }

    //Displays all sales.
    public void DisplayFeed(ArrayList<String> forms){

        for (int i = 0; i < forms.size(); i++) {

            String temp = forms.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\n");

        }

    }
}
