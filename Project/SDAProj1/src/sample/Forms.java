package sample;
//===========================================================BUSINESS LAYER===========================================================

public class Forms {

    //Class Attributes.
    private String Vehicle, FirstName, LastName, Email, PhoneNo, Cnic;

    //Public Functions =================================================================================================

    //Constructor.
    public Forms(){
        Vehicle = FirstName = LastName = Email = PhoneNo  = Cnic = "";
    }

    public Forms(String v, String fn, String ln, String e, String Num, String cnic){

        Vehicle = v;
        FirstName = fn;
        LastName = ln;
        Email = e;
        PhoneNo = Num;
        Cnic = cnic;

    }
    //Setters.
    public void setCnic(String cnic) {
        Cnic = cnic;
    }

    public void setVehicle(String v){
        Vehicle = v;
    }

    public void setFirstName(String fn){ FirstName = fn; }

    public void setLastName(String ln){
        LastName = ln;
    }

    public void setEmail(String e){
        Email = e;
    }

    public void setPhoneNo(String p){
        PhoneNo = p;
    }

    //Getters
    public String getVehicle(){
        return Vehicle;
    }

    public String getCnic() {
        return Cnic;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public String getEmail(){
        return Email;
    }

    public String getPhoneNo(){
        return PhoneNo;
    }

    //Initializer
    public void Addform(String v, String fn, String ln, String e, String Num, String cnic){

        Vehicle = v;
        FirstName = fn;
        LastName = ln;
        Email = e;
        PhoneNo = Num;
        Cnic = cnic;

    }

    //Displays content of Class.
    public void Print(){

        System.out.print("Vehicle: " + getVehicle() + "\n");
        System.out.print("First Name: " + getFirstName() + "\n");
        System.out.print("Last name: " + getLastName() + "\n");
        System.out.print("Phone Number: " + getPhoneNo() + "\n");
        System.out.print("CNIC: " + getCnic() + "\n");

    }

}

