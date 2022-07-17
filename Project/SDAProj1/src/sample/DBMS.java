package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBMS {

    //====================================================================================

    public boolean InsertSale(Sale S) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();

            String sql = "INSERT INTO SALE(DLR_EMAIL, CUST_EMAIL, DLRNAME, CUSTNAME,VEHICLE,MODEL,COST, BUYINGOPTION)" +
                    " VALUES ('" + S.Person.getEmail() + "', '" + S.Car.getEmail() + "', '" + S.Person.getFirstName() + " " + S.Person.getLastName() +"', '" + S.Car.getFirstName() + " " + S.Car.getLastName() + "', '" + S.Car.V.getName() + "', '" + S.Car.V.getModel() + "', " + S.Car.V.getCost() + ", '" + S.Car.getBuyingOption()+"')";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean IncreaseDealerSale(String val){

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();

            String sql = "update employee set total_sales = total_sales+1 where email = '" + val +"'";
            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    public boolean InsertBookingForm(BookingForm B) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();

            String sql = "INSERT INTO BOOKING(EMAIL,CNIC,FNAME,LNAME,PHONE_NO,VEHICLE, TYPE,MODEL,COST,COLOR,BUYINGOPTION)" +
                    " VALUES ('" + B.getEmail() + "', " + B.getCnic() + ", '" + B.getFirstName() + "', '" + B.getLastName() + "'," + B.getPhoneNo() + ", '" + B.V.getName() + "', '" + B.V.getType() + "', '" + B.V.getModel() +"', '"+B.V.getCost()+"', '"+B.V.getColor()+"','"+B.getBuyingOption()+"')";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    public boolean InsertTestDriveForm(TestDriveForm T) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO TESTDRIVEREG(EMAIL,CNIC,FNAME,LNAME,PHONE_NO,VEHICLE,OUTLET,REGDATE)" +
                    " VALUES ('" + T.getEmail() + "', " + T.getCnic() + ", '" + T.getFirstName() + "', '" + T.getLastName() + "'," + T.getPhoneNo() + ", '" + T.getVehicle() + "', '" + T.getOutlet() + "', to_date('" + T.getDate() + " " + T.getTime() +  "', 'DD/MM/YYYY HH24:MI'))";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertCustomer(Customer C) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO CUSTOMER(EMAIL,CNIC,FNAME,LNAME,PHONE_NO,ADDRESS)" +
                    " VALUES ('" + C.getEmail() + "', " + C.getCNIC() + ", '" + C.getFirstName() + "', '" + C.getLastName() + "'," + C.getPhoneNo() + ", '" + C.getAddress() + "')";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public void InsertLogInfo(LogInfo L) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO LOGIN(EMAIL,PASSWORD,IS_MANAGER,IS_DEALER)" +
                    " VALUES ('" + L.getEmail() + "', '" + L.getPw() + "', " + L.isManager() + ", " + L.isDealer() + ")";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void InsertFeedback(String fn, String ln, String desc) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO FEEDBACK(FNAME,LNAME,DESCRIPTION)" +
                    " VALUES ('" + fn + "', '" + ln + "', '" + desc + "')";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean InsertDealer(Dealer D) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO EMPLOYEE(EMAIL,CNIC,FNAME,LNAME,PHONE_NO,ADDRESS,SALARY,TYPE,TOTAL_SALES, IS_MGR)" +
                    " VALUES ('" + D.getEmail() + "', " + D.getCNIC() + ", '" + D.getFirstName() + "', '" + D.getLastName() + "'," + D.getPhoneNo() + ", '" + D.getAddress() + "'," + D.getSalary() + ", '" + D.getType() + "',0, NULL)";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean InsertVehicle(Vehicles V) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "INSERT INTO VEHICLE(NAME,COMPANY,TYPE,MODEL,COST,COLOR,AVAILABLE)" +
                    " VALUES ('" + V.getName() + "', '" + V.getCompany() + "', '" + V.getType() + "', '" + V.getModel() + "'," + V.getCost() + ", '" + V.getColor() + "'," + V.getTotal() + ")";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();

            return false;
        }

    }

    //=================================================

    public int SearchLogin(String em, String p){
        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";
        int ret = 0;

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "select * from LOGIN where EMAIL = '" + em + "' and PASSWORD = '" + p + "'";

            ResultSet rs = mySt.executeQuery(sql);

            while(rs.next()){
                if ((rs.getInt(3) == 1) && rs.getInt(4) == 0) {
                    ret = 1;
                }
                if ((rs.getInt(3) == 0) && rs.getInt(4) == 1) {
                    ret = 2;
                }
                if ((rs.getInt(3) == 0) && rs.getInt(4) == 0) {
                    ret = 3;
                }
            }

            rs.close(); mySt.close(); myCon.close();

            return ret;

        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<String> SEARCH(String table, String opt, String val) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        ArrayList<String> lists = new ArrayList<String>();
        String temp = "", sql = "";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();

            if(table.compareTo("EMPLOYEE") == 0){
                sql = "select * from " + table + " where IS_MGR IS NULL";
                if (opt != "") {
                    sql = "select * from " + table + " where " + opt + " = '" + val + "' and IS_MGR IS NULL";
                }

            }
            else {
                sql = "select * from " + table;
                if (opt != "") {
                    sql = "select * from " + table + " where " + opt + " = '" + val + "'";
                }
            }

            ResultSet rs = mySt.executeQuery(sql);
            while(rs.next()){
                if(table.compareTo("CUSTOMER") == 0) {
                    temp = rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getString(3) + ":" + rs.getString(4) + ":" + rs.getString(5) + ":" + rs.getString(6) + ":";
                }
                if(table.compareTo("TESTDRIVEREG") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":"+ rs.getString(4) +":"+ rs.getString(5) +":"+ rs.getString(6) +":"+ rs.getString(7) +":"+ rs.getString(8) +":";
                }
                if(table.compareTo("VEHICLE") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":"+ rs.getString(4) +":"+ rs.getString(5) +":"+ rs.getString(6) +":"+ rs.getString(7) +":";
                }
                if(table.compareTo("EMPLOYEE") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":"+ rs.getString(4) +":"+ rs.getString(5) +":"+ rs.getString(6) +":"+ rs.getString(7) +":"+ rs.getString(8) +":"+ rs.getString(9) +":";
                }
                if(table.compareTo("BOOKING") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":"+ rs.getString(4) +":"+ rs.getString(5) +":"+ rs.getString(6) +":"+ rs.getString(7) +":"+ rs.getString(8) +":"+ rs.getString(9) +":"+ rs.getString(10) +":"+ rs.getString(11) +":";
                }
                if(table.compareTo("SALE") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":"+ rs.getString(4) +":"+ rs.getString(5) +":"+ rs.getString(6) +":"+ rs.getString(7) +":"+ rs.getString(8) +":";
                }
                if(table.compareTo("FEEDBACK") == 0){
                    temp = rs.getString(1) +":"+ rs.getString(2) +":"+ rs.getString(3) +":";
                }

                lists.add(temp);
            }

            rs.close(); mySt.close(); myCon.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return lists;
    }

    //============================================================

    public boolean DELETE(String table, String opt, String val) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "delete from "+ table +" where " + opt + " = '" + val + "'";

            ResultSet rs = mySt.executeQuery(sql);

            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //=======================================================================================


    public boolean UPDATEEMP(String opt, String v, String em) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {
            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();

           String  sql = "update EMPLOYEE set " + opt + " = '" + v + "' where Email = '" + em + "'";

            ResultSet rs = mySt.executeQuery(sql);


            rs.close(); mySt.close(); myCon.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UPDATEVEH(String tot, String n, String mod) {

        String url = "jdbc:oracle:thin:@DESKTOP-ALC0PHC:1521:TOLA";
        String user = "tola";
        String pw = "1234";

        try {

            Connection myCon = DriverManager.getConnection(url, user, pw);
            Statement mySt = myCon.createStatement();
            String sql = "update VEHICLE set Available = " + tot + " where Name = '" + n + "' and Model = '" + mod + "'";

            ResultSet rs = mySt.executeQuery(sql);


            rs.close(); mySt.close(); myCon.close();


            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
