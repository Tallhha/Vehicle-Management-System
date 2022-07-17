package sample;

import java.util.ArrayList;

//===========================================================BUSINESS LAYER===========================================================

public class Vehicles {

    //Class Attributes.
    private String Name, Company, Type, Model, Color, Cost, Total;
    DBMS DB = new DBMS();

    //Public Functions =================================================================================================

    //Constructor.
    public Vehicles() {
        Name = Type = Model = Color = Cost = Company = Total = "";
    }

    public Vehicles(String n, String com, String t, String m, String col, String c, String tot) {

        Name = n;
        Model = m;
        Type = t;
        Cost = c;
        Color = col;
        Company = com;
        Total = tot;

    }
    //Setters.
    public void setCompany(String company) { Company = company; }

    public void setName(String n) { Name = n; }

    public void setType(String t) { Type = t; }

    public void setModel(String m) { Model = m; }

    public void setCost(String c) { Cost = c; }

    public void setColor(String col) { Color = col; }

    public void setTotal(String total) { Total = total; }

    //Getters.
    public String getTotal() { return Total; }

    public String getName() { return Name; }

    public String getType() { return Type; }

    public String getModel() { return Model; }

    public String getCost() { return Cost; }

    public String getColor() { return Color; }

    public String getCompany() { return Company; }

    //Initializer.
    public void SetVehicle(String n, String com, String t, String m, String col, String c, String tot) {

        Name = n;
        Model = m;
        Type = t;
        Cost = c;
        Color = col;
        Company = com;
        Total = tot;

    }

    //This Function add vehicles in database server.
    public boolean AddVehicle(String n, String com, String t, String m, String col, String c, String tot) {

        Name = n;
        Model = m;
        Type = t;
        Cost = c;
        Color = col;
        Company = com;
        Total = tot;

        boolean ret = DB.InsertVehicle(this);       //Function from DBMS class to add vehicle.

        return ret;

    }

    //This function returns list of vehicle from DBMS.
    public ArrayList<String> VehicleStatus(String opt, String v) {

        ArrayList<String> cars = new ArrayList<String>();
        cars = DB.SEARCH("VEHICLE",opt, v);     //This function search vehicle in DBMS.

        return cars;

    }

    //Displaying Content of Class.
    public void DisplayCars(ArrayList<String> cars){

        for (int i = 0; i < cars.size(); i++) {

            String temp = cars.get(i);
            String[] temp1 = temp.split(":");

            System.out.println("\t" + temp1[0] + "\t\t:\t" + temp1[1] + "\t\t:\t\t" + temp1[2] + "\t\t:\t\t" + temp1[3] + "\t:\t" + temp1[4] + "\t:\t" + temp1[5] + "\t\n");

        }

    }

}

