import java.util.HashMap;

/* users class */

public class Users {
    String name;
    private String pinCode;
    private int currentdepositMoney;

    int getCurrentdepositMoney(String pin)
    {
        if (pin.equals(this.pinCode))
            return currentdepositMoney;
        return 0;
    }

    void setCurrentdepositMoney(int delta)
    {
        this.currentdepositMoney=this.currentdepositMoney-delta;
    }

    void setPinCode(String pinCode)
    {
        this.pinCode = pinCode;
    }

    String getPinCode(String pin)
    {
        if (pin.equals(this.pinCode))
            return pinCode;
        return "";
    }

}
