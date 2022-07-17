package sample;
//===========================================================BUSINESS LAYER===========================================================

public class LogInfo {

    //Class Attributes.
    String pw, email;
    int isManager, isDealer;
    DBMS DB = new DBMS();

    //Public Functions =================================================================================================

    //Setters.
    public void setEmail(String email) { this.email = email; }

    public void setDealer(int dealer) { isDealer = dealer; }

    public void setManager(int manager) { isManager = manager; }

    public void setPw(String pw) { this.pw = pw; }

    //Getters.
    public String getEmail() { return email; }

    public int isDealer() { return isDealer; }

    public int isManager() { return isManager; }

    public String getPw() { return pw; }

    //Initializer
    public void StoreInfo(String e, String p, int isMgr, int isDlr){

        pw = p;
        email = e;
        isManager = isMgr;
        isDealer = isDlr;

        DB.InsertLogInfo(this);     //Store log In information in DBMS.

    }

    //This functions delete log in information from DBMS.
    public void DeleteInfo(String opt, String v){
        DB.DELETE("LOGIN",opt,v);
    }

    //Search person info using email and password in MIS.
    public int SearchInfo(String e, String pw){

        int success = DB.SearchLogin(e,pw);         //Searching info in DBMS.
        return success;

    }

}
