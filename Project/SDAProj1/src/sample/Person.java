package sample;
//===========================================================BUSINESS LAYER===========================================================

public class Person {

    //Class Attributes.
    private String FirstName, LastName, Email, PhoneNo, CNIC, Address;

    //Public Functions =================================================================================================

    //Constructor.
    public Person(){
        FirstName = LastName = Email = PhoneNo = CNIC = Address = "";
    }
    //Initializer Function.
    public Person(String fn, String ln, String e, String num, String cnic, String addr){

        FirstName = fn;
        LastName = ln;
        Email = e;
        PhoneNo = num;
        CNIC = cnic;
        Address = addr;

    }

    //Initializer Function.
    public void AddPerson(String fn, String ln, String e, String num, String cnic, String addr){

        FirstName = fn;
        LastName = ln;
        Email = e;
        PhoneNo = num;
        CNIC = cnic;
        Address = addr;

    }

    //Setters.
    public void setEmail(String email) {
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setCNIC(String CNIC) { this.CNIC = CNIC; }

    public void setAddress(String address) {
        Address = address;
    }

    //Getters
    public String getAddress() {
        return Address;
    }

    public String getCNIC() { return CNIC; }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    //Displays Content of Class.
    public void DisplayPerson(){

        System.out.print("First Name: " + getFirstName() + "\n");
        System.out.print("Last name: " + getLastName() + "\n");
        System.out.print("Phone Number: " + getPhoneNo() + "\n");
        System.out.print("Email: " + getEmail() + "\n");
        System.out.print("CNIC: " + getCNIC() + "\n");

    }

}
