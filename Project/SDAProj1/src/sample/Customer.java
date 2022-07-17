package sample;
//===========================================================BUSINESS LAYER===========================================================

import java.util.ArrayList;

public class Customer extends Person{

    //Class Attributes
    LogInfo Log = new LogInfo();
    DBMS DB = new DBMS();

    public Customer(String fn, String ln, String e, String num, String cnic, String addr)
    {
        super(fn,ln,e,num,cnic,addr);
    }

    public Customer() {}
    //Public Functions =================================================================================================

    //Initializer Function.
    public void SetCustomer(String fn, String ln, String e, String num, String cnic, String addr){
        AddPerson(fn,ln,e,num,cnic,addr);               //This function add details of person for MIS.
    }

    //Initializer Function.
    public boolean RegisterCustomer(String fn, String ln, String e, String num, String cnic, String addr, String p){

        AddPerson(fn,ln,e,num,cnic,addr);               //This function add details of person for MIS.
        boolean ret = DB.InsertCustomer(this);       //This person save costumer info in DBMS for further processing.

        if(ret)
            Log.StoreInfo(e, p, 0, 0);       //Store user email and password.

        return ret;
    }

    //This function deletes costumer from DBMS
    public boolean DeleteCustomer(String opt, String v){

        boolean ret = DB.DELETE("CUSTOMER",opt,v);

        if(ret) {
            Log.DeleteInfo(opt, v);
        }

        return ret;

    }

    //This functions inserts feedback by customers;
    public void Feedback(String fn, String ln, String desc){
       DB.InsertFeedback(fn,ln,desc);

    }


}
