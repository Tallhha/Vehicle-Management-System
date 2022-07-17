package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Sale {

    //Class Attributes.
    Date d = new Date();
    BookingForm Car = new BookingForm();
    Dealer Person = new Dealer();
    DBMS DB = new DBMS();

    //Public Functions  ================================================================================================

    //Constructor
    public Sale(BookingForm C, Dealer D){
        Car = C; Person = D;
    }

    //This function send denial message to costumers and make a log of it.
    public void Generate_DenyForm() {

        try {

            File myObj = new File("Denial.txt");          //Opening file.

            if(myObj.createNewFile()){      //create new file if file doesn't exist.

                FileWriter myWriter = new FileWriter("Denial.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("\t\t\t********** B.M.W **********\n");

                myWriter.write("Dear " + Car.getFirstName() + ",\n");
                myWriter.write("\nYour Booking for vehicle " + Car.V.getName() + " has been denied due to some inconvenience. We highly " +
                        "apologize for discomfort. Please make new booking or contact to nearest outlet.\nHave a Good Day.\n\nB.M.W.\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }
            else{           //Open existing file.

                FileWriter myWriter = new FileWriter("Denial.txt", true);       //Making instance for writing in file.

                //Writing in file.
                myWriter.write("Dear " + Car.getFirstName() + ",\n");
                myWriter.write("\nYour Booking for vehicle " + Car.V.getName() + " has been denied due to some inconvenience. We highly " +
                        "apologize for discomfort. Please make new booking or contact to nearest outlet.\nHave a Good Day.\n\nB.M.W.\n");
                myWriter.write("Date: " + d + ".\n");

                myWriter.write("\n**************************************************\n");
                myWriter.write("**************************************************\n");

                myWriter.close();           //Closing file

            }

        }
        catch (IOException e) {         //Exception handling if error occurs in file handling.

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    public void Generate_SaleForm(){

       try {

           File myObj = new File("SALE.txt");          //Opening file.

           if (myObj.createNewFile()) {         //Create new file (form) if it doesn't exist.

               FileWriter myWriter = new FileWriter("SALE.txt");       //Making instance for writing in file.

               //Writing in file.
               myWriter.write("\t\t\t  ********** B.M.W **********\n");
               myWriter.write("\t\t\t********** SALE FORM **********\n");
               myWriter.write("Date: " + d + "\n");
               myWriter.write("Dealer:" + Person.getFirstName() + " " + Person.getLastName() + "\n");
               myWriter.write("Customer:" + Car.getFirstName() + " " + Car.getLastName() + "\n");
               myWriter.write("Vehicle: " + Car.V.getName() + "\t\t\tType:" + Car.V.getType() + "\n");
               myWriter.write("Model: " + Car.V.getModel() + "\t\t\tColor:" + Car.V.getColor() + "\n");
               myWriter.write("Payment Method: " + Car.getBuyingOption() + "\t\t\tCost:" + Car.V.getCost() + "\n");
               myWriter.write("\n\t\t\t**********Thanks For Support**********\n");
               myWriter.write("\t\t\t      ********** B.M.W **********\n");

               myWriter.close();           //Closing file

           }
           else {           //Open existing file.

               FileWriter myWriter = new FileWriter("SALE.txt");        //Making instance for writing in file.
               myWriter.flush();

               //Writing in file.
               myWriter.write("\t\t\t  ********** B.M.W **********\n");
               myWriter.write("\t\t\t********** SALE FORM **********\n");
               myWriter.write("Date: " + d  + "\n");
               myWriter.write("Dealer:" + Person.getFirstName() + " " + Person.getLastName() + "\n");
               myWriter.write("Customer:" + Car.getFirstName() + " " + Car.getLastName() + "\n");
               myWriter.write("Vehicle: " + Car.V.getName() + "\t\t\tType:" + Car.V.getType() + "\n");
               myWriter.write("Model: " + Car.V.getModel() + "\t\t\tColor:" + Car.V.getColor() + "\n");
               myWriter.write("Payment Method: " + Car.getBuyingOption() + "\t\t\tCost:" + Car.V.getCost() + "\n");
               myWriter.write("\n\t\t\t**********Thanks For Support**********\n");
               myWriter.write("\t\t\t      ********** B.M.W **********\n");

               myWriter.close();           //Closing file

           }

       } catch (IOException e) {         //Exception handling if error occurs in file handling.

           System.out.println("An error occurred.");
           e.printStackTrace();

       }

   }

   //Displaying content of Class.
   public void Display(){

       System.out.println("Date: " + d  + "\n");

   }

   //This function add sale in DBMS for company track record.
   public boolean Add_Sale(){

        boolean ret = DB.InsertSale(this);          //Storing sale details in DBMS.

        if(ret)
            DB.IncreaseDealerSale(Person.getEmail());

        return ret;

   }

}
