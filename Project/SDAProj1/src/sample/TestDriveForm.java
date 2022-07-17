package sample;
//===========================================================BUSINESS LAYER===========================================================

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TestDriveForm extends Forms{

    //Class Attributes.
    private String date, time, Outlet;
    private boolean policy;
    Date d = new Date();
    DBMS DB = new DBMS();

    //Public Functions =================================================================================================

    //Constructor.
    public TestDriveForm(){

        date = time = Outlet = "";
        policy = false;

    }
    public TestDriveForm(String v, String o, String fn, String ln, String e, String Num, String cnic, String d, String t) {
        super(v,fn,ln,e,Num,cnic);
        date = d;
        time = t;
        Outlet = o;
    }

    //Setters.
    public void setOutlet(String outlet) { Outlet = outlet; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPolicy(boolean p){
        policy = p;
    }

    public void setTime(String time) { this.time = time; }

    //Getters.
    public String getOutlet() { return Outlet; }

    public String getTime() { return time; }

    public String getDate() {
        return date;
    }

    public boolean getPolicy(){
        return policy;
    }

    //Initializer.
    public void SetTestDrive(String v, String o, String fn, String ln, String e, String Num, String cnic, String d, String t) {

        date = d;
        time = t;
        Outlet = o;
        Addform(v,fn,ln,e,Num,cnic);

    }

    //This function stores Test Drive Registration info in DBMS.
    public boolean RegTestDrive(String v, String o, String fn, String ln, String e, String Num, String cnic, String d, String t) {

        date = d;
        time = t;
        Outlet = o;
        Addform(v,fn,ln,e,Num,cnic);            //Storing form info.

        boolean ret = DB.InsertTestDriveForm(this);         //Storing Test Drive request in DBMS.
        return ret;

    }

    //This function send approval message to costumer and maintain its log.
    public void Generate_TestDriveForm(Dealer D){

        try {

            File myObj = new File("ApprovedTestDrive.txt");          //Opening file.

            if (myObj.createNewFile()){         //Creating file if doesn't exist.

                FileWriter myWriter = new FileWriter("ApprovedTestDrive.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("\t\t\t********** MERCEDES **********\n");

                myWriter.write("Dear " + getFirstName() + ",\n");
                myWriter.write("\nYour Test Drive Registration for vehicle " + getVehicle() + " has been Approved! Have a good Day! Please visit nearest outlet for Test Drive!\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }
            else{           //Opening existing file.

                FileWriter myWriter = new FileWriter("ApprovedTestDrive.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("\t\t\t********** MERCEDES **********\n");


                myWriter.write("Dear " + getFirstName() + ",\n");
                myWriter.write("\nYour Test Drive Registration for vehicle " + getVehicle() + " has been Approved! Have a good Day! Please visit nearest outlet for Test Drive!\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }

        } catch (IOException e) {         //Exception handling if error occurs in file handling.

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    //This function send denial message to costumer and maintain its log.
    public void Deny_TestDriveForm(Dealer D){

        try {

            File myObj = new File("DenialTestDrive.txt");          //Opening file.

            if(myObj.createNewFile()){        //Creating file if doesn't exist.

                FileWriter myWriter = new FileWriter("DenialTestDrive.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("\t\t\t********** MERCEDES **********\n");

                myWriter.write("Dear " + getFirstName() + ",\n");
                myWriter.write("\nYour Test Drive Registration for vehicle " + getVehicle() + " has been denied due to some inconvenience. We highly \" +\n" +
                        "                        \"apologize for discomfort. Please make new registration or contact to nearest outlet.\\:((\n:(\n\nMERCEDES\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }
            else{           //Opening existing file.

                FileWriter myWriter = new FileWriter("DenialTestDrive.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("\t\t\t********** MERCEDES **********\n");
                myWriter.write("Dear " + getFirstName() + ",\n");
                myWriter.write("\nYour Test Drive Registration for vehicle " + getVehicle() + " has been denied due to some inconvenience. We highly \" +\n" +
                        "                        \"apologize for discomfort. Please make new registration or contact to nearest outlet.\\:((\n:(\n\nMERCEDES\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }

        } catch (IOException e) {         //Exception handling if error occurs in file handling.

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    //Display Contents of class.
    public void TestPrint(){

        Print();
        System.out.print("Date: " + getDate() + "\n");

    }

}
